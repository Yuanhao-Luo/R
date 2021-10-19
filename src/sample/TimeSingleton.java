package sample;

public class TimeSingleton {
    private static TimeSingleton t = new TimeSingleton();
    private int time = 0;

    private TimeSingleton(){}

    public static TimeSingleton getInstance(){
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

    public void modifyTime(int x){
        time = (time+x)%9;
    }
}
