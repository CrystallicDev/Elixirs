package elixirs.datagen.client.lang;


import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ElixirsLangFR extends LanguageProvider{

	public ElixirsLangFR(PackOutput output) {
		super(output, Elixirs.MODID, "fr_fr");
	}
	
	@Override
	protected void addTranslations() {
		addEffect(ElixirsEffects.REJUVENATION, "Régénération accélérée");
		addEffect(ElixirsEffects.CLEANSED, "Purification");
		addEffect(ElixirsEffects.WRATH, "Rage");
		addEffect(ElixirsEffects.ENDURANCE, "Endurance");
		addEffect(ElixirsEffects.FRICTION, "Friction");
		addEffect(ElixirsEffects.SLIPPERY, "Friction réduite");

		addEffect(ElixirsEffects.CRUMBLING, "Effritement");
		addEffect(ElixirsEffects.HYPERCHARGED, "Hyper chargé");
		addEffect(ElixirsEffects.BURNED, "Brûlure");
		addEffect(ElixirsEffects.DEPTH_CRUSH, "Pression des profondeurs");
		addEffect(ElixirsEffects.FROZEN, "Gelé");
		addEffect(ElixirsEffects.APHAGIA, "Aphagie");
		addEffect(ElixirsEffects.FEAR, "Peur");
		addEffect(ElixirsEffects.DEAFENED, "Assourdissement");
		addEffect(ElixirsEffects.BLEEDING, "Saignement");
		addEffect(ElixirsEffects.SMITED, "Châtiment");
		addEffect(ElixirsEffects.DECAY, "Pourrisement");
		addEffect(ElixirsEffects.PARALYSIS, "Paralysie");
		addEffect(ElixirsEffects.FROZEN_SOLID, "Gelé sur place");
		addEffect(ElixirsEffects.SYMBIOSIS, "Symbiose");
		addEffect(ElixirsEffects.LEECH, "Sangsue");
		addEffect(ElixirsEffects.ATTRACTION, "Attraction");
		addEffect(ElixirsEffects.HEAVY, "Lourdeur");
		addEffect(ElixirsEffects.UNSTABLE, "Instabilité");
		addEffect(ElixirsEffects.RUSTED, "Rouillé");
		addEffect(ElixirsEffects.SHAKEN, "Secoué");
		addEffect(ElixirsEffects.CONFUSED, "Confusion");

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
