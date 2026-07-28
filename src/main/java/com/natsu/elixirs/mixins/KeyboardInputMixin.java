package com.natsu.elixirs.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.Input;
import net.minecraft.client.player.KeyboardInput;
import net.minecraft.client.player.LocalPlayer;

/**
 * L'input du joueur est recalculé à chaque {@code tick()}. Toute suppression/altération doit se faire
 * APRÈS ce calcul (TAIL), sinon elle a un tick de retard (ex : le saut de Heavy passait quand même un
 * frame → petit hop). On centralise ici les effets qui touchent l'input.
 */
@Mixin(value = KeyboardInput.class, remap = false)
public class KeyboardInputMixin extends Input {

    @Inject(method = "tick(ZF)V", at = @At("TAIL"))
    private void onTick(boolean isSneaking, float movementMultiplier, CallbackInfo ci) {
        LocalPlayer player = Minecraft.getInstance().player;
        if (player == null) return;

        if (player.hasEffect(ElixirsEffects.PARALYSIS) || player.hasEffect(ElixirsEffects.FROZEN_SOLID)) {
            // immobilisation totale
            this.up = false;
            this.down = false;
            this.left = false;
            this.right = false;
            this.jumping = false;
            this.shiftKeyDown = false;
            this.forwardImpulse = 0.0f;
            this.leftImpulse = 0.0f;
        } else if (player.hasEffect(ElixirsEffects.HEAVY)) {
            // pas de saut (le déplacement au sol reste autorisé)
            this.jumping = false;
        } else if (player.hasEffect(ElixirsEffects.CONFUSED)) {
            // contrôles inversés
            this.forwardImpulse = -this.forwardImpulse;
            this.leftImpulse = -this.leftImpulse;
            boolean oldJump = this.jumping;
            this.jumping = this.shiftKeyDown;
            this.shiftKeyDown = oldJump;
        }
    }
}
