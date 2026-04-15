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
    private void onTick(boolean isSneaking, float sneakingSpeedFactor, CallbackInfo ci) {
        LocalPlayer player = net.minecraft.client.Minecraft.getInstance().player;
        if (player == null) return;
        if (!player.hasEffect(ElixirsEffects.CONFUSED.get())) return; 
        float oldForward = this.forwardImpulse;
        this.forwardImpulse = -this.forwardImpulse;
        this.leftImpulse = -this.leftImpulse;
        boolean oldJump = this.jumping;
        this.jumping = this.shiftKeyDown;
        this.shiftKeyDown = oldJump;
    }
}