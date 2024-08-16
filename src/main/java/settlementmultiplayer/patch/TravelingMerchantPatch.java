package settlementmultiplayer.patch;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.engine.network.server.ServerClient;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.friendly.human.humanShop.TravelingMerchantMob;
import necesse.level.maps.levelData.villageShops.ShopItem;
import necesse.level.maps.levelData.villageShops.VillageShopsData;
import net.bytebuddy.asm.Advice;

import java.util.ArrayList;

import static necesse.entity.mobs.friendly.human.humanShop.HumanShop.conditionSection;

@ModMethodPatch(target = TravelingMerchantMob.class, name = "getShopItems", arguments = {VillageShopsData.class, ServerClient.class})
public class TravelingMerchantPatch {

    @Advice.OnMethodExit
    static void onExit(@Advice.This TravelingMerchantMob merchant, @Advice.Return(readOnly = false) ArrayList<ShopItem> out) {
        addCondition(merchant, out);
    }

    public static void addCondition(TravelingMerchantMob merchant, ArrayList<ShopItem> out) {
        GameRandom random = new GameRandom(merchant.getShopSeed() + 5L);
        conditionSection(random, random.getChance(0.5), (r) -> {
            out.add(ShopItem.item("claimingscroll", r.getIntBetween(3000, 5000)));
        });
    }
}
