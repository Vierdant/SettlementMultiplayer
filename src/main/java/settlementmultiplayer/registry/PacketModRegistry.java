package settlementmultiplayer.registry;

import necesse.engine.registries.PacketRegistry;
import settlementmultiplayer.packet.PacketPlayerEnablePvP;

public class PacketModRegistry {

    public static void registerPackets() {
        PacketRegistry.registerPacket(PacketPlayerEnablePvP.class);
    }
}
