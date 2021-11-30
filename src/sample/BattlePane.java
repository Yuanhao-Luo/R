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
    int itemPage = 0;
    GeneralButton nextPage;
    GeneralButton prePage;
    ImageView battleBackground1 = new ImageView();
    ImageView battledRance2 = new ImageView();
    ImageView tentPicture3 = new ImageView();
    ImageView thief = new ImageView();
    ImageView defense = new ImageView();
    ImageView HPBackground4 = new ImageView();
    ImageView HPCurrent5 = new ImageView();
    Label hp = new Label("160");
    Label currentHp = new Label("125");

    private static BattlePane battlePane = new BattlePane();



    private BattlePane(){
        //冷却图标
        //总结页面
        //无法存放道具
        //没有道具依然能选择
        //战斗伤害
        //战斗过程页面

        Person p = Person.getInstance();
        Image battleBackground = new Image("file:.\\images\\battleBackground.png");
        Image battledRance = new Image("file:.\\images\\ranceinbattle.png");
        Image tentPicture = new Image("file:.\\images\\tent2.png");
        Image thief1 = new Image("file:.\\images\\thief1.png");
        Image defenseD = new Image("file:.\\images\\defenseD.png");
        Image HPBackground = new Image("file:.\\images\\HPBackground.png");
        Image HPCurrent = new Image("file:.\\images\\HPCurrent.png");
        //在这里面放backpack


        battleBackground1.setImage(battleBackground);
        battleBackground1.setFitHeight(battleBackground.getHeight());
        battleBackground1.setFitWidth(battleBackground.getWidth());
        int battleBackgroundLeft = 0;
        int battleBackgroundTop = 0;
        battleBackground1.setX(battleBackgroundLeft);
        battleBackground1.setY(battleBackgroundTop);

        battledRance2.setImage(battledRance);
        battledRance2.setFitHeight(battledRance.getHeight());
        int battledRanceLeft = -100;
        int battledRanceTop = 120;
//        tent2.setFitWidth(1150);
        battledRance2.setX(battledRanceLeft);
        battledRance2.setY(battledRanceTop);

        tentPicture3.setImage(tentPicture);
        tentPicture3.setFitHeight(tentPicture.getHeight());
        tentPicture3.setFitWidth(tentPicture.getWidth());
        int tentPictureLeft = -50;
        int tentPictureTop = 510;
        tentPicture3.setX(tentPictureLeft);
        tentPicture3.setY(tentPictureTop);

        thief.setImage(thief1);
        thief.setFitHeight(thief1.getHeight());
        int thiefLeft = 600;
        int thiefTop = 30;
        thief.setX(thiefLeft);
        thief.setY(thiefTop);

        defense.setImage(defenseD);
        defense.setFitHeight(defenseD.getHeight());
        int defenseDLeft = 700;
        int defenseDTop = 300;
        defense.setX(defenseDLeft);
        defense.setY(defenseDTop);

        HPBackground4.setImage(HPBackground);
        HPBackground4.setFitHeight(HPBackground.getHeight());
        int HPBackgroundLeft = -50;
        int HPBackgroundTop = 210;
        HPBackground4.setX(HPBackgroundLeft);
        HPBackground4.setY(HPBackgroundTop);

        HPCurrent5.setImage(HPCurrent);
        HPCurrent5.setFitHeight(HPCurrent.getHeight());
        int HPCurrentLeft = 27;
        int HPCurrentTop = 281;
        HPCurrent5.setX(HPCurrentLeft);
        HPCurrent5.setY(HPCurrentTop);

        hp.setLayoutX(50);
        hp.setLayoutY(280);
        hp.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  35));

        currentHp.setLayoutX(50);
        currentHp.setLayoutY(240);
        currentHp.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  35));

        this.getChildren().add(battleBackground1);
        this.getChildren().add(battledRance2);
        this.getChildren().add(tentPicture3);
        this.getChildren().add(thief);
        this.getChildren().add(defense);
        this.getChildren().add(HPBackground4);
        this.getChildren().add(HPCurrent5);

        this.getChildren().add(hp);
        this.getChildren().add(currentHp);

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

    public static BattlePane getInstance(){
        return battlePane;
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

    public void concludBattle(){

    }
}