package com.natsu.elixirs.server.events;

import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.common.registry.ElixirsPotions;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

// 1.21 : les recettes d'alambic ne sont plus dans un registre global mutable, elles sont
// reconstruites par PotionBrewing a chaque chargement de monde via cet event (bus principal).
@EventBusSubscriber(modid = Elixirs.MODID)
public class RecipeInitEvent {

	@SubscribeEvent
	public static void onRegisterBrewingRecipes(RegisterBrewingRecipesEvent event) {
		ElixirsPotions.initRecipes(event.getBuilder());
	}
}
