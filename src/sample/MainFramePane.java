package sample;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sample.Event.EnterPlace;
import sample.Event.KillTime;
import sample.Event.PassOneTime;
import sample.buttons.MapButton;
import sample.buttons.OpenTentButton;
import sample.specificPlace.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
//new commit 在mainframe里面新增一个背包数组，背包数组里面本来是装满了空item的
public class MainFramePane extends Pane {
    boolean[] bistroAvailable = {false,false,false,true,true,true,true,true,false};
    boolean[] seaAvailable = {true,true,true,true,true,true,false,false,false};
    boolean[] hotelAvailable = {false,true,true,true,true,true,true,true,true};
    boolean[] levelAvailable = {true,true,true,true,true,true,false,false,false};
    boolean[] mazeAvailable = {true,true,true,true,true,true,true,true,false};
    boolean[] WSAvailable = {false,false,false,true,true,true,true,true,false};
    boolean[] killTimeAvailable = {true,true,true,true,true,true,true,true,false};
    //tem
    boolean OpenTentAvailable = true;
    int HPTotal = 120;
    int HPCurrent = 8;

    MapButton bBistro = new MapButton(".\\images\\bistroButton_hover.png",".\\images\\bistroButton_preparing.png",".\\images\\bistroButton_pressable.png",".\\images\\bistroButton_pressed.png",bistroAvailable,"bistro");
    MapButton bSea = new MapButton(".\\images\\homeofseaButton_hover.png",".\\images\\homeofseaButton_preparing.png",".\\images\\homeofseaButton_pressable.png",".\\images\\homeofseaButton_pressed.png",seaAvailable,"homeofsea");
    MapButton bHotel = new MapButton(".\\images\\hotelButton_hover.png",".\\images\\hotelButton_preparing.png",".\\images\\hotelButton_pressable.png",".\\images\\hotelButton_pressed.png",hotelAvailable,"hotel");
    MapButton bLevel = new MapButton(".\\images\\levelhouseButton_hover.png",".\\images\\levelhouseButton_preparing.png",".\\images\\levelhouseButton_pressable.png",".\\images\\levelhouseButton_pressed.png",levelAvailable,"level");
    MapButton bMaze = new MapButton(".\\images\\walkthemazeButton_hover.png",".\\images\\walkthemazeButton_preparing.png",".\\images\\walkthemazeButton_pressable.png",".\\images\\walkthemazeButton_pressed.png",mazeAvailable,"maze");
    MapButton bWS = new MapButton(".\\images\\weaponstoreButton_hover.png",".\\images\\weaponstoreButton_preparing.png",".\\images\\weaponstoreButton_pressable.png",".\\images\\weaponstoreButton_pressed.png",WSAvailable,"weapons");
    MapButton bKillTime = new MapButton(".\\images\\killtimeButton_hover.png",".\\images\\killtimeButton_preparing.png",".\\images\\killtimeButton_pressable.png",".\\images\\killtimeButton_pressed.png",killTimeAvailable,"killtime");
    OpenTentButton bOpenTent = new OpenTentButton("    打开帐篷","200",820,720);

    ImageView clockImv = new ImageView();
    Pane HPBackgroundPane = new Pane();
    Pane HPCurrentImg = new Pane();
    Pane dot = new Pane();
    ImageView CI = new ImageView();
    Pane HPBlackImg = new Pane();
    Label HPCurrentLabel = new Label("" + HPCurrent);

    public TentPane tentPane = TentPane.getInstance();
    public HomeofseaPane homeofseaPane = new HomeofseaPane();
    public WeaponsPane weaponsPane = new WeaponsPane();
    public HotelPane hotelPane = new HotelPane();
    public LevelPane levelPane = new LevelPane();
    public BistroPane bistroPane = new BistroPane();
    public MazePane mazePane = MazePane.getInstance();

    Label HPTotalLabel = new Label("" + HPTotal);
    ClockStatus[] ClS = new ClockStatus[9];

    private static MainFramePane m = new MainFramePane();
    TimeSingleton t = TimeSingleton.getInstance();
    public static MainFramePane getInstance(){
        return m;
    }

