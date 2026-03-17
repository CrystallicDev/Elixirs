package com.natsu.elixirs.server.events;

import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.DEDICATED_SERVER)
public class DamageListener {

	@SubscribeEvent
	public static void onLivingDamage(LivingDamageEvent event) {
		LivingEntity entity = event.getEntityLiving();
		
		if (entity == null) return; 		// Safe check, there is always weird shit in modded envs
		
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
		if (entity.hasEffect(ElixirsEffects.ENDURANCE.get())) {
			MobEffectInstance effect = entity.getEffect(ElixirsEffects.ENDURANCE.get());
			int level = effect.getAmplifier() + 1;
			
			event.setAmount(event.getAmount() * (1 - (0.1f * level)));
		}
	}
	
	@SubscribeEvent
	public static void onLivingHurt(LivingHurtEvent event) {
		Entity source = event.getSource().getEntity();
		if (source instanceof LivingEntity living) {
			if (living.hasEffect(ElixirsEffects.FEAR.get())) {
				event.setCanceled(true);
			} else if (living.hasEffect(ElixirsEffects.SYMBIOSIS.get()) && event.getEntityLiving().hasEffect(ElixirsEffects.SYMBIOSIS.get()) && !event.getSource().isProjectile()) {
				event.setCanceled(true);
			}
			
			if (event.getEntityLiving().hasEffect(ElixirsEffects.LEECH.get())) {
				//Back in 1.8.9 you'd get an error if you setHealth > getMaxHealth, i dont know if this is still a thing
				//and i dont want to find out
				living.setHealth(Math.min(living.getMaxHealth(), living.getHealth() + (event.getAmount() * 0.1f * event.getEntityLiving().getEffect(ElixirsEffects.LEECH.get()).getAmplifier())));
			}
		}

		if (event.getEntityLiving().hasEffect(ElixirsEffects.UNSTABLE.get())) {
			int dist = 20 + 10 * event.getEntityLiving().getEffect(ElixirsEffects.UNSTABLE.get()).getAmplifier();
			boolean success = randomTeleport(event.getEntityLiving(), dist);
			if (success) {
				event.getEntityLiving().level.playSound(null, event.getEntityLiving().blockPosition(), SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.PLAYERS, 1.0f, 1.0f);
			}
		}
		
	}
	
	
	private static boolean randomTeleport(LivingEntity entity, int radius) {
	    Level level = entity.level;
	    for (int i = 0; i < 16; i++) {
	        double x = entity.getX() + (entity.getRandom().nextDouble() - 0.5) * radius * 2;
	        double y = entity.getY() + entity.getRandom().nextInt(8) - 4;
	        double z = entity.getZ() + (entity.getRandom().nextDouble() - 0.5) * radius * 2;
	        BlockPos pos = new BlockPos(x, y, z);
	        
	        if (level.getBlockState(pos).isAir() && level.getBlockState(pos.above()).isAir()) {
	            if (level.getBlockState(pos.below()).isSolidRender(level, pos.below())) {
	                entity.teleportTo(x + 0.5, y, z + 0.5);
	                return true;
	            }
	        }
	    }
	    return false;
	}
}
