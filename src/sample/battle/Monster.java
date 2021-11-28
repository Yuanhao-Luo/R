package sample.battle;

public class Monster {
    private BehaviourLogic[] bls;
    private int maxhp;
    private int hp;
    private int critical;
    String url;
    public Monster(String url, BehaviourLogic[] bls, int maxhp, int critical){
        this.url = url;
        this.maxhp = maxhp;
        this.bls = bls;
        this.critical = critical;
        this.hp = maxhp;
    }

    public String getUrl() {
        return url;
    }

    public BehaviourLogic[] getBehaviourLogics() {
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
}
