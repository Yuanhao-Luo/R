package sample.itemPart.itemSystem2;

//arms是军备,军火的意思
public class arms extends manyTimesItem implements combat{
    private String url;
    private int price;
    private int damage;
    private int defence;


    public arms(String url, int price, int totalCoolDown, int damage, int defence) {
        super(url,price,totalCoolDown);
        this.damage = damage;
        this.defence = defence;
    }

    @Override
    public int getDamage() {
        return damage;
    }
    @Override
    public int getDefence() {
        return defence;
    }
}
