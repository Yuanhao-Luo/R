package sample.battle;

public class Weakness extends Behavior {
    private int weakness = 0;
    public Weakness(String url, int weakness) {
        super(url);
        this.weakness = weakness;
    }

    public int getWeeknessType() {
        return weakness;
    }
}
