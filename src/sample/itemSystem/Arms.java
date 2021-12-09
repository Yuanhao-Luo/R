package sample.itemSystem;

//arms是军备,军火的意思
public class Arms extends ManyTimesItem implements Combat {
    private String url;
    private int price;
    private int damage;
    private int defence;
    private int attribute;


    public Arms(String url, int price, int totalCoolDown, int damage, int defence) {
        super(url,price,totalCoolDown);
        this.damage = damage;
        this.defence = defence;
    }

    public Arms(String url, int price, int totalCoolDown, int damage, int defence, int attribute){
        super(url, price, totalCoolDown);
        this.damage = damage;
        this.defence = defence;
        this.attribute = attribute;
    }

    @Override
    public int getDamage() {
        return damage;
    }
    @Override
    public int getDefence() {
        return defence;
    }

    public int getAttribute() {
        return attribute;
    }
}
