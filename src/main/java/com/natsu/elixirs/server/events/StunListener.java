package com.natsu.elixirs.server.events;

import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;

public class StunListener {

	// Le joueur figé (Paralysie / Gelé sur place) ne peut ni attaquer ni interagir.
	private static boolean isStunned(Player player) {
		return player != null
				&& (player.hasEffect(ElixirsEffects.PARALYSIS) || player.hasEffect(ElixirsEffects.FROZEN_SOLID));
	}

	public static void register() {
		AttackEntityCallback.EVENT.register((player, level, hand, entity, hitResult) ->
				isStunned(player) ? InteractionResult.FAIL : InteractionResult.PASS);

		AttackBlockCallback.EVENT.register((player, level, hand, pos, direction) ->
				isStunned(player) ? InteractionResult.FAIL : InteractionResult.PASS);

		UseBlockCallback.EVENT.register((player, level, hand, hitResult) ->
				isStunned(player) ? InteractionResult.FAIL : InteractionResult.PASS);

		UseItemCallback.EVENT.register((player, level, hand) ->
				isStunned(player)
						? InteractionResultHolder.fail(player.getItemInHand(hand))
						: InteractionResultHolder.pass(player.getItemInHand(hand)));
	}

}
