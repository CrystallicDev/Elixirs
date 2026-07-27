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
import net.minecraft.world.item.ItemStack;

public class RustedEffect extends MobEffect {

	// 1.21 : un modificateur d'attribut est identifié par une Identifier, plus par un UUID.
	public static final Identifier RUSTED_MOVE_SPEED_ID =
			Identifier.fromNamespaceAndPath(Elixirs.MODID, "rusted_move_speed");

	public RustedEffect() {
		super(MobEffectCategory.HARMFUL, 0x9E5600);
	}

	@Override
	public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity entity, int amplifier) {

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
		for (net.minecraft.world.entity.EquipmentSlot slot : new net.minecraft.world.entity.EquipmentSlot[]{
				net.minecraft.world.entity.EquipmentSlot.HEAD, net.minecraft.world.entity.EquipmentSlot.CHEST,
				net.minecraft.world.entity.EquipmentSlot.LEGS, net.minecraft.world.entity.EquipmentSlot.FEET}) {
			ItemStack stack = entity.getItemBySlot(slot);
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
