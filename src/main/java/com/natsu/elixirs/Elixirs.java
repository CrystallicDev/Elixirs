package com.natsu.elixirs;


import org.slf4j.Logger;

import com.llamalad7.mixinextras.MixinExtrasBootstrap;
import com.mojang.logging.LogUtils;
import com.natsu.elixirs.common.registry.ElixirsEffects;
import com.natsu.elixirs.common.registry.ElixirsPotions;
import com.natsu.elixirs.config.ElixirsConfig;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Elixirs.MODID)
public class Elixirs {
	public static final String MODID = "elixirs";
	public static final Logger LOGGER = LogUtils.getLogger();

    public Elixirs() {
    	IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	ElixirsEffects.EFFECTS.register(modEventBus);
    	ElixirsPotions.POTIONS.register(modEventBus);
    	ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ElixirsConfig.SPEC);
    	MixinExtrasBootstrap.init();
    }
    
    

}
