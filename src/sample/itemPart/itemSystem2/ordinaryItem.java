package sample.itemPart.itemSystem2;

public class ordinaryItem extends oneTimeItem implements combat{
    //什么倾斜装甲板，飞镖，葡萄酒都算是这个，他们能在战斗中使用，所以独立为一类
    private int damage;
    private int defence;


    public ordinaryItem(String url, int price, int heal, int damage, int defence) {
        super(url, price);
        this.damage = damage;
        this.defence = defence;
    }

    @Override
    public String getUrl() {
        return super.getUrl();
    }
    @Override
    public int getPrice() {
        return super.getPrice();
    }

    public int getDamage() {
        return damage;
    }

    public int getDefence(){return defence;}

}
