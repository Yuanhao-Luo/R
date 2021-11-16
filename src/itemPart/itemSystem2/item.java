package itemPart.itemSystem2;

import itemPart.characterSystem.Person;

public class item {
    private String url;
    private int price;

    public item(String url, int price) {
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
