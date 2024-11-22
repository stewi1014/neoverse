package link.lenqua.neoverse;

import static java.util.Objects.requireNonNull;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;

public abstract class Main {
    private MinecraftServer server;

    protected void onServerStarting(MinecraftServer server) {
        requireNonNull(server);
        this.server = server;
    }

    protected void onServerStarted(MinecraftServer server) {
        requireNonNull(server);
        NeoWorld.getOrCreateDimension(server, ResourceLocation.fromNamespaceAndPath("neoverse", "neoworld"));
    }

    protected void onServerStopping(MinecraftServer server) {

    }

    protected void onServerStop(MinecraftServer server) {
        this.server = null;
    }
}
