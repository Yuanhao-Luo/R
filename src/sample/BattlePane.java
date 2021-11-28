package sample;

import sample.buttons.*;
import sample.itemPart.characterSystem.Person;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class BattlePane extends Pane {
    ItemPane[] itemList = new ItemPane[21];
    //    int HPTotal = 120;
//    int HPCurrent = 8;
    int itemPage = 0;
    GeneralButton nextPage;
    GeneralButton prePage;
//    Pane HPBackgroundPane = new Pane();
//    Pane HPCurrentImg = new Pane();
//    Pane HPBlackImg = new Pane();
//    Label HPCurrentLabel = new Label("" + HPCurrent);
//    Label HPTotalLabel = new Label("" + HPTotal);


    public BattlePane(){
        Person p = Person.getInstance();
        //要求
        //变量名指示不清，改变量名
        Image imageTent1 = new Image("file:.\\images\\battleBackground.png");
        Image imageTent2 = new Image("file:.\\images\\ranceinbattle.png");
        Image imageTent3 = new Image("file:.\\images\\tent2.png");
        Image imageTent4 = new Image("file:.\\images\\thief1.png");
        Image imageTent5 = new Image("file:.\\images\\defenseD.png");
        Image imageTent6 = new Image("file:.\\images\\HPBackground.png");
        Image imageTent7 = new Image("file:.\\images\\HPCurrent.png");
        //在这里面放backpack

//        simpleFactory s1 = new simpleFactory();
//
//        p.getBackpack().add(s1.buildXIHUXIHU());
//        p.getMedicineBackpack().add(s1.buildXIHUXIHU());
//        System.out.println(p.getBackpack().get(0).getUrl());
//        System.out.println(p.getBackpack().get(0).getPrice());
//        System.out.println(((medicine)p.getBackpack().get(0)).getHeal());


        //要求
        //以下几个组件，如果需要之后修改的话，把它作为BattlePane类的属性，或者直接全部变成BattlePane类的属性，可以参考mainframePane
        //把非必要的注释删了
        ImageView tent1 = new ImageView();
        tent1.setImage(imageTent1);
        tent1.setFitHeight(imageTent1.getHeight());
        tent1.setFitWidth(imageTent1.getWidth());
        int tent1Left = 0;
        int tent1Top = 0;
        tent1.setX(tent1Left);
        tent1.setY(tent1Top);

        ImageView tent2 = new ImageView();
        tent2.setImage(imageTent2);
        tent2.setFitHeight(imageTent2.getHeight());
        int tent2Left = -100;
        int tent2Top = 120;
//        tent2.setFitWidth(1150);
        tent2.setX(tent2Left);
        tent2.setY(tent2Top);

        ImageView tent3 = new ImageView();
        tent3.setImage(imageTent3);
        tent3.setFitHeight(imageTent3.getHeight());
        tent3.setFitWidth(imageTent3.getWidth());
        int tent3Left = -50;
        int tent3Top = 510;
        tent3.setX(tent3Left);
        tent3.setY(tent3Top);

        ImageView tent4 = new ImageView();
        tent4.setImage(imageTent4);
        tent4.setFitHeight(imageTent4.getHeight());
        int tent4Left = 600;
        int tent4Top = 30;
        tent4.setX(tent4Left);
        tent4.setY(tent4Top);

        ImageView tent5 = new ImageView();
        tent5.setImage(imageTent5);
        tent5.setFitHeight(imageTent5.getHeight());
        int tent5Left = 700;
        int tent5Top = 300;
        tent5.setX(tent5Left);
        tent5.setY(tent5Top);

        ImageView tent6 = new ImageView();
        tent6.setImage(imageTent6);
        tent6.setFitHeight(imageTent6.getHeight());
        int tent6Left = -50;
        int tent6Top = 210;
        tent6.setX(tent6Left);
        tent6.setY(tent6Top);

        ImageView tent7 = new ImageView();
        tent7.setImage(imageTent7);
        tent7.setFitHeight(imageTent7.getHeight());
        int tent7Left = 27;
        int tent7Top = 281;
        tent7.setX(tent7Left);
        tent7.setY(tent7Top);

//        Label level = new Label("?");
//        level.setLayoutX(460 -100 + tent1Left);
//        level.setLayoutY(90 - (-300) + tent1Top);
//        level.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  45));
//
        Label hp = new Label("160");
        hp.setLayoutX(50);
        hp.setLayoutY(280);
        hp.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  35));
