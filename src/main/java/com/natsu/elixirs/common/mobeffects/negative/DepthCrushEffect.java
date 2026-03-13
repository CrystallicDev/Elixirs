package com.natsu.elixirs.common.mobeffects.negative;

import com.natsu.elixirs.common.registry.ElixirsEffects;

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
	public void applyEffectTick(LivingEntity entity, int intValue) {
		
		entity.setAirSupply(0);
		
	}
	
	@Override
	public boolean isDurationEffectTick(int d, int a) {
		return true;
	}
}