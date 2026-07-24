package com.natsu.elixirs.server.events;

import com.natsu.elixirs.Elixirs;

import net.minecraft.core.component.DataComponents;
import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.UseAnim;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = Elixirs.MODID)
public class AphagiaEffectListener {

	@SubscribeEvent
	public static void onEat(LivingEntityUseItemEvent.Start event) {
		LivingEntity entity = event.getEntity();
		
		if (entity == null) return;
		
		if (entity.hasEffect(ElixirsEffects.APHAGIA)) {
			if (event.getItem().has(DataComponents.FOOD) || event.getItem().getUseAnimation() == UseAnim.DRINK) {
				event.setCanceled(true);
			}
		}
	}

}
