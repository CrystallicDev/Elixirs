package com.natsu.elixirs.common.mobeffects.positive;

import com.natsu.elixirs.Elixirs;

import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class WrathEffect extends MobEffect {

	// 1.21 : un modificateur d'attribut est identifié par une Identifier, plus par un UUID.
	public static final Identifier WRATH_ATTACK_ID =
			Identifier.fromNamespaceAndPath(Elixirs.MODID, "wrath_attack_damage");

	public WrathEffect() {
		super(MobEffectCategory.BENEFICIAL, 0xD10000);

		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, WRATH_ATTACK_ID,
				0.6, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
	}
}
