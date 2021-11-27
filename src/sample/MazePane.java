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

public class MazePane extends Pane {
    //tem
    boolean OpenTentAvailable = true;
    int HPTotal = 120;
    int HPCurrent = 8;

    LogicalMazeOuterCityStore logicalMazeOuterCityStore = LogicalMazeOuterCityStore.getInstance();
    LogicalMazeCaveFloor1Store logicalMazeCaveFloor1Store = LogicalMazeCaveFloor1Store.getInstance();
    LogicalMazeCaveUndergroundStore logicalMazeCaveUndergroundStore = LogicalMazeCaveUndergroundStore.getInstance();

    Card[][] logicalMaze;
    Card[][] MazeCanBeSeen;
    CardPane[][] currentMaze = new CardPane[3][5];//这就是当前显示的部分
    int currentRow = 0;//现在应该在迷宫的第几行 0~15
    int currentCard = 2;//现在是第几列，也就是第几张牌 0~4
    boolean currentSelected[] = {false,true,false};//记录一下现在是左中右那一张牌被选到了


    OpenTentButton bOpenTent = new OpenTentButton("    打开帐篷","200",820,720);
    //这个地方需要的是另一个帐篷，就是下面的桌面部分，点了打开帐篷会再打开一个新的tentPane


    //改
    Pane Character = new Pane();
    Pane leftMazeBar = new Pane();
    Pane rightMazeBar = new Pane();

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
        initAllStep();
        this.getChildren().add(Character);
        this.getChildren().add(leftMazeBar);
        this.getChildren().add(rightMazeBar);
        initPane(Character,390,570,".\\images\\rancewalkingmaze.png");
        initPane(leftMazeBar,260,340,".\\images\\leftMazeBar.png");
        initPane(rightMazeBar,680,340,".\\images\\rightMazeBar.png");
    }


    public void initTheMaze(){
        for(int j = 0; j < 5; j++) {
            currentMaze[0][j] = new CardPane(MazeCanBeSeen[(currentRow+2)%MazeCanBeSeen.length][j]);
            this.getChildren().add(currentMaze[0][j]);
            setXY(currentMaze[0][j],160*j + 120, 150);
            currentMaze[1][j] = new CardPane(MazeCanBeSeen[(currentRow+1)%MazeCanBeSeen.length][j]);
            this.getChildren().add(currentMaze[1][j]);
            setXY(currentMaze[1][j],160*j + 120, 250);
            currentMaze[2][j] = new CardPane(MazeCanBeSeen[(currentRow)%MazeCanBeSeen.length][j]);
            this.getChildren().add(currentMaze[2][j]);
            setXY(currentMaze[2][j],160*j + 120, 350);
        }
        whichCardSelected();
//        System.out.println(currentSelected[0]);
//        System.out.println(currentSelected[1]);
//        System.out.println(currentSelected[2]);
    }

    //这里用release其实是有bug的，主要是因为似乎一种触发只能对应一种事件，比如clicked只能下辖一个事件，所以我这里不得已用了release，希望后面能完善这里
    public void whichCardSelected(){
        currentMaze[2][currentCard].setOnMouseReleased(e->{
            currentSelected[0] = false;
            currentSelected[1] = true;
            currentSelected[2] = false;
        });
        if (currentCard > 0) {
            currentMaze[2][currentCard - 1].setOnMouseReleased(e->{
                currentSelected[0] = true;
                currentSelected[1] = false;
                currentSelected[2] = false;
            });
        }
        if (currentCard < 4){
            currentMaze[2][currentCard + 1].setOnMouseReleased(e->{
                currentSelected[0] = false;
                currentSelected[1] = false;
                currentSelected[2] = true;
            });
        }
    }


    // 有两种情况是不会给牌加上这个功能的，对应的type分别是2障碍卡片，他不应该被加事件
    // 3仅显示背面的图片，这个比较特殊，
    public void initAllStep(){
//        whichCardSelected();
        initCenterStep(whichAction(currentMaze[2][currentCard]));
        if (currentCard>0){
            initLeftStep(whichAction(currentMaze[2][currentCard-1]));}
        if (currentCard<4){
            initRightStep(whichAction(currentMaze[2][currentCard+1]));
        }
    }

    public void initLeftStep(boolean cardCanPass){
        if (cardCanPass) {
            currentMaze[2][currentCard-1].setOnMouseClicked(e->{
                currentCard-=1;
                currentRow = (currentRow+1)%logicalMaze.length;
                initTheMaze();
                initAllStep();
                initLeftBar();
            });
        }
    }

    public void initCenterStep(boolean cardCanPass){
        if (cardCanPass) {
        currentMaze[2][currentCard].setOnMouseClicked(e ->{
            currentRow = (currentRow+1)%logicalMaze.length;
            initTheMaze();
            initAllStep();
        } );}
    }

    public void initRightStep(boolean cardCanPass){
        if (cardCanPass) {
            currentMaze[2][currentCard+1].setOnMouseClicked(e->{
                currentCard+=1;//
                currentRow = (currentRow+1)%logicalMaze.length;
                initTheMaze();
                initAllStep();
                initRightBar();
            });
        }
    }

    public void initLeftBar(){
        setXY(Character,(int)Character.getLayoutX()-160,570);
        if((currentCard==1)||(currentCard==0))  setXY(leftMazeBar,100,340);
        else  setXY(leftMazeBar,(int)(Character.getLayoutX()-130),340);
        setXY(rightMazeBar,(int)(Character.getLayoutX()+290),340);
    }

    public void initRightBar(){
        setXY(Character,(int)Character.getLayoutX()+160,570);
        if((currentCard==3)||(currentCard==4))  setXY(rightMazeBar,840,340);
        else  setXY(rightMazeBar,(int)(Character.getLayoutX()+290),340);
        setXY(leftMazeBar, (int)(Character.getLayoutX()-130),340);
    }


    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//    public void initLeftStepWithoutinitMaze(boolean cardCanPass){
