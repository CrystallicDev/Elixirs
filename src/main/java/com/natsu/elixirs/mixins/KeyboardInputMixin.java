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

@Mixin(value = KeyboardInput.class, remap = false)
public class KeyboardInputMixin extends ClientInput {

	// 26.1 : l'input est un record immuable (ClientInput.keyPresses), plus des champs impulse/jumping.
	// Inverser les contrôles (effet Confused) = reconstruire l'Input avec avant<->arrière,
	// gauche<->droite et saut<->sneak permutés.
	@Inject(method = "tick", at = @At("TAIL"))
	private void onTick(CallbackInfo ci) {
		LocalPlayer player = Minecraft.getInstance().player;
		if (player == null || !player.hasEffect(ElixirsEffects.CONFUSED)) return;
		Input kp = this.keyPresses;
		this.keyPresses = new Input(kp.backward(), kp.forward(), kp.right(), kp.left(), kp.shift(), kp.jump(), kp.sprint());
	}
}
