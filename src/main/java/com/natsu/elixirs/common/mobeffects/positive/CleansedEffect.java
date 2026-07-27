package com.natsu.elixirs.common.mobeffects.positive;

import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;

public class CleansedEffect extends MobEffect {

	public CleansedEffect() {
		super(MobEffectCategory.BENEFICIAL, 0x185429);
	}
	
	@Override
	public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity entity, int intValue) {
		
		entity.removeEffect(MobEffects.POISON);
		entity.removeEffect(MobEffects.WITHER);
		entity.removeEffect(MobEffects.WEAKNESS);
		entity.removeEffect(MobEffects.SLOWNESS);
		entity.removeEffect(ElixirsEffects.DECAY);
		entity.removeEffect(ElixirsEffects.SMITED);
		return true;
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int d, int a) {
		return d%5 == 0;
	}
	
}