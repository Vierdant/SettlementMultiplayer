package settlementmultiplayer.object;

import necesse.engine.localization.Localization;
import necesse.engine.network.packet.PacketOpenContainer;
import necesse.engine.registries.ContainerRegistry;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.objectEntity.ObjectEntity;
import necesse.entity.objectEntity.SettlementFlagObjectEntity;
import necesse.inventory.item.Item;
import necesse.inventory.item.toolItem.ToolType;
import necesse.level.gameObject.SettlementFlagObject;
import necesse.level.maps.Level;
import settlementmultiplayer.item.placeable.SettlementFlagModObjectItem;
import settlementmultiplayer.SettlementModData;
import settlementmultiplayer.object.entity.SettlementFlagModObjectEntity;
import settlementmultiplayer.registry.ContainerModRegistry;

public class SettlementFlagModObject extends SettlementFlagObject {

    public SettlementFlagModObject() {
        super();
        this.toolType = ToolType.NONE;
    }

    @Override
    public String getInteractTip(Level level, int x, int y, PlayerMob perspective, boolean debug) {
        return Localization.translate("controls", "usetip");
    }

    @Override
    public ObjectEntity getNewObjectEntity(Level level, int x, int y) {
        return new SettlementFlagModObjectEntity(level, x, y);
    }

    @Override
    public Item generateNewObjectItem() {
        return new SettlementFlagModObjectItem(this);
    }

    @Override
    public void interact(Level level, int x, int y, PlayerMob player) {
        if (level.isServer()) {
            SettlementFlagObjectEntity objectEntity = (SettlementFlagObjectEntity)level.entityManager.getObjectEntity(x, y);
            int container = ContainerModRegistry.SETTLEMENT_CONTAINER;

            if (level.settlementLayer.getOwnerAuth() != -1L && !level.settlementLayer.doesClientHaveAccess(player.getServerClient())) {
                SettlementModData modData = SettlementModData.getSettlementModDataCreateIfNonExist(level);
                if (modData.isPvpFlagged) {
                    container = ContainerModRegistry.SETTLEMENT_CLAIM_CONTAINER;
                }
            }

            PacketOpenContainer p = PacketOpenContainer.ObjectEntity(container, objectEntity, objectEntity.getContainerContentPacket(player.getServerClient()));
            ContainerRegistry.openAndSendContainer(player.getServerClient(), p);
        }
    }
}
