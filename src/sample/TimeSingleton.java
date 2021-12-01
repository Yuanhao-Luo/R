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
        //每六张牌能跳一格时间
        cardWalked = (cardWalked + 1) % 7;
        System.out.println("cardWalked is "+ cardWalked);
        currentTime = (currentTime + (cardWalked / 6)) % 9;
        System.out.println("currentTime is "+ currentTime);
    }
}
