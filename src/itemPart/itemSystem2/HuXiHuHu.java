package itemPart.itemSystem2;

import itemPart.characterSystem.Person;

public class HuXiHuHu extends oneTimeItem implements Useable {
    public HuXiHuHu(String url, int price, int heal) {
        super(url, price, heal);
    }

    @Override
    public void use() {
        Person p = Person.getInstance();
        p.setBlind(false);
        //将所有异常属性设为false




    }
}
