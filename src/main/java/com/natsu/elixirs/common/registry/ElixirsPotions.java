package com.natsu.elixirs.common.registry;

import java.lang.reflect.Method;

import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.config.ElixirsConfig;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;

public class ElixirsPotions {

	public static Potion HASTE;
	public static Potion HASTE_LONG;
	public static Potion HASTE_STRONG;

	public static Potion RESISTANCE;
	public static Potion RESISTANCE_LONG;
	public static Potion RESISTANCE_STRONG;

	public static Potion MINING_FATIGUE;
	public static Potion MINING_FATIGUE_LONG;
	public static Potion MINING_FATIGUE_STRONG;

	public static Potion HUNGER;
	public static Potion HUNGER_LONG;
	public static Potion HUNGER_STRONG;

	public static Potion DOLPHIN_GRACE;
	public static Potion DOLPHIN_GRACE_LONG;
	public static Potion DOLPHIN_GRACE_STRONG;

	public static Potion LUCK;
	public static Potion LUCK_LONG;
	public static Potion LUCK_STRONG;

	public static Potion WITHER;
	public static Potion WITHER_LONG;
	public static Potion WITHER_STRONG;

	public static Potion BLINDNESS;
	public static Potion BLINDNESS_LONG;

	public static Potion GLOWING;
	public static Potion GLOWING_LONG;

	public static Potion HEALTH_BOOST;
	public static Potion HEALTH_BOOST_LONG;
	public static Potion HEALTH_BOOST_STRONG;

