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
		add(ElixirsEffects.PARALISYS.get(), "Paralisys");
		add(ElixirsEffects.FROZEN_SOLID.get(), "Frozen Solid");
		add(ElixirsEffects.SYMBIOSIS.get(), "Symbiosis");
		add(ElixirsEffects.LEECH.get(), "Leech");
		add(ElixirsEffects.ATTRACTION.get(), "Attraction");
		add(ElixirsEffects.HEAVY.get(), "Heavy");
		add(ElixirsEffects.UNSTABLE.get(), "Unstable");
		add(ElixirsEffects.RUSTED.get(), "Rusted");
	}
	
}
