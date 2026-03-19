package com.natsu.elixirs.server.events;

import java.util.Random;

import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Elixirs.MODID)
public class TickListener {

	@SubscribeEvent
	public static void onTick(LivingEvent.LivingUpdateEvent event) {
		LivingEntity entity = event.getEntityLiving();
		if (entity == null) return;
		
		if (entity.hasEffect(ElixirsEffects.ATTRACTION.get())) {
			Level world = entity.getLevel();
			int dist = 15 + (10 * entity.getEffect(ElixirsEffects.ATTRACTION.get()).getAmplifier());
			for (Player player : world.players()) {
				if (player.hasEffect(ElixirsEffects.ATTRACTION.get())) {
					if (player.distanceTo(entity) <= dist) {
						lookAt(player, entity);
					}
				}
			}
		}
		
	}
	
	private static void lookAt(Player player, Entity target) {

	    double dx = target.getX() - player.getX();
	    double dy = target.getEyeY() - player.getEyeY();
	    double dz = target.getZ() - player.getZ();

	    double distance = Math.sqrt(dx * dx + dz * dz);

	    float yaw = (float)(Math.atan2(dz, dx) * (180 / Math.PI)) - 90F;
	    float pitch = (float)(-(Math.atan2(dy, distance) * (180 / Math.PI)));

	    player.setYRot(yaw);
	    player.setXRot(pitch);

	    player.yHeadRot = yaw;
	    player.yBodyRot = yaw;
	}
	
}
