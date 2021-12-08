package sample.battle;

public class MonsterFactory {
    //像以下这个方法，为每个怪物都写一个方法，怪物的信息在设计档案里有
    public Monster buildPurin(){
        String b1a_url = "";
        Attack b1a = new Attack(b1a_url, 20);
        BehaviorLogic b1 = new BehaviorLogic(b1a, null);

        BehaviorLogic[] bls = {b1};

        String monster_url = ".\\images\\monster\\purin.png";
        int maxHp = 18;
        int critical = 0;
        int exp = 12;
        int money = 10;
        return new Monster(monster_url, bls, maxHp, critical, money, exp);
    }

    public Monster buildHoney(){
        String b2a_url = "";
        Attack b2a = new Attack(b2a_url, 60);
        BehaviorLogic b2 = new BehaviorLogic(b2a, null);

        BehaviorLogic[] bls = {b2};

        String monster_url = ".\\images\\monster\\honey.png";
        int maxHp = 200;
        int critical = 0;
        int exp = 50;
        int money = 40;
        return new Monster(monster_url, bls, maxHp, critical, money, exp);
    }

    public Monster buildFox(){
        String b3a_url = "";
        Attack b3a = new Attack(b3a_url, 100);
        BehaviorLogic b3 = new BehaviorLogic(b3a, null);

        BehaviorLogic[] bls = {b3};

        String monster_url = ".\\images\\monster\\fox.png";
        int maxHp = 72;
        int critical = 0;
        int exp = 36;
        int money = 45;
        return new Monster(monster_url, bls, maxHp, critical, money, exp);
    }

    public Monster buildFrog(){
        String b4a_url = "";
        Attack b4a = new Attack(b4a_url, 40);
        BehaviorLogic b4 = new BehaviorLogic(b4a, null);

        BehaviorLogic[] bls = {b4};

        String monster_url = ".\\images\\monster\\frog.png";
        int maxHp = 96;
        int critical = 0;
        int exp = 31;
        int money = 20;
        return new Monster(monster_url, bls, maxHp, critical, money, exp);
    }

    public Monster buildHorse(){
        String b5a_url = "";
        Attack b5a = new Attack(b5a_url, 700);
        BehaviorLogic b5 = new BehaviorLogic(b5a, null);

        BehaviorLogic[] bls = {b5};

        String monster_url = ".\\images\\monster\\horse.png";
        int maxHp = 1480;
        int critical = 0;
        int exp = 21;
        int money = 10;
        return new Monster(monster_url, bls, maxHp, critical, money, exp);
    }

    public Monster buildWorm(){
        String b6a_url = "";
        Attack b6a = new Attack(b6a_url, 50);
        BehaviorLogic b6 = new BehaviorLogic(b6a, null);

        BehaviorLogic[] bls = {b6};

        String monster_url = ".\\images\\monster\\worm.png";
        int maxHp = 180;
        int critical = 0;
        int exp = 36;
        int money = 30;
        return new Monster(monster_url, bls, maxHp, critical, money, exp);
    }

    public Monster buildThief(){
        String b7a_url = "";
        Attack b7a = new Attack(b7a_url, 30);
        BehaviorLogic b7 = new BehaviorLogic(b7a, null);

        BehaviorLogic[] bls = {b7};

        String monster_url = ".\\images\\monster\\thief.png";
        int maxHp = 64;
        int critical = 0;
        int exp = 21;
        int money = 30;
        return new Monster(monster_url, bls, maxHp, critical, money, exp);
    }

    public Monster buildRedThief(){
        String b8a_url = "";
        Attack b8a = new Attack(b8a_url, 50);
        BehaviorLogic b8 = new BehaviorLogic(b8a, null);

        BehaviorLogic[] bls = {b8};

        String monster_url = ".\\images\\monster\\red_thief.png";
        int maxHp = 56;
        int critical = 0;
        int exp = 26;
        int money = 20;
        return new Monster(monster_url, bls, maxHp, critical, money, exp);
    }
}
