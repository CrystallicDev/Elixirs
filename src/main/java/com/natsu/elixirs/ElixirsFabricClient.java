package com.natsu.elixirs;

import com.natsu.elixirs.client.events.StunListener;
import com.natsu.elixirs.client.render.FrozenSolidHandler;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;

public class ElixirsFabricClient implements ClientModInitializer {

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onInitializeClient() {
		// Ajoute la couche de rendu "gelé sur place" à tous les renderers d'entités vivantes
		LivingEntityFeatureRendererRegistrationCallback.EVENT.register(
				(entityType, entityRenderer, registrationHelper, context) -> {
					LivingEntityRenderer raw = entityRenderer;
					registrationHelper.register(new FrozenSolidHandler.FrozenSolidLayer(raw));
				});

		// Blocage des entrées clavier quand le joueur est figé
		StunListener.register();
	}

}
