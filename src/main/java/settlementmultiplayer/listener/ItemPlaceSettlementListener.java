package settlementmultiplayer.listener;

import necesse.engine.GameEventListener;
import necesse.engine.events.players.ItemPlaceEvent;
import necesse.level.maps.layers.settlement.SettlementLevelLayer;
import necesse.level.maps.levelData.settlementData.SettlementLevelData;
import settlementmultiplayer.SettlementModData;

public class ItemPlaceSettlementListener extends GameEventListener<ItemPlaceEvent> {

    @Override
    public void onEvent(ItemPlaceEvent event) {
        if (event.player != null && event.player.isServerClient()) {
            SettlementLevelData data = SettlementLevelData.getSettlementData(event.level);
            if (event.level.settlementLayer.isActive() && data != null) {
                SettlementLevelLayer layer = event.level.settlementLayer;
                SettlementModData layerData = SettlementModData.getSettlementModDataCreateIfNonExist(event.level);
                if (!layer.doesClientHaveAccess(event.player.getServerClient()) && !layerData.isPvpFlagged) {
                    event.preventDefault();
                }
            }
        }
    }
}
