package link.lenqua.neoverse.neoforge;

import link.lenqua.neoverse.Main;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.event.server.ServerStoppedEvent;

@Mod("neoverse")
public class NeoForgeMain extends Main {
    public NeoForgeMain(IEventBus modEventBus, ModContainer container) {
        NeoForge.EVENT_BUS.addListener((ServerStartedEvent event) -> onServerStarted(event.getServer()));
        NeoForge.EVENT_BUS.addListener((ServerStartingEvent event) -> onServerStarting(event.getServer()));
        NeoForge.EVENT_BUS.addListener((ServerStoppedEvent event) -> onServerStop(event.getServer()));
    }
}
