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

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;
import net.minecraftforge.registries.RegistryObject;

public class ElixirsEffects {

	public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Elixirs.MODID);
	
	// Positive
	public static final RegistryObject<MobEffect> REJUVENATION = EFFECTS.register("rejuvenation", 
			() -> new RejuvenationEffect());
	public static final RegistryObject<MobEffect> CLEANSED = EFFECTS.register("cleansed", 
			() -> new CleansedEffect());
	public static final RegistryObject<MobEffect> WRATH = EFFECTS.register("wrath", 
			() -> new WrathEffect());
	public static final RegistryObject<MobEffect> ENDURANCE = EFFECTS.register("endurance", 
			() -> new EnduranceEffect());
	public static final RegistryObject<MobEffect> FRICTION = EFFECTS.register("friction", 
			() -> new FrictionEffect());
	public static final RegistryObject<MobEffect> SLIPPERY = EFFECTS.register("slippery", 
			() -> new SlipperyEffect());
	
	//Negative
	public static final RegistryObject<MobEffect> CRUMBLING = EFFECTS.register("crumbling", 
			() -> new CrumblingEffect());
	public static final RegistryObject<MobEffect> HYPERCHARGED = EFFECTS.register("hypercharged", 
			() -> new HyperchargedEffect());
	public static final RegistryObject<MobEffect> BURNED = EFFECTS.register("burned", 
			() -> new BurnedEffect());
	public static final RegistryObject<MobEffect> DEPTH_CRUSH = EFFECTS.register("depth_crush", 
			() -> new DepthCrushEffect());
	public static final RegistryObject<MobEffect> FROZEN = EFFECTS.register("frozen", 
			() -> new FrozenEffect());
	public static final RegistryObject<MobEffect> APHAGIA = EFFECTS.register("aphagia", 
			() -> new AphagiaEffect());
	public static final RegistryObject<MobEffect> FEAR = EFFECTS.register("fear", 
			() -> new FearEffect());
	public static final RegistryObject<MobEffect> DEAFENED = EFFECTS.register("deafened", 
			() -> new DeafenedEffect());
	public static final RegistryObject<MobEffect> BLEEDING = EFFECTS.register("bleeding", 
			() -> new BleedingEffect());
	public static final RegistryObject<MobEffect> SMITED = EFFECTS.register("smited", 
			() -> new SmitedEffect());
	public static final RegistryObject<MobEffect> DECAY = EFFECTS.register("decay", 
			() -> new DecayEffect());
	public static final RegistryObject<MobEffect> PARALYSIS = EFFECTS.register("paralysis",
			() -> new ParalysisEffect());
	public static final RegistryObject<MobEffect> FROZEN_SOLID = EFFECTS.register("frozen_solid", 
			() -> new FrozenSolidEffect());
	public static final RegistryObject<MobEffect> SYMBIOSIS = EFFECTS.register("symbiosis", 
			() -> new SymbiosisEffect());
	public static final RegistryObject<MobEffect> HEAVY = EFFECTS.register("heavy", 
			() -> new HeavyEffect());
	public static final RegistryObject<MobEffect> ATTRACTION = EFFECTS.register("attraction", 
			() -> new AttractionEffect());
	public static final RegistryObject<MobEffect> LEECH = EFFECTS.register("leech", 
			() -> new LeechEffect());
	public static final RegistryObject<MobEffect> UNSTABLE = EFFECTS.register("unstable", 
			() -> new UnstableEffect());
	public static final RegistryObject<MobEffect> RUSTED = EFFECTS.register("rusted", 
			() -> new RustedEffect());
	public static final RegistryObject<MobEffect> SHAKEN = EFFECTS.register("shaken", 
			() -> new ShakenEffect());
	public static final RegistryObject<MobEffect> CONFUSED = EFFECTS.register("confused", 
			() -> new ConfusedEffect());
	
}
