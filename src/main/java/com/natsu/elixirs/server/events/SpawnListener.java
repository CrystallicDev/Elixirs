package com.natsu.elixirs.server.events;

import java.util.Random;

import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Elixirs.MODID)
public class SpawnListener {

	@SubscribeEvent
	public static void onSpawn(EntityJoinWorldEvent event) {
		if (!(event.getEntity() instanceof LightningBolt)) return;
		
		LightningBolt bolt = (LightningBolt)event.getEntity();
		Level world = bolt.getLevel();
		for (Player player : world.players()) {
			if (player.hasEffect(ElixirsEffects.HYPERCHARGED.get())) {
				if (player.distanceTo(bolt) <= 150) {
					int r = new Random().nextInt(100);
					if (r <= (5 * (player.getEffect(ElixirsEffects.HYPERCHARGED.get()).getAmplifier() + 1))) {
						bolt.setPos(player.getX(), player.getY(), player.getZ());
					}
				}
			}
		}
		
	}
	
}
