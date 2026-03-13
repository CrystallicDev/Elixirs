package com.natsu.elixirs.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.phys.Vec3;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

	@Inject(method = "travel(Lnet/minecraft/world/entity/ai/control/MoveControl$MovementInput;)V", at = @At("HEAD"), cancellable = true)
	private void adaptFriction(Vec3 travelVector, CallbackInfo cb) {
		try {
			LivingEntity entity = (LivingEntity)(Object)this;
			
			if (entity.hasEffect(ElixirsEffects.SLIPPERY.get())) {
				float sliperiness = 0.98F;
				Vec3 motion = entity.getDeltaMovement();
				entity.setDeltaMovement(motion.x * sliperiness / 0.6F,
						motion.y,
						motion.z * sliperiness / 0.6F);
			}
			
			if (entity.hasEffect(ElixirsEffects.FRICTION.get())) {
				float antiSliperiness = 0.5F;
				Vec3 motion = entity.getDeltaMovement();
				entity.setDeltaMovement(motion.x * antiSliperiness / 0.6F,
						motion.y,
						motion.z * antiSliperiness / 0.6F);
			}
		} catch (Exception er) {
			er.printStackTrace();
			//Could happen a lot with mixins and mods
		}
		
	}
	
	
}