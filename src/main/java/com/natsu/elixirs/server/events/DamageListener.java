package com.natsu.elixirs.server.events;

import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class DamageListener {

	@SubscribeEvent
	public static void onLivingDamage(LivingDamageEvent event) {
		LivingEntity entity = event.getEntityLiving();
		
		if (entity == null) return; 		// Safe check, you never now in modded envs
		
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
		Entity source = event.getSource().getEntity();
		if (source instanceof LivingEntity living) {
			if (living.hasEffect(ElixirsEffects.FEAR.get())) {
				event.setCanceled(true);
			} else if (living.hasEffect(ElixirsEffects.SYMBIOSIS.get()) && event.getEntityLiving().hasEffect(ElixirsEffects.SYMBIOSIS.get()) && !event.getSource().isProjectile()) {
				event.setCanceled(true);
			}
		}
	}
	
}
