package sample;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sample.Event.KillTime;
import sample.Event.PassOneTime;
import sample.buttons.MapButton;
import sample.buttons.OpenTentButton;

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

    MapButton bBistro = new MapButton(".\\images\\bistroButton_hover.png",".\\images\\bistroButton_preparing.png",".\\images\\bistroButton_pressable.png",".\\images\\bistroButton_pressed.png",bistroAvailable);
    MapButton bSea = new MapButton(".\\images\\homeofseaButton_hover.png",".\\images\\homeofseaButton_preparing.png",".\\images\\homeofseaButton_pressable.png",".\\images\\homeofseaButton_pressed.png",seaAvailable);
    MapButton bHotel = new MapButton(".\\images\\hotelButton_hover.png",".\\images\\hotelButton_preparing.png",".\\images\\hotelButton_pressable.png",".\\images\\hotelButton_pressed.png",hotelAvailable);
    MapButton bLevel = new MapButton(".\\images\\levelhouseButton_hover.png",".\\images\\levelhouseButton_preparing.png",".\\images\\levelhouseButton_pressable.png",".\\images\\levelhouseButton_pressed.png",levelAvailable);
    MapButton bMaze = new MapButton(".\\images\\walkthemazeButton_hover.png",".\\images\\walkthemazeButton_preparing.png",".\\images\\walkthemazeButton_pressable.png",".\\images\\walkthemazeButton_pressed.png",mazeAvailable);
    MapButton bWS = new MapButton(".\\images\\weaponstoreButton_hover.png",".\\images\\weaponstoreButton_preparing.png",".\\images\\weaponstoreButton_pressable.png",".\\images\\weaponstoreButton_pressed.png",WSAvailable);
    MapButton bKillTime = new MapButton(".\\images\\killtimeButton_hover.png",".\\images\\killtimeButton_preparing.png",".\\images\\killtimeButton_pressable.png",".\\images\\killtimeButton_pressed.png",killTimeAvailable);
    OpenTentButton bOpenTent = new OpenTentButton(".\\images\\normalButton200_hover.png",".\\images\\normalButton200_unpressable.png",".\\images\\normalButton200_pressable.png",".\\images\\normalButton200_pressed.png");

    Pane clockPane = new Pane();
    Pane HPBackgroundPane = new Pane();
    Pane HPCurrentImg = new Pane();
    Pane dot = new Pane();
    Pane CI = new Pane();
    Pane HPBlackImg = new Pane();
    Label HPCurrentLabel = new Label("" + HPCurrent);
    Label openTentLabel = new Label("张开帐篷");

    TentPane tentPane = new TentPane();

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
        setPaneXY(bBistro, 360,560);
        bBistro.setOnMouseClicked(new PassOneTime());

        this.getChildren().add(bSea);
        setPaneXY(bSea, 730, 589);
//        initPane(bSea,730,589,bSea.whichUrl(t.getCurrentTime()));
        bSea.setOnMouseClicked(new PassOneTime());

        this.getChildren().add(bHotel);
        setPaneXY(bHotel, 217, 505);
//        initPane(bHotel,217,505,bHotel.whichUrl(t.getCurrentTime()));
        bHotel.setOnMouseClicked(new PassOneTime());

        this.getChildren().add(bLevel);
        setPaneXY(bLevel, 550, 620);
//        initPane(bLevel,550,620,bLevel.whichUrl(t.getCurrentTime()));
        bLevel.setOnMouseClicked(new PassOneTime());

        this.getChildren().add(bMaze);
        setPaneXY(bMaze, 460, 705);
//        initPane(bMaze,460,705,bMaze.whichUrl(t.getCurrentTime()));
        bMaze.setOnMouseClicked(new PassOneTime());

        this.getChildren().add(bWS);
        setPaneXY(bWS, 660, 494);
//        initPane(bWS,600,494,bWS.whichUrl(t.getCurrentTime()));
        bWS.setOnMouseClicked(new PassOneTime());

        this.getChildren().add(bKillTime);
        setPaneXY(bKillTime, 580, 60);
//        initPane(bKillTime,580,60,bKillTime.whichUrl(t.getCurrentTime()));
        bKillTime.setOnMouseClicked(new KillTime());
