package com.natsu.elixirs.common.registry;

import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.config.ServerConfig;

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
			() -> new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 3*60*20)));
	public static final RegistryObject<Potion> HASTE_LONG = POTIONS.register("long_haste", 
			() -> new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 8*60*20)));
	public static final RegistryObject<Potion> HASTE_STRONG = POTIONS.register("strong_haste", 
			() -> new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 90*20, 1)));

	public static final RegistryObject<Potion> RESISTANCE = POTIONS.register("resistance", 
			() -> new Potion(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3*60*20)));
	public static final RegistryObject<Potion> RESISTANCE_LONG = POTIONS.register("long_resistance", 
			() -> new Potion(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 8*60*20)));
	public static final RegistryObject<Potion> RESISTANCE_STRONG = POTIONS.register("strong_resistance", 
			() -> new Potion(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 90*20, 1)));

	public static final RegistryObject<Potion> MINING_FATIGUE = POTIONS.register("mining_fatigue", 
			() -> new Potion(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 45*20)));
	public static final RegistryObject<Potion> MINING_FATIGUE_LONG = POTIONS.register("long_mining_fatigue", 
			() -> new Potion(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 90*20)));
	public static final RegistryObject<Potion> MINING_FATIGUE_STRONG = POTIONS.register("strong_mining_fatigue", 
			() -> new Potion(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 20*20, 1)));

	public static final RegistryObject<Potion> HUNGER = POTIONS.register("hunger", 
			() -> new Potion(new MobEffectInstance(MobEffects.HUNGER, 90*20)));
	public static final RegistryObject<Potion> HUNGER_LONG = POTIONS.register("long_hunger", 
			() -> new Potion(new MobEffectInstance(MobEffects.HUNGER, 3*60*20)));
	public static final RegistryObject<Potion> HUNGER_STRONG = POTIONS.register("strong_hunger", 
			() -> new Potion(new MobEffectInstance(MobEffects.HUNGER, 45*20, 1)));

	public static final RegistryObject<Potion> DOLPHINE_GRACE = POTIONS.register("dolphin_grace", 
			() -> new Potion(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 3*60*20, 1)));
	public static final RegistryObject<Potion> DOLPHINE_GRACE_LONG = POTIONS.register("long_dolphin_grace", 
			() -> new Potion(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 8*60*20, 1)));
	public static final RegistryObject<Potion> DOLPHINE_GRACE_STRONG = POTIONS.register("strong_dolphin_grace", 
			() -> new Potion(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 90*20, 2)));

	public static final RegistryObject<Potion> LUCK = POTIONS.register("luck", 
			() -> new Potion(new MobEffectInstance(MobEffects.LUCK, 3*60*20)));
	public static final RegistryObject<Potion> LUCK_LONG = POTIONS.register("long_luck", 
			() -> new Potion(new MobEffectInstance(MobEffects.LUCK, 8*60*20)));
	public static final RegistryObject<Potion> LUCK_STRONG = POTIONS.register("strong_luck", 
			() -> new Potion(new MobEffectInstance(MobEffects.LUCK, 90*20, 1)));

	public static final RegistryObject<Potion> WITHER = POTIONS.register("wither", 
			() -> new Potion(new MobEffectInstance(MobEffects.WITHER, 45*20)));
	public static final RegistryObject<Potion> WITHER_LONG = POTIONS.register("long_wither", 
			() -> new Potion(new MobEffectInstance(MobEffects.WITHER, 90*20)));
	public static final RegistryObject<Potion> WITHER_STRONG = POTIONS.register("strong_wither", 
			() -> new Potion(new MobEffectInstance(MobEffects.WITHER, 20*20, 1)));

	public static final RegistryObject<Potion> BLINDNESS = POTIONS.register("blindness", 
			() -> new Potion(new MobEffectInstance(MobEffects.BLINDNESS, 21*20)));
	public static final RegistryObject<Potion> BLINDNESS_LONG = POTIONS.register("long_blindness", 
			() -> new Potion(new MobEffectInstance(MobEffects.BLINDNESS, 35*20)));

	public static final RegistryObject<Potion> GLOWING = POTIONS.register("glowing", 
			() -> new Potion(new MobEffectInstance(MobEffects.GLOWING, 3*60*20)));
	public static final RegistryObject<Potion> GLOWING_LONG = POTIONS.register("long_glowing", 
			() -> new Potion(new MobEffectInstance(MobEffects.GLOWING, 8*60*20)));

	public static final RegistryObject<Potion> HEALTH_BOOST = POTIONS.register("health_boost", 
			() -> new Potion(new MobEffectInstance(MobEffects.HEALTH_BOOST, 90*20)));
	public static final RegistryObject<Potion> HEALTH_BOOST_LONG = POTIONS.register("long_health_boost", 
			() -> new Potion(new MobEffectInstance(MobEffects.HEALTH_BOOST, 3*60*20)));
	public static final RegistryObject<Potion> HEALTH_BOOST_STRONG = POTIONS.register("strong_health_boost", 
			() -> new Potion(new MobEffectInstance(MobEffects.HEALTH_BOOST, 45*20, 1)));
	
	public static void initRecipes() {
		System.out.print("[ELIXIRS] Setting Up Potion Recipe");
		if (ServerConfig.USE_HASTE_RECIPE.get()) {
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
					Ingredient.of(new ItemStack(Items.HONEYCOMB)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), HASTE.get())
				);
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), HASTE.get())),
					Ingredient.of(new ItemStack(Items.REDSTONE)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), HASTE_LONG.get())
				);
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), HASTE.get())),
					Ingredient.of(new ItemStack(Items.GLOWSTONE_DUST)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), HASTE_STRONG.get())
				);
		}
		
		if (ServerConfig.USE_RESISTANCE_RECIPE.get()) {
			
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
					Ingredient.of(new ItemStack(Items.NAUTILUS_SHELL)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), RESISTANCE.get())
				);
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), HASTE.get())),
					Ingredient.of(new ItemStack(Items.REDSTONE)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), RESISTANCE_LONG.get())
				);
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), HASTE.get())),
					Ingredient.of(new ItemStack(Items.GLOWSTONE_DUST)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), RESISTANCE_STRONG.get())
				);
		}
		
		if (ServerConfig.USE_DOLPHIN_GRACE_RECIPE.get()) {
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
					Ingredient.of(new ItemStack(Items.PRISMARINE_SHARD)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), DOLPHINE_GRACE.get())
				);
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), HASTE.get())),
					Ingredient.of(new ItemStack(Items.REDSTONE)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), DOLPHINE_GRACE_LONG.get())
				);
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), HASTE.get())),
					Ingredient.of(new ItemStack(Items.GLOWSTONE_DUST)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), DOLPHINE_GRACE_STRONG.get())
				);
		}
		
		if (ServerConfig.USE_MINING_FATIGUE_RECIPE.get()) {
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
					Ingredient.of(new ItemStack(Items.DRIED_KELP)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), MINING_FATIGUE.get())
				);
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), HASTE.get())),
					Ingredient.of(new ItemStack(Items.REDSTONE)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), MINING_FATIGUE_LONG.get())
				);
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), HASTE.get())),
					Ingredient.of(new ItemStack(Items.GLOWSTONE_DUST)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), MINING_FATIGUE_STRONG.get())
				);
		}
		
		if (ServerConfig.USE_LUCK_RECIPE.get()) {
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
					Ingredient.of(new ItemStack(Items.SCUTE)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), LUCK.get())
				);
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), HASTE.get())),
					Ingredient.of(new ItemStack(Items.REDSTONE)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), LUCK_LONG.get())
				);
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), HASTE.get())),
					Ingredient.of(new ItemStack(Items.GLOWSTONE_DUST)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), LUCK_STRONG.get())
				);
		}
		
		if (ServerConfig.USE_WITHER_RECIPE.get()) {
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
					Ingredient.of(new ItemStack(Items.WITHER_ROSE)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), WITHER.get())
				);
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), HASTE.get())),
					Ingredient.of(new ItemStack(Items.REDSTONE)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), WITHER_LONG.get())
				);
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), HASTE.get())),
					Ingredient.of(new ItemStack(Items.GLOWSTONE_DUST)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), WITHER_STRONG.get())
				);
		}
		
		if (ServerConfig.USE_BLINDNESS_RECIPE.get()) {
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
					Ingredient.of(new ItemStack(Items.SLIME_BALL)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), BLINDNESS.get())
				);
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), HASTE.get())),
					Ingredient.of(new ItemStack(Items.REDSTONE)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), BLINDNESS_LONG.get())
				);
		}

		if (ServerConfig.USE_GLOWING_RECIPE.get()) {
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
					Ingredient.of(new ItemStack(Items.GLOW_INK_SAC)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), GLOWING.get())
				);
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), HASTE.get())),
					Ingredient.of(new ItemStack(Items.REDSTONE)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), GLOWING_LONG.get())
				);	
		}

		if (ServerConfig.USE_HUNGER_RECIPE.get()) {
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
					Ingredient.of(new ItemStack(Items.SEA_PICKLE)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), HUNGER.get())
				);
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), HASTE.get())),
					Ingredient.of(new ItemStack(Items.REDSTONE)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), HUNGER_LONG.get())
				);
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), HASTE.get())),
					Ingredient.of(new ItemStack(Items.GLOWSTONE_DUST)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), HUNGER_STRONG.get())
				);
		}
		
		if (ServerConfig.USE_HEALTH_BOOST_RECIPE.get()) {
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
					Ingredient.of(new ItemStack(Items.NETHERITE_SCRAP)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), HEALTH_BOOST.get())
				);
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), HASTE.get())),
					Ingredient.of(new ItemStack(Items.REDSTONE)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), HEALTH_BOOST_LONG.get())
				);
			BrewingRecipeRegistry.addRecipe(
					NBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), HASTE.get())),
					Ingredient.of(new ItemStack(Items.GLOWSTONE_DUST)),
					PotionUtils.setPotion(new ItemStack(Items.POTION), HEALTH_BOOST_STRONG.get())
				);
		}
	}
	
}
