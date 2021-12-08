package sample;

public class TimeSingleton {
    private static TimeSingleton t = new TimeSingleton();
    private int currentTime = 0;
    private int totalTime = 0;
    private int cardWalked = 0;

    private TimeSingleton(){}

    public static TimeSingleton getInstance(){
        return t;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    public void addOne(){
        currentTime = (currentTime + 1) % 9;
        totalTime += 1;
    }

    public void addXTime(int x){
        currentTime = (currentTime + x) % 9;
        totalTime += x;
    }

    public void walkOneCard(){
        //每9张牌能跳一格时间
        cardWalked = (cardWalked + 1) % 10;
        currentTime = (currentTime + (cardWalked / 9)) % 9;
    }
}
