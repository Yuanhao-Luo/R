package sample.battle;

public class MonsterFactory {
    //没加图片
    public Monster buildPurin(){
        String b1a_url = "";
        Attack b1a = new Attack(b1a_url, 20);
        BehaviorLogic b1 = new BehaviorLogic(b1a, null);

        BehaviorLogic[] bls = {b1};

        String monster_url = "";
        int maxHp = 500;
        int critical = 5;
        int exp = 12;
        int money = 10;
        return new Monster(monster_url, bls, maxHp, critical, money, exp);
    }
}
