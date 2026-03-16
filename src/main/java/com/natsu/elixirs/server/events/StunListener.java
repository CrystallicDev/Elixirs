package com.natsu.elixirs.server.events;

import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.DEDICATED_SERVER)
public class StunListener {

	@SubscribeEvent
	public static void onAttack(AttackEntityEvent event) {
	    Player player = event.getPlayer();
		if (player.hasEffect(ElixirsEffects.PARALISYS.get()) || player.hasEffect(ElixirsEffects.FROZEN_SOLID.get())) {
			event.setCanceled(true);
		}
	}
	
	@SubscribeEvent
	public static void onInteract(PlayerInteractEvent event) {
	    Player player = event.getPlayer();
		if (player.hasEffect(ElixirsEffects.PARALISYS.get()) || player.hasEffect(ElixirsEffects.FROZEN_SOLID.get())) {
			event.setCanceled(true);
		}
	}
	
	@SubscribeEvent
	public static void onOpenInventory(PlayerContainerEvent event) {
	    Player player = event.getPlayer();
		if (player.hasEffect(ElixirsEffects.PARALISYS.get()) || player.hasEffect(ElixirsEffects.FROZEN_SOLID.get())) {
			event.setCanceled(true);
		}
	}
	
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
	    Player player = event.player;

	    if (player.hasEffect(ElixirsEffects.PARALISYS.get()) || player.hasEffect(ElixirsEffects.FROZEN_SOLID.get())) {
	        player.setDeltaMovement(0, 0, 0);
	        player.teleportTo(player.getX(), player.getY(), player.getZ());
	        player.setSprinting(false);
	        player.setJumping(false);
	    } else if (player.hasEffect(ElixirsEffects.HEAVY.get())) {
	        player.setDeltaMovement(player.getDeltaMovement().x, player.getDeltaMovement().y > 0 ? 0 : player.getDeltaMovement().y, player.getDeltaMovement().z);
	        player.setJumping(false);
	    }
	}
	
}
