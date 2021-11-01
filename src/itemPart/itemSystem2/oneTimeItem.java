package itemPart.itemSystem2;

public class oneTimeItem extends item{
    //一次性物品下有药品和其他各种，分别是战斗时不能用与能用，所以仅设定为有图片地址，有治疗量，有价格
    private int heal;

    public oneTimeItem(String url, int price, int heal) {
        super(url, price);
        this.heal = heal;
    }

    public String getUrl() {
        return super.getUrl();
    }

    public int getPrice() {
        return super.getPrice();
    }

    public int getHeal() {
        return heal;
    }
}
