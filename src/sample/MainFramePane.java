package sample;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainFramePane extends Pane {
    boolean[] bistroAvailable = {false,false,false,true,true,true,true,true,false};
    boolean[] seaAvailable = {true,true,true,true,true,true,false,false,false};
    boolean[] hotelAvailable = {false,true,true,true,true,true,true,true,true};
    boolean[] levelAvailable = {true,true,true,true,true,true,false,false,false};
    boolean[] mazeAvailable = {true,true,true,true,true,true,true,true,false};
    boolean[] WSAvailable = {false,false,false,true,true,true,true,true,false};
    boolean[] killTimeAvailable = {true,true,true,true,true,true,true,true,false};
    //tem
    boolean[] OpenTentAvailable = {true,true,true,true,true,true,true,true,true};
    int HPTotal = 120;
    int HPCurrent = 8;

    MapButton bBistro = new MapButton(".\\images\\bistroButton_hover.png",".\\images\\bistroButton_preparing.png",".\\images\\bistroButton_pressable.png",".\\images\\bistroButton_pressed.png",bistroAvailable);
    MapButton bSea = new MapButton(".\\images\\homeofseaButton_hover.png",".\\images\\homeofseaButton_preparing.png",".\\images\\homeofseaButton_pressable.png",".\\images\\homeofseaButton_pressed.png",seaAvailable);
    MapButton bHotel = new MapButton(".\\images\\hotelButton_hover.png",".\\images\\hotelButton_preparing.png",".\\images\\hotelButton_pressable.png",".\\images\\hotelButton_pressed.png",hotelAvailable);
    MapButton bLevel = new MapButton(".\\images\\levelhouseButton_hover.png",".\\images\\levelhouseButton_preparing.png",".\\images\\levelhouseButton_pressable.png",".\\images\\levelhouseButton_pressed.png",levelAvailable);
    MapButton bMaze = new MapButton(".\\images\\walkthemazeButton_hover.png",".\\images\\walkthemazeButton_preparing.png",".\\images\\walkthemazeButton_pressable.png",".\\images\\walkthemazeButton_pressed.png",mazeAvailable);
    MapButton bWS = new MapButton(".\\images\\weaponstoreButton_hover.png",".\\images\\weaponstoreButton_preparing.png",".\\images\\weaponstoreButton_pressable.png",".\\images\\weaponstoreButton_pressed.png",WSAvailable);
    MapButton bKillTime = new MapButton(".\\images\\killtimeButton_hover.png",".\\images\\killtimeButton_preparing.png",".\\images\\killtimeButton_pressable.png",".\\images\\killtimeButton_pressed.png",killTimeAvailable);

    MapButton bOpenTent = new MapButton("C:\\Users\\a\\Desktop\\大三上\\rance\\button.png","C:\\Users\\a\\Desktop\\大三上\\rance\\button.png","C:\\Users\\a\\Desktop\\大三上\\rance\\button.png","C:\\Users\\a\\Desktop\\大三上\\rance\\button.png",OpenTentAvailable);

    Pane clockPane = new Pane();
    Pane HPBackgroundPane = new Pane();
    Pane HPCurrentImg = new Pane();
    Pane dot = new Pane();
    Pane CI = new Pane();
    Pane HPBlackImg = new Pane();
    Label HPCurrentLabel = new Label("" + HPCurrent);

    Label HPTotalLabel = new Label("" + HPTotal);
    ClockStatus[] ClS = new ClockStatus[9];

    private static MainFramePane m = new MainFramePane();
    TimeSingleton t = TimeSingleton.getInstance();
    public static MainFramePane getInstance(){
        return m;
    }

    private MainFramePane(){
        dealImage(this,".\\images\\backgroundMain.png");

        this.getChildren().add(bBistro);
        initPane(bBistro,447,645,bBistro.whichUrl(t.getTime()));
        buttonAction(bBistro);

        this.getChildren().add(bSea);
        initPane(bSea,780,643,bSea.whichUrl(t.getTime()));
        buttonAction(bSea);

        this.getChildren().add(bHotel);
        initPane(bHotel,262,560,bHotel.whichUrl(t.getTime()));
        buttonAction(bHotel);

        this.getChildren().add(bLevel);
        initPane(bLevel,607,674,bLevel.whichUrl(t.getTime()));
        buttonAction(bLevel);

        this.getChildren().add(bMaze);
        initPane(bMaze,498,771,bMaze.whichUrl(t.getTime()));
        buttonAction(bMaze);

        this.getChildren().add(bWS);
        initPane(bWS,660,546,bWS.whichUrl(t.getTime()));
        buttonAction(bWS);

        this.getChildren().add(bKillTime);
        initPane(bKillTime,649,115,bKillTime.whichUrl(t.getTime()));
        killTimebuttonAction(bKillTime);

//
        this.getChildren().add(bOpenTent);
        initPane(bOpenTent,900,700,bOpenTent.whichUrl(t.getTime()));
        openTentbuttonAction(bOpenTent);

        this.getChildren().add(clockPane);
        initPane(clockPane,930,-100,".\\images\\clock.png");

        this.getChildren().add(dot);
        initPane(dot,100,100,".\\images\\dot.png");
        initDot(dot);

        this.getChildren().add(CI);
        initPane(CI,980,-70,selectClockIndicator());

        this.getChildren().add(HPBackgroundPane);
        initPane(HPBackgroundPane,30,30,".\\images\\HPBackground.png");

        int HPCurrentImgLeft = 107;
        int HPCurrentImgRight = 233;
        this.getChildren().add(HPCurrentImg);
        initPane(HPCurrentImg,HPCurrentImgLeft,101,".\\images\\HPCurrent.png");
        //记录一下血条和血条背景还有几个数字的相对位置差值，方便以后调整

        double ratioOfHP = (double) (HPTotal - HPCurrent) / (double)HPTotal;
        int HPBlackImgLeft = (int) (HPCurrentImgLeft + (HPCurrentImgRight - HPCurrentImgLeft) * (1 - ratioOfHP));//这个left是左边的意思不是剩余的意思
        int HPBlackImgWidth = (int)((HPCurrentImgRight - HPCurrentImgLeft) * ratioOfHP) + 1;
        this.getChildren().add(HPBlackImg);
        initPaneWidthHeight(HPBlackImg,HPBlackImgLeft,101,".\\images\\black.png",HPBlackImgWidth,2);
        //调整位置的时候要特别注意上面的几个值

        this.getChildren().add(HPCurrentLabel);
        HPCurrentLabel.setFont(Font.font("Arial",40));
        if(HPCurrent >= 100){
            initLabel(HPCurrentLabel,133,55);
        }
        else if(HPCurrent <= 9){
            initLabel(HPCurrentLabel,155,55);
        }
        else{
            initLabel(HPCurrentLabel,144,55);
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
        initLabel(HPTotalLabel,142,108);
        HPTotalLabel.setFont(Font.font("Arial",28));
        HPTotalLabel.setTextFill(Color.web("#000000"));
    }

    private void dealImage(Pane p, String url) {
        Image imageBack = null;
        try {
            imageBack = new Image(new FileInputStream(url));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView imageView = new ImageView();
        imageView.setImage(imageBack);
        p.getChildren().add(imageView);
    }

    private void dealImage(Pane p, String url, int width, int height) {
        Image imageBack = null;
        try {
            imageBack = new Image(new FileInputStream(url));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView imageView = new ImageView();
        imageView.setImage(imageBack);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        p.getChildren().add(imageView);
    }

    public void initPane(Pane p,int x, int y,String url){
        dealImage(p, url);
        p.setLayoutX(x);
        p.setLayoutY(y);
    }

    public void initPaneWidthHeight(Pane p,int x, int y, String url, int width, int height){
        dealImage(p, url, width, height);
        p.setLayoutX(x);
        p.setLayoutY(y);
    }

    public void initLabel(Label l,int x, int y){
        l.setLayoutX(x);
        l.setLayoutY(y);
    }

    public void changeButtonStatues(Pane p,String url){
        dealImage(p, url);
    }


    public void changeAllButtonStatues(){
        changeButtonStatues(bBistro,bBistro.whichUrl(t.getTime()));
        buttonAction(bBistro);
        changeButtonStatues(bSea,bSea.whichUrl(t.getTime()));
        buttonAction(bSea);
        changeButtonStatues(bHotel,bHotel.whichUrl(t.getTime()));
        buttonAction(bHotel);
        changeButtonStatues(bLevel,bLevel.whichUrl(t.getTime()));
        buttonAction(bLevel);
        changeButtonStatues(bMaze,bMaze.whichUrl(t.getTime()));
        buttonAction(bMaze);
        changeButtonStatues(bWS,bWS.whichUrl(t.getTime()));
        buttonAction(bWS);
        changeButtonStatues(bKillTime,bKillTime.whichUrl(t.getTime()));
        killTimebuttonAction(bKillTime);
    }

    public void changeClockStatues(Pane dot,Pane clockPane){
        initDot(dot);
        initPane(clockPane,980,-70,selectClockIndicator());
    }

    public void buttonAction(MapButton b){
        int time = t.getTime();
        b.setOnMouseEntered(e->{
            if(b.ifVisiable(time))
                changeButtonStatues(b,b.getUrl_hover());
        });

        b.setOnMouseExited(e->{
            if(b.ifVisiable(time))
                changeButtonStatues(b, b.getUrl_pressable());
        });

        b.setOnMouseClicked(e->{
            if(b.ifVisiable(time)){
                changeButtonStatues(b, b.getUrl_pressed());
            }
        });
    }

    public void openTentbuttonAction(MapButton b){
        b.setOnMouseClicked(e->{
            tentPane tentPane = new tentPane();
            m.getChildren().add(tentPane);
        });
    }

    public void closeTentbuttonAction(MapButton b){
        b.setOnMouseClicked(e->{
            tentPane tentPane = new tentPane();
            m.getChildren().remove(tentPane);
        });
    }

    //按钮功能的具体实现类似本图
    public void killTimebuttonAction(MapButton b){
        int time = t.getTime();
        buttonAction(b);
        b.setOnMouseClicked(e->{
            if(b.ifVisiable(time)){
                if(time>=6){
                    t.setTime(8);
                }else if(time%3 == 0){
                    t.modifyTime(3);
                }else if (time%3 == 1){
                    t.modifyTime(2);
                }else
                    t.modifyTime(1);
                changeAllButtonStatues();
                changeClockStatues(dot,CI);
            }
        });
    }


    public String selectClockIndicator(){
        int time = t.getTime();
        if(time > 5){
            return ".\\images\\night.png";
        }else if (time <3){
            return ".\\images\\morning.png";
        }else
            return ".\\images\\afternoon.png";
    }


    public void initDot(Pane d){
        int time = t.getTime();
        double[] dx = {1109, 1080, 1054, 1029, 1004, 985, 972, 964, 964};
        double[] dy = {128, 139, 139, 137, 117, 98, 77, 50, 23};
        for (int i = 0; i < ClS.length; i++) {
            ClS[i] = new ClockStatus(dx[i], dy[i], i);
        }
        ClS[time].setLocation(d);
    }

}





