package sample;

import javafx.scene.paint.Color;
import sample.battle.Battle;
import sample.battle.Monster;
import sample.buttons.*;
import sample.characterSystem.Person;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class BattlePane extends Pane {
    ItemListPane itemListPane;
//    ItemPane[] itemList = new ItemPane[21];
//    int itemPage = 0;
//    GeneralButton nextPage;
//    GeneralButton prePage;
    ImageView battleBackground1 = new ImageView();
    ImageView settlementInterface1 = new ImageView();
    Pane settlementInterface2 = new Pane();
    ImageView battledRance2 = new ImageView();
    ImageView tentPicture3 = new ImageView();
    ImageView thief = new ImageView();
    ImageView defense = new ImageView();
    ImageView HPBackground4 = new ImageView();
    ImageView HPCurrent5 = new ImageView();
    double hpCurrentWidth;
    Label hp = new Label("160");
    Label currentHp = new Label("125");
    public Label monsterDamage;
    public Label personDamage;
    Pane concludeEvent;

    Label exp = new Label("10");
    Label current_exp = new Label("94");
    Label gold = new Label("9");
    Label current_gold = new Label("177");

    private static BattlePane battlePane;

    static {
        try {
            battlePane = new BattlePane();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private BattlePane() throws FileNotFoundException {
        //冷却图标
        Image wait = new Image(new FileInputStream(".\\images\\wait.png"));
        //总结页面
        Image settlementInterface = new Image(new FileInputStream(".\\images\\settlementInterface.png"));
        //无法存放道具
        Image canNotUsePicture = new Image(new FileInputStream(".\\images\\CanNotUse.png"));
        //战斗伤害
        Image damage = new Image(new FileInputStream(".\\images\\damage.png"));
        //战斗过程页面

        Person p = Person.getInstance();
        Image battleBackground = new Image(new FileInputStream(".\\images\\battleBackground.png"));
        Image battledRance = new Image(new FileInputStream(".\\images\\ranceinbattle.png"));
        Image tentPicture = new Image(new FileInputStream(".\\images\\tent2.png"));
        Image thief1 = new Image(new FileInputStream(".\\images\\thief1.png"));
        Image defenseD = new Image(new FileInputStream(".\\images\\defenseD.png"));
        Image HPBackground = new Image(new FileInputStream(".\\images\\HPBackground.png"));
        Image HPCurrent = new Image(new FileInputStream(".\\images\\HPCurrent.png"));


        settlementInterface1.setImage(settlementInterface);
        settlementInterface1.setFitHeight(settlementInterface.getHeight());
        settlementInterface1.setFitWidth(settlementInterface.getWidth());
        int settlementInterfaceLeft = 80;
        int settlementInterfaceTop = -340;
        settlementInterface1.setX(settlementInterfaceLeft);
        settlementInterface1.setY(settlementInterfaceTop);

        concludeEvent = new Pane();
        concludeEvent.setPrefHeight(808);
        concludeEvent.setPrefWidth(1040);
        concludeEvent.setVisible(false);
        concludeEvent.setOnMouseReleased(e->{
            System.out.println("conclude Pane");
            this.setVisible(false);
            MazePane.getInstance().setVisible(true);
            MazePane.getInstance().initHealthForMaze();
            MainFramePane.getInstance().initHealthForMain();
        });

        exp.setLayoutX(540);
        exp.setLayoutY(313);
        exp.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  45));

        current_exp.setLayoutX(540);
        current_exp.setLayoutY(375);
        current_exp.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  45));

        gold.setLayoutX(860);
        gold.setLayoutY(313);
        gold.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  45));

        current_gold.setLayoutX(804);
        current_gold.setLayoutY(375);
        current_gold.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  45));

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
//        thief.setFitHeight(thief1.getHeight());
        int thiefLeft = 600;
        int thiefTop = 80;
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
        System.out.println();
        hpCurrentWidth = HPCurrent.getWidth();

        hp.setLayoutX(50);
        hp.setLayoutY(280);
        hp.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  35));

        currentHp.setLayoutX(50);
        currentHp.setLayoutY(240);
        currentHp.setFont(Font.font("Timer New Roman", FontWeight.BOLD,  35));
        setCurrentHp(Integer.parseInt(currentHp.getText()));

        monsterDamage = new Label();
        monsterDamage.setVisible(false);
        monsterDamage.setLayoutX(215);
        monsterDamage.setLayoutY(360);
        monsterDamage.setFont(new Font(45));

        personDamage = new Label();
        personDamage.setVisible(false);
        personDamage.setLayoutX(720);
        personDamage.setLayoutY(160);
        personDamage.setFont(new Font(45));
        personDamage.setTextFill(Color.AZURE);


        this.getChildren().add(battleBackground1);
        this.getChildren().add(battledRance2);
        this.getChildren().add(tentPicture3);
        this.getChildren().add(thief);
        this.getChildren().add(defense);
        this.getChildren().add(HPBackground4);
        this.getChildren().add(HPCurrent5);

        this.getChildren().add(hp);
        this.getChildren().add(currentHp);
        this.getChildren().add(monsterDamage);
        this.getChildren().add(personDamage);
        settlementInterface2.getChildren().add(settlementInterface1);
        settlementInterface2.getChildren().add(exp);
        settlementInterface2.getChildren().add(current_exp);
        settlementInterface2.getChildren().add(gold);
        settlementInterface2.getChildren().add(current_gold);
        this.getChildren().add(settlementInterface2);

        settlementInterface2.setVisible(false);



        itemListPane = new ItemListPane();
        this.getChildren().add(itemListPane);
        refreshAll();


        //jpy
        //这个closetentbutton改掉，这战斗页面哪来的closetent？
        RunAwayButton runAwayButton = new RunAwayButton("   逃往城下町","200",10,720);
        this.getChildren().add(runAwayButton);

        StartBattleButton startBattleButton = new StartBattleButton("    战斗开始！","200",350,520);
        this.getChildren().add(startBattleButton);

        SelectAllButton selectAllButton = new SelectAllButton("     全选择","200",570,520);
        this.getChildren().add(selectAllButton);

        CancelAllButton cancelAllButton = new CancelAllButton("   全选择解除","200",800,520);
        this.getChildren().add(cancelAllButton);
        this.getChildren().add(concludeEvent);






