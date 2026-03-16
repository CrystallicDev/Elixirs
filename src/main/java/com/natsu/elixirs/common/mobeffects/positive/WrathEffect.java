package com.natsu.elixirs.common.mobeffects.positive;

import java.util.UUID;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class WrathEffect extends MobEffect {

	public static final String WrathAttackModifierUUID = "89dd1b8c-528a-46c0-9435-206da3e55953";
	
	public WrathEffect() {
		super(MobEffectCategory.BENEFICIAL, 0xD10000);
		
		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, 
				WrathAttackModifierUUID, 
				0.6, AttributeModifier.Operation.MULTIPLY_TOTAL);
	}
}