//        if (cardCanPass) {
//            currentMaze[2][currentCard-1].setOnMouseClicked(e->{
//                currentCard-=1;
//                currentRow = (currentRow+1)%logicalMaze.length;
//                initAllStep();
//                initLeftBar();
//            });
//        }
//    }
//
//    public void initCenterStepWithoutinitMaze(boolean cardCanPass){
//        if (cardCanPass) {
//            currentMaze[2][currentCard].setOnMouseClicked(e ->{
//                currentRow = (currentRow+1)%logicalMaze.length;
//                initTheMaze();
//                initAllStep();
//            } );}
//    }
//
//    public void initRightStepWithoutinitMaze(boolean cardCanPass){
//        if (cardCanPass) {
//            currentMaze[2][currentCard+1].setOnMouseClicked(e->{
//                currentCard+=1;//
//                currentRow = (currentRow+1)%logicalMaze.length;
//                initTheMaze();
//                initAllStep();
//                initRightBar();
//            });
//        }
//    }


    //让他根据type返回true和false，暂存在initAllStep里面，然后左中右三个step都要传Boolean进去，true才能用
    public boolean whichAction(CardPane cardPane){
        switch (cardPane.getCard().getType()){
            case "1"://
//                System.out.println(1);
//                System.out.println(cardPane.getCard().getContent());
                return true;
            case "2":
//                initTheMaze();
//                //因为没加40锁，可能有bug,
//                if (currentSelected[0]){
//                    CardPane c0 = new CardPane(logicalMaze[currentRow][currentCard-1]);
//                    currentMaze[2][currentCard-1] = c0;
//                    initRightStepWithoutinitMaze(whichAction(c0));//因为他自动更新了迷宫，所以这里被覆盖掉了
//                }else if (currentSelected[1]) {
//                    CardPane c1 = new CardPane(logicalMaze[currentRow][currentCard]);
//                    currentMaze[2][currentCard] = c1;
//                    initCenterStepWithoutinitMaze(whichAction(c1));
//                }else{
//                    CardPane c2 = new CardPane(logicalMaze[currentRow][currentCard+1]);
//                    currentMaze[2][currentCard+1] = c2;
//                    initLeftStepWithoutinitMaze(whichAction(c2));
//                }

                //这个的逻辑暂定为点一下，就初始化这张牌，然后也初始化所有整列的牌，这样他们身上就不会有事件了，这样就只能摁着点这张牌了
                //但是我怎么知道这是左中右的哪一张牌
//                System.out.println(2);
//                System.out.println(cardPane.getCard().getContent());
                return false;
            case "3":
//                System.out.println(3);
//                System.out.println(cardPane.getCard().getContent());
                return false;
            case "4":
//                System.out.println(4);
//                System.out.println(cardPane.getCard().getContent());
                return true;
            case "5":
//                System.out.println(5);
//                System.out.println(cardPane.getCard().getContent());
                return true;
            case "6":
//                System.out.println(6);
//                System.out.println(cardPane.getCard().getContent());
                return true;
            case "7":
//                System.out.println(7);
//                System.out.println(cardPane.getCard().getContent());
                return true;
            case "8":
//                System.out.println(8);
//                System.out.println(cardPane.getCard().getContent());
                return true;
            case "9":
//                System.out.println(9);
//                System.out.println(cardPane.getCard().getContent());
                return true;
        }
        return true;
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