//        nextPage = new GeneralButton("".\\images\\nextItemPage_hover.png","".\\images\\nextItemPage_preparing.png","".\\images\\nextItemPage_pressable.png","".\\images\\nextItemPage_pressed.png");
//        nextPage.setOnMouseReleased(e->{
//            if (getItemPage() != 2){
//                setItemPage(getItemPage()+1);
//            }
//        });
//        getChildren().add(nextPage);
//        nextPage.setLayoutX(843);
//        nextPage.setLayoutY(578);
//
//        prePage = new GeneralButton("".\\images\\preItemPage_hover.png","".\\images\\preItemPage_preparing.png","".\\images\\preItemPage_pressable.png","".\\images\\preItemPage_pressed.png");
//        prePage.setOnMouseReleased(e->{
//            if (getItemPage() != 0){
//                setItemPage(getItemPage()-1);
//            }
//        });
//        getChildren().add(prePage);
//        prePage.setLayoutX(131);
//        prePage.setLayoutY(578);
//
//        for (int i = 0; i < itemList.length; i++) {
//            itemList[i] = new ItemPane(i);
//            getChildren().add(itemList[i]);
//        }
//        refreshAll();
//        changeToItemPage(0);
    }

    public static BattlePane getInstance(){
        return battlePane;
    }

//    public ItemPane[] getItemList() {
//        return itemList;
//    }
//
//    public void refreshItems(){
//        Person person = Person.getInstance();
//        for (int i = 0; i < person.getItemList().size(); i++) {
//            itemList[i].refresh(person.getItemList().get(i));
//        }
//    }
//
//    //page start from 0
//    public void changeToItemPage(int page){
//        for (ItemPane item :
//                itemList) {
//            item.setVisible(false);
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

    public void setCurrentHp(int hp){
        currentHp.setText(String.valueOf(hp));
        double x = (double)hp / (double)Integer.parseInt(this.hp.getText());
        System.out.println(hpCurrentWidth);
        HPCurrent5.setFitWidth(hpCurrentWidth * x);
    }

    public void setMaxHp(int maxHp){
        hp.setText(String.valueOf(maxHp));
    }


    public void refreshAll(){
        Person person = Person.getInstance();
        itemListPane.refreshItems();
        setMaxHp(person.getMaxHealth());
        int hp = person.getHealth();
        setCurrentHp(hp);
    }

    public void concludBattle(){
        Person person = Person.getInstance();
        Battle battle = Battle.getInstance();
        exp.setText(String.valueOf(person.getExp()));
        current_exp.setText(String.valueOf(battle.getMonster().getExp()));
        gold.setText(String.valueOf(person.getMoney()));
        current_gold.setText(String.valueOf(battle.getMonster().getMoney()));
        settlementInterface2.setVisible(true);
        concludeEvent.setVisible(true);
    }

    public void startBattle(Monster monster){
        Person.getInstance().getSelectItems().clear();
        settlementInterface2.setVisible(false);
        monsterDamage.setVisible(false);
        personDamage.setVisible(false);
        concludeEvent.setVisible(false);
        try {
            thief.setImage(new Image(new FileInputStream(monster.getUrl())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Battle.getInstance().setMonster(monster);
        refreshAll();
    }

    public ItemListPane getItemListPane() {
        return itemListPane;
    }
}