package com.natsu.elixirs.client.events;

import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.client.Minecraft;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Elixirs.MODID, value = Dist.CLIENT)
public class ShakenRenderEvent {

	@SubscribeEvent
	public static void onCameraSetup(EntityViewRenderEvent.CameraSetup event) {
	    Minecraft mc = Minecraft.getInstance();
	    if (mc.player == null) return;
	    if (!mc.player.hasEffect(ElixirsEffects.SHAKEN.get())) return;

	    MobEffectInstance effect = mc.player.getEffect(ElixirsEffects.SHAKEN.get());
	    float intensity = 0.8F * (effect.getAmplifier() + 1);

	    int duration = effect.getDuration();
	    float fade = duration < 60 ? duration / 60.0F : 1.0F;

	    long time = System.currentTimeMillis();
	    float shake = (float) Math.sin(time * 0.02) * intensity * fade;

	    event.setRoll(event.getRoll() + shake);
	    // event.setYaw(event.getYaw() + shake * 0.5F);
	    // event.setPitch(event.getPitch() + shake * 0.3F);
	}
}
