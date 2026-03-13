package com.natsu.elixirs.server.events;

import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class TickListener {

	@SubscribeEvent
	public static void onPlayerTick(LivingEvent.LivingUpdateEvent event) {
	    LivingEntity entity = event.getEntityLiving();

	    if (!(entity instanceof Player player)) return;

	    if (player.hasEffect(ElixirsEffects.PARALISYS.get()) || player.hasEffect(ElixirsEffects.FROZEN_SOLID.get())) {
	        player.setDeltaMovement(0, 0, 0);
	        player.setJumping(false);
	        player.setYRot(player.yRotO);
	        player.setXRot(player.xRotO);
	    }
	}
	
}
