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

	public static final UUID FrozenMoveSpeedModifierUUID = UUID.fromString("636df67c-ee75-46fb-b508-b2207ec04a69");
	public static final UUID FrozenDigSpeedModifierUUID = UUID.fromString("049b6bb0-c62d-4460-be11-48fd852ae9ce");
	
	public FrozenEffect() {
		super(MobEffectCategory.HARMFUL, 0xFFFFFF);
	}

	@Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {

        AttributeInstance speed = entity.getAttribute(Attributes.MOVEMENT_SPEED);
        if(speed == null) return;

        boolean inWater = entity.isInWater();

        AttributeModifier modifier = new AttributeModifier(
        		FrozenMoveSpeedModifierUUID,
                "water_speed_penalty",
                -0.2,
                AttributeModifier.Operation.MULTIPLY_TOTAL
        );

        if(inWater) {
            if(speed.getModifier(FrozenMoveSpeedModifierUUID) == null) {
                speed.addTransientModifier(modifier);
            }
        } else {
            if(speed.getModifier(FrozenMoveSpeedModifierUUID) != null) {
                speed.removeModifier(FrozenMoveSpeedModifierUUID);
            }
        }
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
            speed.removeModifier(FrozenMoveSpeedModifierUUID);
        }
    }
	
}
