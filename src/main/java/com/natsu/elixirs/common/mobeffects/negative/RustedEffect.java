package com.natsu.elixirs.common.mobeffects.negative;

import java.util.UUID;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;

public class RustedEffect extends MobEffect {

	public static final UUID RustedMoveSpeedModifierUUID = UUID.fromString("407d5b4f-f9d0-4820-9f5d-fbd5b49bed02");
	
	public RustedEffect() {
		super(MobEffectCategory.HARMFUL, 0x9E5600);
	}

	@Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {

        AttributeInstance speed = entity.getAttribute(Attributes.MOVEMENT_SPEED);
        if(speed == null) return;

        // -15% par pièce d'armure, recalculé chaque tick pour suivre l'équipement
        double desired = -0.15 * getTotalArmorPieces(entity);
        AttributeModifier current = speed.getModifier(RustedMoveSpeedModifierUUID);

        if (current != null && current.getAmount() == desired) return; // déjà à jour

        if (current != null) {
            speed.removeModifier(RustedMoveSpeedModifierUUID);
        }
        if (desired != 0.0) {
            speed.addTransientModifier(new AttributeModifier(
                    RustedMoveSpeedModifierUUID,
                    "armor_move_speed_penalty",
                    desired,
                    AttributeModifier.Operation.MULTIPLY_TOTAL));
        }
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
	public boolean isDurationEffectTick(int d, int a) {
		return true;
	}
	
	@Override
    public void removeAttributeModifiers(LivingEntity entity,
                                         AttributeMap attributes,
                                         int amplifier) {

        super.removeAttributeModifiers(entity, attributes, amplifier);

        AttributeInstance speed = entity.getAttribute(Attributes.MOVEMENT_SPEED);

        if(speed != null) {
            speed.removeModifier(RustedMoveSpeedModifierUUID);
        }
    }
	
}