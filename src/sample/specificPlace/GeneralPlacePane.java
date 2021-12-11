package sample.specificPlace;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sample.ImageProcess;
import sample.ItemListPane;
import sample.buttons.ActionButton;
import sample.buttons.TextButton;
import sample.characterSystem.Person;
import sample.itemSystem.Item;
import sample.itemSystem.SimpleFactory;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class GeneralPlacePane extends Pane {
    Pane me = new Pane();
    String placeName;


    int actionButtonX = 10;
    static final int firstActionButtonY = 150;
    static final int actionbuttonInterval = 82;
    static final int dialogPlaceX = -38;
    static final int dialogPlaceY = 593;
    static final int dialogTitleX = -16;
    static final int dialogTitleY = -15;
    static final int dialogTextX = 120;
    static final int dialogTextY = 30;
    static final int dialogTextSize = 28;



    ActionButton beyeButton;
    ActionButton bmouthButton;
    ActionButton bhandButton;
    ActionButton battackButton;
    ActionButton bfootButton;

    ImageView goodBackground;
    GoodsListPane goodsListPane;
    TextButton buyButton;
    Pane shopPane;
    ImageView itemBackground;
    ItemListPane itemListPane;
    TextButton quitShop;


    public GeneralPlacePane(String placeName){
        this.placeName = placeName;

        beyeButton = new ActionButton(this,".\\images\\eyeButton_hover.png",".\\images\\eyeButton_unpressable.png",".\\images\\eyeButton_pressable.png",".\\images\\eyeButton_pressed.png",placeName,"eye");
        bmouthButton = new ActionButton(this,".\\images\\mouthButton_hover.png",".\\images\\mouthButton_unpressable.png",".\\images\\mouthButton_pressable.png",".\\images\\mouthButton_pressed.png",placeName,"mouth");
        bhandButton = new ActionButton(this,".\\images\\handButton_hover.png",".\\images\\handButton_unpressable.png",".\\images\\handButton_pressable.png",".\\images\\handButton_pressed.png",placeName,"hand");
        battackButton = new ActionButton(this,".\\images\\attackButton_hover.png",".\\images\\attackButton_unpressable.png",".\\images\\attackButton_pressable.png",".\\images\\attackButton_pressed.png",placeName,"attack");
        bfootButton = new ActionButton(this,".\\images\\footButton_hover.png",".\\images\\footButton_unpressable.png",".\\images\\footButton_pressable.png",".\\images\\footButton_pressed.png",placeName,"foot");

        ImageProcess.addImage(this,".\\images\\" + placeName + "Background.png");
        this.getChildren().add(me);

        ImageProcess.initDialogMeImage(me,".\\images\\me.png");
        this.getChildren().add(beyeButton);
        ImageProcess.setXY(beyeButton,actionButtonX,firstActionButtonY);

        this.getChildren().add(bmouthButton);
        ImageProcess.setXY(bmouthButton,actionButtonX,firstActionButtonY + actionbuttonInterval);

        this.getChildren().add(bhandButton);
        ImageProcess.setXY(bhandButton,actionButtonX,firstActionButtonY + actionbuttonInterval*2);

        this.getChildren().add(battackButton);
        ImageProcess.setXY(battackButton,actionButtonX,firstActionButtonY + actionbuttonInterval*3);

        this.getChildren().add(bfootButton);
        ImageProcess.setXY(bfootButton,actionButtonX,firstActionButtonY + actionbuttonInterval*4);


        ArrayList<Item> items = new ArrayList<Item>();
        SimpleFactory sf = new SimpleFactory();
        items.add(sf.buildBaseball());
        items.add(sf.buildBoomerang());
        items.add(sf.buildBarrelBreakingHammer());
        items.add(sf.buildPillow());

        shopPane = new Pane();
        shopPane.setPrefWidth(0);
        shopPane.setPrefHeight(0);
        shopPane.setVisible(false);

        Image imageTent2 = new Image("file:.\\images\\tent2.png");
        itemBackground = new ImageView();
        itemBackground.setImage(imageTent2);
        itemBackground.setFitHeight(imageTent2.getHeight());
        int tent2Left = -50;
        int tent2Top = 510;
        itemBackground.setX(tent2Left);
        itemBackground.setY(tent2Top);
        shopPane.getChildren().add(itemBackground);

        itemListPane = new ItemListPane();
        shopPane.getChildren().add(itemListPane);
        itemListPane.refreshAll();



        goodBackground = new ImageView();
        ImageProcess.initImageView(goodBackground, 0, 0, ".\\images\\shopListBackground.png");
        shopPane.getChildren().add(goodBackground);
        goodBackground.setFitWidth(1025);

        goodsListPane = new GoodsListPane(items);
        shopPane.getChildren().add(goodsListPane);
        goodsListPane.refreshAll();

        buyButton = new TextButton("    购买", "200", 200, 200);
        shopPane.getChildren().add(buyButton);
        buyButton.setOnMouseReleased(e->{
            Person person = Person.getInstance();
            int cost = 0;
            for (int i = 0; i < goodsListPane.getItemList().length; i++) {
                if (goodsListPane.getItemList()[i].isSelect()){
                    cost += goodsListPane.items.get(i).getPrice();
                }
            }
            if (cost <= person.getMoney()){
                for (int i = 0; i < goodsListPane.getItemList().length; i++) {
                    if (goodsListPane.getItemList()[i].isSelect()){
                        person.getItemList().add(goodsListPane.items.get(i));
                        goodsListPane.getItemList()[i].setSelect(false);
                    }
                }
                person.setMoney(person.getMoney()-cost);
                resetGoodsList();
                itemListPane.refreshAll();
            }
        });

        quitShop = new TextButton("    退出商店","200", 800, 710);
        shopPane.getChildren().add(quitShop);
        quitShop.setOnMouseReleased(e->{
            shopPane.setVisible(false);
        });


    }

    public void dialogBegin(String placeName, String[] dialogContent, int firstSpeaker){
        String meDialogUrl = ".\\images\\meDialog.png";
        String youDialogUrl = ".\\images\\" + placeName + "YouDialog.png";

        Pane dialogPlace = new Pane();
        String dialogText = "";
        Label dialogTextLabel = new Label(dialogText);
        ImageView dialogTitle = new ImageView();

        dialogTextLabel.setFont(Font.font("Kaiti",dialogTextSize));
        dialogTextLabel.setTextFill(Color.WHITE);


        this.beyeButton.setVisible(false);
        this.bmouthButton.setVisible(false);
        this.bhandButton.setVisible(false);
        this.battackButton.setVisible(false);
        this.bfootButton.setVisible(false);
        dialogTextLabel.setText(dialogContent[0]);
        AtomicInteger count = new AtomicInteger();
        count.set(firstSpeaker);
        ImageProcess.initImageView(dialogTitle, dialogTitleX, dialogTitleY, (firstSpeaker == 1)? meDialogUrl : youDialogUrl);
        dialogPlace.setOnMouseClicked(e ->{
            if(((firstSpeaker == 1)? count.get() : count.get() - 1) >= dialogContent.length){
                this.beyeButton.setVisible(true);
                this.bmouthButton.setVisible(true);
                this.bhandButton.setVisible(true);
                this.battackButton.setVisible(true);
                this.bfootButton.setVisible(true);
                dialogPlace.setVisible(false);
            }
            else {
                dialogTextLabel.setText(dialogContent[(firstSpeaker == 1)? count.get() : count.get() - 1]);
                System.out.println((firstSpeaker == 1)? count.get() : count.get() - 1);
                ImageProcess.changeImage(dialogTitle,(count.get() % 2 != 0)? youDialogUrl : meDialogUrl);
                count.set(count.get() + 1);
            }
        });

        ImageProcess.initPane(dialogPlace,dialogPlaceX,dialogPlaceY,".\\images\\dialogPlace.png");
        ImageProcess.setXY(dialogTextLabel,dialogTextX,dialogTextY);
        this.getChildren().add(dialogPlace);
        dialogPlace.getChildren().add(dialogTitle);
        dialogPlace.getChildren().add(dialogTextLabel);
    }

    public void dialogBegin(String placeName, String actionName, int number, String[] dialogContent, int firstSpeaker){
        String meDialogUrl = ".\\images\\meDialog.png";
        String youDialogUrl = ".\\images\\" + placeName + "YouDialog.png";

        Pane dialogPlace = new Pane();
        String dialogText = "";
        Label dialogTextLabel = new Label(dialogText);
        ImageView dialogTitle = new ImageView();

        dialogTextLabel.setFont(Font.font("Kaiti",dialogTextSize));
        dialogTextLabel.setTextFill(Color.WHITE);

        this.beyeButton.setVisible(false);
        this.bmouthButton.setVisible(false);
        this.bhandButton.setVisible(false);
        this.battackButton.setVisible(false);
        this.bfootButton.setVisible(false);
        this.getChildren().remove(9);
        dialogPlace.setVisible(true);

        dialogTextLabel.setText(dialogContent[0]);
        AtomicInteger count = new AtomicInteger();
        count.set(firstSpeaker);
        ImageProcess.initImageView(dialogTitle, dialogTitleX, dialogTitleY, (firstSpeaker == 1)? meDialogUrl : youDialogUrl);
        dialogPlace.setOnMouseClicked(e ->{
            if(((firstSpeaker == 1)? count.get() : count.get() - 1) >= dialogContent.length){
                this.beyeButton.setVisible(true);
                this.bmouthButton.setVisible(true);
                this.bhandButton.setVisible(true);
                this.battackButton.setVisible(true);
                this.bfootButton.setVisible(true);
                this.getChildren().remove(dialogPlace);
            }
            else {
                dialogTextLabel.setText(dialogContent[(firstSpeaker == 1)? count.get() : count.get() - 1]);
                System.out.println((firstSpeaker == 1)? count.get() : count.get() - 1);
                ImageProcess.changeImage(dialogTitle,(count.get() % 2 != 0)? youDialogUrl : meDialogUrl);
                count.set(count.get() + 1);
            }
        });
        ImageProcess.initPane(dialogPlace,dialogPlaceX,dialogPlaceY,".\\images\\dialogPlace.png");
        ImageProcess.setXY(dialogTextLabel,dialogTextX,dialogTextY);
        this.getChildren().add(dialogPlace);
        dialogPlace.getChildren().add(dialogTitle);
        dialogPlace.getChildren().add(dialogTextLabel);
    }


    public void dialogBegin(String placeName, String actionName, int number, String[] dialogContent, int firstSpeaker, String otherAction){
        String meDialogUrl = ".\\images\\meDialog.png";
        String youDialogUrl = ".\\images\\" + placeName + "YouDialog.png";

        Pane dialogPlace = new Pane();
        String dialogText = "";
        Label dialogTextLabel = new Label(dialogText);
        ImageView dialogTitle = new ImageView();

        dialogTextLabel.setFont(Font.font("Kaiti",dialogTextSize));
        dialogTextLabel.setTextFill(Color.WHITE);

        this.beyeButton.setVisible(false);
        this.bmouthButton.setVisible(false);
        this.bhandButton.setVisible(false);
        this.battackButton.setVisible(false);
        this.bfootButton.setVisible(false);
        this.getChildren().remove(9);
        dialogPlace.setVisible(true);

        dialogTextLabel.setText(dialogContent[0]);
        AtomicInteger count = new AtomicInteger();
        count.set(firstSpeaker);
        ImageProcess.initImageView(dialogTitle, dialogTitleX, dialogTitleY, (firstSpeaker == 1)? meDialogUrl : youDialogUrl);
        dialogPlace.setOnMouseClicked(e ->{
            if(((firstSpeaker == 1)? count.get() : count.get() - 1) >= dialogContent.length){
                this.beyeButton.setVisible(true);
                this.bmouthButton.setVisible(true);
                this.bhandButton.setVisible(true);
                this.battackButton.setVisible(true);
                this.bfootButton.setVisible(true);
                this.getChildren().remove(dialogPlace);
                switch (otherAction){
                    case "openHomeofseaShop":
                        this.shopPane.setVisible(true);
                        break;
                    default:
                        this.shopPane.setVisible(false);
                }
            }
            else {
                dialogTextLabel.setText(dialogContent[(firstSpeaker == 1)? count.get() : count.get() - 1]);
                System.out.println((firstSpeaker == 1)? count.get() : count.get() - 1);
                ImageProcess.changeImage(dialogTitle,(count.get() % 2 != 0)? youDialogUrl : meDialogUrl);
                count.set(count.get() + 1);
            }
        });
        ImageProcess.initPane(dialogPlace,dialogPlaceX,dialogPlaceY,".\\images\\dialogPlace.png");
        ImageProcess.setXY(dialogTextLabel,dialogTextX,dialogTextY);
        this.getChildren().add(dialogPlace);
        dialogPlace.getChildren().add(dialogTitle);
        dialogPlace.getChildren().add(dialogTextLabel);
    }

    public String getPlaceName() {
        return placeName;
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
