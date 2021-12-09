package sample.itemSystem;

public class SimpleFactory {
    public HuXiHuHu buildXIHUXIHU(){
        return new HuXiHuHu(Constant.XIHUXIHU_URL, Constant.XIHUXIHU_PRICE, Constant.XIHUXIHU_HEAL);
    }

    public FireFly buildFirefly(){
        return new FireFly(Constant.FIRE_FLY_URL, Constant.FIRE_FLY_PRICE);
    }

    public PassiveEffect buildGreenTea(){
        return new PassiveEffect(Constant.GREEN_TEA_URL, Constant.GREEN_TEA_PRICE, Constant.GREEN_TEA_HEAL, Constant.BADLEG);
    }

    public PassiveEffect buildTravelingMethod(){
        return new PassiveEffect(Constant.TRAVELING_METHOD_URL, Constant.TRAVELING_METHOD_PRICE, Constant.TRAVELING_METHOD_HEAL, Constant.LOST_ID);
    }

    public PassiveEffect buildFlashJump(){
        return new PassiveEffect(Constant.FLASH_JUMP_URL, Constant.FLASH_JUMP_PRICE, Constant.FLASH_JUMP_HEAL, Constant.TRAP_ID);
    }

    public Medicine buildCureCancer50(){
        return new Medicine(Constant.CURE_CANCER_50_URL, Constant.CURE_CANCER_50_PRICE, Constant.CURE_CANCER_50_HEAL);
    }

    public Medicine buildCureCancer75(){
        return new Medicine(Constant.CURE_CANCER_75_URL, Constant.CURE_CANCER_75_PRICE, Constant.CURE_CANCER_75_HEAL);
    }

    public Arms buildBigStick(){
        return new Arms(Constant.BIG_STICK_URL, Constant.BIG_STICK_PRICE, Constant.BIG_STICK_COOL_DOWN, Constant.BIG_STICK_DAMAGE, Constant.BIG_STICK_DEFENCE);
    }

    public Arms buildGuerrillaSword(){
        return new Arms(Constant.GUERRILLA_SWORD_URL, Constant.GUERRILLA_SWORD_PRICE, Constant.GUERRILLA_SWORD_COOL_DOWN, Constant.GUERRILLA_SWORD_DAMAGE, Constant.GUERRILLA_SWORD_DEFENCE);
    }

    public Arms buildHolySword(){
        return new Arms(Constant.HOLY_SWORD_URL, Constant.HOLY_SWORD_PRICE, Constant.HOLY_SWORD_COOL_DOWN, Constant.HOLY_SWORD_DAMAGE, Constant.HOLY_SWORD_DEFENCE);
    }

    public Arms buildMagicSword(){
        return new Arms(Constant.MAGIC_SWORD_URL, Constant.MAGIC_SWORD_PRICE, Constant.MAGIC_SWORD_COOL_DOWN, Constant.MAGIC_SWORD_DAMAGE, Constant.MAGIC_SWORD_DEFENCE);
    }

    public Arms buildTH180(){
        return new Arms(Constant.TH180_URL, Constant.TH180_SWORD_PRICE, Constant.TH180_SWORD_COOL_DOWN, Constant.TH180_DAMAGE, Constant.TH180_DEFENCE);
    }

    public Arms buildVeryShortSword(){
        return new Arms(Constant.VERY_SHORT_SWORD_URL, Constant.VERY_SHORT_SWORD_PRICE, Constant.VERY_SHORT_SWORD_COOL_DOWN, Constant.VERY_SHORT_SWORD_DAMAGE, Constant.VERY_SHORT_SWORD_DEFENCE);
    }

    public Arms buildPlainShield(){
        return new Arms(Constant.PLAIN_SHIELD_URL, Constant.PLAIN_SHIELD_PRICE, Constant.PLAIN_SHIELD_COOL_DOWN, Constant.PLAIN_SHIELD_DAMAGE, Constant.PLAIN_SHIELD_DEFENCE);
    }

