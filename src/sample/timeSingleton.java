package sample;

public class timeSingleton {
    private static timeSingleton t = new timeSingleton();
    private int time = 0;


    private timeSingleton(){}

    public static timeSingleton getInstance(){
        return t;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void addOne(){
        time = (time+1)%9;
    }
}
