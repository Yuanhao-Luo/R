package sample.battle;

public class Attack extends Behaviour {
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

    public int getAttack() {
        return attack;
    }

    public int getAttribute() {
        return attribute;
    }
}
