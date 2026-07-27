package elixirs.datagen;

import com.natsu.elixirs.Elixirs;

import elixirs.datagen.client.lang.ElixirsLangEN;
import elixirs.datagen.client.lang.ElixirsLangFR;
import net.minecraft.data.DataGenerator;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = Elixirs.MODID)
public class ElixirsDataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {

        DataGenerator gen = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        if (event.includeClient()) {
            //gen.addProvider(new CristalliteBlockStateProvider(gen, helper));
            //gen.addProvider(new CristalliteItemModelProvider(gen, helper));
            gen.addProvider(event.includeClient(), new ElixirsLangEN(gen.getPackOutput()));
            gen.addProvider(event.includeClient(), new ElixirsLangFR(gen.getPackOutput()));
        }

        if (event.includeServer()) {
            //gen.addProvider(new CristalliteLootTableProvider(gen));
            //gen.addProvider(new CristalliteBlockTags(gen, helper));
           // gen.addProvider(new CristalliteLootTableProvider(gen));
        }
    }
}
