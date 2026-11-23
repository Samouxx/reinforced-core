package atonkish.reinfcore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

import atonkish.reinfcore.api.ReinforcedCoreModInitializer;
import atonkish.reinfcore.item.ModItemGroups;

public class ReinforcedCoreMod implements ModInitializer {
  public static final String MOD_ID = "reinfcore";
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
  public static ReinforcedCoreConfig CONFIG;

  @Override
  public void onInitialize() {
    // Auto Config
    AutoConfig.register(ReinforcedCoreConfig.class, GsonConfigSerializer::new);
    CONFIG = AutoConfig.getConfigHolder(ReinforcedCoreConfig.class).getConfig();

    // Items
    ModItemGroups.init();

    // entrypoint: "reinfcore"
    FabricLoader.getInstance()
        .getEntrypoints(MOD_ID, ReinforcedCoreModInitializer.class)
        .forEach(ReinforcedCoreModInitializer::onInitializeReinforcedCore);

    // 26.x port: the "reinfcore-gametest" entrypoint (automated tests) was removed.
    // It relied on a mixin into the game's registry loading, which 26.x rewrote,
    // and it ran in every player's game although only developers used it.
  }
}
