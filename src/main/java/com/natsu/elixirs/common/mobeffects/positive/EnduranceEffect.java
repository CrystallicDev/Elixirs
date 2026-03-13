package com.natsu.elixirs.common.mobeffects.positive;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class EnduranceEffect extends MobEffect {

	public static final String EnduranceArmorModifierUUID = "e90ee74b-528a-4fd8-94f0-8338c3b06794";
	
	public EnduranceEffect() {
		super(MobEffectCategory.BENEFICIAL, 0xFFFFFF);
		
		this.addAttributeModifier(Attributes.ARMOR, 
				EnduranceArmorModifierUUID, 
				0.1, AttributeModifier.Operation.MULTIPLY_TOTAL);
	}
}

