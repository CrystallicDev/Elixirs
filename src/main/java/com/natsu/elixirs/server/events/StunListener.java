package com.natsu.elixirs.server.events;

import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = Elixirs.MODID)
public class StunListener {

	@SubscribeEvent
	public static void onAttack(AttackEntityEvent event) {
	    Player player = event.getEntity();
		if (player.hasEffect(ElixirsEffects.PARALYSIS) || player.hasEffect(ElixirsEffects.FROZEN_SOLID)) {
			event.setCanceled(true);
		}
	}
	
	// PlayerInteractEvent est abstrait en NeoForge : on s'abonne à chaque sous-type annulable.
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		cancelIfStunned(event);
	}

	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		cancelIfStunned(event);
	}

	@SubscribeEvent
	public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
		cancelIfStunned(event);
	}

	@SubscribeEvent
	public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
		cancelIfStunned(event);
	}

	@SubscribeEvent
	public static void onEntityInteractSpecific(PlayerInteractEvent.EntityInteractSpecific event) {
		cancelIfStunned(event);
	}

	private static <T extends PlayerInteractEvent & ICancellableEvent> void cancelIfStunned(T event) {
		Player player = event.getEntity();
		if (player.hasEffect(ElixirsEffects.PARALYSIS) || player.hasEffect(ElixirsEffects.FROZEN_SOLID)) {
			event.setCanceled(true);
		}
	}
	
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Post event) {
	    if (!(event.getEntity() instanceof LivingEntity living)) return;

	    if (living.hasEffect(ElixirsEffects.PARALYSIS) || living.hasEffect(ElixirsEffects.FROZEN_SOLID)) {
	    	living.setDeltaMovement(0, 0, 0);
	    	living.teleportTo(living.getX(), living.getY(), living.getZ());
	    	living.setSprinting(false);
	    	living.setJumping(false);
	    } else if (living.hasEffect(ElixirsEffects.HEAVY)) {
	    	applyHeavy(living);
	    }
	}
	
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
	    Player player = event.getEntity();

	    if (player.hasEffect(ElixirsEffects.PARALYSIS) || player.hasEffect(ElixirsEffects.FROZEN_SOLID)) {
	        player.setDeltaMovement(0, 0, 0);
	        player.teleportTo(player.getX(), player.getY(), player.getZ());
	        player.setSprinting(false);
	        player.setJumping(false);
	    } else if (player.hasEffect(ElixirsEffects.HEAVY)) {
	        applyHeavy(player);
	    }
	}

	// bloque la montée, et fait couler dans l'eau (plus vite à haut niveau)
	private static void applyHeavy(LivingEntity living) {
	    Vec3 movement = living.getDeltaMovement();
	    double dy = movement.y > 0 ? 0 : movement.y;
	    if (living.isInWater()) {
	        int level = living.getEffect(ElixirsEffects.HEAVY).getAmplifier() + 1;
	        dy = Math.min(dy, -0.03 * level);
	    }
	    living.setDeltaMovement(movement.x, dy, movement.z);
	    living.setJumping(false);
	}
	
}
