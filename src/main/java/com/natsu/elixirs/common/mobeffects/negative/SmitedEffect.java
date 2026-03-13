package com.natsu.elixirs.common.mobeffects.negative;

import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

public class SmitedEffect extends MobEffect {

	public SmitedEffect() {
		super(MobEffectCategory.HARMFUL, 0xFFFFFF);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int intValue) {
		Level world = entity.getLevel();
		if (world.isDay() && world.canSeeSkyFromBelowWater(entity.blockPosition())) {
			entity.setRemainingFireTicks(entity.getRemainingFireTicks() + 5);
		}
		
	}

	@Override
	public boolean isDurationEffectTick(int d, int a) {
		return d%5 == 0;
	}
	
}