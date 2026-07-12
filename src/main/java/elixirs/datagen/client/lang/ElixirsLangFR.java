package elixirs.datagen.client.lang;


import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ElixirsLangFR extends LanguageProvider{

	public ElixirsLangFR(DataGenerator gen) {
		super(gen, Elixirs.MODID, "fr_fr");
	}
	
	@Override
	protected void addTranslations() {
		add(ElixirsEffects.REJUVENATION.get(), "Régénération accélérée");
		add(ElixirsEffects.CLEANSED.get(), "Purification");
		add(ElixirsEffects.WRATH.get(), "Rage");
		add(ElixirsEffects.ENDURANCE.get(), "Endurance");
		add(ElixirsEffects.FRICTION.get(), "Friction");
		add(ElixirsEffects.SLIPPERY.get(), "Friction réduite");

		add(ElixirsEffects.CRUMBLING.get(), "Effritement");
		add(ElixirsEffects.HYPERCHARGED.get(), "Hyper chargé");
		add(ElixirsEffects.BURNED.get(), "Brûlure");
		add(ElixirsEffects.DEPTH_CRUSH.get(), "Pression des profondeurs");
		add(ElixirsEffects.FROZEN.get(), "Gelé");
		add(ElixirsEffects.APHAGIA.get(), "Aphagie");
		add(ElixirsEffects.FEAR.get(), "Peur");
		add(ElixirsEffects.DEAFENED.get(), "Assourdissement");
		add(ElixirsEffects.BLEEDING.get(), "Saignement");
		add(ElixirsEffects.SMITED.get(), "Châtiment");
		add(ElixirsEffects.DECAY.get(), "Pourrisement");
		add(ElixirsEffects.PARALYSIS.get(), "Paralysie");
		add(ElixirsEffects.FROZEN_SOLID.get(), "Gelé sur place");
		add(ElixirsEffects.SYMBIOSIS.get(), "Symbiose");
		add(ElixirsEffects.LEECH.get(), "Sangsue");
		add(ElixirsEffects.ATTRACTION.get(), "Attraction");
		add(ElixirsEffects.HEAVY.get(), "Lourdeur");
		add(ElixirsEffects.UNSTABLE.get(), "Instabilité");
		add(ElixirsEffects.RUSTED.get(), "Rouillé");
		add(ElixirsEffects.SHAKEN.get(), "Secoué");
		add(ElixirsEffects.CONFUSED.get(), "Confusion");

		addPotion("haste", "Célérité");
		addPotion("resistance", "Résistance");
		addPotion("mining_fatigue", "Fatigue de minage");
		addPotion("hunger", "Faim");
		addPotion("dolphin_grace", "Grâce du dauphin");
		addPotion("luck", "Chance");
		addPotion("wither", "Flétrissement");
		addPotion("blindness", "Cécité");
		addPotion("glowing", "Surbrillance");
		addPotion("health_boost", "Bonus de santé");
	}

	private void addPotion(String name, String displayName) {
		add("item.minecraft.potion.effect." + name, "Potion de " + displayName);
		add("item.minecraft.splash_potion.effect." + name, "Potion jetable de " + displayName);
		add("item.minecraft.lingering_potion.effect." + name, "Potion persistante de " + displayName);
		add("item.minecraft.tipped_arrow.effect." + name, "Flèche de " + displayName);
	}

}
