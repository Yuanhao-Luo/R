package sample.battle;

public class Weekness extends Behaviour {
    private int weekness;
    public Weekness(String url, int weekness) {
        super(url);
        this.weekness = weekness;
    }

    public int getWeeknessType() {
        return weekness;
    }
}
