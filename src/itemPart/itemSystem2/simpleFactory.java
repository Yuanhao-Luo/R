package itemPart.itemSystem2;

public class simpleFactory {
    public HuXiHuHu buildXIHUXIHU(){
        return new HuXiHuHu(constant.XIHUXIHU_URL,constant.XIHUXIHU_PRICE,constant.XIHUXIHU_HEAL);
    }

    public FireFly buildFirefly(){
        return new FireFly(constant.FIRE_FLY_URL,constant.FIRE_FLY_PRICE);
    }

    public PassiveEffect buildGreenTea(){
        return new PassiveEffect(constant.GREEN_TEA_URL,constant.GREEN_TEA_PRICE,constant.GREEN_TEA_HEAL,constant.BADLEG);
    }

    public PassiveEffect buildTravelingMethod(){
        return new PassiveEffect(constant.TRAVELING_METHOD_URL,constant.TRAVELING_METHOD_PRICE,constant.TRAVELING_METHOD_HEAL,constant.LOST_ID);
    }

    public PassiveEffect buildFlashJump(){
        return new PassiveEffect(constant.FLASH_JUMP_URL,constant.FLASH_JUMP_PRICE,constant.FLASH_JUMP_HEAL,constant.TRAP_ID);
    }

    public medicine buildCureCancer50(){
        return new medicine(constant.CURE_CANCER_50_URL,constant.CURE_CANCER_50_PRICE,constant.CURE_CANCER_50_HEAL);
    }

    public medicine buildCureCancer75(){
        return new medicine(constant.CURE_CANCER_75_URL,constant.CURE_CANCER_75_PRICE,constant.CURE_CANCER_75_HEAL);
    }

    public arms buildBigStick(){
        return new arms(constant.BIG_STICK_URL,constant.BIG_STICK_PRICE,constant.BIG_STICK_COOL_DOWN,constant.BIG_STICK_DAMAGE,constant.BIG_STICK_DEFENCE);
    }

    public arms buildGuerrillaSword(){
        return new arms(constant.GUERRILLA_SWORD_URL,constant.GUERRILLA_SWORD_PRICE,constant.GUERRILLA_SWORD_COOL_DOWN,constant.GUERRILLA_SWORD_DAMAGE,constant.GUERRILLA_SWORD_DEFENCE);
    }

    public arms buildHolySword(){
        return new arms(constant.HOLY_SWORD_URL,constant.HOLY_SWORD_PRICE,constant.HOLY_SWORD_COOL_DOWN,constant.HOLY_SWORD_DAMAGE,constant.HOLY_SWORD_DEFENCE);
    }

    public arms buildMagicSword(){
        return new arms(constant.MAGIC_SWORD_URL,constant.MAGIC_SWORD_PRICE,constant.MAGIC_SWORD_COOL_DOWN,constant.MAGIC_SWORD_DAMAGE,constant.MAGIC_SWORD_DEFENCE);
    }

    public arms buildTH180(){
        return new arms(constant.TH180_URL,constant.TH180_SWORD_PRICE,constant.TH180_SWORD_COOL_DOWN,constant.TH180_DAMAGE,constant.TH180_DEFENCE);
    }

    public arms buildVeryShortSword(){
        return new arms(constant.VERY_SHORT_SWORD_URL,constant.VERY_SHORT_SWORD_PRICE,constant.VERY_SHORT_SWORD_COOL_DOWN,constant.VERY_SHORT_SWORD_DAMAGE,constant.VERY_SHORT_SWORD_DEFENCE);
    }

    public arms buildPlainShield(){
        return new arms(constant.PLAIN_SHIELD_URL,constant.PLAIN_SHIELD_PRICE,constant.PLAIN_SHIELD_COOL_DOWN,constant.PLAIN_SHIELD_DAMAGE,constant.PLAIN_SHIELD_DEFENCE);
    }

    public arms buildPURUPURUShield(){
        return new arms(constant.PURUPURU_SHIELD_URL,constant.PURUPURU_SHIELD_PRICE,constant.PURUPURU_SHIELD_COOL_DOWN,constant.PURUPURU_SHIELD_DAMAGE,constant.PURUPURU_SHIELD_DEFENCE);
    }

    public arms buildResistShield(){
        return new arms(constant.RESIST_SHIELD_URL,constant.LONG_SWORD_PRICE,constant.LONG_SWORD_COOL_DOWN,constant.LONG_SWORD_DAMAGE,constant.LONG_SWORD_DEFENCE);
    }

    public arms buildShiningShield(){
        return new arms(constant.SHINING_SHIELD_URL,constant.SHINING_SHIELD_PRICE,constant.SHINING_SHIELD_COOL_DOWN,constant.SHINING_SHIELD_DAMAGE,constant.SHINING_SHIELD_DEFENCE);
    }

    public arms buildSmallShield(){
        return new arms(constant.SMALL_SHIELD_URL,constant.SMALL_SHIELD_PRICE,constant.SMALL_SHIELD_COOL_DOWN,constant.SMALL_SHIELD_DAMAGE,constant.SMALL_SHIELD_DEFENCE);
    }

    public ordinaryItem buildBarrelBreakingHammer(){
        return new ordinaryItem(constant.BARREL_BREAKING_HAMMER_URL,constant.BARREL_BREAKING_HAMMER_PRICE,constant.BARREL_BREAKING_HAMMER_HEAL,constant.BARREL_BREAKING_HAMMER_DAMAGE,constant.BARREL_BREAKING_HAMMER_DEFENCE);
    }

    public ordinaryItem buildBoomerang(){
        return new ordinaryItem(constant.BOOMERANG_URL,constant.BOOMERANG_PRICE,constant.BOOMERANG_HEAL,constant.BOOMERANG_DAMAGE,constant.BOOMERANG_DEFENCE);
    }

    public ordinaryItem buildFriedNoodles (){
        return new ordinaryItem(constant.FRIED_NOODLES_URL,constant.FRIED_NOODLES_PRICE,constant.FRIED_NOODLES_HEAL,constant.FRIED_NOODLES_DAMAGE,constant.FRIED_NOODLES_DEFENCE);
    }

    public ordinaryItem buildKYLogo (){
        return new ordinaryItem(constant.KY_LOGO_URL,constant.KY_LOGO_PRICE,constant.KY_LOGO_HEAL,constant.KY_LOGO_DAMAGE,constant.KY_LOGO_DEFENCE);
    }

    public ordinaryItem buildPillow (){
        return new ordinaryItem(constant.PILLOW_URL,constant.PILLOW_PRICE,constant.PILLOW_HEAL,constant.PILLOW_DAMAGE,constant.PILLOW_DEFENCE);
    }

    public ordinaryItem buildBaseball (){
        return new ordinaryItem(constant.BASEBALL_URL,constant.BASEBALL_PRICE,constant.BASEBALL_HEAL,constant.BASEBALL_DAMAGE,constant.BASEBALL_DEFENCE);
    }

    public ordinaryItem buildGrapeWine (){
        return new ordinaryItem(constant.GRAPE_WINE_URL,constant.GRAPE_WINE_PRICE,constant.GRAPE_WINE_HEAL,constant.GRAPE_WINE_DAMAGE,constant.GRAPE_WINE_DEFENCE);
    }

    public ordinaryItem buildRiceWine (){
        return new ordinaryItem(constant.RICE_WINE_URL,constant.RICE_WINE_PRICE,constant.RICE_WINE_HEAL,constant.RICE_WINE_DAMAGE,constant.RICE_WINE_DEFENCE);
    }
}
