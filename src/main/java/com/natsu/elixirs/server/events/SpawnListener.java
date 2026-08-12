package com.natsu.elixirs.server.events;

import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class SpawnListener {

	public static void register() {
		ServerEntityEvents.ENTITY_LOAD.register((entity, world) -> {
			if (!(entity instanceof LightningBolt bolt)) return;

			Level level = bolt.getLevel();
			if (level.isClientSide()) return;

			for (Player player : level.players()) {
				if (player.hasEffect(ElixirsEffects.HYPERCHARGED)) {
					if (player.distanceTo(bolt) <= 150) {
						int r = level.getRandom().nextInt(100);
						if (r <= (5 * (player.getEffect(ElixirsEffects.HYPERCHARGED).getAmplifier() + 1))) {
							bolt.setPos(player.getX(), player.getY(), player.getZ());
						}
					}
				}
			}
		});
	}

}
