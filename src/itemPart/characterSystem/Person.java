package itemPart.characterSystem;

import itemPart.itemSystem2.*;

import java.util.ArrayList;

public class Person {
//    private boolean[]StateFlags = new boolean[5];
    private boolean blind = false;
    private int health = 900;
    private int money = 1000;
    //backpack part
    private ArrayList<item> backpack = new ArrayList<>();
    private ArrayList<arms> armsBackpack = new ArrayList<>();
    private ArrayList<ordinaryItem> ordinaryItemsBackpack = new ArrayList<>();
    private ArrayList<medicine> medicineBackpack = new ArrayList<>();
    private ItemList itemList = new ItemList();

    private static Person p = new Person();

    private Person(){}

    public static Person getInstance(){
        return p;
    }

    public boolean isBlind() {
        return blind;
    }

    public void setBlind(boolean blind) {
        this.blind = blind;
    }

    public ArrayList<item> getBackpack() {
        return backpack;
    }

    public ArrayList<arms> getArmsBackpack() {
        return armsBackpack;
    }

    public ArrayList<ordinaryItem> getOrdinaryItemsBackpack() {
        return ordinaryItemsBackpack;
    }

    public ArrayList<medicine> getMedicineBackpack() {
        return medicineBackpack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public ItemList getItemList() {
        return itemList;
    }
}
