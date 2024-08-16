package settlementmultiplayer.registry;

import necesse.engine.registries.ItemRegistry;
import necesse.inventory.item.matItem.MatItem;

public class ItemModRegistry {

    public static void registerItems() {
        ItemRegistry.registerItem("claimingscroll", (new MatItem(5).setItemCategory("misc")), 500F, true);
    }
}
