package com.natsu.elixirs.server.events;

import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.common.mobeffects.negative.FrozenEffect;
import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = Elixirs.MODID)
public class FrozenEffectListener {

	@SubscribeEvent
	public static void onPlayerBreak(PlayerEvent.BreakSpeed event) {
		Player pl = event.getEntity();
		if (pl == null) return;
		
		if (pl.hasEffect(ElixirsEffects.FROZEN) && pl.isInWaterOrRain()) {
			int level = pl.getEffect(ElixirsEffects.FROZEN).getAmplifier() + 1;
			event.setNewSpeed(Math.max(0, event.getOriginalSpeed() * (1 - (0.2f * level))));
		}
	}
	
}
