package settlementmultiplayer.registry;

import necesse.inventory.container.events.ContainerEventRegistry;
import settlementmultiplayer.inventory.event.PvPSettlementFlaggedEvent;
import settlementmultiplayer.inventory.event.SettlementClaimTickEvent;
import settlementmultiplayer.inventory.event.SettlementModDataUpdateEvent;

public class ContainerEventModRegistry {

    public static void registerContainerEvents() {
        ContainerEventRegistry.registerUpdate(SettlementModDataUpdateEvent.class);
        ContainerEventRegistry.registerUpdate(SettlementClaimTickEvent.class);
        ContainerEventRegistry.registerUpdate(PvPSettlementFlaggedEvent.class);
    }
}
