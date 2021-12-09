package sample.itemSystem;

public class ManyTimesItem extends Item {
    private boolean canBeSelected;
    private int currentCoolDown;
    private int totalCoolDown;


    public ManyTimesItem(String url, int price, int totalCoolDown) {
        super(url, price);
        this.canBeSelected = true;
        this.currentCoolDown = 0;
        this.totalCoolDown = totalCoolDown;
    }

    public String getUrl(){
        return super.getUrl();
    }

    public int getPrice(){
        return super.getPrice();
    }

    public int getCurrentCoolDown(){
        return currentCoolDown;
    }

    //这个getter主要测试用
    public int getTotalCoolDown(){
        return totalCoolDown;
    }

    public void used(){
        currentCoolDown = totalCoolDown;
    }

    public void refreshCoolDown(){
        this.currentCoolDown -= 1;
        if (currentCoolDown == 0)
            this.canBeSelected = true;
    }
}
