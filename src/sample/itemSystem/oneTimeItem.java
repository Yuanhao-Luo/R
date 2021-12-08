package sample.itemSystem;

public class oneTimeItem extends Item {
    //一次性物品下有药品和其他各种，分别是战斗时不能用与能用，所以仅设定为有图片地址，有治疗量，有价格

    public oneTimeItem(String url, int price) {
        super(url, price);

    }

    public String getUrl() {
        return super.getUrl();
    }

    public int getPrice() {
        return super.getPrice();
    }

}
