package sample;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


public class tentPane extends Pane {

    public tentPane(){
        Image imageTent1 = new Image("file:C:\\Users\\a\\Desktop\\大三上\\rance\\tent1.png");
        Image imageTent2 = new Image("file:C:\\Users\\a\\Desktop\\大三上\\rance\\tent2.png");
        Image returnButton = new Image("file:C:\\Users\\a\\Desktop\\大三上\\rance\\button.png");

        ImageView tent1 = new ImageView();
        tent1.setImage(imageTent1);
        tent1.setFitHeight(imageTent1.getHeight());
        tent1.setFitWidth(imageTent1.getWidth());
        tent1.setX(100);
        tent1.setY(-300);

        ImageView tent2 = new ImageView();
        tent2.setImage(imageTent2);
        tent2.setFitHeight(imageTent2.getHeight());
        tent2.setFitWidth(1150);
        tent2.setY(500);

        ImageView returnButtonimv = new ImageView();
        returnButtonimv.setImage(returnButton);
        returnButtonimv.setFitHeight(returnButton.getHeight());
        returnButtonimv.setFitWidth(returnButton.getWidth());
        returnButtonimv.setX(900);
        returnButtonimv.setY(700);

        Label level = new Label("?");
        level.setLayoutX(460);
        level.setLayoutY(90);
        level.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  45));

        Label hp = new Label("10 40");
        hp.setLayoutX(605);
        hp.setLayoutY(90);
        hp.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  45));

        Label luck = new Label("3");
        luck.setLayoutX(855);
        luck.setLayoutY(90);
        luck.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  45));

        Label exp = new Label("4");
        exp.setLayoutX(575);
        exp.setLayoutY(185);
        exp.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  45));

        Label gold = new Label("6");
        gold.setLayoutX(707);
        gold.setLayoutY(185);
        gold.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  45));

        Label chip = new Label("7 10");
        chip.setLayoutX(807);
        chip.setLayoutY(185);
        chip.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  45));

        Label skill = new Label("8");
        Label condition = new Label("9");
        Label note = new Label("10");


        this.getChildren().add(tent1);
        this.getChildren().add(tent2);
        this.getChildren().add(returnButtonimv);

        this.getChildren().add(level);
        this.getChildren().add(hp);
        this.getChildren().add(luck);
        this.getChildren().add(exp);
        this.getChildren().add(gold);
        this.getChildren().add(chip);
//        this.getChildren().add(skill);
//        this.getChildren().add(condition);
//        this.getChildren().add(note);

    }



}
