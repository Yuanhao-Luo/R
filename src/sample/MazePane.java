package sample;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sample.MazePart.*;
import sample.buttons.OpenTentButton;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
//new commit 在mainframe里面新增一个背包数组，背包数组里面本来是装满了空item的
public class MazePane extends Pane {
    //tem
    boolean OpenTentAvailable = true;
    int HPTotal = 120;
    int HPCurrent = 8;

    LogicalMazeOuterCityStore logicalMazeOuterCityStore = LogicalMazeOuterCityStore.getInstance();
    LogicalMazeCaveFloor1Store logicalMazeCaveFloor1Store = LogicalMazeCaveFloor1Store.getInstance();
    LogicalMazeCaveUndergroundStore logicalMazeCaveUndergroundStore = LogicalMazeCaveUndergroundStore.getInstance();

    Card[][] logicalMaze;
    Card [][] MazeCanBeSeen;

    CardPane [][] currentMaze = new CardPane[3][5];//这就是当前显示的部分
    int currentRow = 10;//现在应该在迷宫的第几行 0~15
    int currentCard = 3;//现在是第几列，也就是第几张牌 0~4


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



        //这主要是选定好一个迷宫，因为传送走之后会换迷宫的,换迷宫直接换这两个就好了
        logicalMaze = logicalMazeOuterCityStore.logicalMaze;
        MazeCanBeSeen = logicalMazeOuterCityStore.MazeCanBeSeen;
        initTheMaze();
        initStep();
    }

    public void initTheMaze(){
        for(int j = 0; j < 5; j++) {
            currentMaze[0][j] = new CardPane(logicalMaze[(currentRow+ 2)%logicalMaze.length][j]);
            this.getChildren().add(currentMaze[0][j]);
            setXY(currentMaze[0][j],160*j + 100, 100);
            currentMaze[1][j] = new CardPane(logicalMaze[(currentRow + 1)%logicalMaze.length][j]);
            this.getChildren().add(currentMaze[1][j]);
            setXY(currentMaze[1][j],160*j + 100, 200);
            currentMaze[2][j] = new CardPane(logicalMaze[(currentRow)%logicalMaze.length][j]);
            this.getChildren().add(currentMaze[2][j]);
            setXY(currentMaze[2][j],160*j + 100, 300);
        }
    }

    public void initStep(){
        currentMaze[2][currentCard].setOnMouseClicked(e ->{

            //修改下一步的位置，包括行列
            currentRow = (currentRow+1)%logicalMaze.length;
            System.out.println(currentCard);
        } );

        if (currentCard>0) {//把上一个Pane传进来
            currentMaze[2][currentCard-1].setOnMouseClicked(e->{

                //修改下一步的位置，包括行列
                currentCard-=1;
                currentRow = (currentRow+1)%logicalMaze.length;
                System.out.println(currentCard);
            });
        }

        if (currentCard<4){//把下一个Pane传进来
            currentMaze[2][currentCard+1].setOnMouseClicked(e->{

                //修改下一步的位置，包括行列
                currentCard+=1;//
                currentRow = (currentRow+1)%logicalMaze.length;
                System.out.println(currentCard);
            });
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





