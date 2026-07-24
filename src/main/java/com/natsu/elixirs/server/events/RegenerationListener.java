package com.natsu.elixirs.server.events;

import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.event.entity.living.LivingHealEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = Elixirs.MODID)
public class RegenerationListener {

	@SubscribeEvent
	public static void onEntityHeal(LivingHealEvent event) {
		LivingEntity entity = event.getEntity();
		
		if (entity == null) return; 		// Safe check, you never now in modded envs
		
		if (entity.hasEffect(ElixirsEffects.BLEEDING)) {
			event.setAmount(0);
		} else {
			if (entity.hasEffect(ElixirsEffects.REJUVENATION)) {
				MobEffectInstance effect = entity.getEffect(ElixirsEffects.REJUVENATION);
				int level = effect.getAmplifier() + 1;
				
				event.setAmount(event.getAmount() * (1 + (0.5f * level)));
			} 
			if (entity.hasEffect(ElixirsEffects.DECAY)) {
				MobEffectInstance effect = entity.getEffect(ElixirsEffects.DECAY);
				int level = effect.getAmplifier() + 1;
				
				event.setAmount(event.getAmount() * (1 - (0.15f * level)));
			}
		}
	}

}
