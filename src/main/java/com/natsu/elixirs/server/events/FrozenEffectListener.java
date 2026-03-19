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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Elixirs.MODID)
public class FrozenEffectListener {

	@SubscribeEvent
	public static void onPlayerBreak(PlayerEvent.BreakSpeed event) {
		Player pl = event.getPlayer();
		if (pl == null) return;
		
		if (pl.hasEffect(ElixirsEffects.FROZEN.get()) && pl.isInWaterOrRain()) {
			event.setNewSpeed(event.getOriginalSpeed() * (1 - (0.2f * pl.getEffect(ElixirsEffects.FROZEN.get()).getAmplifier())));
		}
	}
	
}
