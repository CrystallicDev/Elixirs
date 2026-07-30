package com.natsu.elixirs.common.mobeffects.positive;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class WrathEffect extends MobEffect {

	// 1.20.6 : MobEffect.addAttributeModifier prend un String id (ResourceLocation = 1.21).
	public static final String WRATH_ATTACK_ID = "wrath_attack_damage";

	public WrathEffect() {
		super(MobEffectCategory.BENEFICIAL, 0xD10000);

		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, WRATH_ATTACK_ID,
				0.6, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
	}
}
