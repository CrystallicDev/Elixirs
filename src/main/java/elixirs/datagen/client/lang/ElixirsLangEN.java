package elixirs.datagen.client.lang;

import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.common.registry.ElixirsEffects;
import com.natsu.elixirs.common.registry.ElixirsPotions;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ElixirsLangEN extends LanguageProvider{

	public ElixirsLangEN(PackOutput output) {
		super(output, Elixirs.MODID, "en_us");
	}
	
	@Override
	protected void addTranslations() {
		add(ElixirsEffects.REJUVENATION.get(), "Rejuvenation");
		add(ElixirsEffects.CLEANSED.get(), "Cleansed");
		add(ElixirsEffects.WRATH.get(), "Wrath");
		add(ElixirsEffects.ENDURANCE.get(), "Endurance");
		add(ElixirsEffects.FRICTION.get(), "Friction");
		add(ElixirsEffects.SLIPPERY.get(), "Slippery");

		add(ElixirsEffects.CRUMBLING.get(), "Crumbling");
		add(ElixirsEffects.HYPERCHARGED.get(), "Hypercharged");
		add(ElixirsEffects.BURNED.get(), "Burned");
		add(ElixirsEffects.DEPTH_CRUSH.get(), "Depths Crush");
		add(ElixirsEffects.FROZEN.get(), "Frozen");
		add(ElixirsEffects.APHAGIA.get(), "Aphagia");
		add(ElixirsEffects.FEAR.get(), "Fear");
		add(ElixirsEffects.DEAFENED.get(), "Deafened");
		add(ElixirsEffects.BLEEDING.get(), "Bleeding");
		add(ElixirsEffects.SMITED.get(), "Smited");
		add(ElixirsEffects.DECAY.get(), "Decay");
		add(ElixirsEffects.PARALYSIS.get(), "Paralysis");
		add(ElixirsEffects.FROZEN_SOLID.get(), "Frozen Solid");
		add(ElixirsEffects.SYMBIOSIS.get(), "Symbiosis");
		add(ElixirsEffects.LEECH.get(), "Leech");
		add(ElixirsEffects.ATTRACTION.get(), "Attraction");
		add(ElixirsEffects.HEAVY.get(), "Heavy");
		add(ElixirsEffects.UNSTABLE.get(), "Unstable");
		add(ElixirsEffects.RUSTED.get(), "Rusted");
		add(ElixirsEffects.SHAKEN.get(), "Shaken");
		add(ElixirsEffects.CONFUSED.get(), "Confused");

		addPotion("haste", "Haste");
		addPotion("resistance", "Resistance");
		addPotion("mining_fatigue", "Mining Fatigue");
		addPotion("hunger", "Hunger");
		addPotion("dolphin_grace", "Dolphin's Grace");
		addPotion("luck", "Luck");
		addPotion("wither", "Wither");
		addPotion("blindness", "Blindness");
		addPotion("glowing", "Glowing");
		addPotion("health_boost", "Health Boost");
	}

	private void addPotion(String name, String displayName) {
		add("item.minecraft.potion.effect." + name, "Potion of " + displayName);
		add("item.minecraft.splash_potion.effect." + name, "Splash Potion of " + displayName);
		add("item.minecraft.lingering_potion.effect." + name, "Lingering Potion of " + displayName);
		add("item.minecraft.tipped_arrow.effect." + name, "Arrow of " + displayName);
	}

}