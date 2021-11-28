package sample.battle;

import sample.itemPart.characterSystem.Person;
import sample.itemPart.itemSystem2.arms;

import java.util.ArrayList;
import java.util.Random;

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


    //都没死返回0，怪死返回1，人死返回2
    public int startBattle(){
        BehaviourLogic bl = monster.getBehaviourLogics()[turn];
        int monAtt = bl.getAttack().getAttackNum();
        int monAttAb = bl.getAttack().getAttributeType();
        int monDef = bl.getDefence().getDefenceNum();
        int monDefAb = bl.getDefence().getAttributeType();

        Person person = Person.getInstance();
        ArrayList<arms> arms = person.getSelectArms();
        int perAtt = 0;
        int perDef = 0;
        for (int i = 0; i < arms.size(); i++) {
            arms a = arms.get(i);
            int temA = a.getDamage();
            int temD = a.getDefence();
            if (a.getAttribute() == bl.getWeekness().getWeeknessType()){
                temA = temA * 3;
            }else if (a.getAttribute() == monDefAb){
                temA = temA / 3;
            }
            if (a.getAttribute() == monAttAb){
                temD = temD * 3;
            }
            perAtt += temA;
            perDef += temD;
        }

        Random random = new Random();
        int pcritical = random.nextInt(100) > person.getCritical() ? 1 : 2;
        int moncritical = random.nextInt(100) > monster.getCritical() ? 1 : 2;
        int pdamage = (person.getAttackNum() + perAtt - monDef) * pcritical;
        int mondamage = (monAtt - perDef) * moncritical;

        person.loseHp(pdamage);
        monster.loseHp(pdamage);

        if (person.isDie())
            return 2;
        else if (monster.isDie())
            return 1;
        else
            return 0;
    }
}
