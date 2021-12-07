package sample.characterSystem;


import sample.itemSystem.ItemList;
import sample.itemSystem.arms;
import sample.itemSystem.simpleFactory;

import java.util.ArrayList;

public class Person {
//    private boolean[]StateFlags = new boolean[5];
    private boolean blind = false;
    private boolean getLost = false;
    private boolean squidMan = false;
    private int health = 900;
    private int maxHealth = 900;
    private int money = 1000;
    private int attack = 100;
    private int critical = 10;
    private int exp = 0;
    private int level = 0;
    //backpack part

    private ItemList itemList = new ItemList();
    private ArrayList selectArms = new ArrayList<arms>();

    private static Person p = new Person();

    private Person(){
        maxHealth = health;


        //test
        simpleFactory s = new simpleFactory();
        itemList.add(s.buildMagicSword());
        itemList.add(s.buildMagicSword());
        itemList.add(s.buildGuerrillaSword());
        itemList.add(s.buildGuerrillaSword());
        itemList.add(s.buildSmallShield());
        itemList.add(s.buildMagicSword());
        itemList.add(s.buildTH180());
        itemList.add(s.buildBigStick());
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

    public ArrayList getSelectArms() {
        return selectArms;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getAttackNum() {
        return attack;
    }

    public int getCritical() {
        return critical;
    }

    public boolean isDie(){
        return health <= 0;
    }

    public void loseHp(int damage){
        if (damage >= health){
            die();
        }else {
            setHealth(getHealth()-damage);
        }
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    //还没有实现，需要对接
    public void die(){
        System.out.println("die");
    }
}
