package com.natsu.elixirs.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(Player.class)
public abstract class PlayerMixin {

	// Frozen : ralentit le minage quand le joueur est dans l'eau ou sous la pluie (ancien PlayerEvent.BreakSpeed)
	@Inject(method = "getDestroySpeed", at = @At("RETURN"), cancellable = true)
	private void elixirs$frozenBreakSpeed(BlockState state, CallbackInfoReturnable<Float> cir) {
		Player self = (Player) (Object) this;
		if (self.hasEffect(ElixirsEffects.FROZEN) && self.isInWaterOrRain()) {
			int level = self.getEffect(ElixirsEffects.FROZEN).getAmplifier() + 1;
			cir.setReturnValue(Math.max(0, cir.getReturnValueF() * (1 - (0.2f * level))));
		}
	}

}
