package itemPart.itemSystem2;

import itemPart.characterSystem.Person;

import java.util.Random;

public class PassiveEffect extends medicine {
    //闪跳君、旅行方法、绿茶等
    int effectId;
    public PassiveEffect(String url, int price, int heal, int effectId) {
        super(url, price, heal);
        this.effectId = effectId;
    }

    public int avoidAbnormalState(){
        Random r = new Random();
        if (r.nextDouble() < 0.05){
            Person.getInstance().getItemList().drop(this);
        }
        return effectId;
    }
}
