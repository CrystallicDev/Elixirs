package com.natsu.elixirs.common.mobeffects.negative;

import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

public class SmitedEffect extends MobEffect {

	public SmitedEffect() {
		super(MobEffectCategory.HARMFUL, 0xFFFFFF);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int intValue) {
		Level world = entity.getLevel();
		if (isSunBurnTick(world, entity) && entity.getRemainingFireTicks() <= 0) {
			entity.setRemainingFireTicks(50);
		}
	}

	@Override
	public boolean isDurationEffectTick(int d, int a) {
		return d%5 == 0;
	}
	
	public static boolean isSunBurnTick(Level level, LivingEntity entity) {
		if (level.isDay() && !entity.level.isClientSide) {
			float f = entity.getBrightness();
			BlockPos blockpos = new BlockPos(entity.getX(), entity.getEyeY(), entity.getZ());
			boolean flag = entity.isInWaterRainOrBubble() || entity.isInPowderSnow || entity.wasInPowderSnow;
			if (f > 0.5F && !flag && entity.level.canSeeSky(blockpos)) {
				return true;
			}
		}
		return false;
	}
	
	
	
}