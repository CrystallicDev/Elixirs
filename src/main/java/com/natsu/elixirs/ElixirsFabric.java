package com.natsu.elixirs;

import com.natsu.elixirs.common.registry.ElixirsEffects;
import com.natsu.elixirs.common.registry.ElixirsPotions;
import com.natsu.elixirs.server.events.SpawnListener;
import com.natsu.elixirs.server.events.StunListener;

import net.fabricmc.api.ModInitializer;

public class ElixirsFabric implements ModInitializer {

	@Override
	public void onInitialize() {
		Elixirs.LOGGER.info("Initialisation d'Elixirs");
		ElixirsEffects.register();
		ElixirsPotions.register();
		ElixirsPotions.initRecipes();

		// Events communs portés sur des callbacks Fabric (le reste passe par des mixins)
		SpawnListener.register();
		StunListener.register();
	}

}
