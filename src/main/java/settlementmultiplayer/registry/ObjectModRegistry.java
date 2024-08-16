package settlementmultiplayer.registry;

import necesse.engine.registries.ObjectRegistry;
import settlementmultiplayer.object.SettlementFlagModObject;

public class ObjectModRegistry {
    public static void replaceObjects() {
        ObjectRegistry.replaceObject("settlementflag", new SettlementFlagModObject(), 500, true);
    }
}