//
        this.getChildren().add(bOpenTent);
        initPane(bOpenTent,900,700,bOpenTent.whichUrl());
        bOpenTent.getChildren().add(openTentLabel);
        openTentLabel.setFont(Font.font("Kaiti",25));
        initLabel(openTentLabel,0,0);


        this.getChildren().add(clockPane);
        initPane(clockPane,840,-100,".\\images\\clock.png");

        this.getChildren().add(dot);
        initPane(dot,100,100,".\\images\\dot.png");
        initDot(dot);

        this.getChildren().add(CI);
        initPane(CI,890,-65,selectClockIndicator());

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
    }

    public void initPane(Pane p,int x, int y,String url){
        ImageProcess.addImage(p, url);
        setPaneXY(p, x, y);
    }

    public void initPaneWidthHeight(Pane p,int x, int y, String url, int width, int height){
        ImageProcess.dealImage(p, url, width, height);
        setPaneXY(p, x, y);
    }

    public void setPaneXY(Pane p, int x, int y){
        p.setLayoutX(x);
        p.setLayoutY(y);
    }

    public void initLabel(Label l,int x, int y){
        l.setLayoutX(x);
        l.setLayoutY(y);
    }

//    public void changeButtonStatues(Pane p,String url){
//        GeneralButton generalButton = new GeneralButton();
//        generalButton.dealImage(p, url);
//    }


    public void changeAllButtonStatues(){
        bBistro.changeImage(bBistro.whichUrl(t.getCurrentTime()));
//        bBistro.addButtonEvent(bBistro,1);
        bSea.changeImage(bSea.whichUrl(t.getCurrentTime()));
//        bSea.addButtonEvent(bSea,1);
        bHotel.changeImage(bHotel.whichUrl(t.getCurrentTime()));
//        bHotel.addButtonEvent(bHotel,1);
        bLevel.changeImage(bLevel.whichUrl(t.getCurrentTime()));
//        bLevel.addButtonEvent(bLevel,1);
        bMaze.changeImage(bMaze.whichUrl(t.getCurrentTime()));
//        bMaze.addButtonEvent(bMaze,1);
        bWS.changeImage(bWS.whichUrl(t.getCurrentTime()));
//        bWS.addButtonEvent(bWS,1);
        bKillTime.changeImage(bKillTime.whichUrl(t.getCurrentTime()));
    }

    public void changeClockStatues(Pane dot,Pane clockPane){
        initDot(dot);
        initPane(clockPane,980,-70,selectClockIndicator());
    }

//    public void openTentbuttonAction(OpenTentButton b){
//        b.buttonAction(b);
//        b.setOnMouseClicked(e->{
//            tentPane.setVisible(true);
//        });
//    }

    public void bKillTimeChangeTime(MapButton b){
        int time = t.getCurrentTime();
        if (b.ifVisiable(time)){
            if(time>=6){
                t.setCurrentTime(8);
            }else if(time%3 == 0){
                t.addXTime(3);
            }else if (time%3 == 1){
                t.addXTime(2);
            }else
                t.addXTime(1);
            changeAllButtonStatues();
            changeClockStatues(dot,clockPane);
        }

    }

    public void timeChange(MapButton b){
        int time = t.getCurrentTime();
        if (b.ifVisiable(time)){
            t.addOne();
            changeAllButtonStatues();
            changeClockStatues(dot,clockPane);
        }

    }


    //give it up
//    public void killTimebuttonAction(MapButton b){
//        int time = t.getTime();
//        b.buttonAction(b);
//        b.setOnMouseClicked(e->{
//            if(b.ifVisiable(time)){
//                if(time>=6){
//                    t.setTime(8);
//                }else if(time%3 == 0){
//                    t.modifyTime(3);
//                }else if (time%3 == 1){
//                    t.modifyTime(2);
//                }else
//                    t.modifyTime(1);
//                changeAllButtonStatues();
//                changeClockStatues(dot,CI);
//            }
//        });
//    }


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
        double[] dx = {1109, 1080, 1054, 1029, 1004, 985, 972, 964, 964};
        double[] dy = {128, 139, 139, 137, 117, 98, 77, 50, 23};
        for (int i = 0; i < ClS.length; i++) {
            ClS[i] = new ClockStatus(dx[i], dy[i], i);
        }
        ClS[time].setLocation(d);
    }

}





