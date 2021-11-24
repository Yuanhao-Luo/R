package sample.battle;

public class Monster {
    private BehaviourLogic[] bls;
    private int hp;
    String url;
    public Monster(String url, BehaviourLogic[] bls, int hp){
        this.url = url;
        this.hp = hp;
        this.bls = bls;
    }

    public String getUrl() {
        return url;
    }

    public BehaviourLogic[] getBehaviourLogics() {
        return bls;
    }

    public int getHp() {
        return hp;
    }
}
