package elixirs.datagen;

import com.natsu.elixirs.Elixirs;

import net.neoforged.fml.common.EventBusSubscriber;

/**
 * Génération des lang EN/FR.
 *
 * <p>TODO 26.1.2 : {@code GatherDataEvent} a été refondu (devenu abstrait, plus de
 * {@code includeClient()}/{@code getExistingFileHelper()}, providers ajoutés via
 * {@code addProvider}/{@code createProvider}, probable split Client/Server). Le datagen est mis en
 * pause : les fichiers lang sont déjà présents dans {@code resources/assets/elixirs/lang/}, donc le
 * mod fonctionne sans. À re-porter si on veut régénérer les assets.
 */
@EventBusSubscriber(modid = Elixirs.MODID)
public class ElixirsDataGenerators {

	// Datagen désactivé le temps de porter GatherDataEvent (voir TODO ci-dessus).

}
