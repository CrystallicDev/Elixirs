package com.natsu.elixirs.common.mobeffects.negative;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class DecayEffect extends MobEffect {

	public DecayEffect() {
		super(MobEffectCategory.HARMFUL, 0xFFFFFF);
		
	}
}