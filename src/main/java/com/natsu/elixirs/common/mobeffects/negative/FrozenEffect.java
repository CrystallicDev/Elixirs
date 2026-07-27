package com.natsu.elixirs.common.mobeffects.negative;

import com.natsu.elixirs.Elixirs;

import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class FrozenEffect extends MobEffect {

	// 1.21 : un modificateur d'attribut est identifié par une Identifier, plus par un UUID.
	public static final Identifier FROZEN_MOVE_SPEED_ID =
			Identifier.fromNamespaceAndPath(Elixirs.MODID, "frozen_move_speed");

	public FrozenEffect() {
		super(MobEffectCategory.HARMFUL, 0x08EBFF);
	}

	@Override
	public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity entity, int amplifier) {

		AttributeInstance speed = entity.getAttribute(Attributes.MOVEMENT_SPEED);
		if (speed == null) return true;

		if (entity.isInWater()) {
			if (speed.getModifier(FROZEN_MOVE_SPEED_ID) == null) {
				speed.addTransientModifier(new AttributeModifier(
						FROZEN_MOVE_SPEED_ID, -0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
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
