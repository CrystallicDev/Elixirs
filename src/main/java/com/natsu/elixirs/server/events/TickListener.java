package com.natsu.elixirs.server.events;

import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Elixirs.MODID)
public class TickListener {

	@SubscribeEvent
	public static void onTick(LivingEvent.LivingUpdateEvent event) {
		LivingEntity entity = event.getEntityLiving();
		if (entity == null || entity.getLevel().isClientSide()) return;

		if (entity.hasEffect(ElixirsEffects.ATTRACTION.get())) {
			Level world = entity.getLevel();
			int dist = 15 + (10 * entity.getEffect(ElixirsEffects.ATTRACTION.get()).getAmplifier());
			for (Player player : world.players()) {
				if (player == entity || player.isSpectator()) continue;
				if (player.distanceTo(entity) <= dist && player instanceof ServerPlayer serverPlayer) {
					serverPlayer.lookAt(EntityAnchorArgument.Anchor.EYES, entity, EntityAnchorArgument.Anchor.EYES);
				}
			}
		}

	}

}
