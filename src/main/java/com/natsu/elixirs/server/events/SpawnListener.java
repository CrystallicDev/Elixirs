package com.natsu.elixirs.server.events;

import java.util.Random;

import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = Elixirs.MODID)
public class SpawnListener {

	@SubscribeEvent
	public static void onSpawn(EntityJoinLevelEvent event) {
		if (!(event.getEntity() instanceof LightningBolt bolt)) return;

		Level world = bolt.level();
		if (world.isClientSide()) return;

		for (Player player : world.players()) {
			if (player.hasEffect(ElixirsEffects.HYPERCHARGED)) {
				if (player.distanceTo(bolt) <= 150) {
					int r = world.getRandom().nextInt(100);
					if (r <= (5 * (player.getEffect(ElixirsEffects.HYPERCHARGED).getAmplifier() + 1))) {
						bolt.setPos(player.getX(), player.getY(), player.getZ());
					}
				}
			}
		}

	}
	
}
