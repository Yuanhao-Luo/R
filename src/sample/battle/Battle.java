package sample.battle;

import sample.characterSystem.Person;
import sample.characterSystem.Schedule;
import sample.itemSystem.*;

import java.util.ArrayList;
import java.util.Random;

public class Battle {
    private static Battle battle = new Battle();
    private Monster monster;
    private int turn = 0;//回合数
    private int result;//都没死0，怪死1，人死2
    private int monsterDamage;//怪物对玩家造成的伤害
    private int personDamage;//玩家对怪物造成的伤害

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

    //由于有Arms和OrdinaryItem两种可使用的道具，于是将OrdinaryItem也转成Arms统一进行处理
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
                Person.getInstance().getSelectItems().remove(oi);
            }
        }
        return arms;
    }

    public void startBattle(){
        //将双方的伤害初始化为0
        monsterDamage = 0;
        personDamage = 0;

        //选择怪物这一回合的行动
        BehaviorLogic bl = monster.getBehaviourLogics()[turn%monster.getBehaviourLogics().length];
        int monAtt;//怪物的攻击力
        int monAttAb;//怪物的攻击属性
        int monDef;//怪物的防御力
        int monDefAb;//怪物的防御属性
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

        //由于有Arms和OrdinaryItem两种可使用的道具，于是将OrdinaryItem也转成Arms统一进行处理
        ArrayList<Arms> arms = items2Arms(person.getSelectItems());
        ItemList itemList = person.getItemList();


        //物品栏中正在冷却的物品冷却时间-1
        for (Object item : itemList) {
            if (item instanceof Arms) {
                ((Arms) item).refreshCoolDown();
            }
        }

        int perAtt = 0;//玩家攻击力
        int perDef = 0;//玩家防御力
        for (Arms a : arms) {
            a.used();//使用后进入冷却时间
            int temA = a.getDamage();
            int temD = a.getDefence();

            //如果道具的属性与怪物弱点属性相同的话会造成3倍伤害
            //如果道具属性与怪物防御的属性相同的话，伤害只有1/3
            if (bl.getWeakness().getWeeknessType() != 0 && a.getAttribute() == bl.getWeakness().getWeeknessType()) {
                temA = temA * 3;
            } else if (monDefAb != 0 && a.getAttribute() == monDefAb) {
                temA = temA / 3;
            }

            //如果道具（防御型）与怪物的攻击属性相同的话，防御力变为3倍
            if (monAttAb != 0 && a.getAttribute() == monAttAb) {
                temD = temD * 3;
            }
            perAtt += temA;
            perDef += temD;
        }

        //计算暴击率，如果暴击伤害变为2倍
        Random random = new Random();
        int pcritical = random.nextInt(100) > person.getCritical() ? 1 : 2;
        int moncritical = random.nextInt(100) > monster.getCritical() ? 1 : 2;
        int pdamage = (person.getAttackNum() + perAtt - monDef) * pcritical;
        int mondamage = (monAtt - perDef) * moncritical;

        //玩家和怪物的Hp减少
        person.loseHp(mondamage);
        monster.loseHp(pdamage);

        //储存造成的伤害，用于gui中显示伤害
        this.monsterDamage = mondamage;
        this.personDamage = pdamage;

        //回合数增加
        turn++;

        //如果玩家死亡result=2，怪物死亡result=1，都没死result=0
        if (person.isDie())
            result =  2;
        else if (monster.isDie()){
            person.setMoney(person.getMoney() + monster.getMoney());
            person.setExp(person.getExp() + monster.getExp());
            result =  1;
            if (monster.getUrl().equals(".\\images\\monster\\head.png")){
                person.getItemList().add(new SimpleFactory().buildDaughter());
                person.setSchedule(Schedule.GET_DAUGHTER);
            }
        }
        else
            result =  0;
    }
}
