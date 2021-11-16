package itemPart.storeExample;

import itemPart.itemSystem2.*;

import java.util.ArrayList;

public class mainframe1 {
    public static void main(String[] args) {
        simpleFactory s1 = new simpleFactory();
        ArrayList<item> backpack = new ArrayList<>();
        ArrayList<arms> armsBackpack = new ArrayList<>();
        ArrayList<ordinaryItem> ordinaryItemsBackpack = new ArrayList<>();
        ArrayList<medicine> medicineBackpack = new ArrayList<>();



        backpack.add(s1.buildXIHUXIHU());
        medicineBackpack.add(s1.buildXIHUXIHU());

        System.out.println(backpack.get(0).getUrl());
        System.out.println(backpack.get(0).getPrice());
        System.out.println(((medicine)backpack.get(0)).getHeal());



        backpack.add(s1.buildBigStick());
        armsBackpack.add(s1.buildBigStick());

        System.out.println(backpack.get(1).getUrl());
        System.out.println(armsBackpack.get(0).getUrl());
        System.out.println(backpack.get(1).getPrice());
        System.out.println(((arms)backpack.get(1)).getTotalCoolDown());



        backpack.add(s1.buildBoomerang());
        ordinaryItemsBackpack.add(s1.buildBoomerang());

        System.out.println(backpack.get(2).getUrl());
        System.out.println(backpack.get(2).getPrice());
        System.out.println(((ordinaryItem)backpack.get(2)).getHeal());
        System.out.println(((ordinaryItem)backpack.get(2)).getDamage());
        System.out.println(((ordinaryItem)backpack.get(2)).getDefence());


    }
}
