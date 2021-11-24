package sample.battle;

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

    }
}
