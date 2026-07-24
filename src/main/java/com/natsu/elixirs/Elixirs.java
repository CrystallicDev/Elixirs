package com.natsu.elixirs;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.natsu.elixirs.common.registry.ElixirsEffects;
import com.natsu.elixirs.common.registry.ElixirsPotions;
import com.natsu.elixirs.config.ElixirsConfig;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(Elixirs.MODID)
public class Elixirs {

	public static final String MODID = "elixirs";
	public static final Logger LOGGER = LogUtils.getLogger();

	// NeoForge injecte le bus et le container : plus de FMLJavaModLoadingContext.
	// MixinExtras est fourni par le loader, pas besoin de le bootstrap.
	public Elixirs(IEventBus modEventBus, ModContainer modContainer) {
		ElixirsEffects.EFFECTS.register(modEventBus);
		ElixirsPotions.POTIONS.register(modEventBus);
		modContainer.registerConfig(ModConfig.Type.COMMON, ElixirsConfig.SPEC);
	}

}
