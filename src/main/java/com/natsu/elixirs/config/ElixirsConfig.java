package com.natsu.elixirs.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ElixirsConfig {

	public static final ForgeConfigSpec SPEC;

	public static final ForgeConfigSpec.BooleanValue USE_HASTE_RECIPE;
	public static final ForgeConfigSpec.BooleanValue USE_RESISTANCE_RECIPE;
	public static final ForgeConfigSpec.BooleanValue USE_DOLPHIN_GRACE_RECIPE;
	public static final ForgeConfigSpec.BooleanValue USE_GLOWING_RECIPE;
	public static final ForgeConfigSpec.BooleanValue USE_LUCK_RECIPE;
	public static final ForgeConfigSpec.BooleanValue USE_HEALTH_BOOST_RECIPE;
	public static final ForgeConfigSpec.BooleanValue USE_MINING_FATIGUE_RECIPE;
	public static final ForgeConfigSpec.BooleanValue USE_BLINDNESS_RECIPE;
	public static final ForgeConfigSpec.BooleanValue USE_WITHER_RECIPE;
	public static final ForgeConfigSpec.BooleanValue USE_HUNGER_RECIPE;
	
	static {
		ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
		builder.push("vanillaPotionRecipes");
		USE_HASTE_RECIPE = builder.
				comment("Allows players to craft Haste potions using Honeycomb")
				.define("useHasteRecipe", true);
		USE_RESISTANCE_RECIPE = builder.
				comment("Allows players to craft Resistance potions using Nautilus Shells")
				.define("useResistanceRecipe", true);
		USE_DOLPHIN_GRACE_RECIPE = builder.
				comment("Allows players to craft Dolphin Grace potions using Prismarine Shard")
				.define("useDolphinGraceRecipe", true);
		USE_GLOWING_RECIPE = builder.
				comment("Allows players to craft Glowing potions using Glowing Ink Sacs")
				.define("useGlowingRecipe", true);
		USE_LUCK_RECIPE = builder.
				comment("Allows players to craft Luck potions using Scute")
				.define("useLuckRecipe", true);
		USE_HEALTH_BOOST_RECIPE = builder.
				comment("Allows players to craft Health Boost potions using Netherite Scraps")
				.define("useHealthBoostRecipe", true);
		USE_MINING_FATIGUE_RECIPE = builder.
				comment("Allows players to craft Mining Fatigue potions using Dried Kelp")
				.define("useMiningFatigueRecipe", true);
		USE_BLINDNESS_RECIPE = builder.
				comment("Allows players to craft Blindness potions using Slime")
				.define("useBlindnessRecipe", true);
		USE_WITHER_RECIPE = builder.
				comment("Allows players to craft Wither potions using Wither Roses")
				.define("useWitherRecipe", true);
		USE_HUNGER_RECIPE = builder.
				comment("Allows players to craft Hunger potions using Sea Pickle")
				.define("useHungerRecipe", true);
		builder.pop();
		SPEC = builder.build();
	}
	
}
