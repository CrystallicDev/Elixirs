package com.natsu.elixirs.server.events;

import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.common.registry.ElixirsPotions;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

@Mod.EventBusSubscriber(modid = Elixirs.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RecipeInitEvent {

    @SubscribeEvent
    public static void onFMLLoadComplete(FMLLoadCompleteEvent event) {
        ElixirsPotions.initRecipes();
    }
}