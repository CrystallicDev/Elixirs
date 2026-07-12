package com.natsu.elixirs.client.render;

import java.util.Random;

import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.client.Minecraft;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Elixirs.MODID, value = Dist.CLIENT)
public class CameraEventHandler {

    private static float currentShakeX = 0;
    private static float currentShakeY = 0;
    private static final Random RANDOM = new Random();

    @SubscribeEvent
    public static void onComputeCameraAngles(ViewportEvent.ComputeCameraAngles event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;
        if (!mc.player.hasEffect(ElixirsEffects.SHAKEN.get())) return;

        MobEffectInstance effect = mc.player.getEffect(ElixirsEffects.SHAKEN.get());
        float intensity = 0.5f * (effect.getAmplifier() + 1);

        currentShakeX += ((RANDOM.nextFloat() * 2 - 1) * intensity - currentShakeX) * 0.3f;
        currentShakeY += ((RANDOM.nextFloat() * 2 - 1) * intensity - currentShakeY) * 0.3f;

        event.setYaw(event.getYaw() + currentShakeX);
        event.setPitch(event.getPitch() + currentShakeY);
    }
}