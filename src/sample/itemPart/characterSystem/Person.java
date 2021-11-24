package sample.itemPart.characterSystem;

import sample.itemPart.itemSystem2.*;

public class Person {
//    private boolean[]StateFlags = new boolean[5];
    private boolean blind = false;
    private boolean getLost = false;
    private boolean squidMan = false;
    private int health = 900;
    private int money = 1000;
    //backpack part

    private ItemList itemList = new ItemList();

    private static Person p = new Person();

    private Person(){



        //test
        simpleFactory s = new simpleFactory();
        itemList.add(s.buildFirefly());
        itemList.add(s.buildGrapeWine());
        itemList.add(s.buildRiceWine());
        itemList.add(s.buildGuerrillaSword());
        itemList.add(s.buildCureCancer75());
        itemList.add(s.buildFlashJump());
        itemList.add(s.buildTravelingMethod());
    }

    public static Person getInstance(){
        return p;
    }

    public boolean isBlind() {
        return blind;
    }

    public void setBlind(boolean blind) {
        this.blind = blind;
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

    public void setGetLost(boolean getLost) {
        this.getLost = getLost;
    }

    public void setSquidMan(boolean squidMan) {
        this.squidMan = squidMan;
    }
}
