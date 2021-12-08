package sample.itemSystem;

import sample.characterSystem.Person;

public class FireFly extends oneTimeItem implements Useable {
    public FireFly(String url, int price) {
        super(url, price);
    }

    @Override
    public void use() {
        Person p = Person.getInstance();
        p.setSquidMan(false);
    }
}
