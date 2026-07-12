package com.natsu.elixirs.server.events;

import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Elixirs.MODID)
public class DamageListener {

	@SubscribeEvent
	public static void onAttack(LivingAttackEvent event) {
		LivingEntity entity = event.getEntity();
		if (entity == null) return; 		// Safe check, there is always weird shit in modded envs
		Entity source = event.getSource().getEntity();
		
		if (source instanceof LivingEntity living) {
			if (living.hasEffect(ElixirsEffects.FEAR.get())) {
				event.setCanceled(true);
			} else if (living.hasEffect(ElixirsEffects.SYMBIOSIS.get()) && entity.hasEffect(ElixirsEffects.SYMBIOSIS.get()) && !event.getSource().isProjectile()) {
				event.setCanceled(true);
			}

			if (!event.isCanceled() && entity.hasEffect(ElixirsEffects.LEECH.get())) {
				int level = entity.getEffect(ElixirsEffects.LEECH.get()).getAmplifier() + 1;
				//Back in 1.8.9 you'd get an error if you setHealth > getMaxHealth, i dont know if this is still a thing
				//and i dont want to find out
				living.setHealth(Math.min(living.getMaxHealth(), living.getHealth() + (event.getAmount() * 0.2f * level)));
			}
		}
	}
	
	@SubscribeEvent
	public static void onLivingDamage(LivingDamageEvent event) {
		LivingEntity entity = event.getEntity();
		if (entity == null) return;
		if (entity.hasEffect(ElixirsEffects.BURNED.get())) {
			MobEffectInstance effect = entity.getEffect(ElixirsEffects.BURNED.get());
			int level = effect.getAmplifier() + 1;
			
			if (event.getSource().isFire()) {	//Didnt know mc had a feature like that, it dit not exist in 1.8 !
				event.setAmount(event.getAmount() * (1 + (0.5f * level)));
			}
		}
		if (entity.hasEffect(ElixirsEffects.CRUMBLING.get())) {
			MobEffectInstance effect = entity.getEffect(ElixirsEffects.CRUMBLING.get());
			int level = effect.getAmplifier() + 1;
			
			event.setAmount(event.getAmount() * (1 + (0.1f * level)));
		}
		
	}
	
	@SubscribeEvent
	public static void onLivingHurt(LivingHurtEvent event) {
		LivingEntity entity = event.getEntity();
		if (entity == null) return;
		if (entity.hasEffect(ElixirsEffects.UNSTABLE.get())) {
			int dist = 20 + 10 * entity.getEffect(ElixirsEffects.UNSTABLE.get()).getAmplifier();
			randomTeleport(entity, dist);
		}
		if (entity.hasEffect(ElixirsEffects.ENDURANCE.get())) {
			MobEffectInstance effect = entity.getEffect(ElixirsEffects.ENDURANCE.get());
			int level = effect.getAmplifier() + 1;
			
			event.setAmount(Math.max(0, event.getAmount() * (1 - (0.1f * level))));
		}
		
	}
	
	
	// téléportation façon fruit de chorus, avec son au départ et à l'arrivée
	private static void randomTeleport(LivingEntity entity, int radius) {
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
