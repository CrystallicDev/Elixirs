package com.natsu.elixirs.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;

// Shaken screen shake. Fabric has no camera-setup event here, so we nudge the camera yaw/pitch
// right after vanilla positions it. Amount eases toward a random target each frame for a jitter feel.
@Mixin(Camera.class)
public abstract class CameraMixin {

	@Shadow private float xRot;
	@Shadow private float yRot;

	@Shadow protected abstract void setRotation(float yaw, float pitch);

	private static float elixirs$shakeX = 0.0F;
	private static float elixirs$shakeY = 0.0F;

	@Inject(method = "setup", at = @At("TAIL"))
	private void elixirs$shake(BlockGetter level, Entity entity, boolean detached, boolean thirdPersonReverse,
			float partialTicks, CallbackInfo ci) {
		LocalPlayer player = Minecraft.getInstance().player;
		if (player == null || !player.hasEffect(ElixirsEffects.SHAKEN)) {
			elixirs$shakeX = 0.0F;
			elixirs$shakeY = 0.0F;
			return;
		}
		MobEffectInstance effect = player.getEffect(ElixirsEffects.SHAKEN);
		float intensity = 0.5F * (effect.getAmplifier() + 1);
		elixirs$shakeX += ((float) (Math.random() * 2 - 1) * intensity - elixirs$shakeX) * 0.3F;
		elixirs$shakeY += ((float) (Math.random() * 2 - 1) * intensity - elixirs$shakeY) * 0.3F;
		this.setRotation(this.yRot + elixirs$shakeX, this.xRot + elixirs$shakeY);
	}
}
