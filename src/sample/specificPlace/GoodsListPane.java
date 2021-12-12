package sample.specificPlace;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import sample.ImageProcess;
import sample.ItemPane;
import sample.buttons.GeneralButton;
import sample.characterSystem.Person;
import sample.itemSystem.Arms;
import sample.itemSystem.Item;
import sample.itemSystem.Medicine;
import sample.itemSystem.OrdinaryItem;

import java.util.ArrayList;

public class GoodsListPane extends Pane {
    GoodPane[] itemList = new GoodPane[21];
    int itemPage = 0;
    GeneralButton nextPage;
    GeneralButton prePage;
    Label price;
    Label priceLabel;
    Label att;
    Label attLabel;
    Label def;
    Label defLabel;
    ImageView moneyBackground;
    Label moneyLabel;
    ArrayList<Item> items;

    public GoodsListPane(){
        super();
        setWidth(0);
        setHeight(0);

        for (int i = 0; i < itemList.length; i++) {
            itemList[i] = new GoodPane(i);
            getChildren().add(itemList[i]);
            int ii = i;
            itemList[i].setOnMouseReleased(e -> {
                if (itemList[ii].isSelectable()){
                    itemList[ii].setSelect(!itemList[ii].isSelect());
                    setGoodInfo(ii);
                }
            });
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

        price = new Label("价格：");
        double price_x = 400;
        price.setLayoutX(price_x);
        price.setLayoutY(200);
        price.setFont(Font.font("kaiti", 35));
        this.getChildren().add(price);

        priceLabel = new Label();
        priceLabel.setLayoutX(price_x + 100);
        priceLabel.setLayoutY(200);
        priceLabel.setFont(Font.font("kaiti", 35));
        this.getChildren().add(priceLabel);

        att = new Label("攻击：");
        att.setLayoutX(price_x+200);
        att.setLayoutY(200);
        att.setFont(Font.font("kaiti", 35));
        this.getChildren().add(att);

        attLabel = new Label();
        attLabel.setLayoutX(price_x + 300);
        attLabel.setLayoutY(200);
        attLabel.setFont(Font.font("kaiti", 35));
        this.getChildren().add(attLabel);

        def = new Label("防御：");
        def.setLayoutX(price_x+400);
        def.setLayoutY(200);
        def.setFont(Font.font("kaiti", 35));
        this.getChildren().add(def);

        defLabel = new Label();
        defLabel.setLayoutX(price_x + 500);
        defLabel.setLayoutY(200);
        defLabel.setFont(Font.font("kaiti", 35));
        this.getChildren().add(defLabel);

        moneyBackground = new ImageView();
        int moneyBackground_y = 200;
        ImageProcess.initImageView(moneyBackground, -50, moneyBackground_y, ".\\images\\moneyBackground.png");
        this.getChildren().add(moneyBackground);

        moneyLabel = new Label();
        moneyLabel.setLayoutX(20);
        moneyLabel.setLayoutY(moneyBackground_y + 285);
        moneyLabel.setFont(Font.font("kaiti", 35));
        refreshMoney();
        this.getChildren().add(moneyLabel);

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

    public void refreshMoney(){
        Person person = Person.getInstance();
        moneyLabel.setText(String.valueOf(person.getMoney()));
    }

    public void setPrice(int price){
        priceLabel.setText(String.valueOf(price));
    }

    public void setGoodInfo(int index){
        int price;
        int att = 0;
        int def = 0;
        Item i = items.get(index);
        if (items.get(index) instanceof Arms){
            Arms a = (Arms) i;
            att = a.getDamage();
            def = a.getDefence();
        }else if (i instanceof OrdinaryItem){
            OrdinaryItem o = (OrdinaryItem) i;
            att = o.getDamage();
            def = o.getDefence();
        }
        price = i.getPrice();
        setPrice(price);
        attLabel.setText(String.valueOf(att));
        defLabel.setText(String.valueOf(def));
    }
}
