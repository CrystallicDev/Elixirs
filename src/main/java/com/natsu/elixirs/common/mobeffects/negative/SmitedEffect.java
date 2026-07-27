package com.natsu.elixirs.common.mobeffects.negative;

import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.level.Level;

public class SmitedEffect extends MobEffect {

	public SmitedEffect() {
		super(MobEffectCategory.HARMFUL, 0xCDFA46);
	}

	@Override
	public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity entity, int intValue) {
		Level world = entity.level();
		if (isSunBurnTick(world, entity) && entity.getRemainingFireTicks() <= 0) {
			entity.setRemainingFireTicks(50);
		}
		return true;
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int d, int a) {
		return d%5 == 0;
	}
	
	public static boolean isSunBurnTick(Level level, LivingEntity entity) {
		if (level.isBrightOutside() && !entity.level().isClientSide()) {
			float f = entity.getLightLevelDependentMagicValue();
			BlockPos blockpos = BlockPos.containing(entity.getX(), entity.getEyeY(), entity.getZ());
			boolean flag = entity.isInWaterOrRain() || entity.isInPowderSnow || entity.wasInPowderSnow;
			if (f > 0.5F && !flag && entity.level().canSeeSky(blockpos)) {
				return true;
			}
		}
		return false;
	}
	
	
	
}