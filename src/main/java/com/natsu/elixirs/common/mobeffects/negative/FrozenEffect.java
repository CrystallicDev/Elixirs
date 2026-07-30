package com.natsu.elixirs.common.mobeffects.negative;

import java.util.UUID;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class FrozenEffect extends MobEffect {

	// 1.20.6 : un modificateur d'attribut est encore identifié par un UUID (ResourceLocation = 1.21).
	public static final UUID FROZEN_MOVE_SPEED_ID = UUID.fromString("636df67c-ee75-46fb-b508-b2207ec04a69");

	public FrozenEffect() {
		super(MobEffectCategory.HARMFUL, 0x08EBFF);
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {

		AttributeInstance speed = entity.getAttribute(Attributes.MOVEMENT_SPEED);
		if (speed == null) return true;

		if (entity.isInWater()) {
			if (speed.getModifier(FROZEN_MOVE_SPEED_ID) == null) {
				speed.addTransientModifier(new AttributeModifier(
						FROZEN_MOVE_SPEED_ID, "frozen_move_speed", -0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
			}
		} else {
			speed.removeModifier(FROZEN_MOVE_SPEED_ID);
		}
		return true;
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int d, int a) {
		return true;
	}

	@Override
	public void removeAttributeModifiers(AttributeMap attributes) {
		super.removeAttributeModifiers(attributes);

		AttributeInstance speed = attributes.getInstance(Attributes.MOVEMENT_SPEED);
		if (speed != null) {
			speed.removeModifier(FROZEN_MOVE_SPEED_ID);
		}
	}

}
