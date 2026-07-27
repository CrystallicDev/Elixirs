package com.natsu.elixirs.client.render;

import com.natsu.elixirs.Elixirs;

import net.minecraft.resources.Identifier;

/**
 * Overlay visuel "gelé" (texture appliquée sur les entités sous l'effet FROZEN_SOLID).
 *
 * <p>TODO 26.1.2 : la refonte "entity render state" fait que les RenderLayer ne reçoivent plus
 * l'entité (mais un {@code LivingEntityRenderState}) — impossible de tester {@code hasEffect} dans
 * la layer sans injecter le flag dans le render state (via {@code RegisterRenderStateModifiersEvent}).
 * La layer est donc désactivée pour l'instant ; seul le VISUEL est perdu, l'effet gameplay (blocage
 * des mouvements) reste géré par StunListener + KeyboardInputMixin. À réimplémenter proprement plus tard.
 */
public class FrozenSolidHandler {

	public static final Identifier FROZEN_OVERLAY = Identifier.fromNamespaceAndPath(Elixirs.MODID, "textures/entity/frozen_solid.png");

}
