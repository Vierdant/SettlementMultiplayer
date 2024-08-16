package settlementmultiplayer;

import necesse.engine.save.LoadData;
import necesse.engine.save.SaveData;
import necesse.level.maps.Level;
import necesse.level.maps.levelData.LevelData;

public class SettlementModData extends LevelData {

    public boolean isPvpFlagged;
    public boolean doExplosionDamage;

    public SettlementModData() {
        this.isPvpFlagged = false;
        this.doExplosionDamage = true;
    }

    public void addSaveData(SaveData save) {
        super.addSaveData(save);
        save.addBoolean("settlementPvpFlagged", this.isPvpFlagged);
        save.addBoolean("settlementExplosionDamage", this.doExplosionDamage);
    }

    public void applyLoadData(LoadData save) {
        super.applyLoadData(save);
        this.isPvpFlagged = save.getBoolean("settlementPvpFlagged", false);
        if (this.level.getWorldSettings().forcedPvP) {
            this.isPvpFlagged = true;
        }
        this.doExplosionDamage = save.getBoolean("settlementExplosionDamage", true);
    }


    public void togglePvpFlag() {
        if (!this.level.getWorldSettings().forcedPvP) {
            this.isPvpFlagged = !this.isPvpFlagged;
        } else {
            this.isPvpFlagged = this.level.getWorldSettings().forcedPvP;
        }
    }

    public void setPvpFlagged(boolean state) {
        if (!this.level.getWorldSettings().forcedPvP) {
            this.isPvpFlagged = state;
        } else {
            this.isPvpFlagged = this.level.getWorldSettings().forcedPvP;
        }
    }

    public void setExplosionDamage(boolean doExplosionDamage) {
        this.doExplosionDamage = doExplosionDamage;
    }

    public static void createSettlementModDataCreateIfNonExist(Level level) {
        if (!level.isServer()) {
            throw new IllegalArgumentException("Level must be server level");
        } else {
            SettlementModData settlementData = getSettlementModData(level);
            if (settlementData == null) {
                settlementData = new SettlementModData();
                level.addLevelData("settlementMultiplayer", settlementData);
            }
        }
    }

    public static SettlementModData getSettlementModDataCreateIfNonExist(Level level) {
        if (!level.isServer()) {
            throw new IllegalArgumentException("Level must be server level");
        } else {
            SettlementModData settlementData = getSettlementModData(level);
            if (settlementData == null) {
                settlementData = new SettlementModData();
                level.addLevelData("settlementMultiplayer", settlementData);
            }

            return settlementData;
        }
    }

    public static SettlementModData getSettlementModData(Level level) {
        LevelData data = level.getLevelData("settlementMultiplayer");
        return data instanceof SettlementModData ? (SettlementModData)data : null;
    }

    public void setLevel(Level level) {
        super.setLevel(level);
    }
}
