package elixirs.datagen.client.lang;

import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.common.registry.ElixirsEffects;
import com.natsu.elixirs.common.registry.ElixirsPotions;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ElixirsLangEN extends LanguageProvider{

	public ElixirsLangEN(PackOutput output) {
		super(output, Elixirs.MODID, "en_us");
	}
	
	@Override
	protected void addTranslations() {
		addEffect(ElixirsEffects.REJUVENATION, "Rejuvenation");
		addEffect(ElixirsEffects.CLEANSED, "Cleansed");
		addEffect(ElixirsEffects.WRATH, "Wrath");
		addEffect(ElixirsEffects.ENDURANCE, "Endurance");
		addEffect(ElixirsEffects.FRICTION, "Friction");
		addEffect(ElixirsEffects.SLIPPERY, "Slippery");

		addEffect(ElixirsEffects.CRUMBLING, "Crumbling");
		addEffect(ElixirsEffects.HYPERCHARGED, "Hypercharged");
		addEffect(ElixirsEffects.BURNED, "Burned");
		addEffect(ElixirsEffects.DEPTH_CRUSH, "Depths Crush");
		addEffect(ElixirsEffects.FROZEN, "Frozen");
		addEffect(ElixirsEffects.APHAGIA, "Aphagia");
		addEffect(ElixirsEffects.FEAR, "Fear");
		addEffect(ElixirsEffects.DEAFENED, "Deafened");
		addEffect(ElixirsEffects.BLEEDING, "Bleeding");
		addEffect(ElixirsEffects.SMITED, "Smited");
		addEffect(ElixirsEffects.DECAY, "Decay");
		addEffect(ElixirsEffects.PARALYSIS, "Paralysis");
		addEffect(ElixirsEffects.FROZEN_SOLID, "Frozen Solid");
		addEffect(ElixirsEffects.SYMBIOSIS, "Symbiosis");
		addEffect(ElixirsEffects.LEECH, "Leech");
		addEffect(ElixirsEffects.ATTRACTION, "Attraction");
		addEffect(ElixirsEffects.HEAVY, "Heavy");
		addEffect(ElixirsEffects.UNSTABLE, "Unstable");
		addEffect(ElixirsEffects.RUSTED, "Rusted");
		addEffect(ElixirsEffects.SHAKEN, "Shaken");
		addEffect(ElixirsEffects.CONFUSED, "Confused");

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