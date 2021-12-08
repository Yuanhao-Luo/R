package sample.battle;

public class MonsterFactory {
    //像以下这个方法，为每个怪物都写一个方法，怪物的信息在设计档案里有
    public Monster buildPurin(){
        String b1a_url = "";
        Attack b1a = new Attack(b1a_url, 20);
        BehaviorLogic b1 = new BehaviorLogic(b1a, null);

        BehaviorLogic[] bls = {b1};

        String monster_url = ".\\images\\monster\\purin.png";
        int maxHp = 500;
        int critical = 5;
        int exp = 12;
        int money = 10;
        return new Monster(monster_url, bls, maxHp, critical, money, exp);
    }
}
