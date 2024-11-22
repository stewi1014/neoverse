package link.lenqua.neoverse;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Lifecycle;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistrationInfo;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.WritableRegistry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.storage.LevelStorageSource;
import net.minecraft.world.level.storage.ServerLevelData;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.OptionalLong;

public class NeoWorld extends ServerLevel {
    private NeoWorld(MinecraftServer server, ResourceKey<Level> worldKey, Long seed, ServerLevelData properties, LevelStem options) throws IOException {
        super(
                server,
                null,
                LevelStorageSource.createDefault(Path.of("testworld")).createAccess("world1"),
                properties,
                worldKey,
                options,
                null,
                false,
                seed,
                ImmutableList.of(),
                true,
                null
        );
    }

    public static NeoWorld getOrCreateDimension(MinecraftServer server, ResourceLocation key) {
        var worldKey = ResourceKey.create(Registries.DIMENSION, key);
        var serverWorld = server.getLevel(worldKey);
        if (serverWorld instanceof NeoWorld) {
            return (NeoWorld) serverWorld;
        }

        var dimensionType = new DimensionType(
                OptionalLong.empty(),
                true,
                false,
                false,
                true,
                32,
                true,
                false,
                -64,
                384,
                384,
                BlockTags.INFINIBURN_OVERWORLD,
                BuiltinDimensionTypes.OVERWORLD_EFFECTS,
                0.0f,
                new DimensionType.MonsterSettings(false, true, UniformInt.of(0, 7), 0)
        );

        var options = new LevelStem(Holder.direct(dimensionType), server.getLevel(Level.OVERWORLD).getChunkSource().getGenerator());

        NeoWorld neoWorld = null;
        try {
            neoWorld = new NeoWorld(
                    server,
                    worldKey,
                    (long) 0,
                    new NeoWorldProperties(worldKey),
                    options
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        var registry = (WritableRegistry<LevelStem>) server.registries().compositeAccess().lookupOrThrow(Registries.LEVEL_STEM);
        registry.register(ResourceKey.create(Registries.LEVEL_STEM, worldKey.location()), options, new RegistrationInfo(Optional.empty(), Lifecycle.stable()));

        return neoWorld;
    }
}
