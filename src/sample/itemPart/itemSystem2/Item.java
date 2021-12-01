package sample.itemPart.itemSystem2;

import sample.itemPart.characterSystem.Person;

public class Item {
    private String url;
    private int price;

    public Item(String url, int price) {
        this.url = url;
        this.price = price;
    }


    public String getUrl() {
        return url;
    }

    public int getPrice() {
        return price;
    }

    public void drop(){
        Person.getInstance().getItemList().dropItem(this);
    }
}
