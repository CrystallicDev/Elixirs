package com.natsu.elixirs.common.mobeffects.negative;

import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class DepthCrushEffect extends MobEffect {

	public DepthCrushEffect() {
		super(MobEffectCategory.HARMFUL, 0xFFFFFF);
	}
	
	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {

	    if (!entity.level.isClientSide) {
	        if (entity.isEyeInFluid(FluidTags.WATER)) {

	            entity.setAirSupply(0);
	            entity.hurt(DamageSource.DROWN, 2.0F);
	        }
	    }
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
	    return duration % 20 == 0;
	}
}