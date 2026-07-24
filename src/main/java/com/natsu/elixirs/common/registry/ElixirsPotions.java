package com.natsu.elixirs.common.registry;

import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.config.ElixirsConfig;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ElixirsPotions {

	public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(Registries.POTION, Elixirs.MODID);

	public static final DeferredHolder<Potion, Potion> HASTE = POTIONS.register("haste", 
			() -> new Potion("haste", new MobEffectInstance(MobEffects.DIG_SPEED, 3*60*20)));
	public static final DeferredHolder<Potion, Potion> HASTE_LONG = POTIONS.register("long_haste", 
			() -> new Potion("haste", new MobEffectInstance(MobEffects.DIG_SPEED, 8*60*20)));
	public static final DeferredHolder<Potion, Potion> HASTE_STRONG = POTIONS.register("strong_haste", 
			() -> new Potion("haste", new MobEffectInstance(MobEffects.DIG_SPEED, 90*20, 1)));

	public static final DeferredHolder<Potion, Potion> RESISTANCE = POTIONS.register("resistance", 
			() -> new Potion("resistance", new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3*60*20)));
	public static final DeferredHolder<Potion, Potion> RESISTANCE_LONG = POTIONS.register("long_resistance", 
			() -> new Potion("resistance", new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 8*60*20)));
	public static final DeferredHolder<Potion, Potion> RESISTANCE_STRONG = POTIONS.register("strong_resistance", 
			() -> new Potion("resistance", new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 90*20, 1)));

	public static final DeferredHolder<Potion, Potion> MINING_FATIGUE = POTIONS.register("mining_fatigue", 
			() -> new Potion("mining_fatigue", new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 45*20)));
	public static final DeferredHolder<Potion, Potion> MINING_FATIGUE_LONG = POTIONS.register("long_mining_fatigue", 
			() -> new Potion("mining_fatigue", new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 90*20)));
	public static final DeferredHolder<Potion, Potion> MINING_FATIGUE_STRONG = POTIONS.register("strong_mining_fatigue", 
			() -> new Potion("mining_fatigue", new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 20*20, 1)));

	public static final DeferredHolder<Potion, Potion> HUNGER = POTIONS.register("hunger", 
			() -> new Potion("hunger", new MobEffectInstance(MobEffects.HUNGER, 90*20)));
	public static final DeferredHolder<Potion, Potion> HUNGER_LONG = POTIONS.register("long_hunger", 
			() -> new Potion("hunger", new MobEffectInstance(MobEffects.HUNGER, 3*60*20)));
	public static final DeferredHolder<Potion, Potion> HUNGER_STRONG = POTIONS.register("strong_hunger", 
			() -> new Potion("hunger", new MobEffectInstance(MobEffects.HUNGER, 45*20, 1)));

	public static final DeferredHolder<Potion, Potion> DOLPHIN_GRACE = POTIONS.register("dolphin_grace", 
			() -> new Potion("dolphin_grace", new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 3*60*20, 1)));
	public static final DeferredHolder<Potion, Potion> DOLPHIN_GRACE_LONG = POTIONS.register("long_dolphin_grace", 
			() -> new Potion("dolphin_grace", new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 8*60*20, 1)));
	public static final DeferredHolder<Potion, Potion> DOLPHIN_GRACE_STRONG = POTIONS.register("strong_dolphin_grace", 
			() -> new Potion("dolphin_grace", new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 90*20, 2)));

	public static final DeferredHolder<Potion, Potion> LUCK = POTIONS.register("luck", 
			() -> new Potion("luck", new MobEffectInstance(MobEffects.LUCK, 3*60*20)));
	public static final DeferredHolder<Potion, Potion> LUCK_LONG = POTIONS.register("long_luck", 
			() -> new Potion("luck", new MobEffectInstance(MobEffects.LUCK, 8*60*20)));
	public static final DeferredHolder<Potion, Potion> LUCK_STRONG = POTIONS.register("strong_luck", 
			() -> new Potion("luck", new MobEffectInstance(MobEffects.LUCK, 90*20, 1)));

	public static final DeferredHolder<Potion, Potion> WITHER = POTIONS.register("wither", 
			() -> new Potion("wither", new MobEffectInstance(MobEffects.WITHER, 45*20)));
	public static final DeferredHolder<Potion, Potion> WITHER_LONG = POTIONS.register("long_wither", 
			() -> new Potion("wither", new MobEffectInstance(MobEffects.WITHER, 90*20)));
	public static final DeferredHolder<Potion, Potion> WITHER_STRONG = POTIONS.register("strong_wither", 
			() -> new Potion("wither", new MobEffectInstance(MobEffects.WITHER, 20*20, 1)));

	public static final DeferredHolder<Potion, Potion> BLINDNESS = POTIONS.register("blindness", 
			() -> new Potion("blindness", new MobEffectInstance(MobEffects.BLINDNESS, 21*20)));
	public static final DeferredHolder<Potion, Potion> BLINDNESS_LONG = POTIONS.register("long_blindness", 
			() -> new Potion("blindness", new MobEffectInstance(MobEffects.BLINDNESS, 35*20)));

	public static final DeferredHolder<Potion, Potion> GLOWING = POTIONS.register("glowing", 
			() -> new Potion("glowing", new MobEffectInstance(MobEffects.GLOWING, 3*60*20)));
	public static final DeferredHolder<Potion, Potion> GLOWING_LONG = POTIONS.register("long_glowing", 
			() -> new Potion("glowing", new MobEffectInstance(MobEffects.GLOWING, 8*60*20)));

	public static final DeferredHolder<Potion, Potion> HEALTH_BOOST = POTIONS.register("health_boost", 
			() -> new Potion("health_boost", new MobEffectInstance(MobEffects.HEALTH_BOOST, 90*20)));
	public static final DeferredHolder<Potion, Potion> HEALTH_BOOST_LONG = POTIONS.register("long_health_boost", 
			() -> new Potion("health_boost", new MobEffectInstance(MobEffects.HEALTH_BOOST, 3*60*20)));
	public static final DeferredHolder<Potion, Potion> HEALTH_BOOST_STRONG = POTIONS.register("strong_health_boost", 
			() -> new Potion("health_boost", new MobEffectInstance(MobEffects.HEALTH_BOOST, 45*20, 1)));
	
	public static void initRecipes(PotionBrewing.Builder builder) {
		Elixirs.LOGGER.info("Setting up potion recipes");
		if (ElixirsConfig.USE_HASTE_RECIPE.get())
			addPotionChain(builder, Items.HONEYCOMB, HASTE, HASTE_LONG, HASTE_STRONG);
		if (ElixirsConfig.USE_RESISTANCE_RECIPE.get())
			addPotionChain(builder, Items.NAUTILUS_SHELL, RESISTANCE, RESISTANCE_LONG, RESISTANCE_STRONG);
		if (ElixirsConfig.USE_DOLPHIN_GRACE_RECIPE.get())
			addPotionChain(builder, Items.PRISMARINE_SHARD, DOLPHIN_GRACE, DOLPHIN_GRACE_LONG, DOLPHIN_GRACE_STRONG);
		if (ElixirsConfig.USE_MINING_FATIGUE_RECIPE.get())
			addPotionChain(builder, Items.DRIED_KELP, MINING_FATIGUE, MINING_FATIGUE_LONG, MINING_FATIGUE_STRONG);
		if (ElixirsConfig.USE_LUCK_RECIPE.get())
			addPotionChain(builder, Items.TURTLE_SCUTE, LUCK, LUCK_LONG, LUCK_STRONG);
		if (ElixirsConfig.USE_WITHER_RECIPE.get())
			addPotionChain(builder, Items.WITHER_ROSE, WITHER, WITHER_LONG, WITHER_STRONG);
		if (ElixirsConfig.USE_BLINDNESS_RECIPE.get())
			addPotionChain(builder, Items.SLIME_BALL, BLINDNESS, BLINDNESS_LONG);
		if (ElixirsConfig.USE_GLOWING_RECIPE.get())
			addPotionChain(builder, Items.GLOW_INK_SAC, GLOWING, GLOWING_LONG);
		if (ElixirsConfig.USE_HUNGER_RECIPE.get())
			addPotionChain(builder, Items.SEA_PICKLE, HUNGER, HUNGER_LONG, HUNGER_STRONG);
		if (ElixirsConfig.USE_HEALTH_BOOST_RECIPE.get())
			addPotionChain(builder, Items.NETHERITE_SCRAP, HEALTH_BOOST, HEALTH_BOOST_LONG, HEALTH_BOOST_STRONG);
	}

	// Awkward + ingredient = base, base + Redstone = longue, base + Glowstone = forte
	private static void addPotionChain(PotionBrewing.Builder builder, Item ingredient,
			Holder<Potion> base, Holder<Potion> longVariant, Holder<Potion> strongVariant) {
		addPotionChain(builder, ingredient, base, longVariant);
		builder.addMix(base, Items.GLOWSTONE_DUST, strongVariant);
	}

	// addMix couvre d'office les trois contenants (normale, jet, persistante).
	private static void addPotionChain(PotionBrewing.Builder builder, Item ingredient,
			Holder<Potion> base, Holder<Potion> longVariant) {
		builder.addMix(Potions.AWKWARD, ingredient, base);
		builder.addMix(base, Items.REDSTONE, longVariant);
	}

}
