package sample.characterSystem;


import sample.itemSystem.Item;
import sample.itemSystem.ItemList;
import sample.itemSystem.Arms;
import sample.itemSystem.SimpleFactory;

import java.util.ArrayList;

public class Person {
//    private boolean[]StateFlags = new boolean[5];
    private boolean blind = false;
    private boolean getLost = false;
    private boolean squidMan = false;
    private int health = 160;
    private int maxHealth = 900;
    private int money = 1000;
    private int attack = 10;
    private int critical = 10;
    private int exp = 500;
    private int level = 10;
    private int luck = 5;
    private int schedule = 0;
    //backpack part

    private ItemList itemList = new ItemList();
    private ArrayList selectItems = new ArrayList<Item>();

    private static Person p = new Person();

    private Person(){
        maxHealth = health;


        //test
        SimpleFactory s = new SimpleFactory();
        itemList.add(s.buildMagicSword());
        itemList.add(s.buildGuerrillaSword());
        itemList.add(s.buildSmallShield());
        itemList.add(s.buildTH180());
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

    public ArrayList getSelectItems() {
        return selectItems;
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
        setHealth(getHealth()-damage);
        if (damage >= health)
            die();
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

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public void setSchedule(int schedule) {
        this.schedule = schedule;
    }

    public int getSchedule() {
        return schedule;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void levelUp(){
        int needExp = 100000000;
        if (level>=10 && level<=15){
            needExp = (level + 1) * 10;
        }else if (level > 15 && level <= 20){
            needExp = (level - 10) *90;
        }
        if (getExp() > needExp){
            setExp(getExp()-needExp);
            setLevel(getLevel()+1);
            setMaxHealth(getMaxHealth()+40);
            setHealth(getHealth()+40);
        }
    }

    public boolean canLevelUp(){
        int needExp = 100000000;
        if (level>=10 && level<=15){
            needExp = (level + 1) * 10;
        }else if (level > 15 && level <= 20){
            needExp = (level - 10) *90;
        }
        return getExp() > needExp;
    }

    //还没有实现，需要对接
    public void die(){
        System.out.println("die");
    }
}
