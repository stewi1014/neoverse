package link.lenqua.neoverse.fabric;

import link.lenqua.neoverse.Main;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FabricMain extends Main implements ModInitializer {
    private static final Logger log = LoggerFactory.getLogger("neoverse");

    @Override
    public void onInitialize() {
        log.info("Hello Fabric World");
    }
}
