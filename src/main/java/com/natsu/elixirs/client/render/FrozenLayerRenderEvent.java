package com.natsu.elixirs.client.render;

import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber
public class FrozenLayerRenderEvent {

	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event) {
		for (EntityType<?> type : ForgeRegistries.ENTITIES) {
			if (type.getCategory() != MobCategory.MISC) {
				Entity dummy = type.create(Minecraft.getInstance().level);
				EntityRenderer<?> renderer = Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(dummy);
				if (renderer instanceof LivingEntityRenderer<?,?> livingRenderer) {
					livingRenderer.addLayer(new FrozenSolidLayer(livingRenderer));
				}
			}
		}
	}
	
	@SubscribeEvent
	public static void onLivingUpdate(LivingEvent.LivingUpdateEvent e) {
		LivingEntity entity = e.getEntityLiving();
		if (entity == null) return;
		
		if (entity.hasEffect(ElixirsEffects.FROZEN_SOLID.get())) {
			//Attempt to freeze animations, hopefully wont break anything
			entity.xRotO = entity.getXRot();
			entity.yRotO = entity.getYRot();
		}
	}
	
}
