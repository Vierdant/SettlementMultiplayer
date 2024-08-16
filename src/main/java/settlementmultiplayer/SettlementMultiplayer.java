package settlementmultiplayer;

import necesse.engine.GameEvents;
import necesse.engine.events.players.DamageTileEvent;
import necesse.engine.events.players.ItemPlaceEvent;
import necesse.engine.events.players.MobInteractEvent;
import necesse.engine.events.players.ObjectInteractEvent;
import necesse.engine.modLoader.annotations.ModEntry;
import settlementmultiplayer.listener.DamageTileSettlementListener;
import settlementmultiplayer.listener.ItemPlaceSettlementListener;
import settlementmultiplayer.listener.MobInteractSettlementListener;
import settlementmultiplayer.listener.ObjectInteractSettlementListener;
import settlementmultiplayer.registry.*;

@ModEntry
public class SettlementMultiplayer {

    private static Settings settings;

    public void init() {
        System.out.println("Settlement Multiplayer was enabled!");

        addListeners();

        LevelDataModRegistry.registerLevelData();
        ContainerEventModRegistry.registerContainerEvents();

        ObjectModRegistry.replaceObjects();

        ItemModRegistry.registerItems();

        ContainerModRegistry.registerContainers();

        PacketModRegistry.registerPackets();
    }

    public static Settings getSettings() {
        return settings;
    }

    private void addListeners() {
        GameEvents.addListener(DamageTileEvent.class, new DamageTileSettlementListener());
        GameEvents.addListener(ItemPlaceEvent.class, new ItemPlaceSettlementListener());
        GameEvents.addListener(ObjectInteractEvent.class, new ObjectInteractSettlementListener());
        GameEvents.addListener(MobInteractEvent.class, new MobInteractSettlementListener());
    }

}
