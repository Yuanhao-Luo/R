package sample.specificPlace;

import javafx.scene.layout.Pane;
import sample.ItemPane;
import sample.buttons.GeneralButton;
import sample.characterSystem.Person;
import sample.itemSystem.Item;

import java.util.ArrayList;

public class GoodsListPane extends Pane {
    GoodPane[] itemList = new GoodPane[21];
    int itemPage = 0;
    GeneralButton nextPage;
    GeneralButton prePage;
    ArrayList<Item> items;

    public GoodsListPane(){
        super();
        setWidth(0);
        setHeight(0);




        for (int i = 0; i < itemList.length; i++) {
            itemList[i] = new GoodPane(i);
            getChildren().add(itemList[i]);
        }
        changeToItemPage(0);

        nextPage = new GeneralButton(".\\images\\nextItemPage_hover.png",".\\images\\nextItemPage_preparing.png",".\\images\\nextItemPage_pressable.png",".\\images\\nextItemPage_pressed.png");
        nextPage.setOnMouseReleased(e->{
            if (getItemPage() != 2){
                setItemPage(getItemPage()+1);
            }
        });
        getChildren().add(nextPage);
        nextPage.setLayoutX(815);
        nextPage.setLayoutY(75);

        prePage = new GeneralButton(".\\images\\preItemPage_hover.png",".\\images\\preItemPage_preparing.png",".\\images\\preItemPage_pressable.png",".\\images\\preItemPage_pressed.png");
        prePage.setOnMouseReleased(e->{
            if (getItemPage() != 0){
                setItemPage(getItemPage()-1);
            }
        });
        getChildren().add(prePage);
        prePage.setLayoutX(165);
        prePage.setLayoutY(75);

    }

    public GoodPane[] getItemList() {
        return itemList;
    }

    public void refreshItems(){
        Person person = Person.getInstance();
        for (int i = 0; i < items.size(); i++) {
            itemList[i].refresh(items.get(i));
        }
        for (int i = items.size(); i < 21; i++) {
            itemList[i].refresh(null);
        }
    }

    //page start from 0
    public void changeToItemPage(int page){
        for (GoodPane item :
                itemList) {
            item.setVisible(false);
        }
        for (int i = 7*page; i < 7*page + 7; i++) {
            itemList[i].setVisible(true);
        }
    }

    public void setItemPage(int itemPage) {
        this.itemPage = itemPage;
        changeToItemPage(itemPage);
    }

    public int getItemPage() {
        return itemPage;
    }

    public void refreshAll(){
        refreshItems();
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
