package com.natsu.elixirs.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.phys.Vec3;

@Mixin(Boat.class)
public abstract class BoatMixin {

	@Inject(method = "tocl", at = @At("HEAD"))
	private void adaptFriction(Vec3 travelVector, CallbackInfo cb) {
		try {
			Boat boat = (Boat) (Object) this;
			if (boat.getPassengers().stream().anyMatch(e -> isSlip(e))) {
				Vec3 motion = boat.getDeltaMovement();
				boat.setDeltaMovement(motion.x * 1.01, motion.y, motion.z * 1.01);
			}
		} catch (Exception er) {
			er.printStackTrace();
			// Could happen a lot with mixins and mods
		}
		
	}
	
	private static boolean isSlip(Entity entity) {
		if (entity instanceof LivingEntity) {
			LivingEntity livingEntity = (LivingEntity)entity;
			return livingEntity.hasEffect(ElixirsEffects.SLIPPERY.get());
		}
		return false;
	}
	
	
}
