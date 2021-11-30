package sample.battle;

import sample.itemPart.characterSystem.Person;
import sample.itemPart.itemSystem2.ItemList;
import sample.itemPart.itemSystem2.arms;

import java.util.ArrayList;
import java.util.Random;

public class Battle {
    private static Battle battle = new Battle();
    private Monster monster;
    private int turn = 0;

    private Battle(){
        MonsterFactory monsterFactory = new MonsterFactory();
        setMonster(monsterFactory.buildPurin());
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
        BehaviorLogic bl = monster.getBehaviourLogics()[turn%monster.getBehaviourLogics().length];
        //att、def可能为null
        int monAtt;
        int monAttAb;
        int monDef;
        int monDefAb;
        if (bl.getAttack() == null){
            monAtt = 0;
        }else {
            monAtt = bl.getAttack().getAttackNum();
        }
        if (bl.getDefence() == null){
            monDef = 0;
        }else {
            monDef = bl.getDefence().getDefenceNum();
        }
        monAttAb = bl.getAttack().getAttributeType();
        monDefAb = bl.getDefence().getAttributeType();


        Person person = Person.getInstance();
        ArrayList<arms> arms = person.getSelectArms();
        ItemList itemList = person.getItemList();

        for (int i = 0; i < itemList.size(); i++) {
            Object item = itemList.get(i);
            if (item instanceof arms){
                ((arms) item).refreshCoolDown();
            }
        }

        int perAtt = 0;
        int perDef = 0;
        for (int i = 0; i < arms.size(); i++) {
            arms a = arms.get(i);
            a.used();
            int temA = a.getDamage();
            int temD = a.getDefence();
            if (bl.getWeakness().getWeeknessType() != 0 && a.getAttribute() == bl.getWeakness().getWeeknessType()){
                temA = temA * 3;
            }else if (monDefAb != 0 && a.getAttribute() == monDefAb){
                temA = temA / 3;
            }
            if (monAttAb != 0 && a.getAttribute() == monAttAb){
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

        //加经验，加钱





        if (person.isDie())
            return 2;
        else if (monster.isDie()){
            person.setMoney(person.getMoney() + monster.getMoney());
            person.setExp(person.getExp() + monster.getExp());
            return 1;
        }
        else
            return 0;
    }
}
