package sample.itemSystem;

import sample.characterSystem.Person;

public class HuXiHuHu extends OneTimeItem implements Useable {
    public HuXiHuHu(String url, int price, int heal) {
        super(url, price);
    }

    @Override
    public void use() {
        Person p = Person.getInstance();
        p.setBlind(false);
        //将所有异常属性设为false




    }
}
