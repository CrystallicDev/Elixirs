package com.natsu.elixirs.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.ClientInput;
import net.minecraft.client.player.KeyboardInput;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Input;
import net.minecraft.world.phys.Vec2;

/**
 * 26.1 : l'input du joueur est calculé DANS {@code KeyboardInput.tick()} — le record immuable
 * {@code keyPresses} ET le {@code moveVector} (le déplacement réel). Toute suppression/altération
 * d'input doit donc se faire APRÈS ce calcul (TAIL), sinon elle a un tick de retard (ex : le saut de
 * Heavy passait quand même un frame → petit hop). On centralise ici les effets qui touchent l'input.
 */
@Mixin(value = KeyboardInput.class, remap = false)
public class KeyboardInputMixin extends ClientInput {

	@Inject(method = "tick", at = @At("TAIL"))
	private void onTick(CallbackInfo ci) {
		LocalPlayer player = Minecraft.getInstance().player;
		if (player == null) return;
		Input kp = this.keyPresses;

		if (player.hasEffect(ElixirsEffects.PARALYSIS) || player.hasEffect(ElixirsEffects.FROZEN_SOLID)) {
			// immobilisation totale
			this.moveVector = Vec2.ZERO;
			this.keyPresses = new Input(false, false, false, false, false, false, false);
		} else if (player.hasEffect(ElixirsEffects.HEAVY)) {
			// pas de saut (le déplacement au sol reste autorisé)
			this.keyPresses = new Input(kp.forward(), kp.backward(), kp.left(), kp.right(), false, kp.shift(), kp.sprint());
		} else if (player.hasEffect(ElixirsEffects.CONFUSED)) {
			// contrôles inversés : négater le moveVector (déplacement) + permuter keyPresses (saut<->sneak)
			this.moveVector = new Vec2(-this.moveVector.x, -this.moveVector.y);
			this.keyPresses = new Input(kp.backward(), kp.forward(), kp.right(), kp.left(), kp.shift(), kp.jump(), kp.sprint());
		}
	}
}