//
        Label currentHp = new Label("125");
        currentHp.setLayoutX(50);
        currentHp.setLayoutY(240);
        currentHp.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  35));
//
//        Label exp = new Label("4");
//        exp.setLayoutX(575 -100 + tent1Left);
//        exp.setLayoutY(185 - (-300) + tent1Top);
//        exp.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  45));
//
//        Label gold = new Label("6");
//        gold.setLayoutX(707 -100 + tent1Left);
//        gold.setLayoutY(185 - (-300) + tent1Top);
//        gold.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  45));
//
//        Label chip = new Label("7 10");
//        chip.setLayoutX(822 -100 + tent1Left);
//        chip.setLayoutY(185 - (-300) + tent1Top);
//        chip.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  40));
//
//        Label skill = new Label("8");
//        Label condition = new Label("9");
//        Label note = new Label("10");

        this.getChildren().add(tent1);
        this.getChildren().add(tent2);
        this.getChildren().add(tent3);
        this.getChildren().add(tent4);
        this.getChildren().add(tent5);
        this.getChildren().add(tent6);
        this.getChildren().add(tent7);

//        this.getChildren().add(level);
        this.getChildren().add(hp);
        this.getChildren().add(currentHp);
//        this.getChildren().add(exp);
//        this.getChildren().add(gold);
//        this.getChildren().add(chip);

        CloseTentButton closeTentButton = new CloseTentButton("快点回去城下町吧","200",10,720);
        this.getChildren().add(closeTentButton);

        StartBattleButton startBattleButton = new StartBattleButton("    战斗开始！","200",350,520);
        this.getChildren().add(startBattleButton);

        SelectAllButton selectAllButton = new SelectAllButton("     全选择","200",570,520);
        this.getChildren().add(selectAllButton);

        CancelAllButton cancelAllButton = new CancelAllButton("   全选择解除","200",800,520);
        this.getChildren().add(cancelAllButton);

        //以下是物品系统加的东西
        //bet的位置大小还要调一下
        nextPage = new GeneralButton(".\\images\\nextItemPage_hover.png",".\\images\\nextItemPage_preparing.png",".\\images\\nextItemPage_pressable.png",".\\images\\nextItemPage_pressed.png");
        //图片还没有放进去
        nextPage.setOnMouseReleased(e->{
            if (getItemPage() != 3){
                setItemPage(getItemPage()+1);
            }
        });
        getChildren().add(nextPage);
        nextPage.setLayoutX(0);//需要调整位置
        nextPage.setLayoutY(0);

        prePage = new GeneralButton(".\\images\\preItemPage_hover.png",".\\images\\preItemPage_preparing.png",".\\images\\preItemPage_pressable.png",".\\images\\preItemPage_pressed.png");
        //图片还没有放进去
        prePage.setOnMouseReleased(e->{
            if (getItemPage() != 0){
                setItemPage(getItemPage()-1);
            }
        });
        getChildren().add(prePage);
        prePage.setLayoutX(0);//需要调整位置
        prePage.setLayoutY(0);

        for (int i = 0; i < itemList.length; i++) {
            itemList[i] = new ItemPane(i);
            getChildren().add(itemList[i]);
        }
        refreshItems();
        changeToItemPage(0);
    }

    public Pane[] getItemList() {
        return itemList;
    }

    public void refreshItems(){
        Person person = Person.getInstance();
        for (int i = 0; i < person.getItemList().size(); i++) {
            itemList[i].setImage(person.getItemList().get(i).getUrl());
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
}