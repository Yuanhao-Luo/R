package sample.battle;

import sample.itemPart.characterSystem.Person;
import sample.itemPart.itemSystem2.arms;

import java.util.ArrayList;

public class Battle {
    private static Battle battle = new Battle();
    private Monster monster;
    private int turn = 0;

    private Battle(){

    }

    public static Battle getInstance() {
        return battle;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public void startBattle(){
        BehaviourLogic bl = monster.getBehaviourLogics()[turn];
        int monAtt = bl.getAttack().getAttackNum();
        int monAttAb = bl.getAttack().getAttribute();
        int monDef = bl.getDefence().getDefenceNum();
        int monDefAb = bl.getDefence().getAttribute();

        Person person = Person.getInstance();
        ArrayList<arms> arms = person.getSelectArms();
        int perAtt = 0;
        int perDef = 0;
        for (int i = 0; i < arms.size(); i++) {
            arms a = arms.get(i);
            int temA = a.getDamage();
            int temD = a.getDefence();


            perAtt += temA;
            perDef += temD;
        }
    }
}
