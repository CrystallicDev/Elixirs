package com.natsu.elixirs.server.events;

import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class RegenerationListener {

	@SubscribeEvent
	public static void onEntityHeal(LivingHealEvent event) {
		LivingEntity entity = event.getEntityLiving();
		
		if (entity == null) return; 		// Safe check, you never now in modded envs
		
		if (entity.hasEffect(ElixirsEffects.BLEEDING.get())) {
			event.setAmount(0);
		} else {
			if (entity.hasEffect(ElixirsEffects.REJUVENATION.get())) {
				MobEffectInstance effect = entity.getEffect(ElixirsEffects.REJUVENATION.get());
				int level = effect.getAmplifier() + 1;
				
				event.setAmount(event.getAmount() * (1 + (0.5f * level)));
			} 
			if (entity.hasEffect(ElixirsEffects.DECAY.get())) {
				MobEffectInstance effect = entity.getEffect(ElixirsEffects.DECAY.get());
				int level = effect.getAmplifier() + 1;
				
				event.setAmount(event.getAmount() * (1 - (0.15f * level)));
			}
		}
	}

}
