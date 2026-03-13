package com.natsu.elixirs;


import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Elixirs.MODID)
public class Elixirs {
	public static final String MODID = "elixirs";

    public Elixirs() {
    	IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	ElixirsEffects.EFFECTS.register(modEventBus);
    }

}
