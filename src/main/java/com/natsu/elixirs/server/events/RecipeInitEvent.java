package com.natsu.elixirs.server.events;

import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.common.registry.ElixirsPotions;

import net.minecraftforge.event.brewing.BrewingRecipeRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

// 1.20.6 : BrewingRecipeRegisterEvent est diffusé sur le bus FORGE (jeu), pas le bus MOD.
@Mod.EventBusSubscriber(modid = Elixirs.MODID)
public class RecipeInitEvent {

	// 1.20.6 : le brewing s'enregistre via BrewingRecipeRegisterEvent (le PotionBrewing.Builder est fourni).
	@SubscribeEvent
	public static void onRegisterBrewing(BrewingRecipeRegisterEvent event) {
		ElixirsPotions.initRecipes(event.getBuilder());
	}
}
