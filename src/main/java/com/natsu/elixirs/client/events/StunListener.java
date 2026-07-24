package com.natsu.elixirs.client.events;

import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = Elixirs.MODID, value = Dist.CLIENT)
public class StunListener {

	@SubscribeEvent
	public static void onClientTick(ClientTickEvent.Post event) {
		Minecraft mc = Minecraft.getInstance();
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
		
	}
	
	
	
}
