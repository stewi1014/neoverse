package link.lenqua.neoverse;

import com.mojang.serialization.Lifecycle;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.*;
import net.minecraft.world.level.levelgen.WorldOptions;
import net.minecraft.world.level.storage.PrimaryLevelData;


public class NeoWorldProperties extends PrimaryLevelData {
    public NeoWorldProperties(ResourceKey<Level> worldKey) {
        super(
                new LevelSettings(
                        worldKey.registry().toString(),
                        GameType.DEFAULT_MODE,
                        false,
                        Difficulty.NORMAL,
                        true,
                        new GameRules(WorldDataConfiguration.DEFAULT.enabledFeatures()),
                        WorldDataConfiguration.DEFAULT
                ),
                WorldOptions.defaultWithRandomSeed(),
                SpecialWorldProperty.NONE,
                Lifecycle.stable()
        );
    }
}
