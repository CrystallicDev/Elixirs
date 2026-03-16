package com.natsu.elixirs.client.events;

import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class StunListener {

	@SubscribeEvent
	public static void onClientTick(TickEvent.ClientTickEvent event) {
		Minecraft mc = Minecraft.getInstance();
		if (mc.player == null) return;
		
		if (mc.player.hasEffect(ElixirsEffects.PARALISYS.get()) || mc.player.hasEffect(ElixirsEffects.FROZEN_SOLID.get())) {
			mc.options.keyUp.setDown(false);
			mc.options.keyDown.setDown(false);
			mc.options.keyLeft.setDown(false);
			mc.options.keyRight.setDown(false);
			mc.options.keyJump.setDown(false);
			mc.options.keyInventory.setDown(false);
		} else if (mc.player.hasEffect(ElixirsEffects.HEAVY.get())) {
			mc.options.keyJump.setDown(false);
		}
		
	}
	
	
	
}
