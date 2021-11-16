package sample;

import sample.itemPart.characterSystem.Person;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import sample.buttons.CloseTentButton;


public class TentPane extends Pane {
    ItemPane[] itemList = new ItemPane[7];
    int itemPage = 0;


    public TentPane(){
        Person p = Person.getInstance();
        Image imageTent1 = new Image("file:.\\images\\tent1.png");
        Image imageTent2 = new Image("file:.\\images\\tent2.png");
        //在这里面放backpack

//        simpleFactory s1 = new simpleFactory();
//
//        p.getBackpack().add(s1.buildXIHUXIHU());
//        p.getMedicineBackpack().add(s1.buildXIHUXIHU());
//        System.out.println(p.getBackpack().get(0).getUrl());
//        System.out.println(p.getBackpack().get(0).getPrice());
//        System.out.println(((medicine)p.getBackpack().get(0)).getHeal());



        ImageView tent1 = new ImageView();
        tent1.setImage(imageTent1);
        tent1.setFitHeight(imageTent1.getHeight());
        tent1.setFitWidth(imageTent1.getWidth());
        int tent1Left = 83;
        int tent1Top = -347;
        tent1.setX(tent1Left);
        tent1.setY(tent1Top);

        ImageView tent2 = new ImageView();
        tent2.setImage(imageTent2);
        tent2.setFitHeight(imageTent2.getHeight());
        int tent2Left = -50;
        int tent2Top = 510;
//        tent2.setFitWidth(1150);
        tent2.setX(tent2Left);
        tent2.setY(tent2Top);

        Label level = new Label("?");
        level.setLayoutX(460 -100 + tent1Left);
        level.setLayoutY(90 - (-300) + tent1Top);
        level.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  45));

        Label hp = new Label("10 40");
        hp.setLayoutX(605 -100 + tent1Left);
        hp.setLayoutY(90 - (-300) + tent1Top);
        hp.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  45));

        Label luck = new Label("3");
        luck.setLayoutX(855 -100 + tent1Left);
        luck.setLayoutY(90 - (-300) + tent1Top);
        luck.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  45));

        Label exp = new Label("4");
        exp.setLayoutX(575 -100 + tent1Left);
        exp.setLayoutY(185 - (-300) + tent1Top);
        exp.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  45));

        Label gold = new Label("6");
        gold.setLayoutX(707 -100 + tent1Left);
        gold.setLayoutY(185 - (-300) + tent1Top);
        gold.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  45));

        Label chip = new Label("7 10");
        chip.setLayoutX(822 -100 + tent1Left);
        chip.setLayoutY(185 - (-300) + tent1Top);
        chip.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  40));

        Label skill = new Label("8");
        Label condition = new Label("9");
        Label note = new Label("10");

        this.getChildren().add(tent1);
        this.getChildren().add(tent2);

        this.getChildren().add(level);
        this.getChildren().add(hp);
        this.getChildren().add(luck);
        this.getChildren().add(exp);
        this.getChildren().add(gold);
        this.getChildren().add(chip);

        CloseTentButton closeTentButton = new CloseTentButton("    关闭帐篷","200",820,720);
        this.getChildren().add(closeTentButton);


        for (int i = 0; i < itemList.length; i++) {
            itemList[i] = new ItemPane(i);
            getChildren().add(itemList[i]);
        }
        refreshItems();
    }

    public Pane[] getItemList() {
        return itemList;
    }

    public void refreshItems(){
        Person person = Person.getInstance();
        for (int i = 0; i < 7; i++) {
            int j = itemPage*7 +i;
            if (j >= person.getItemList().size())
                break;
            itemList[i].setImage(person.getItemList().get(j).getUrl());
        }
    }



}
