package com.natsu.elixirs.common.registry;

import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.config.ElixirsConfig;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.crafting.NBTIngredient;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ElixirsPotions {

	public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, Elixirs.MODID);

	public static final RegistryObject<Potion> HASTE = POTIONS.register("haste", 
			() -> new Potion("haste", new MobEffectInstance(MobEffects.DIG_SPEED, 3*60*20)));
	public static final RegistryObject<Potion> HASTE_LONG = POTIONS.register("long_haste", 
			() -> new Potion("haste", new MobEffectInstance(MobEffects.DIG_SPEED, 8*60*20)));
	public static final RegistryObject<Potion> HASTE_STRONG = POTIONS.register("strong_haste", 
			() -> new Potion("haste", new MobEffectInstance(MobEffects.DIG_SPEED, 90*20, 1)));

	public static final RegistryObject<Potion> RESISTANCE = POTIONS.register("resistance", 
			() -> new Potion("resistance", new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3*60*20)));
	public static final RegistryObject<Potion> RESISTANCE_LONG = POTIONS.register("long_resistance", 
			() -> new Potion("resistance", new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 8*60*20)));
	public static final RegistryObject<Potion> RESISTANCE_STRONG = POTIONS.register("strong_resistance", 
			() -> new Potion("resistance", new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 90*20, 1)));

	public static final RegistryObject<Potion> MINING_FATIGUE = POTIONS.register("mining_fatigue", 
			() -> new Potion("mining_fatigue", new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 45*20)));
	public static final RegistryObject<Potion> MINING_FATIGUE_LONG = POTIONS.register("long_mining_fatigue", 
			() -> new Potion("mining_fatigue", new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 90*20)));
	public static final RegistryObject<Potion> MINING_FATIGUE_STRONG = POTIONS.register("strong_mining_fatigue", 
			() -> new Potion("mining_fatigue", new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 20*20, 1)));

	public static final RegistryObject<Potion> HUNGER = POTIONS.register("hunger", 
			() -> new Potion("hunger", new MobEffectInstance(MobEffects.HUNGER, 90*20)));
	public static final RegistryObject<Potion> HUNGER_LONG = POTIONS.register("long_hunger", 
			() -> new Potion("hunger", new MobEffectInstance(MobEffects.HUNGER, 3*60*20)));
	public static final RegistryObject<Potion> HUNGER_STRONG = POTIONS.register("strong_hunger", 
			() -> new Potion("hunger", new MobEffectInstance(MobEffects.HUNGER, 45*20, 1)));

	public static final RegistryObject<Potion> DOLPHIN_GRACE = POTIONS.register("dolphin_grace", 
			() -> new Potion("dolphin_grace", new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 3*60*20, 1)));
	public static final RegistryObject<Potion> DOLPHIN_GRACE_LONG = POTIONS.register("long_dolphin_grace", 
			() -> new Potion("dolphin_grace", new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 8*60*20, 1)));
	public static final RegistryObject<Potion> DOLPHIN_GRACE_STRONG = POTIONS.register("strong_dolphin_grace", 
			() -> new Potion("dolphin_grace", new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 90*20, 2)));

	public static final RegistryObject<Potion> LUCK = POTIONS.register("luck", 
			() -> new Potion("luck", new MobEffectInstance(MobEffects.LUCK, 3*60*20)));
	public static final RegistryObject<Potion> LUCK_LONG = POTIONS.register("long_luck", 
			() -> new Potion("luck", new MobEffectInstance(MobEffects.LUCK, 8*60*20)));
	public static final RegistryObject<Potion> LUCK_STRONG = POTIONS.register("strong_luck", 
			() -> new Potion("luck", new MobEffectInstance(MobEffects.LUCK, 90*20, 1)));

	public static final RegistryObject<Potion> WITHER = POTIONS.register("wither", 
			() -> new Potion("wither", new MobEffectInstance(MobEffects.WITHER, 45*20)));
	public static final RegistryObject<Potion> WITHER_LONG = POTIONS.register("long_wither", 
			() -> new Potion("wither", new MobEffectInstance(MobEffects.WITHER, 90*20)));
	public static final RegistryObject<Potion> WITHER_STRONG = POTIONS.register("strong_wither", 
			() -> new Potion("wither", new MobEffectInstance(MobEffects.WITHER, 20*20, 1)));

	public static final RegistryObject<Potion> BLINDNESS = POTIONS.register("blindness", 
			() -> new Potion("blindness", new MobEffectInstance(MobEffects.BLINDNESS, 21*20)));
	public static final RegistryObject<Potion> BLINDNESS_LONG = POTIONS.register("long_blindness", 
			() -> new Potion("blindness", new MobEffectInstance(MobEffects.BLINDNESS, 35*20)));

	public static final RegistryObject<Potion> GLOWING = POTIONS.register("glowing", 
			() -> new Potion("glowing", new MobEffectInstance(MobEffects.GLOWING, 3*60*20)));
	public static final RegistryObject<Potion> GLOWING_LONG = POTIONS.register("long_glowing", 
			() -> new Potion("glowing", new MobEffectInstance(MobEffects.GLOWING, 8*60*20)));

	public static final RegistryObject<Potion> HEALTH_BOOST = POTIONS.register("health_boost", 
			() -> new Potion("health_boost", new MobEffectInstance(MobEffects.HEALTH_BOOST, 90*20)));
	public static final RegistryObject<Potion> HEALTH_BOOST_LONG = POTIONS.register("long_health_boost", 
			() -> new Potion("health_boost", new MobEffectInstance(MobEffects.HEALTH_BOOST, 3*60*20)));
	public static final RegistryObject<Potion> HEALTH_BOOST_STRONG = POTIONS.register("strong_health_boost", 
			() -> new Potion("health_boost", new MobEffectInstance(MobEffects.HEALTH_BOOST, 45*20, 1)));
	
	public static void initRecipes() {
		Elixirs.LOGGER.info("Setting up potion recipes");
		if (ElixirsConfig.USE_HASTE_RECIPE.get())
			addPotionChain(Items.HONEYCOMB, HASTE.get(), HASTE_LONG.get(), HASTE_STRONG.get());
		if (ElixirsConfig.USE_RESISTANCE_RECIPE.get())
			addPotionChain(Items.NAUTILUS_SHELL, RESISTANCE.get(), RESISTANCE_LONG.get(), RESISTANCE_STRONG.get());
		if (ElixirsConfig.USE_DOLPHIN_GRACE_RECIPE.get())
			addPotionChain(Items.PRISMARINE_SHARD, DOLPHIN_GRACE.get(), DOLPHIN_GRACE_LONG.get(), DOLPHIN_GRACE_STRONG.get());
		if (ElixirsConfig.USE_MINING_FATIGUE_RECIPE.get())
			addPotionChain(Items.DRIED_KELP, MINING_FATIGUE.get(), MINING_FATIGUE_LONG.get(), MINING_FATIGUE_STRONG.get());
		if (ElixirsConfig.USE_LUCK_RECIPE.get())
			addPotionChain(Items.SCUTE, LUCK.get(), LUCK_LONG.get(), LUCK_STRONG.get());
		if (ElixirsConfig.USE_WITHER_RECIPE.get())
			addPotionChain(Items.WITHER_ROSE, WITHER.get(), WITHER_LONG.get(), WITHER_STRONG.get());
		if (ElixirsConfig.USE_BLINDNESS_RECIPE.get())
			addPotionChain(Items.SLIME_BALL, BLINDNESS.get(), BLINDNESS_LONG.get());
		if (ElixirsConfig.USE_GLOWING_RECIPE.get())
			addPotionChain(Items.GLOW_INK_SAC, GLOWING.get(), GLOWING_LONG.get());
		if (ElixirsConfig.USE_HUNGER_RECIPE.get())
			addPotionChain(Items.SEA_PICKLE, HUNGER.get(), HUNGER_LONG.get(), HUNGER_STRONG.get());
		if (ElixirsConfig.USE_HEALTH_BOOST_RECIPE.get())
			addPotionChain(Items.NETHERITE_SCRAP, HEALTH_BOOST.get(), HEALTH_BOOST_LONG.get(), HEALTH_BOOST_STRONG.get());
	}

	/**
	 * Enregistre la chaîne de brassage standard d'une potion :
	 * Awkward + ingredient = base, base + Redstone = longue, base + Glowstone = forte.
	 */
	private static void addPotionChain(Item ingredient, Potion base, Potion longVariant, Potion strongVariant) {
		addPotionChain(ingredient, base, longVariant);
		addBrewingRecipe(base, Items.GLOWSTONE_DUST, strongVariant);
	}

	private static void addPotionChain(Item ingredient, Potion base, Potion longVariant) {
		addBrewingRecipe(Potions.AWKWARD, ingredient, base);
		addBrewingRecipe(base, Items.REDSTONE, longVariant);
	}

	private static void addBrewingRecipe(Potion input, Item ingredient, Potion output) {
		BrewingRecipeRegistry.addRecipe(
				NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), input)),
				Ingredient.of(ingredient),
				PotionUtils.setPotion(new ItemStack(Items.POTION), output)
			);
	}
	
}
