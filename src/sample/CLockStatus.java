package sample;

import javafx.scene.layout.Pane;

public class CLockStatus {
    private double x;
    private double y;
    private int time;

    public CLockStatus(double x, double y, int time){
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
