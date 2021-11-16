package itemPart.storeExample;

import itemPart.characterSystem.Person;
import itemPart.itemSystem2.*;

import java.util.ArrayList;

public class mainframe1 {
    public static void main(String[] args) {
        simpleFactory s1 = new simpleFactory();
        Person person = Person.getInstance();

        person.getItemList().add(s1.buildXIHUXIHU());
        person.getItemList().add(s1.buildXIHUXIHU());

        System.out.println(person.getItemList().get(0).getUrl());
        System.out.println(person.getItemList().get(0).getPrice());
        System.out.println(((medicine)person.getItemList().get(0)).getHeal());



        person.getItemList().add(s1.buildBigStick());
        person.getItemList().add(s1.buildBigStick());

        System.out.println(person.getItemList().get(1).getUrl());
        System.out.println(person.getItemList().get(0).getUrl());
        System.out.println(person.getItemList().get(1).getPrice());



        person.getItemList().add(s1.buildBoomerang());
        person.getItemList().add(s1.buildBoomerang());

        System.out.println(person.getItemList().get(2).getUrl());
        System.out.println(person.getItemList().get(2).getPrice());
        System.out.println(((ordinaryItem)person.getItemList().get(2)).getDamage());
        System.out.println(((ordinaryItem)person.getItemList().get(2)).getDefence());


    }
}