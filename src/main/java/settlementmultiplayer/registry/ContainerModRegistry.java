package settlementmultiplayer.registry;

import necesse.engine.registries.ContainerRegistry;
import settlementmultiplayer.inventory.container.*;
import settlementmultiplayer.inventory.form.*;
import settlementmultiplayer.object.entity.SettlementFlagModObjectEntity;

public class ContainerModRegistry {

    public static int SETTLEMENT_CONTAINER;
    public static int SETTLEMENT_CLAIM_CONTAINER;

    public static void registerContainers() {
        SETTLEMENT_CONTAINER = ContainerRegistry.registerOEContainer((client, uniqueSeed, oe, content) ->
                new SettlementModContainerForm<>(client, new SettlementModContainer(client.getClient(), uniqueSeed, (SettlementFlagModObjectEntity)oe,
                        content)), (client, uniqueSeed, oe, content, serverObject) ->
                new SettlementModContainer(client, uniqueSeed, (SettlementFlagModObjectEntity)oe, content));
        SETTLEMENT_CLAIM_CONTAINER = ContainerRegistry.registerOEContainer((client, uniqueSeed, oe, content) ->
                new SettlementClaimForm(client, new SettlementClaimContainer(client.getClient(), uniqueSeed, (SettlementFlagModObjectEntity)oe
                )), (client, uniqueSeed, oe, content, serverObject) ->
                new SettlementClaimContainer(client, uniqueSeed, (SettlementFlagModObjectEntity)oe));

        ContainerRegistry.PVP_TEAMS_CONTAINER = ContainerRegistry.registerContainer((client, uniqueSeed, content) ->
                new PvPTeamsModContainerForm(client,
                        new PvPTeamsModContainer(client.getClient(), uniqueSeed, content)), (client, uniqueSeed, content, serverObject) ->
                new PvPTeamsModContainer(client, uniqueSeed, content));
    }
}
