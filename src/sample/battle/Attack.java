package sample.battle;

public class Attack extends Behavior {
    private int attack;
    private int attribute = 0;
    public Attack(String url,int attack) {
        super(url);
        this.attack = attack;
    }

    public Attack(String url, int attack, int attribute){
        super(url);
        this.attack = attack;
        this.attribute = attribute;
    }

    public int getAttackNum() {
        return attack;
    }

    public int getAttributeType() {
        return attribute;
    }
}
