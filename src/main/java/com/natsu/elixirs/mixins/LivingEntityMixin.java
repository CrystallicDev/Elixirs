package com.natsu.elixirs.mixins;

import javax.annotation.Nullable;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

@Mixin(value = LivingEntity.class)
public class LivingEntityMixin {

	@WrapOperation(method = "travel", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;getFriction(Lnet/minecraft/world/level/LevelReader;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/Entity;)F", remap = false))
	private float modifyFriction(BlockState state, LevelReader level, BlockPos pos, @Nullable Entity entity,
			Operation<Float> original) {
		// original.call préserve les wraps des autres mods sur getFriction
		float baseFriction = original.call(state, level, pos, entity);
		if (entity instanceof LivingEntity le && le.hasEffect(ElixirsEffects.FRICTION.get())) {
			return Math.min(0.6f, baseFriction);
		}
		return baseFriction;
	}
}