package sample.battle;

public class BehaviorLogic {
    private Attack attack;
    private Defence defence;
    private Weakness weakness;
    public BehaviorLogic(Attack attack, Defence defence){
        if (attack == null){
            attack = new Attack(null, 0);
        }
        if (defence == null){
            defence = new Defence(null, 0);
        }
        this.attack = attack;
        this.defence = defence;
        this.weakness = new Weakness(null, 0);
    }

    public BehaviorLogic(Attack attack, Defence defence, Weakness weakness){
        this.attack = attack;
        this.defence = defence;
        this.weakness = weakness;
    }

    public Attack getAttack() {
        return attack;
    }

    public Defence getDefence() {
        return defence;
    }

    public Weakness getWeakness() {
        return weakness;
    }
}
