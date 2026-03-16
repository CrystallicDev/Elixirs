package com.natsu.elixirs.client.events;

import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Elixirs.MODID, value = Dist.CLIENT)
public class SoundListener {

    @SubscribeEvent
    public static void onPlaySound(PlaySoundEvent event) {
        Entity entity = Minecraft.getInstance().player;
        if (entity instanceof Player player) {
            if (player.hasEffect(ElixirsEffects.DEAFENED.get())) {
                event.setSound(null);
            }
        }
    }
}