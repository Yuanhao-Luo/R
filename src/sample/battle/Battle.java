package sample.battle;

import sample.characterSystem.Person;
import sample.itemSystem.Item;
import sample.itemSystem.ItemList;
import sample.itemSystem.Arms;
import sample.itemSystem.OrdinaryItem;

import java.util.ArrayList;
import java.util.Random;

public class Battle {
    private static Battle battle = new Battle();
    private Monster monster;
    private int turn = 0;
    private int result;//都没死0，怪死1，人死2
    private int monsterDamage;
    private int personDamage;

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

    public int getMonsterDamage() {
        return monsterDamage;
    }

    public int getPersonDamage() {
        return personDamage;
    }

    public int getResult() {
        return result;
    }

    public Arms ordinary2Arm(OrdinaryItem ordinaryItem){
        Arms a = new Arms(ordinaryItem.getUrl(), ordinaryItem.getPrice(), 0, ordinaryItem.getDamage(), ordinaryItem.getDefence());
        return a;
    }

    public ArrayList<Arms> items2Arms(ArrayList<Item> items){
        ArrayList<Arms> arms = new ArrayList<>();
        for (Object i :
                items.toArray()) {
            if (i instanceof Arms){
                arms.add((Arms) i);
            }
            else if (i instanceof OrdinaryItem){
                OrdinaryItem oi = (OrdinaryItem) i;
                arms.add(ordinary2Arm(oi));
                Person.getInstance().getItemList().dropItem(oi);
            }
        }
        return arms;
    }

    public void startBattle(){
        monsterDamage = 0;
        personDamage = 0;
        BehaviorLogic bl = monster.getBehaviourLogics()[turn%monster.getBehaviourLogics().length];
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
        ArrayList<Arms> arms = items2Arms(person.getSelectItems());
        ItemList itemList = person.getItemList();

        for (int i = 0; i < itemList.size(); i++) {
            Object item = itemList.get(i);
            if (item instanceof Arms){
                ((Arms) item).refreshCoolDown();
            }
        }

        int perAtt = 0;
        int perDef = 0;
        for (int i = 0; i < arms.size(); i++) {
            Arms a = arms.get(i);
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

        person.loseHp(mondamage);
        monster.loseHp(pdamage);

        this.monsterDamage = mondamage;
        this.personDamage = pdamage;

        if (person.isDie())
            result =  2;
        else if (monster.isDie()){
            person.setMoney(person.getMoney() + monster.getMoney());
            person.setExp(person.getExp() + monster.getExp());
            result =  1;
        }
        else
            result =  0;
    }
}
