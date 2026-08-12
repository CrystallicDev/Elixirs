package com.natsu.elixirs.client.events;

import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.Minecraft;

public class StunListener {

	// Bloque les entrées clavier du joueur figé côté client (ancien TickEvent.ClientTickEvent)
	public static void register() {
		ClientTickEvents.END_CLIENT_TICK.register(mc -> {
			if (mc.player == null) return;

			if (mc.player.hasEffect(ElixirsEffects.PARALYSIS) || mc.player.hasEffect(ElixirsEffects.FROZEN_SOLID)) {
				mc.options.keyUp.setDown(false);
				mc.options.keyDown.setDown(false);
				mc.options.keyLeft.setDown(false);
				mc.options.keyRight.setDown(false);
				mc.options.keyJump.setDown(false);
				mc.options.keyInventory.setDown(false);
			} else if (mc.player.hasEffect(ElixirsEffects.HEAVY)) {
				mc.options.keyJump.setDown(false);
			}
		});
	}

}
