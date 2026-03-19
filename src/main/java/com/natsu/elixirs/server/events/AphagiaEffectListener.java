package com.natsu.elixirs.server.events;

import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.UseAnim;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Elixirs.MODID)
public class AphagiaEffectListener {

	@SubscribeEvent
	public static void onEat(LivingEntityUseItemEvent event) {
		LivingEntity entity = event.getEntityLiving();
		
		if (entity == null) return;
		
		if (entity.hasEffect(ElixirsEffects.APHAGIA.get())) {
			if (event.getItem().isEdible() || event.getItem().getUseAnimation() == UseAnim.DRINK) {
				event.setCanceled(true);
			}
		}
	}

}
