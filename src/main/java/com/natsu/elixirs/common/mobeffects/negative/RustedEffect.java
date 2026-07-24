package com.natsu.elixirs.common.mobeffects.negative;

import com.natsu.elixirs.Elixirs;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;

public class RustedEffect extends MobEffect {

	// 1.21 : un modificateur d'attribut est identifié par une ResourceLocation, plus par un UUID.
	public static final ResourceLocation RUSTED_MOVE_SPEED_ID =
			ResourceLocation.fromNamespaceAndPath(Elixirs.MODID, "rusted_move_speed");

	public RustedEffect() {
		super(MobEffectCategory.HARMFUL, 0x9E5600);
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {

		AttributeInstance speed = entity.getAttribute(Attributes.MOVEMENT_SPEED);
		if (speed == null) return true;

		// -15% par pièce d'armure, recalculé chaque tick pour suivre l'équipement
		double desired = -0.15 * getTotalArmorPieces(entity);
		AttributeModifier current = speed.getModifier(RUSTED_MOVE_SPEED_ID);

		if (current != null && current.amount() == desired) return true; // déjà à jour

		if (current != null) {
			speed.removeModifier(RUSTED_MOVE_SPEED_ID);
		}
		if (desired != 0.0) {
			speed.addTransientModifier(new AttributeModifier(
					RUSTED_MOVE_SPEED_ID, desired, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
		}
		return true;
	}

	private int getTotalArmorPieces(LivingEntity entity) {
		int count = 0;
		for (ItemStack stack : entity.getArmorSlots()) {
			if (stack == null || stack.isEmpty()) continue;
			count++;
		}
		return count;
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
			speed.removeModifier(RUSTED_MOVE_SPEED_ID);
		}
	}

}
