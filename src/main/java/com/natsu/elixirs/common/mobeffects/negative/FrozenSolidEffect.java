package com.natsu.elixirs.common.mobeffects.negative;

import javax.annotation.Nullable;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class FrozenSolidEffect extends MobEffect {

	public FrozenSolidEffect() {
		super(MobEffectCategory.HARMFUL, 0x08EBFF);
		
	}
	
	@Override
	public void applyInstantenousEffect(@Nullable Entity entity, @Nullable Entity entity2, LivingEntity victim, int p_19465_, double p_19466_) {
		victim.playSound(SoundEvents.GLASS_BREAK, 1.0f, 1.0f);
	}
}