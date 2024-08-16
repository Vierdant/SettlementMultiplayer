package settlementmultiplayer.listener;

import necesse.engine.GameEventListener;
import necesse.engine.events.players.DamageTileEvent;
import necesse.level.maps.layers.settlement.SettlementLevelLayer;
import necesse.level.maps.levelData.settlementData.SettlementLevelData;
import settlementmultiplayer.SettlementModData;

public class DamageTileSettlementListener extends GameEventListener<DamageTileEvent> {

    @Override
    public void onEvent(DamageTileEvent event) {
        if (event.client != null && event.client.isServer()) {
            SettlementLevelData data = SettlementLevelData.getSettlementData(event.level);
            if (event.level.settlementLayer.isActive() && data != null) {
                SettlementLevelLayer layer = event.level.settlementLayer;
                SettlementModData layerData = SettlementModData.getSettlementModDataCreateIfNonExist(event.level);
                if (!layer.doesClientHaveAccess(event.client) && !layerData.isPvpFlagged) {
                    event.preventDefault();
                }
            }
        }
    }
}
