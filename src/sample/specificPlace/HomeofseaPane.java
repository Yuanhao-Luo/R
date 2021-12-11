package sample.specificPlace;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import sample.ImageProcess;
import sample.ItemListPane;
import sample.buttons.TextButton;
import sample.characterSystem.Person;
import sample.itemSystem.Item;
import sample.itemSystem.SimpleFactory;

import java.util.ArrayList;

public class HomeofseaPane extends GeneralPlacePane {
    ImageView goodBackground;
    GoodsListPane goodsListPane;
    TextButton buyButton;
    Pane shopPane;
    ImageView itemBackground;
    ItemListPane itemListPane;

    Pane homeofseaYou = new Pane();

    public HomeofseaPane(){
        super("homeofsea");



        ArrayList<Item> items = new ArrayList<Item>();
        SimpleFactory sf = new SimpleFactory();
        items.add(sf.buildBaseball());
        items.add(sf.buildBoomerang());
        items.add(sf.buildBarrelBreakingHammer());
        items.add(sf.buildPillow());

        this.getChildren().add(homeofseaYou);
        ImageProcess.initDialogYouImage(homeofseaYou,".\\images\\homeofseaYou.png");
        ImageProcess.setXY(homeofseaYou,500,160);



        Image imageTent2 = new Image("file:.\\images\\tent2.png");
        itemBackground = new ImageView();
        itemBackground.setImage(imageTent2);
        itemBackground.setFitHeight(imageTent2.getHeight());
        int tent2Left = -50;
        int tent2Top = 510;
        itemBackground.setX(tent2Left);
        itemBackground.setY(tent2Top);
        this.getChildren().add(itemBackground);

        itemListPane = new ItemListPane();
        this.getChildren().add(itemListPane);
        itemListPane.refreshAll();

        shopPane = new Pane();
        shopPane.setPrefWidth(0);
        shopPane.setPrefHeight(0);
        this.getChildren().add(shopPane);
        shopPane.setVisible(true);

        goodBackground = new ImageView();
        ImageProcess.initImageView(goodBackground, 0, 0, ".\\images\\shopListBackground.png");
        shopPane.getChildren().add(goodBackground);
        goodBackground.setFitWidth(1025);

        goodsListPane = new GoodsListPane(items);
        shopPane.getChildren().add(goodsListPane);
        goodsListPane.refreshAll();

        buyButton = new TextButton("    购买", "200", 200, 200);
        shopPane.getChildren().add(buyButton);
        shopPane.setOnMouseReleased(e->{
            Person person = Person.getInstance();
            int cost = 0;
            for (int i = 0; i < goodsListPane.getItemList().length; i++) {
                if (goodsListPane.getItemList()[i].isSelect()){
                    person.getItemList().add(goodsListPane.items.get(i));
                    cost += goodsListPane.items.get(i).getPrice();
                }
            }
            if (cost <= person.getMoney()){
                person.setMoney(person.getMoney()-cost);
                resetGoodsList();
                itemListPane.refreshAll();
            }
        });
    }

    public void resetGoodsList(){
        ArrayList<Item> items = new ArrayList<Item>();
        SimpleFactory sf = new SimpleFactory();
        items.add(sf.buildBaseball());
        items.add(sf.buildBoomerang());
        items.add(sf.buildBarrelBreakingHammer());
        items.add(sf.buildPillow());
        goodsListPane.setItems(items);
    }
}
