package sample.itemPart.itemSystem2;

import java.util.ArrayList;

public class ItemList extends ArrayList<Item> {
    public ItemList(){
        super();
    }

    public void dropItem(Item i){
        this.remove(i);
    }
}
