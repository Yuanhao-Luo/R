package sample;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sample.MazePart.CardPane;
import sample.MazePart.GUIMazeStore;
import sample.MazePart.LogicalMazeStore;
import sample.buttons.OpenTentButton;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
//new commit 在mainframe里面新增一个背包数组，背包数组里面本来是装满了空item的
public class MazePane extends Pane {
    //tem
    boolean OpenTentAvailable = true;
    int HPTotal = 120;
    int HPCurrent = 8;
    CardPane [][] currentMaze = new CardPane[3][5];//这就是当前显示的部分
    int currentCard = 1;
    GUIMazeStore guiMazeStore = GUIMazeStore.getInstance();
    OpenTentButton bOpenTent = new OpenTentButton("    打开帐篷","200",820,720);

    //这个地方需要的是另一个帐篷，就是下面的桌面部分，点了打开帐篷会再打开一个新的tentPane


    //改
    ImageView clockImv = new ImageView();
    Pane HPBackgroundPane = new Pane();
    Pane HPCurrentImg = new Pane();
    Pane dot = new Pane();
    ImageView CI = new ImageView();
    Pane HPBlackImg = new Pane();
    Label HPCurrentLabel = new Label("" + HPCurrent);

    Label HPTotalLabel = new Label("" + HPTotal);
    ClockStatus[] ClS = new ClockStatus[9];

    private static MazePane m = new MazePane();
    TimeSingleton t = TimeSingleton.getInstance();
    public static MazePane getInstance(){
        return m;
    }

    private MazePane(){
        ImageProcess.addImage(this,".\\images\\MazeBackground1.png");

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


        initTheMaze();
        walkTheMaze();
    }

    public void initTheMaze(){
        //只管初始化空牌，内容下面加
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 5; j++){
                currentMaze[i][j] = new CardPane();
                currentMaze[i][j].setLayoutY(100*i + 100);
                currentMaze[i][j].setLayoutX(160*j + 100);
            }
        }
    }

    public void walkTheMaze(){
        //记得在这之前把currentCard+1
        for (int i = currentCard; i < currentCard+3; i++){
            for(int j = 0; j < 5; j++){
                //这个地方的3会被二维数组的上下长度代替
                currentMaze[i%3][j] = guiMazeStore.GuiMaze[i%3][j];//相当于把牌换了
                this.getChildren().add(currentMaze[i%3][j]);
                currentMaze[i%3][j].setLayoutY(100*(i-currentCard) + 100);
                currentMaze[i%3][j].setLayoutX(160*j + 100);
            }
        }
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


    public void changeClockStatues(){
        initDot(dot);
        setXY(CI, 890, -65);
        ImageProcess.changeImage(CI, selectClockIndicator());
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





