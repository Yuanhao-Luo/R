package sample.battle;

public class Defence extends Behaviour {
    private int defence;
    private int attribute = 0;
    public Defence(String url, int defence) {
        super(url);
        this.defence = defence;
    }

    public Defence(String url, int defence, int attribute){
        super(url);
        this.defence = defence;
        this.attribute = attribute;
    }

    public int getDefenceNum() {
        return defence;
    }

    public int getAttributeType() {
        return attribute;
    }
}
