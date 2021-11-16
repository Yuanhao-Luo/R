package sample.itemPart.itemSystem2;

import sample.itemPart.characterSystem.Person;

//只实现迷路，内八，结石，熬夜，乌贼人5个负面状态
//对应的药就是利萨斯的旅行方法，绿茶（这个有点不太全年龄段，建议改为萤火虫），闪跳君，稀稀糊糊全治疗
//按状态命名的，分别是迷路，随机移动，持续掉血，攻击不中，致盲
//
//
//修改后：此类仅仅只是用于回血的道具。例如：世色癌
//
public class medicine extends oneTimeItem implements Useable{
    private int heal;

    public medicine(String url, int price,int heal) {
        super(url,price);
        this.heal = heal;
    }

    @Override
    public void use() {
        Person p = Person.getInstance();
        p.setHealth(p.getHealth() + getHeal());
    }

    public int getHeal() {
        return heal;
    }
}
