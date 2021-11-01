package itemPart.itemSystem2;

public class simpleFactory {
    public medicine buildMedicineCureAll(){
        return new medicine(constant.MEDICINE_CURE_ALL_URL,200,100,true,true,true,true,true);
    }

    public medicine buildMedicineCureBleed(){
        return new medicine(constant.MEDICINE_CURE_BLEED_URL,200,100,true,true,true,true,true);
    }

    public medicine buildMedicineCureBlind(){
        return new medicine(constant.MEDICINE_CURE_BLIND_URL,200,100,true,true,true,true,true);
    }

    public medicine buildMedicineCureGetLost(){
        return new medicine(constant.MEDICINE_CURE_GET_LOST_URL,200,100,true,true,true,true,true);
    }

    public medicine buildMedicineCureMiss(){
        return new medicine(constant.MEDICINE_CURE_MISS_URL,200,100,true,true,true,true,true);
    }

    public medicine buildMedicineCureRandomMove(){
        return new medicine(constant.MEDICINE_CURE_RANDOM_MOVE_URL,200,100,true,true,true,true,true);
    }
}
