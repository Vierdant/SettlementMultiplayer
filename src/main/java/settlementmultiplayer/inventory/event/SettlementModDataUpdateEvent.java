package settlementmultiplayer.inventory.event;

import necesse.engine.network.PacketReader;
import necesse.engine.network.PacketWriter;
import necesse.engine.network.server.ServerClient;
import necesse.inventory.container.events.ContainerEvent;
import settlementmultiplayer.SettlementModData;

public class SettlementModDataUpdateEvent extends ContainerEvent {

    public final boolean isServerClient;
    public final boolean isPvpFlagged;
    public final boolean isSettlementSafe;
    public final boolean doExplosionDamage;
    public final boolean shouldStartCooldown;

    public SettlementModDataUpdateEvent(SettlementModData data, ServerClient client, boolean shouldStartCooldown, boolean isSettlementSafe) {
        this.isServerClient = client.isServer();
        this.isPvpFlagged = data.isPvpFlagged;
        this.isSettlementSafe = isSettlementSafe;
        this.doExplosionDamage = data.doExplosionDamage;
        this.shouldStartCooldown = shouldStartCooldown;
    }

    public SettlementModDataUpdateEvent(PacketReader reader) {
        this.isServerClient = reader.getNextBoolean();
        this.isPvpFlagged = reader.getNextBoolean();
        this.isSettlementSafe = reader.getNextBoolean();
        this.doExplosionDamage = reader.getNextBoolean();
        this.shouldStartCooldown = reader.getNextBoolean();
    }

    @Override
    public void write(PacketWriter writer) {
        writer.putNextBoolean(this.isServerClient);
        writer.putNextBoolean(this.isPvpFlagged);
        writer.putNextBoolean(this.isSettlementSafe);
        writer.putNextBoolean(this.doExplosionDamage);
        writer.putNextBoolean(this.shouldStartCooldown);
    }
}