    public Arms buildPURUPURUShield(){
        return new Arms(Constant.PURUPURU_SHIELD_URL, Constant.PURUPURU_SHIELD_PRICE, Constant.PURUPURU_SHIELD_COOL_DOWN, Constant.PURUPURU_SHIELD_DAMAGE, Constant.PURUPURU_SHIELD_DEFENCE);
    }

    public Arms buildResistShield(){
        return new Arms(Constant.RESIST_SHIELD_URL, Constant.LONG_SWORD_PRICE, Constant.LONG_SWORD_COOL_DOWN, Constant.LONG_SWORD_DAMAGE, Constant.LONG_SWORD_DEFENCE);
    }

    public Arms buildShiningShield(){
        return new Arms(Constant.SHINING_SHIELD_URL, Constant.SHINING_SHIELD_PRICE, Constant.SHINING_SHIELD_COOL_DOWN, Constant.SHINING_SHIELD_DAMAGE, Constant.SHINING_SHIELD_DEFENCE);
    }

    public Arms buildSmallShield(){
        return new Arms(Constant.SMALL_SHIELD_URL, Constant.SMALL_SHIELD_PRICE, Constant.SMALL_SHIELD_COOL_DOWN, Constant.SMALL_SHIELD_DAMAGE, Constant.SMALL_SHIELD_DEFENCE);
    }

    public OrdinaryItem buildBarrelBreakingHammer(){
        return new OrdinaryItem(Constant.BARREL_BREAKING_HAMMER_URL, Constant.BARREL_BREAKING_HAMMER_PRICE, Constant.BARREL_BREAKING_HAMMER_HEAL, Constant.BARREL_BREAKING_HAMMER_DAMAGE, Constant.BARREL_BREAKING_HAMMER_DEFENCE);
    }

    public OrdinaryItem buildBoomerang(){
        return new OrdinaryItem(Constant.BOOMERANG_URL, Constant.BOOMERANG_PRICE, Constant.BOOMERANG_HEAL, Constant.BOOMERANG_DAMAGE, Constant.BOOMERANG_DEFENCE);
    }

    public OrdinaryItem buildFriedNoodles (){
        return new OrdinaryItem(Constant.FRIED_NOODLES_URL, Constant.FRIED_NOODLES_PRICE, Constant.FRIED_NOODLES_HEAL, Constant.FRIED_NOODLES_DAMAGE, Constant.FRIED_NOODLES_DEFENCE);
    }

    public OrdinaryItem buildKYLogo (){
        return new OrdinaryItem(Constant.KY_LOGO_URL, Constant.KY_LOGO_PRICE, Constant.KY_LOGO_HEAL, Constant.KY_LOGO_DAMAGE, Constant.KY_LOGO_DEFENCE);
    }

    public OrdinaryItem buildPillow (){
        return new OrdinaryItem(Constant.PILLOW_URL, Constant.PILLOW_PRICE, Constant.PILLOW_HEAL, Constant.PILLOW_DAMAGE, Constant.PILLOW_DEFENCE);
    }

    public OrdinaryItem buildBaseball (){
        return new OrdinaryItem(Constant.BASEBALL_URL, Constant.BASEBALL_PRICE, Constant.BASEBALL_HEAL, Constant.BASEBALL_DAMAGE, Constant.BASEBALL_DEFENCE);
    }

    public OrdinaryItem buildGrapeWine (){
        return new OrdinaryItem(Constant.GRAPE_WINE_URL, Constant.GRAPE_WINE_PRICE, Constant.GRAPE_WINE_HEAL, Constant.GRAPE_WINE_DAMAGE, Constant.GRAPE_WINE_DEFENCE);
    }

    public OrdinaryItem buildRiceWine (){
        return new OrdinaryItem(Constant.RICE_WINE_URL, Constant.RICE_WINE_PRICE, Constant.RICE_WINE_HEAL, Constant.RICE_WINE_DAMAGE, Constant.RICE_WINE_DEFENCE);
    }
}
