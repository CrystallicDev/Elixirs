package com.natsu.elixirs.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.phys.Vec3;



@Mixin(value = Boat.class)
public class BoatMixin {

    @Inject(method = "getGroundFriction()F", at = @At("RETURN"), cancellable = true)
    private void modifyGroundFriction(CallbackInfoReturnable<Float> cir) {
        Boat boat = (Boat)(Object)this;
        float baseFriction = cir.getReturnValue();
        if (!boat.getPassengers().isEmpty()) {
            if (boat.getPassengers().get(0) instanceof LivingEntity living) {
                if (living.hasEffect(ElixirsEffects.SLIPPERY.get())) {
                    cir.setReturnValue(Math.max(0.98f, baseFriction));
                    return;
                }
            }
        }
    }
}