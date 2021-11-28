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
    //boolean OpenTentAvailable = true;
    int HPTotal = 120;
    int HPCurrent = 8;
    LogicalMazeOuterCityStore logicalMazeOuterCityStore = LogicalMazeOuterCityStore.getInstance();
    LogicalMazeCaveFloor1Store logicalMazeCaveFloor1Store = LogicalMazeCaveFloor1Store.getInstance();
    LogicalMazeCaveUndergroundStore logicalMazeCaveUndergroundStore = LogicalMazeCaveUndergroundStore.getInstance();

    Card[][] logicalMaze;
    Card[][] MazeCanBeSeen;
    CardPane[][] currentMaze = new CardPane[3][5];//这就是当前显示的部分
    int currentRow = 4;//现在应该在迷宫的第几行 0~15
    int currentCard = 2;//现在是第几列，也就是第几张牌 0~4
    int whichCardSelected = currentCard;


    OpenTentButton bOpenTent = new OpenTentButton("    打开帐篷","200",820,720);
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
            whichCardSelected = currentCard;
        }
    }




    public void initAllStep(){
        initCenterStep(whichAction(currentMaze[2][currentCard]));
        if (currentCard>0){
            initLeftStep(whichAction(currentMaze[2][currentCard-1]));
        }
        if (currentCard<4){//他会给牌加一些函数，然后根据牌的类型决定牌能不能走
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


    //这里用release其实是有bug的，主要是因为似乎一种触发只能对应一种事件，比如clicked只能下辖一个事件，所以我这里不得已用了release，希望后面能完善这里
    public void whichCardSelected(){
        //System.out.println("whichCardSelected被执行");
        if (currentCard > 0) {
            currentMaze[2][currentCard - 1].setOnMouseReleased(e->{
                whichCardSelected-=1;
                //System.out.println("whichCardSelected: whichCardSelected is " + whichCardSelected);
            });
        }
        if (currentCard < 4){
            currentMaze[2][currentCard + 1].setOnMouseReleased(e->{
                whichCardSelected+=1;
            });
        }
    }


    public void initForCardType3(){
        currentMaze[2][whichCardSelected].setOnMouseClicked(e->{
            if(whichCardSelected<currentCard){
                initLeftBar();
            }else if(whichCardSelected>currentCard){
                initRightBar();
            }
            currentCard -= (currentCard-whichCardSelected);
            currentRow = (currentRow+1)%logicalMaze.length;
            initTheMaze();
            initAllStep();
        });
    }


    public void reloadLeftCard(){
        if (whichCardSelected<currentCard){
            currentMaze[2][currentCard-1] = new CardPane(logicalMaze[currentRow][currentCard-1]);
            this.getChildren().add(currentMaze[2][currentCard-1]);
            setXY(currentMaze[2][currentCard-1],160*currentCard - 40, 350);
            initForCardType3();
        }else {
            currentMaze[2][currentCard-1] = new CardPane(MazeCanBeSeen[currentRow][currentCard-1]);
            this.getChildren().add(currentMaze[2][currentCard-1]);
            setXY(currentMaze[2][currentCard-1],160*currentCard - 40, 350);
        }
    }


    //现在的问题是他进行下一步了，我们要的效果应该是他没进行下一步，
    public void reloadCenterCard(){
        if (whichCardSelected==currentCard) {
            currentMaze[2][currentCard] = new CardPane(logicalMaze[currentRow][currentCard]);
            this.getChildren().add(currentMaze[2][currentCard]);
            setXY(currentMaze[2][currentCard],160*currentCard + 120, 350);
            initForCardType3();
        }else {
            currentMaze[2][currentCard] = new CardPane(MazeCanBeSeen[currentRow][currentCard]);
            this.getChildren().add(currentMaze[2][currentCard]);
            setXY(currentMaze[2][currentCard],160*currentCard + 120, 350);
        }
    }

    public void reloadRightCard(){
        if (whichCardSelected>currentCard) {//如果这张牌被幸运的选中了，那他就从logicalMaze里拿真相卡，不然就还是拿MazeCanBeSeen
            currentMaze[2][currentCard+1] = new CardPane(logicalMaze[currentRow][currentCard+1]);
            this.getChildren().add(currentMaze[2][currentCard+1]);
            setXY(currentMaze[2][currentCard+1],160*currentCard + 280, 350);
            initForCardType3();
        }else {
            currentMaze[2][currentCard+1] = new CardPane(MazeCanBeSeen[currentRow][currentCard+1]);
            this.getChildren().add(currentMaze[2][currentCard+1]);
            setXY(currentMaze[2][currentCard+1],160*currentCard + 280, 350);
        }
    }


    public void forCardType3(CardPane cardPane){
        //首先将其他的两张牌重新加载，剥夺他们处理事件的权力
        if(currentCard == 0){
            cardPane.setOnMouseClicked(e->{
                reloadCenterCard();
                reloadRightCard();
            });
        }else if(currentCard == 4){
            cardPane.setOnMouseClicked(e-> {
                reloadLeftCard();
                reloadCenterCard();
            });
        }else{
            cardPane.setOnMouseClicked(e->{
                reloadLeftCard();
                reloadCenterCard();
                reloadRightCard();
            });
        }
        //然后看那张被选了，根据被选的牌来直接重新初始化迷宫
        whichCardSelected();
    }


    public void forCardType7OuterCity(CardPane cardPane){
        cardPane.setOnMouseClicked(e->{
            logicalMaze = logicalMazeOuterCityStore.logicalMaze;
            MazeCanBeSeen = logicalMazeOuterCityStore.MazeCanBeSeen;
            currentCard = 2;
            currentRow = 0;
            initTheMaze();
            initAllStep();
        });
    }

    public void forCardType7Floor1(CardPane cardPane){
        Pane pane7 = new Pane();
        cardPane.getChildren().add(pane7);
        pane7.setMinHeight(240);
        pane7.setMaxHeight(240);
        pane7.setMaxWidth(160);
        pane7.setMinWidth(160);
        System.out.println(pane7.getLayoutX());
        System.out.println(pane7.getLayoutY());

        System.out.println("forCardType7Floor1执行了");
        pane7.setOnMouseClicked(e->{
            System.out.println("forCardType7Floor1动作执行了");
            logicalMaze = logicalMazeCaveFloor1Store.logicalMaze;
            MazeCanBeSeen = logicalMazeCaveFloor1Store.MazeCanBeSeen;
            currentCard = 2;
            currentRow = 0;
            initTheMaze();
            initAllStep();
        });
    }

    public void forCardType7Underground(CardPane cardPane){
        cardPane.setOnMouseClicked(e->{
            logicalMaze = logicalMazeCaveUndergroundStore.logicalMaze;
            MazeCanBeSeen = logicalMazeCaveUndergroundStore.MazeCanBeSeen;
            currentCard = 2;
            currentRow = 0;
            initTheMaze();
            initAllStep();
        });
    }


    //让他根据type返回true和false，暂存在initAllStep里面，然后左中右三个step都要传Boolean进去，true才能用
    public boolean whichAction(CardPane cardPane){
        switch (cardPane.getCard().getType()){
            case "1":
                return true;
            case "2":
                return false;
            case "3":
                forCardType3(cardPane);
                return false;
            case "4":
                System.out.println(4);
                System.out.println(cardPane.getCard().getContent());
                return true;
            case "5":
                System.out.println(5);
                System.out.println(cardPane.getCard().getContent());
                return true;
            case "6":
                System.out.println(6);
                System.out.println(cardPane.getCard().getContent());
                return true;
            case "7":
                System.out.println(7);
                if (cardPane.getCard().getContent().equals("0"))  {
                    System.out.println("0");
                    forCardType7Floor1(cardPane);
                }
                else if (cardPane.getCard().getContent().equals("1"))  forCardType7Floor1(cardPane);
                else if (cardPane.getCard().getContent().equals("2"))  forCardType7Floor1(cardPane);
                else if (cardPane.getCard().getContent().equals("3"))  forCardType7Floor1(cardPane);
                else if (cardPane.getCard().getContent().equals("4"))  forCardType7Floor1(cardPane);
                return true;
            case "8":
                System.out.println(8);
                System.out.println(cardPane.getCard().getContent());
                return true;
            case "9":
                System.out.println(9);
                System.out.println(cardPane.getCard().getContent());
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





