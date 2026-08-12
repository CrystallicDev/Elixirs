package com.natsu.elixirs.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

	// Source mémorisée dans hurt() pour être relue dans actuallyHurt() (même thread, appel synchrone)
	@Unique
	private DamageSource elixirs$currentSource;

	private LivingEntity elixirs$self() {
		return (LivingEntity) (Object) this;
	}

	// --- FRICTION : réduit la friction du sol sous l'entité (ancien WrapOperation Forge) ---
	@Redirect(method = "travel", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/Block;getFriction()F"))
	private float elixirs$modifyFriction(Block block) {
		float base = block.getFriction();
		if (elixirs$self().hasEffect(ElixirsEffects.FRICTION)) {
			return Math.min(0.6f, base);
		}
		return base;
	}

	// --- LivingAttackEvent : Fear / Symbiosis annulent l'attaque, Leech soigne l'attaquant ---
	@Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
	private void elixirs$onHurt(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
		elixirs$currentSource = source;
		LivingEntity self = elixirs$self();

		if (source.getEntity() instanceof LivingEntity attacker) {
			boolean cancelled = false;
			if (attacker.hasEffect(ElixirsEffects.FEAR)) {
				cir.setReturnValue(false);
				cancelled = true;
			} else if (attacker.hasEffect(ElixirsEffects.SYMBIOSIS) && self.hasEffect(ElixirsEffects.SYMBIOSIS)
					&& !source.isProjectile()) {
				cir.setReturnValue(false);
				cancelled = true;
			}

			if (!cancelled && self.hasEffect(ElixirsEffects.LEECH)) {
				int level = self.getEffect(ElixirsEffects.LEECH).getAmplifier() + 1;
				attacker.setHealth(Math.min(attacker.getMaxHealth(), attacker.getHealth() + (amount * 0.2f * level)));
			}
		}
	}

	// --- Unstable : téléportation façon fruit de chorus quand on subit des dégâts ---
	@Inject(method = "actuallyHurt", at = @At("HEAD"))
	private void elixirs$onActuallyHurt(DamageSource source, float amount, CallbackInfo ci) {
		LivingEntity self = elixirs$self();
		if (self.hasEffect(ElixirsEffects.UNSTABLE)) {
			int dist = 20 + 10 * self.getEffect(ElixirsEffects.UNSTABLE).getAmplifier();
			elixirs$randomTeleport(self, dist);
		}
	}

	// --- Endurance / Crumbling / Burned : ajustent le montant des dégâts ---
	// Note portage : Forge appliquait Burned/Crumbling après armure (LivingDamageEvent) ;
	// ici tout est appliqué avant réduction d'armure, approximation acceptable.
	@ModifyVariable(method = "actuallyHurt", at = @At("HEAD"), argsOnly = true, ordinal = 0)
	private float elixirs$modifyDamage(float amount) {
		LivingEntity self = elixirs$self();

		if (self.hasEffect(ElixirsEffects.ENDURANCE)) {
			int level = self.getEffect(ElixirsEffects.ENDURANCE).getAmplifier() + 1;
			amount = Math.max(0, amount * (1 - (0.1f * level)));
		}
		if (self.hasEffect(ElixirsEffects.CRUMBLING)) {
			int level = self.getEffect(ElixirsEffects.CRUMBLING).getAmplifier() + 1;
			amount = amount * (1 + (0.1f * level));
		}
		if (self.hasEffect(ElixirsEffects.BURNED) && elixirs$currentSource != null && elixirs$currentSource.isFire()) {
			int level = self.getEffect(ElixirsEffects.BURNED).getAmplifier() + 1;
			amount = amount * (1 + (0.5f * level));
		}
		return amount;
	}

	// --- LivingHealEvent : Bleeding bloque, Rejuvenation amplifie, Decay réduit ---
	@ModifyVariable(method = "heal", at = @At("HEAD"), argsOnly = true, ordinal = 0)
	private float elixirs$modifyHeal(float amount) {
		LivingEntity self = elixirs$self();
		if (self.hasEffect(ElixirsEffects.BLEEDING)) {
			return 0;
		}
		if (self.hasEffect(ElixirsEffects.REJUVENATION)) {
			int level = self.getEffect(ElixirsEffects.REJUVENATION).getAmplifier() + 1;
			amount = amount * (1 + (0.5f * level));
		}
		if (self.hasEffect(ElixirsEffects.DECAY)) {
			int level = self.getEffect(ElixirsEffects.DECAY).getAmplifier() + 1;
			amount = amount * (1 - (0.15f * level));
		}
		return amount;
	}

	// --- Aphagia : empêche de manger ou boire ---
	@Inject(method = "startUsingItem", at = @At("HEAD"), cancellable = true)
	private void elixirs$onStartUsingItem(InteractionHand hand, CallbackInfo ci) {
		LivingEntity self = elixirs$self();
		if (!self.hasEffect(ElixirsEffects.APHAGIA)) return;
		ItemStack stack = self.getItemInHand(hand);
		if (stack.isEdible() || stack.getUseAnimation() == UseAnim.DRINK) {
			ci.cancel();
		}
	}

	// --- Paralysie / Gelé sur place / Lourdeur / Attraction : logique de tick ---
	@Inject(method = "tick", at = @At("TAIL"))
	private void elixirs$onTick(CallbackInfo ci) {
		LivingEntity self = elixirs$self();

		if (self.hasEffect(ElixirsEffects.PARALYSIS) || self.hasEffect(ElixirsEffects.FROZEN_SOLID)) {
			self.setDeltaMovement(0, 0, 0);
			self.teleportTo(self.getX(), self.getY(), self.getZ());
			self.setSprinting(false);
			self.setJumping(false);
		} else if (self.hasEffect(ElixirsEffects.HEAVY)) {
			elixirs$applyHeavy(self);
		}

		if (!self.level.isClientSide() && self.hasEffect(ElixirsEffects.ATTRACTION)) {
			Level level = self.level;
			int dist = 15 + (10 * self.getEffect(ElixirsEffects.ATTRACTION).getAmplifier());
			for (Player player : level.players()) {
				if (player == self || player.isSpectator()) continue;
				if (player.distanceTo(self) <= dist && player instanceof ServerPlayer serverPlayer) {
					serverPlayer.lookAt(EntityAnchorArgument.Anchor.EYES, self, EntityAnchorArgument.Anchor.EYES);
				}
			}
		}
	}

	// bloque la montée, et fait couler dans l'eau (plus vite à haut niveau)
	@Unique
	private void elixirs$applyHeavy(LivingEntity living) {
		Vec3 movement = living.getDeltaMovement();
		double dy = movement.y > 0 ? 0 : movement.y;
		if (living.isInWater()) {
			int level = living.getEffect(ElixirsEffects.HEAVY).getAmplifier() + 1;
			dy = Math.min(dy, -0.03 * level);
		}
		living.setDeltaMovement(movement.x, dy, movement.z);
		living.setJumping(false);
	}

	@Unique
	private void elixirs$randomTeleport(LivingEntity entity, int radius) {
		if (!(entity.level instanceof ServerLevel serverLevel)) return;
		double oldX = entity.getX();
		double oldY = entity.getY();
		double oldZ = entity.getZ();

		for (int i = 0; i < 16; i++) {
			double x = entity.getX() + (entity.getRandom().nextDouble() - 0.5) * radius * 2;
			double y = Mth.clamp(entity.getY() + (entity.getRandom().nextInt(8) - 4),
					serverLevel.getMinBuildHeight(), serverLevel.getMinBuildHeight() + serverLevel.getLogicalHeight() - 1);
			double z = entity.getZ() + (entity.getRandom().nextDouble() - 0.5) * radius * 2;

			if (entity.randomTeleport(x, y, z, true)) {
				serverLevel.playSound(null, oldX, oldY, oldZ, SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.PLAYERS, 1.0f, 1.0f);
				entity.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT, 1.0f, 1.0f);
				return;
			}
		}
	}
}
