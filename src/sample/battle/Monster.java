package sample.battle;

public class Monster {
    private BehaviorLogic[] bls;
    private int maxhp;
    private int hp;
    private int critical;
    String url;
    private int money;
    private int exp;


    public Monster(String url, BehaviorLogic[] bls, int maxhp, int critical, int money, int exp){
        this.url = url;
        this.maxhp = maxhp;
        this.bls = bls;
        this.critical = critical;
        this.hp = maxhp;
        this.money = money;
        this.exp = exp;
    }

    public String getUrl() {
        return url;
    }

    public BehaviorLogic[] getBehaviourLogics() {
        return bls;
    }

    public int getMaxhp() {
        return maxhp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void loseHp(int damage){
        setHp(getHp()-damage);
    }

    public boolean isDie(){
        return hp <= 0;
    }

    public int getCritical() {
        return critical;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
