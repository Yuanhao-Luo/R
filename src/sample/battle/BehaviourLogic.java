package sample.battle;

public class BehaviourLogic {
    private Attack attack;
    private Defence defence;
    private Weekness weekness;
    public BehaviourLogic(Attack attack, Defence defence){
        this.attack = attack;
        this.defence = defence;
    }

    public BehaviourLogic(Attack attack, Defence defence, Weekness weekness){
        this.attack = attack;
        this.defence = defence;
        this.weekness = weekness;
    }

    public Attack getAttack() {
        return attack;
    }

    public Defence getDefence() {
        return defence;
    }

    public Weekness getWeekness() {
        return weekness;
    }
}
