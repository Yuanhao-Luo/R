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
        backpack.add(s1.buildMedicineCureRandomMove());
        medicineBackpack.add(s1.buildMedicineCureRandomMove());
        System.out.println(backpack.get(0).getUrl());
        System.out.println(backpack.get(0).getPrice());
        System.out.println(((medicine)backpack.get(0)).getHeal());
    }
}
