package com.natsu.elixirs.common.mobeffects.positive;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.phys.Vec3;

public class FrictionEffect extends MobEffect {

    public FrictionEffect() {
        super(MobEffectCategory.NEUTRAL, 0xFACAD3);
    }
}