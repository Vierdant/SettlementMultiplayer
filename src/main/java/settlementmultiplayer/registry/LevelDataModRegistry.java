package settlementmultiplayer.registry;

import necesse.engine.registries.LevelDataRegistry;
import settlementmultiplayer.SettlementModData;

public class LevelDataModRegistry {


    public static void registerLevelData() {
        LevelDataRegistry.registerLevelData("settlementMultiplayer", SettlementModData.class);
    }
}
