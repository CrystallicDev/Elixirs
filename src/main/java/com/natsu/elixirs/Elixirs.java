package com.natsu.elixirs;


import com.llamalad7.mixinextras.MixinExtrasBootstrap;
import com.natsu.elixirs.common.registry.ElixirsEffects;
import com.natsu.elixirs.common.registry.ElixirsPotions;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Elixirs.MODID)
public class Elixirs {
	public static final String MODID = "elixirs";

    public Elixirs() {
    	IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	ElixirsEffects.EFFECTS.register(modEventBus);
    	ElixirsPotions.POTIONS.register(modEventBus);
    	MixinExtrasBootstrap.init();
    }
    
    

}
