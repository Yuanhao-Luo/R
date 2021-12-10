package sample;

import sample.buttons.GeneralButton;
import sample.characterSystem.Person;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import sample.buttons.CloseTentButton;


public class TentPane extends Pane {
    ItemListPane itemListPane;
//    int itemPage = 0;
//    ItemPane[] itemList = new ItemPane[21];
//    GeneralButton nextPage;
//    GeneralButton prePage;
    Label levelLabel;
    Label hpLabel;
    Label maxhpLabel;
    Label luckLabel;
    Label expLabel;
    Label goldLabel;
    Label chipLabel;
    Label scheduleLabel;
    String[] scheduleList = {"寻找小光"};

    private static TentPane tentPane = new TentPane();

    public static TentPane getInstance(){return tentPane;}

    private TentPane(){
        Person p = Person.getInstance();
        Image imageTent1 = new Image("file:.\\images\\tent1.png");
        Image imageTent2 = new Image("file:.\\images\\tent2.png");

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
        tent2.setX(tent2Left);
        tent2.setY(tent2Top);

        levelLabel = new Label("5");
        levelLabel.setLayoutX(460 -100 + tent1Left);
        levelLabel.setLayoutY(90 - (-300) + tent1Top);
        levelLabel.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  45));

        hpLabel = new Label("10");
        hpLabel.setLayoutX(570 -100 + tent1Left);
        hpLabel.setLayoutY(90 - (-300) + tent1Top);
        hpLabel.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  45));

        maxhpLabel = new Label("40");
        maxhpLabel.setLayoutX(700 -100 + tent1Left);
        maxhpLabel.setLayoutY(90 - (-300) + tent1Top);
        maxhpLabel.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  45));

        luckLabel = new Label("3");
        luckLabel.setLayoutX(855 -100 + tent1Left);
        luckLabel.setLayoutY(90 - (-300) + tent1Top);
        luckLabel.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  45));

        expLabel = new Label("4");
        expLabel.setLayoutX(570 -100 + tent1Left);
        expLabel.setLayoutY(190 - (-300) + tent1Top);
        expLabel.setFont(Font.font("Timer New Roman",  35));

        goldLabel = new Label("6");
        goldLabel.setLayoutX(700 -100 + tent1Left);
        goldLabel.setLayoutY(190 - (-300) + tent1Top);
        goldLabel.setFont(Font.font("Timer New Roman",  35));

        chipLabel = new Label("7");
        chipLabel.setLayoutX(835 -100 + tent1Left);
        chipLabel.setLayoutY(190 - (-300) + tent1Top);
        chipLabel.setFont(Font.font("Timer New Roman",  35));

        scheduleLabel = new Label();
        scheduleLabel.setText(scheduleList[0]);
        scheduleLabel.setLayoutX(500);
        scheduleLabel.setLayoutY(380);
        scheduleLabel.setFont(Font.font("kaiti",20));


        this.getChildren().add(tent1);
        this.getChildren().add(tent2);

        this.getChildren().add(levelLabel);
        this.getChildren().add(hpLabel);
        this.getChildren().add(maxhpLabel);
        this.getChildren().add(luckLabel);
        this.getChildren().add(expLabel);
        this.getChildren().add(goldLabel);
        this.getChildren().add(chipLabel);
        this.getChildren().add(scheduleLabel);

        itemListPane = new ItemListPane();
        this.getChildren().add(itemListPane);
        itemListPane.refreshAll();

        CloseTentButton closeTentButton = new CloseTentButton("    关闭帐篷","200",820,720);
        this.getChildren().add(closeTentButton);

        refreshNum();

//        //以下是物品系统加的东西
//        //bet的位置大小还要调一下
//        nextPage = new GeneralButton(".\\images\\nextItemPage_hover.png",".\\images\\nextItemPage_pressed.png",".\\images\\nextItemPage_pressable.png",".\\images\\nextItemPage_pressed.png");
//        //图片还没有放进去
//        nextPage.setOnMouseReleased(e->{
//            if (getItemPage() != 3){
//                setItemPage(getItemPage()+1);
//            }
//        });
//        getChildren().add(nextPage);
//        nextPage.setLayoutX(843);//需要调整位置
//        nextPage.setLayoutY(578);
//
//        prePage = new GeneralButton(".\\images\\preItemPage_hover.png",".\\images\\preItemPage_pressed.png",".\\images\\preItemPage_pressable.png",".\\images\\preItemPage_pressed.png");
//        //图片还没有放进去
//        prePage.setOnMouseReleased(e->{
//            if (getItemPage() != 0){
//                setItemPage(getItemPage()-1);
//            }
//        });
//        getChildren().add(prePage);
//        prePage.setLayoutX(131);//需要调整位置
//        prePage.setLayoutY(578);
//
//        for (int i = 0; i < itemList.length; i++) {
//            itemList[i] = new ItemPane(i);
//            getChildren().add(itemList[i]);
//        }
//        refreshItems();
//        changeToItemPage(0);
    }



//    public Pane[] getItemList() {
//        return itemList;
//    }

//    public void refreshItems(){
//        Person person = Person.getInstance();
//        for (int i = 0; i < person.getItemList().size(); i++) {
//            itemList[i].setImage(person.getItemList().get(i).getUrl());
//        }
//    }
//
//    //page start from 0
//    public void changeToItemPage(int page){
//        for (ItemPane i : itemList) {
//            i.setVisible(false);
//        }
//        for (int i = 7*page; i < 7*page + 7; i++) {
//            itemList[i].setVisible(true);
//        }
//    }
//
//    public void setItemPage(int itemPage) {
//        this.itemPage = itemPage;
//        changeToItemPage(itemPage);
//    }
//
//    public int getItemPage() {
//        return itemPage;
//    }


    public ItemListPane getItemListPane() {
        return itemListPane;
    }

    public void refreshNum(){
        Person person = Person.getInstance();
        setLevel(person.getLevel());
        sethp(person.getHealth());
        setMaxhp(person.getMaxHealth());
        setLuck(person.getLuck());
        setGold(person.getMoney());
        setChip(person.getItemList().size());
    }

    public void setLevel(int level){
        levelLabel.setText(String.valueOf(level));
    }

    public void sethp(int hp){
        hpLabel.setText(String.valueOf(hp));
    }

    public void setMaxhp(int maxhp){
        maxhpLabel.setText(String.valueOf(maxhp));
    }

    public void setLuck(int luck){
        luckLabel.setText(String.valueOf(luck));
    }

    public void setExp(int exp){
        expLabel.setText(String.valueOf(exp));
    }

    public void setGold(int gold){
        goldLabel.setText(String.valueOf(gold));
    }

    public void setChip(int chip){
        chipLabel.setText(String.valueOf(chip));
    }

    public void setSchedule(int i){
        scheduleLabel.setText(scheduleList[i]);
    }
}
