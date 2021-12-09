package sample;

import javafx.scene.layout.Pane;
import sample.buttons.GeneralButton;
import sample.characterSystem.Person;

public class ItemListPane extends Pane {
    ItemPane[] itemList = new ItemPane[21];
    int itemPage = 0;
    GeneralButton nextPage;
    GeneralButton prePage;

    public ItemListPane(){
        super();
        setWidth(0);
        setHeight(0);


        nextPage = new GeneralButton(".\\images\\nextItemPage_hover.png",".\\images\\nextItemPage_preparing.png",".\\images\\nextItemPage_pressable.png",".\\images\\nextItemPage_pressed.png");
        nextPage.setOnMouseReleased(e->{
            if (getItemPage() != 2){
                setItemPage(getItemPage()+1);
            }
        });
        getChildren().add(nextPage);
        nextPage.setLayoutX(843);
        nextPage.setLayoutY(578);

        prePage = new GeneralButton(".\\images\\preItemPage_hover.png",".\\images\\preItemPage_preparing.png",".\\images\\preItemPage_pressable.png",".\\images\\preItemPage_pressed.png");
        prePage.setOnMouseReleased(e->{
            if (getItemPage() != 0){
                setItemPage(getItemPage()-1);
            }
        });
        getChildren().add(prePage);
        prePage.setLayoutX(131);
        prePage.setLayoutY(578);

        for (int i = 0; i < itemList.length; i++) {
            itemList[i] = new ItemPane(i);
            getChildren().add(itemList[i]);
        }
        refreshAll();
        changeToItemPage(0);
    }

    public ItemPane[] getItemList() {
        return itemList;
    }

    public void refreshItems(){
        Person person = Person.getInstance();
        for (int i = 0; i < person.getItemList().size(); i++) {
            itemList[i].refresh(person.getItemList().get(i));
        }
    }

    //page start from 0
    public void changeToItemPage(int page){
        for (ItemPane item :
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
        Person person = Person.getInstance();
        refreshItems();
    }
}
