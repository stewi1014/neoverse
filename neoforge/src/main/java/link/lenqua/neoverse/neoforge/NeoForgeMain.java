package link.lenqua.neoverse.neoforge;

import link.lenqua.neoverse.Main;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod("neoverse")
public class NeoForgeMain extends Main {
    private static final Logger log = LogUtils.getLogger();

    public NeoForgeMain(IEventBus modEventBus, ModContainer container) {
        log.info("Hello NeoForge World");
    }
}
