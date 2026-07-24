package com.natsu.elixirs.server.events;

import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = Elixirs.MODID)
public class TickListener {

	@SubscribeEvent
	public static void onTick(EntityTickEvent.Post event) {
		if (!(event.getEntity() instanceof LivingEntity entity)) return;
		if (entity.level().isClientSide()) return;

		if (entity.hasEffect(ElixirsEffects.ATTRACTION)) {
			Level world = entity.level();
			int dist = 15 + (10 * entity.getEffect(ElixirsEffects.ATTRACTION).getAmplifier());
			for (Player player : world.players()) {
				if (player == entity || player.isSpectator()) continue;
				if (player.distanceTo(entity) <= dist && player instanceof ServerPlayer serverPlayer) {
					serverPlayer.lookAt(EntityAnchorArgument.Anchor.EYES, entity, EntityAnchorArgument.Anchor.EYES);
				}
			}
		}

	}

}
