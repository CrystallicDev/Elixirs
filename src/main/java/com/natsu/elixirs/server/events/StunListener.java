package com.natsu.elixirs.server.events;

import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Elixirs.MODID)
public class StunListener {

	@SubscribeEvent
	public static void onAttack(AttackEntityEvent event) {
	    if (event.isCancelable()) {
	    	Player player = event.getPlayer();
			if (player.hasEffect(ElixirsEffects.PARALYSIS.get()) || player.hasEffect(ElixirsEffects.FROZEN_SOLID.get())) {
				event.setCanceled(true);
			}
	    }
	}
	
	@SubscribeEvent
	public static void onInteract(PlayerInteractEvent event) {
		if (event.isCancelable()) {
			Player player = event.getPlayer();
			if (player.hasEffect(ElixirsEffects.PARALYSIS.get()) || player.hasEffect(ElixirsEffects.FROZEN_SOLID.get())) {
				event.setCanceled(true);
			}
		}
	}
	
	@SubscribeEvent
	public static void onOpenInventory(PlayerContainerEvent event) {
	    if (event.isCancelable()) {
	    	Player player = event.getPlayer();
			if (player.hasEffect(ElixirsEffects.PARALYSIS.get()) || player.hasEffect(ElixirsEffects.FROZEN_SOLID.get())) {
				event.setCanceled(true);
			}
	    }
	}
	
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingUpdateEvent event) {
	    LivingEntity living = event.getEntityLiving();

	    if (living.hasEffect(ElixirsEffects.PARALYSIS.get()) || living.hasEffect(ElixirsEffects.FROZEN_SOLID.get())) {
	    	living.setDeltaMovement(0, 0, 0);
	    	living.teleportTo(living.getX(), living.getY(), living.getZ());
	    	living.setSprinting(false);
	    	living.setJumping(false);
	    } else if (living.hasEffect(ElixirsEffects.HEAVY.get())) {
	    	applyHeavy(living);
	    }
	}
	
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
	    Player player = event.player;

	    if (player.hasEffect(ElixirsEffects.PARALYSIS.get()) || player.hasEffect(ElixirsEffects.FROZEN_SOLID.get())) {
	        player.setDeltaMovement(0, 0, 0);
	        player.teleportTo(player.getX(), player.getY(), player.getZ());
	        player.setSprinting(false);
	        player.setJumping(false);
	    } else if (player.hasEffect(ElixirsEffects.HEAVY.get())) {
	        applyHeavy(player);
	    }
	}

	// bloque la montée, et fait couler dans l'eau (plus vite à haut niveau)
	private static void applyHeavy(LivingEntity living) {
	    Vec3 movement = living.getDeltaMovement();
	    double dy = movement.y > 0 ? 0 : movement.y;
	    if (living.isInWater()) {
	        int level = living.getEffect(ElixirsEffects.HEAVY.get()).getAmplifier() + 1;
	        dy = Math.min(dy, -0.03 * level);
	    }
	    living.setDeltaMovement(movement.x, dy, movement.z);
	    living.setJumping(false);
	}
	
}
