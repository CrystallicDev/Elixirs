package com.natsu.elixirs.client.render;

import com.natsu.elixirs.Elixirs;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

/**
 * Ajoutait la {@code FrozenSolidLayer} à tous les renderers d'entités.
 *
 * <p>TODO 26.1.2 : désactivé le temps de porter l'overlay gelé au nouveau pipeline "entity render
 * state" (voir {@link FrozenSolidHandler}). L'effet gameplay FROZEN_SOLID reste actif ailleurs.
 */
@EventBusSubscriber(modid = Elixirs.MODID, value = Dist.CLIENT)
public class FrozenLayerRenderEvent {

	@SubscribeEvent
	public static void onAddLayers(EntityRenderersEvent.AddLayers event) {
		// no-op : voir TODO ci-dessus (overlay gelé à re-porter au render state 26.1).
	}
}
