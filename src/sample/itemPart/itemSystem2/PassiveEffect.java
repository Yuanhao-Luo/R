package sample.itemPart.itemSystem2;

import sample.itemPart.characterSystem.Person;

import java.util.Random;

public class PassiveEffect extends medicine {
    //闪跳君、旅行方法、绿茶等

    int effectId;
    //这个物品的被动是要闪避什么效果。例如：陷阱、迷路
    public PassiveEffect(String url, int price, int heal, int effectId) {
        super(url, price, heal);
        this.effectId = effectId;
    }

    public int avoidAbnormalState(){
        Random r = new Random();
        if (r.nextDouble() < 0.05){
            Person.getInstance().getItemList().dropItem(this);
        }
        return effectId;
    }
}
