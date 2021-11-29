package sample.battle;

public class MonsterFactory {
    //没加图片
    public Monster buildPurin(){
        String b1a_url = "";
        Attack b1a = new Attack(b1a_url, 20);
        BehaviourLogic b1 = new BehaviourLogic(b1a, null);

        BehaviourLogic[] bls = {b1};

        String monster_url = "";
        int maxHp = 100;
        int critical = 5;
        return new Monster(monster_url, bls, maxHp, critical);
    }
}
