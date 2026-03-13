package com.natsu.elixirs.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.natsu.elixirs.common.registry.ElixirsEffects;

import org.spongepowered.asm.mixin.injection.At;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Player;

@Mixin(Player.class)
public class PlayerMixin {

	@Inject(method = "playSound(Lnet/minecraft/sounds/SoundEvent;FF)V", at = @At("HEAD"), cancellable = true)
	private void cancelSound(SoundEvent ev, float volume, float pitch, CallbackInfo cb) {
		Player player = (Player)(Object)this;
		if (player.hasEffect(ElixirsEffects.DEAFENED.get())) {
			cb.cancel();
		}
	}
	
}