	public static void register() {
		HASTE = reg("haste", new Potion("haste", new MobEffectInstance(MobEffects.DIG_SPEED, 3 * 60 * 20)));
		HASTE_LONG = reg("long_haste", new Potion("haste", new MobEffectInstance(MobEffects.DIG_SPEED, 8 * 60 * 20)));
		HASTE_STRONG = reg("strong_haste", new Potion("haste", new MobEffectInstance(MobEffects.DIG_SPEED, 90 * 20, 1)));

		RESISTANCE = reg("resistance", new Potion("resistance", new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3 * 60 * 20)));
		RESISTANCE_LONG = reg("long_resistance", new Potion("resistance", new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 8 * 60 * 20)));
		RESISTANCE_STRONG = reg("strong_resistance", new Potion("resistance", new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 90 * 20, 1)));

		MINING_FATIGUE = reg("mining_fatigue", new Potion("mining_fatigue", new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 45 * 20)));
		MINING_FATIGUE_LONG = reg("long_mining_fatigue", new Potion("mining_fatigue", new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 90 * 20)));
		MINING_FATIGUE_STRONG = reg("strong_mining_fatigue", new Potion("mining_fatigue", new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 20 * 20, 1)));

		HUNGER = reg("hunger", new Potion("hunger", new MobEffectInstance(MobEffects.HUNGER, 90 * 20)));
		HUNGER_LONG = reg("long_hunger", new Potion("hunger", new MobEffectInstance(MobEffects.HUNGER, 3 * 60 * 20)));
		HUNGER_STRONG = reg("strong_hunger", new Potion("hunger", new MobEffectInstance(MobEffects.HUNGER, 45 * 20, 1)));

		DOLPHIN_GRACE = reg("dolphin_grace", new Potion("dolphin_grace", new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 3 * 60 * 20, 1)));
		DOLPHIN_GRACE_LONG = reg("long_dolphin_grace", new Potion("dolphin_grace", new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 8 * 60 * 20, 1)));
		DOLPHIN_GRACE_STRONG = reg("strong_dolphin_grace", new Potion("dolphin_grace", new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 90 * 20, 2)));

		LUCK = reg("luck", new Potion("luck", new MobEffectInstance(MobEffects.LUCK, 3 * 60 * 20)));
		LUCK_LONG = reg("long_luck", new Potion("luck", new MobEffectInstance(MobEffects.LUCK, 8 * 60 * 20)));
		LUCK_STRONG = reg("strong_luck", new Potion("luck", new MobEffectInstance(MobEffects.LUCK, 90 * 20, 1)));

		WITHER = reg("wither", new Potion("wither", new MobEffectInstance(MobEffects.WITHER, 45 * 20)));
		WITHER_LONG = reg("long_wither", new Potion("wither", new MobEffectInstance(MobEffects.WITHER, 90 * 20)));
		WITHER_STRONG = reg("strong_wither", new Potion("wither", new MobEffectInstance(MobEffects.WITHER, 20 * 20, 1)));

		BLINDNESS = reg("blindness", new Potion("blindness", new MobEffectInstance(MobEffects.BLINDNESS, 21 * 20)));
		BLINDNESS_LONG = reg("long_blindness", new Potion("blindness", new MobEffectInstance(MobEffects.BLINDNESS, 35 * 20)));

		GLOWING = reg("glowing", new Potion("glowing", new MobEffectInstance(MobEffects.GLOWING, 3 * 60 * 20)));
		GLOWING_LONG = reg("long_glowing", new Potion("glowing", new MobEffectInstance(MobEffects.GLOWING, 8 * 60 * 20)));

		HEALTH_BOOST = reg("health_boost", new Potion("health_boost", new MobEffectInstance(MobEffects.HEALTH_BOOST, 90 * 20)));
		HEALTH_BOOST_LONG = reg("long_health_boost", new Potion("health_boost", new MobEffectInstance(MobEffects.HEALTH_BOOST, 3 * 60 * 20)));
		HEALTH_BOOST_STRONG = reg("strong_health_boost", new Potion("health_boost", new MobEffectInstance(MobEffects.HEALTH_BOOST, 45 * 20, 1)));
	}

	private static Potion reg(String name, Potion potion) {
		return Registry.register(Registry.POTION, new ResourceLocation(Elixirs.MODID, name), potion);
	}

	public static void initRecipes() {
		Elixirs.LOGGER.info("Setting up potion recipes");
		if (ElixirsConfig.USE_HASTE_RECIPE)
			addPotionChain(Items.HONEYCOMB, HASTE, HASTE_LONG, HASTE_STRONG);
		if (ElixirsConfig.USE_RESISTANCE_RECIPE)
			addPotionChain(Items.NAUTILUS_SHELL, RESISTANCE, RESISTANCE_LONG, RESISTANCE_STRONG);
		if (ElixirsConfig.USE_DOLPHIN_GRACE_RECIPE)
			addPotionChain(Items.PRISMARINE_SHARD, DOLPHIN_GRACE, DOLPHIN_GRACE_LONG, DOLPHIN_GRACE_STRONG);
		if (ElixirsConfig.USE_MINING_FATIGUE_RECIPE)
			addPotionChain(Items.DRIED_KELP, MINING_FATIGUE, MINING_FATIGUE_LONG, MINING_FATIGUE_STRONG);
		if (ElixirsConfig.USE_LUCK_RECIPE)
			addPotionChain(Items.SCUTE, LUCK, LUCK_LONG, LUCK_STRONG);
		if (ElixirsConfig.USE_WITHER_RECIPE)
			addPotionChain(Items.WITHER_ROSE, WITHER, WITHER_LONG, WITHER_STRONG);
		if (ElixirsConfig.USE_BLINDNESS_RECIPE)
			addPotionChain(Items.SLIME_BALL, BLINDNESS, BLINDNESS_LONG);
		if (ElixirsConfig.USE_GLOWING_RECIPE)
			addPotionChain(Items.GLOW_INK_SAC, GLOWING, GLOWING_LONG);
		if (ElixirsConfig.USE_HUNGER_RECIPE)
			addPotionChain(Items.SEA_PICKLE, HUNGER, HUNGER_LONG, HUNGER_STRONG);
		if (ElixirsConfig.USE_HEALTH_BOOST_RECIPE)
			addPotionChain(Items.NETHERITE_SCRAP, HEALTH_BOOST, HEALTH_BOOST_LONG, HEALTH_BOOST_STRONG);
	}

	// Awkward + ingredient = base, base + Redstone = longue, base + Glowstone = forte
	private static void addPotionChain(Item ingredient, Potion base, Potion longVariant, Potion strongVariant) {
		addPotionChain(ingredient, base, longVariant);
		addBrewingRecipe(base, Items.GLOWSTONE_DUST, strongVariant);
	}

	private static void addPotionChain(Item ingredient, Potion base, Potion longVariant) {
		addBrewingRecipe(Potions.AWKWARD, ingredient, base);
		addBrewingRecipe(base, Items.REDSTONE, longVariant);
	}

	// PotionBrewing.addMix est private static : pas d'API Fabric pour le brewing dans cette version,
	// on passe par la réflexion pour réutiliser la mécanique vanilla (potion + réactif = potion).
	private static Method addMixMethod;

	private static void addBrewingRecipe(Potion input, Item ingredient, Potion output) {
		try {
			if (addMixMethod == null) {
				addMixMethod = PotionBrewing.class.getDeclaredMethod("addMix", Potion.class, Item.class, Potion.class);
				addMixMethod.setAccessible(true);
			}
			addMixMethod.invoke(null, input, ingredient, output);
		} catch (Exception e) {
			Elixirs.LOGGER.error("Impossible d'enregistrer une recette de potion", e);
		}
	}

}
