package itemPart.itemSystem2;

import java.util.ArrayList;

public class ItemList extends ArrayList<item> {
    public ItemList(){
        super();
    }

    public void dropItem(item i){
        this.remove(i);
    }
}
