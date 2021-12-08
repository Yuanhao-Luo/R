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
        String b1a_url = "";
        Attack b1a = new Attack(b1a_url, 60);
        Attack b2a = new Attack(b1a_url, 100);
        BehaviorLogic b1 = new BehaviorLogic(b1a, null);
        BehaviorLogic b2 = new BehaviorLogic(b2a, null);

        BehaviorLogic[] bls = {b1,b2};

        String monster_url = ".\\images\\monster\\honey.png";
        int maxHp = 200;
        int critical = 0;
        int exp = 50;
        int money = 40;
        return new Monster(monster_url, bls, maxHp, critical, money, exp);
    }

    public Monster buildFox(){
        String b1a_url = "";
        Attack b1a = new Attack(b1a_url, 30);
        BehaviorLogic b1 = new BehaviorLogic(b1a, null);

        BehaviorLogic[] bls = {b1};

        String monster_url = ".\\images\\monster\\fox.png";
        int maxHp = 72;
        int critical = 0;
        int exp = 36;
        int money = 45;
        return new Monster(monster_url, bls, maxHp, critical, money, exp);
    }

    public Monster buildFrog(){
        String b1a_url = "";
        Attack b1a = new Attack(b1a_url, 40);
        BehaviorLogic b1 = new BehaviorLogic(b1a, null);

        BehaviorLogic[] bls = {b1};

        String monster_url = ".\\images\\monster\\frog.png";
        int maxHp = 96;
        int critical = 0;
        int exp = 31;
        int money = 20;
        return new Monster(monster_url, bls, maxHp, critical, money, exp);
    }

    public Monster buildHorse(){
        String b1a_url = "";
        Attack b1a = new Attack(b1a_url, 700);
        BehaviorLogic b1 = new BehaviorLogic(b1a, null);

        BehaviorLogic[] bls = {b1,b1};

        String monster_url = ".\\images\\monster\\horse.png";
        int maxHp = 1480;
        int critical = 0;
        int exp = 21;
        int money = 10;
        return new Monster(monster_url, bls, maxHp, critical, money, exp);
    }

    public Monster buildWorm(){
        String b1a_url = "";
        Attack b1a = new Attack(b1a_url, 50);
        BehaviorLogic b1 = new BehaviorLogic(b1a, null);

        BehaviorLogic[] bls = {b1};

        String monster_url = ".\\images\\monster\\worm.png";
        int maxHp = 180;
        int critical = 0;
        int exp = 36;
        int money = 30;
        return new Monster(monster_url, bls, maxHp, critical, money, exp);
    }

    public Monster buildThief(){
        String b1a_url = "";
        String b1d_url = "";
        Attack b1a = new Attack(b1a_url, 30);
        Defence b1d = new Defence(b1d_url, 30);
        BehaviorLogic b1 = new BehaviorLogic(b1a, null);
        BehaviorLogic b2 = new BehaviorLogic(null, b1d);

        BehaviorLogic[] bls = {b2,b1,b1};

        String monster_url = ".\\images\\monster\\thief.png";
        int maxHp = 64;
        int critical = 0;
        int exp = 21;
        int money = 30;
        return new Monster(monster_url, bls, maxHp, critical, money, exp);
    }

    public Monster buildRedThief(){
        String b1a_url = "";
        String b1d_url = "";
        Attack b1a = new Attack(b1a_url, 50);
        Defence b1d = new Defence(b1d_url, 50);
        BehaviorLogic b1 = new BehaviorLogic(b1a, null);
        BehaviorLogic b2 = new BehaviorLogic(null, b1d);

        BehaviorLogic[] bls = {b1,b2,b1};

        String monster_url = ".\\images\\monster\\red_thief.png";
        int maxHp = 56;
        int critical = 0;
        int exp = 26;
        int money = 20;
        return new Monster(monster_url, bls, maxHp, critical, money, exp);
    }
}