    private MainFramePane(){
        ImageProcess.addImage(this,".\\images\\backgroundMain.png");

        this.getChildren().add(bBistro);
        setXY(bBistro, 360,560);
        bBistro.setOnMouseClicked(new EnterPlace());

        this.getChildren().add(bSea);
        setXY(bSea, 730, 589);
        bSea.setOnMouseClicked(new EnterPlace());

        this.getChildren().add(bHotel);
        setXY(bHotel, 217, 505);
        bHotel.setOnMouseClicked(new EnterPlace());

        this.getChildren().add(bLevel);
        setXY(bLevel, 550, 620);
        bLevel.setOnMouseClicked(new EnterPlace());

        this.getChildren().add(bMaze);
        setXY(bMaze, 460, 705);
        bMaze.setOnMouseClicked(new EnterPlace());

        this.getChildren().add(bWS);
        setXY(bWS, 660, 494);
        bWS.setOnMouseClicked(new EnterPlace());

        this.getChildren().add(bKillTime);
        setXY(bKillTime, 580, 60);
        bKillTime.setOnMouseClicked(new KillTime());
//
        this.getChildren().add(bOpenTent);

        this.getChildren().add(clockImv);
        setXY(clockImv, 840, -100);
        try {
            clockImv.setImage(new Image(new FileInputStream(".\\images\\clock.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.getChildren().add(dot);
        initPane(dot,100,100,".\\images\\dot.png");
        initDot(dot);

        this.getChildren().add(CI);
        setXY(CI, 890, -65);
        try {
            CI.setImage(new Image(new FileInputStream(selectClockIndicator())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.getChildren().add(HPBackgroundPane);
        initPane(HPBackgroundPane,-15,15,".\\images\\HPBackground.png");

        int HPCurrentImgLeft = 61;
        int HPCurrentImgRight = 190;
        this.getChildren().add(HPCurrentImg);
        initPane(HPCurrentImg,HPCurrentImgLeft,86,".\\images\\HPCurrent.png");
        //记录一下血条和血条背景还有几个数字的相对位置差值，方便以后调整

        double ratioOfHP = (double) (HPTotal - HPCurrent) / (double)HPTotal;
        int HPBlackImgLeft = (int) (HPCurrentImgLeft + (HPCurrentImgRight - HPCurrentImgLeft) * (1 - ratioOfHP));//这个left是左边的意思不是剩余的意思
        int HPBlackImgWidth = (int)((HPCurrentImgRight - HPCurrentImgLeft) * ratioOfHP) + 1;
        this.getChildren().add(HPBlackImg);
        initPaneWidthHeight(HPBlackImg,HPBlackImgLeft,86,".\\images\\black.png",HPBlackImgWidth,2);
        //调整位置的时候要特别注意上面的几个值

        this.getChildren().add(HPCurrentLabel);
        HPCurrentLabel.setFont(Font.font("Arial",40));
        if(HPCurrent >= 100){
            initLabel(HPCurrentLabel,90,40);
        }
        else if(HPCurrent <= 9){
            initLabel(HPCurrentLabel,110,40);
        }
        else{
            initLabel(HPCurrentLabel,100,40);
        }


        if (HPCurrent < HPTotal && HPCurrent > HPTotal * 0.3){
            HPCurrentLabel.setTextFill(Color.web("#FFFFFF"));
        }
        else if (HPCurrent < HPTotal * 0.3){
            HPCurrentLabel.setTextFill(Color.web("red"));
        }
        else{
            HPCurrentLabel.setTextFill(Color.web("yellow"));
        }

        this.getChildren().add(HPTotalLabel);
        initLabel(HPTotalLabel,95,93);
        HPTotalLabel.setFont(Font.font("Arial",28));
        HPTotalLabel.setTextFill(Color.web("#000000"));

        tentPane.setVisible(false);
        this.getChildren().add(tentPane);

        homeofseaPane.setVisible(false);
        this.getChildren().add(homeofseaPane);



        weaponsPane.setVisible(false);
        this.getChildren().add(weaponsPane);

        hotelPane.setVisible(false);
        this.getChildren().add(hotelPane);

        levelPane.setVisible(false);
        this.getChildren().add(levelPane);

        bistroPane.setVisible(false);
        this.getChildren().add(bistroPane);

        mazePane.setVisible(false);
        this.getChildren().add(mazePane);
    }

    public void initPane(Pane p,int x, int y,String url){
        ImageProcess.addImage(p, url);
        setXY(p, x, y);
    }

    public void initPaneWidthHeight(Pane p,int x, int y, String url, int width, int height){
        ImageProcess.dealImage(p, url, width, height);
        setXY(p, x, y);
    }

    public void setXY(Node p, int x, int y){
        p.setLayoutX(x);
        p.setLayoutY(y);
    }

    public void initLabel(Label l,int x, int y){
        l.setLayoutX(x);
        l.setLayoutY(y);
    }


    public void changeAllButtonStatues(){
        bBistro.changeImage(bBistro.whichUrl(t.getCurrentTime()));
        bSea.changeImage(bSea.whichUrl(t.getCurrentTime()));
        bHotel.changeImage(bHotel.whichUrl(t.getCurrentTime()));
        bLevel.changeImage(bLevel.whichUrl(t.getCurrentTime()));
        bMaze.changeImage(bMaze.whichUrl(t.getCurrentTime()));
        bWS.changeImage(bWS.whichUrl(t.getCurrentTime()));
        bKillTime.changeImage(bKillTime.whichUrl(t.getCurrentTime()));
    }

    public void changeClockStatues(){
        initDot(dot);
        setXY(CI, 890, -65);
        ImageProcess.changeImage(CI, selectClockIndicator());
    }


    public void bKillTimeChangeTime(MapButton b){
        int time = t.getCurrentTime();
        if (b.getVisiable(time)){
            if(time>=6){
                t.setCurrentTime(8);
            }else if(time%3 == 0){
                t.addXTime(3);
            }else if (time%3 == 1){
                t.addXTime(2);
            }else
                t.addXTime(1);
            changeAllButtonStatues();
            changeClockStatues();
        }
    }

    public void timeChange(MapButton b){
        int time = t.getCurrentTime();
        if (b.getVisiable(time)){
            t.addOne();
            changeAllButtonStatues();
            changeClockStatues();
        }
    }


    public String selectClockIndicator(){
        int time = t.getCurrentTime();
        if(time > 5){
            return ".\\images\\night.png";
        }else if (time <3){
            return ".\\images\\morning.png";
        }else
            return ".\\images\\afternoon.png";
    }


    public void initDot(Pane d){
        int time = t.getCurrentTime();
        double[] dx = {1011, 985, 958, 934, 908, 890, 877, 870, 869};
        double[] dy = {123, 129, 131, 125, 112, 90, 68, 43, 17};
        for (int i = 0; i < ClS.length; i++) {
            ClS[i] = new ClockStatus(dx[i], dy[i], i);
        }
        ClS[time].setLocation(d);
    }

}





