package itemPart.itemSystem2;

public class manyTimesItem extends item{
    private boolean canBeSelected;
    private int currentCoolDown;
    private int totalCoolDown;


    public manyTimesItem(String url, int price, int totalCoolDown) {
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

    public void used(){
        currentCoolDown = totalCoolDown;
    }

    public void refreshCoolDown(){
        this.currentCoolDown -= 1;
        if (currentCoolDown == 0)
            this.canBeSelected = true;
    }
}
