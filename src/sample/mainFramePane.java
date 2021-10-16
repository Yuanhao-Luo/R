package sample;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class mainFramePane extends Pane {
    boolean[] bistroAvailable = {false,false,false,true,true,true,true,true,false};
    boolean[] seaAvailable = {true,true,true,true,true,true,false,false,false};
    boolean[] hotelAvailable = {false,true,true,true,true,true,true,true,true};
    boolean[] levelAvailable = {true,true,true,true,true,true,false,false,false};
    boolean[] mazeAvailable = {true,true,true,true,true,true,true,true,false};
    boolean[] WSAvailable = {false,false,false,true,true,true,true,true,false};
    boolean[] killTimeAvailable = {true,true,true,true,true,true,true,true,false};

    bButton bBistro = new bButton(".\\images\\bistroButton_hover.png",".\\images\\bistroButton_preparing.png",".\\images\\bistroButton_pressable.png",".\\images\\bistroButton_pressed.png",bistroAvailable);
    bButton bSea = new bButton(".\\images\\homeofseaButton_hover.png",".\\images\\homeofseaButton_preparing.png",".\\images\\homeofseaButton_pressable.png",".\\images\\homeofseaButton_pressed.png",seaAvailable);
    bButton bHotel = new bButton(".\\images\\hotelButton_hover.png",".\\images\\hotelButton_preparing.png",".\\images\\hotelButton_pressable.png",".\\images\\hotelButton_pressed.png",hotelAvailable);
    bButton bLevel = new bButton(".\\images\\levelhouseButton_hover.png",".\\images\\levelhouseButton_preparing.png",".\\images\\levelhouseButton_pressable.png",".\\images\\levelhouseButton_pressed.png",levelAvailable);
    bButton bMaze = new bButton(".\\images\\walkthemazeButton_hover.png",".\\images\\walkthemazeButton_preparing.png",".\\images\\walkthemazeButton_pressable.png",".\\images\\walkthemazeButton_pressed.png",mazeAvailable);
    bButton bWS = new bButton(".\\images\\weaponstoreButton_hover.png",".\\images\\weaponstoreButton_preparing.png",".\\images\\weaponstoreButton_pressable.png",".\\images\\weaponstoreButton_pressed.png",WSAvailable);
    bButton bKillTime = new bButton(".\\images\\killtimeButton_hover.png",".\\images\\killtimeButton_preparing.png",".\\images\\killtimeButton_pressable.png",".\\images\\killtimeButton_pressed.png",killTimeAvailable);

    Pane clockPane = new Pane();
    Pane dot = new Pane();
    Pane CI = new Pane();
    cLockStatus[] ClS = new cLockStatus[9];

    private static mainFramePane m = new mainFramePane();
    timeSingleton t = timeSingleton.getInstance();
    public static mainFramePane getInstance(){
        return m;
    }

    private mainFramePane(){
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
        buttonAction(bKillTime);
        bKillTime.setOnMouseClicked(e->{
            if(bKillTime.ifVisiable(t.getTime())){
                t.addOne();
                changeButtonStatues(bLevel,bLevel.whichUrl(t.getTime()));
                changeClockStatues(dot,CI);
            }
        });


        this.getChildren().add(clockPane);
        initPane(clockPane,930,-100,".\\images\\clock.png");

        this.getChildren().add(dot);
        initPane(dot,100,100,".\\images\\dot.png");
        initDot(dot);

        this.getChildren().add(CI);
        initPane(CI,980,-70,selectClockIndicator());
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

    public void initPane(Pane p,int x, int y,String url){
        dealImage(p, url);
        p.setLayoutX(x);
        p.setLayoutY(y);
    }


    public void changeButtonStatues(Pane p,String url){
        dealImage(p, url);
    }

    public void changeClockStatues(Pane dot,Pane clockPane){
        initDot(dot);
        initPane(clockPane,980,-70,selectClockIndicator());
    }

    public void buttonAction(bButton b){
        int time = t.getTime();

        //！！！！似乎放在事件外面这一层if不起作用，不知道为什么，暂时只知道往里面放有用
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
                //空着转页面的内容
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
            ClS[i] = new cLockStatus(dx[i], dy[i], i);
        }
        ClS[time].setLocation(d);
    }
}





