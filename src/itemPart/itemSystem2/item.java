package itemPart.itemSystem2;

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
}
