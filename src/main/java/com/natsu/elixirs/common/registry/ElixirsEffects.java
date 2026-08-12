package com.natsu.elixirs.common.registry;

import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.common.mobeffects.negative.AphagiaEffect;
import com.natsu.elixirs.common.mobeffects.negative.AttractionEffect;
import com.natsu.elixirs.common.mobeffects.negative.BleedingEffect;
import com.natsu.elixirs.common.mobeffects.negative.BurnedEffect;
import com.natsu.elixirs.common.mobeffects.negative.ConfusedEffect;
import com.natsu.elixirs.common.mobeffects.negative.CrumblingEffect;
import com.natsu.elixirs.common.mobeffects.negative.DeafenedEffect;
import com.natsu.elixirs.common.mobeffects.negative.DecayEffect;
import com.natsu.elixirs.common.mobeffects.negative.DepthCrushEffect;
import com.natsu.elixirs.common.mobeffects.negative.FearEffect;
import com.natsu.elixirs.common.mobeffects.negative.FrozenEffect;
import com.natsu.elixirs.common.mobeffects.negative.FrozenSolidEffect;
import com.natsu.elixirs.common.mobeffects.negative.HeavyEffect;
import com.natsu.elixirs.common.mobeffects.negative.HyperchargedEffect;
import com.natsu.elixirs.common.mobeffects.negative.LeechEffect;
import com.natsu.elixirs.common.mobeffects.negative.ParalysisEffect;
import com.natsu.elixirs.common.mobeffects.negative.RustedEffect;
import com.natsu.elixirs.common.mobeffects.negative.ShakenEffect;
import com.natsu.elixirs.common.mobeffects.negative.SmitedEffect;
import com.natsu.elixirs.common.mobeffects.negative.SymbiosisEffect;
import com.natsu.elixirs.common.mobeffects.negative.UnstableEffect;
import com.natsu.elixirs.common.mobeffects.positive.CleansedEffect;
import com.natsu.elixirs.common.mobeffects.positive.EnduranceEffect;
import com.natsu.elixirs.common.mobeffects.positive.FrictionEffect;
import com.natsu.elixirs.common.mobeffects.positive.RejuvenationEffect;
import com.natsu.elixirs.common.mobeffects.positive.SlipperyEffect;
import com.natsu.elixirs.common.mobeffects.positive.WrathEffect;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;

public class ElixirsEffects {

	// Positive
	public static MobEffect REJUVENATION;
	public static MobEffect CLEANSED;
	public static MobEffect WRATH;
	public static MobEffect ENDURANCE;
	public static MobEffect FRICTION;
	public static MobEffect SLIPPERY;

	// Negative
	public static MobEffect CRUMBLING;
	public static MobEffect HYPERCHARGED;
	public static MobEffect BURNED;
	public static MobEffect DEPTH_CRUSH;
	public static MobEffect FROZEN;
	public static MobEffect APHAGIA;
	public static MobEffect FEAR;
	public static MobEffect DEAFENED;
	public static MobEffect BLEEDING;
	public static MobEffect SMITED;
	public static MobEffect DECAY;
	public static MobEffect PARALYSIS;
	public static MobEffect FROZEN_SOLID;
	public static MobEffect SYMBIOSIS;
	public static MobEffect HEAVY;
	public static MobEffect ATTRACTION;
	public static MobEffect LEECH;
	public static MobEffect UNSTABLE;
	public static MobEffect RUSTED;
	public static MobEffect SHAKEN;
	public static MobEffect CONFUSED;

	public static void register() {
		// Positive
		REJUVENATION = reg("rejuvenation", new RejuvenationEffect());
		CLEANSED = reg("cleansed", new CleansedEffect());
		WRATH = reg("wrath", new WrathEffect());
		ENDURANCE = reg("endurance", new EnduranceEffect());
		FRICTION = reg("friction", new FrictionEffect());
		SLIPPERY = reg("slippery", new SlipperyEffect());

		// Negative
		CRUMBLING = reg("crumbling", new CrumblingEffect());
		HYPERCHARGED = reg("hypercharged", new HyperchargedEffect());
		BURNED = reg("burned", new BurnedEffect());
		DEPTH_CRUSH = reg("depth_crush", new DepthCrushEffect());
		FROZEN = reg("frozen", new FrozenEffect());
		APHAGIA = reg("aphagia", new AphagiaEffect());
		FEAR = reg("fear", new FearEffect());
		DEAFENED = reg("deafened", new DeafenedEffect());
		BLEEDING = reg("bleeding", new BleedingEffect());
		SMITED = reg("smited", new SmitedEffect());
		DECAY = reg("decay", new DecayEffect());
		PARALYSIS = reg("paralysis", new ParalysisEffect());
		FROZEN_SOLID = reg("frozen_solid", new FrozenSolidEffect());
		SYMBIOSIS = reg("symbiosis", new SymbiosisEffect());
		HEAVY = reg("heavy", new HeavyEffect());
		ATTRACTION = reg("attraction", new AttractionEffect());
		LEECH = reg("leech", new LeechEffect());
		UNSTABLE = reg("unstable", new UnstableEffect());
		RUSTED = reg("rusted", new RustedEffect());
		SHAKEN = reg("shaken", new ShakenEffect());
		CONFUSED = reg("confused", new ConfusedEffect());
	}

	private static MobEffect reg(String name, MobEffect effect) {
		return Registry.register(Registry.MOB_EFFECT, new ResourceLocation(Elixirs.MODID, name), effect);
	}

}
