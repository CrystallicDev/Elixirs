package elixirs.datagen;

import com.natsu.elixirs.Elixirs;

import elixirs.datagen.client.lang.ElixirsLangEN;
import elixirs.datagen.client.lang.ElixirsLangFR;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Elixirs.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ElixirsDataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {

        DataGenerator gen = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        if (event.includeClient()) {
            //gen.addProvider(new CristalliteBlockStateProvider(gen, helper));
            //gen.addProvider(new CristalliteItemModelProvider(gen, helper));
            gen.addProvider(new ElixirsLangEN(gen));
            gen.addProvider(new ElixirsLangFR(gen));
        }

        if (event.includeServer()) {
            //gen.addProvider(new CristalliteLootTableProvider(gen));
            //gen.addProvider(new CristalliteBlockTags(gen, helper));
           // gen.addProvider(new CristalliteLootTableProvider(gen));
        }
    }
}
