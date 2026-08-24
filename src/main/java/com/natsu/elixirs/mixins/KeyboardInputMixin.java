package com.natsu.elixirs.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.client.player.Input;
import org.spongepowered.asm.mixin.injection.At;
import net.minecraft.client.player.KeyboardInput;
import net.minecraft.client.player.LocalPlayer;

@Mixin(KeyboardInput.class)
public class KeyboardInputMixin extends Input {

    @Inject(method = "tick", at = @At("TAIL"))
    private void onTick(boolean isSneaking, CallbackInfo ci) {
        LocalPlayer player = net.minecraft.client.Minecraft.getInstance().player;
        if (player == null) return;

        // frozen/paralysed: kill the input here, before movement reads it, so there's no residual walk.
        if (player.hasEffect(ElixirsEffects.PARALYSIS) || player.hasEffect(ElixirsEffects.FROZEN_SOLID)) {
            this.forwardImpulse = 0.0F;
            this.leftImpulse = 0.0F;
            this.up = false;
            this.down = false;
            this.left = false;
            this.right = false;
            this.jumping = false;
            return;
        }

        if (!player.hasEffect(ElixirsEffects.CONFUSED)) return;
        float oldForward = this.forwardImpulse;
        this.forwardImpulse = -this.forwardImpulse;
        this.leftImpulse = -this.leftImpulse;
        boolean oldJump = this.jumping;
        this.jumping = this.shiftKeyDown;
        this.shiftKeyDown = oldJump;
    }
}