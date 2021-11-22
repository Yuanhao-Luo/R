package sample;

import javafx.scene.layout.Pane;

public class ClockStatus {
    private double x;
    private double y;
    private int time;

    public ClockStatus(double x, double y, int time){
        this.x = x;
        this.y = y;
        this.time = time;
    }

    public void setLocation(Pane dot){
        dot.setLayoutX(x);
        dot.setLayoutY(y);
    }

    public int getTime() {
        return time;
    }
}
