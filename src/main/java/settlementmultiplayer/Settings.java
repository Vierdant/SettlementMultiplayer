package settlementmultiplayer;

import necesse.engine.modLoader.ModSettings;
import necesse.engine.save.LoadData;
import necesse.engine.save.SaveData;

public class Settings extends ModSettings {

    public boolean enableMultiFlagPerSettlement;
    public boolean allowOwnedSettlerKillsNoPvP;
    public boolean requireSettlerOwnerOnlineToKill;

    public Settings() {
        this.enableMultiFlagPerSettlement = false;
        this.allowOwnedSettlerKillsNoPvP = false;
        this.requireSettlerOwnerOnlineToKill = false;
    }

    @Override
    public void addSaveData(SaveData save) {
        save.addBoolean("enableMultiFlagPerSettlement", this.enableMultiFlagPerSettlement,
                "If true, allows the player to place multiple flags in a SINGLE settlement | Default: false");
        save.addBoolean("allowOwnedSettlerKillsNoPvP", this.allowOwnedSettlerKillsNoPvP,
                "If true, player will be able to kill owned settlers even while SETTLEMENT pvp is disabled | Default: false");
        save.addBoolean("requireSettlerOwnerOnlineToKill", this.requireSettlerOwnerOnlineToKill,
                "If true, a player can't kill a settler owned by another player, unless the owner player is online | Default: false");
    }

    @Override
    public void applyLoadData(LoadData load) {
        this.enableMultiFlagPerSettlement = load.getBoolean("enableMultiFlagPerSettlement", false);
        this.allowOwnedSettlerKillsNoPvP = load.getBoolean("allowOwnedSettlerKillsNoPvP", false);
        this.requireSettlerOwnerOnlineToKill = load.getBoolean("requireSettlerOwnerOnlineToKill", false);
    }
}
