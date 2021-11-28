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
                initCharacter(currentCard);
                initLeftBar(currentCard);
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
                initCharacter(currentCard);
                initRightBar(currentCard);
            });
        }
    }

    public void initCharacter(int currentCard){
        setXY(Character,390 + (currentCard-2)*160,570);
    }
    //刚开始的时候中心人，左右边框位置分别是390，260，680

    public void initLeftBar(int currentCard){
        System.out.println("初始化左边框被执行了");
        System.out.println("currentCard is "+currentCard);
        System.out.println(Character.getLayoutX()+"对应身位值"+(Character.getLayoutX()-230)/160);
        //setXY(Character,390+(currentCard-2)*160,570);
        if((currentCard==1)||(currentCard==0))  setXY(leftMazeBar,100,340);
        else  setXY(leftMazeBar,390+(currentCard-2)*160-130,340);
        setXY(rightMazeBar,390+(currentCard-2)*160+290,340);
//        setXY(Character,(int)Character.getLayoutX()-160,570);
//        System.out.println("初始化左边框被执行了");
//        if((currentCard==1)||(currentCard==0))  setXY(leftMazeBar,100,340);
//        else  setXY(leftMazeBar,(int)(Character.getLayoutX()-130),340);
//        setXY(rightMazeBar,(int)(Character.getLayoutX()+290),340);
    }

    public void initRightBar(int currentCard){
        System.out.println("初始化右边框被执行了");
        System.out.println("currentCard is "+currentCard);
        System.out.println(Character.getLayoutX()+"对应身位值"+(Character.getLayoutX()-230)/160);
        //setXY(Character,390+(currentCard-2)*160,570);
        if((currentCard==3)||(currentCard==4))  setXY(rightMazeBar,840,340);
        else  setXY(rightMazeBar,390+(currentCard-2)*160+290,340);
        setXY(leftMazeBar, 390+(currentCard-2)*160-130,340);
//                else  setXY(rightMazeBar,680+160*(currentCard-2),340);
//        setXY(leftMazeBar, 260-160*(currentCard-2),340);
    }



    public void whichCardSelected(){
        whichCardSelected = currentCard;
        Pane panewhichCardSelected1 = new Pane();
        panewhichCardSelected1.setMinHeight(240);
        panewhichCardSelected1.setMaxHeight(240);
        panewhichCardSelected1.setMaxWidth(160);
        panewhichCardSelected1.setMinWidth(160);
        Pane panewhichCardSelected2 = new Pane();
        panewhichCardSelected2.setMinHeight(240);
        panewhichCardSelected2.setMaxHeight(240);
        panewhichCardSelected2.setMaxWidth(160);
        panewhichCardSelected2.setMinWidth(160);
        if (currentCard > 0) {
            currentMaze[2][currentCard-1].getChildren().add(panewhichCardSelected1);
            panewhichCardSelected1.setOnMouseClicked(e->{
                whichCardSelected-=1;
                currentMaze[2][currentCard-1].getChildren().remove(panewhichCardSelected1);
                System.out.println("2.1 whichCardSelected: whichCardSelected is " + whichCardSelected);
                System.out.println("2.1 whichCardSelected: currentCard is" + currentCard);
            });
        }
        if (currentCard < 4){
            currentMaze[2][currentCard+1].getChildren().add(panewhichCardSelected2);
            panewhichCardSelected2.setOnMouseReleased(e->{
                whichCardSelected+=1;
                currentMaze[2][currentCard+1].getChildren().remove(panewhichCardSelected1);
                System.out.println("2.1 whichCardSelected: whichCardSelected is " + whichCardSelected);
                System.out.println("2.1 whichCardSelected: currentCard is" + currentCard);
            });
        }
        System.out.println("2.1如果两边的都没点，那就是中间那张没变"+currentCard+"="+whichCardSelected);
    }


    //4,这里就是承接上文所说，用了whichCardSelected来初始化新一行的Maze
    public void initForCardType3(){

        currentMaze[2][whichCardSelected].setOnMouseClicked(e->{
            if(whichCardSelected<currentCard){
                initCharacter(whichCardSelected);
                initLeftBar(whichCardSelected);
            }else if(whichCardSelected>currentCard){
                initCharacter(whichCardSelected);
                initRightBar(whichCardSelected);
            }
            currentCard = whichCardSelected;
            currentRow = (currentRow+1)%logicalMaze.length;
            initTheMaze();
            initAllStep();
        });
    }


    //3,这三个reload函数是把几张牌重新初始化的，如果是左牌被选中，那就给中间，右边，两张牌盖上空白的牌，
    //而左边这张就被赋予新的函数，因为此时被选中的牌，也就是whichCardSelected才真正代表了下一步所处的牌在什么位置
    //所以要拿whichCardSelected当作currentCard的地位去初始化迷宫，初始化几步
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
        if (whichCardSelected>currentCard) {
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

    //先梳理一下逻辑，然后一个一个的print位点，
    //1，他执行whichAction（），然后发现了这三张牌中有一张是背面卡；给这张背面卡上处理
    //2，他执行forCardType3，根据currentCard状况选择执行哪一种，然后，获取你在这三张卡中选了哪一张
    //3,


    public boolean whichAction(CardPane cardPane){
        switch (cardPane.getCard().getType()){
            case "1":
                return true;
            case "2":
                return false;
            case "3":
                forCardType3(cardPane);
                System.out.println("1，此时发现了一张背面卡，并执行了forCardType3给这张背面卡上处理");
                return false;
            case "4":
                //System.out.println(4);
                //System.out.println(cardPane.getCard().getContent());
                return true;
            case "5":
                //System.out.println(5);
                //System.out.println(cardPane.getCard().getContent());
                return true;
            case "6":
                //System.out.println(6);
                //System.out.println(cardPane.getCard().getContent());
                return true;
            case "7":
                //System.out.println(7);
                if (cardPane.getCard().getContent().equals("0"))  {
                    forCardType7Floor1(cardPane);
                }
                return true;
            case "8":
                //System.out.println(8);
                //System.out.println(cardPane.getCard().getContent());
                return true;
            case "9":
                //System.out.println(9);
                //System.out.println(cardPane.getCard().getContent());
                return true;
        }
        return true;
    }

    //2，他执行forCardType3，根据currentCard状况选择执行哪一种，然后，获取你在这三张卡中选了哪一张
    public void forCardType3(CardPane cardPane){
        whichCardSelected();
        System.out.println("2.2，他给几张卡加上事件了，会记录下点了哪一张卡，然后会");
        //首先将其他的两张牌重新加载，剥夺他们处理事件的权力
        if(currentCard == 0){
            cardPane.setOnMouseClicked(e->{
                //currentCard = 0;反正这里有缺陷，总该有个什么地方让currentCard = whichCardSelected
                reloadCenterCard();
                reloadRightCard();
                System.out.println("forCardType3第一种赋值后的whichCardSelected="+whichCardSelected);
                System.out.println("forCardType3第一种赋值后的currentCard="+currentCard);
            });
        }else if(currentCard == 4){
            cardPane.setOnMouseClicked(e-> {
                //currentCard = 4;
                reloadLeftCard();
                reloadCenterCard();
                System.out.println("forCardType3第二种赋值后的whichCardSelected="+whichCardSelected);
                System.out.println("forCardType3第二种赋值后的currentCard="+currentCard);
            });
        }else{
            cardPane.setOnMouseClicked(e->{
                //currentCard = whichCardSelected;
                reloadLeftCard();
                reloadCenterCard();
                reloadRightCard();
                System.out.println("forCardType3第三种赋值后的whichCardSelected="+whichCardSelected);
                System.out.println("forCardType3第三种赋值后的currentCard="+currentCard);
            });
        }
    }


    public void forCardType7OuterCity(CardPane cardPane){
        cardPane.setOnMouseClicked(e->{
            logicalMaze = logicalMazeOuterCityStore.logicalMaze;
            MazeCanBeSeen = logicalMazeOuterCityStore.MazeCanBeSeen;
            currentCard = 2;
            currentRow = 0;
            initTheMaze();
            initAllStep();
            initPane(Character,390,570,".\\images\\rancewalkingmaze.png");
        });
    }



    public void forCardType7Floor1(CardPane cardPane){
        Pane pane7 = new Pane();
        cardPane.getChildren().add(pane7);
        pane7.setMinHeight(240);
        pane7.setMaxHeight(240);
        pane7.setMaxWidth(160);
        pane7.setMinWidth(160);

        //System.out.println("forCardType7Floor1执行了");
        pane7.setOnMouseClicked(e->{
            System.out.println("forCardType7Floor1动作执行了");
            logicalMaze = logicalMazeCaveFloor1Store.logicalMaze;
            MazeCanBeSeen = logicalMazeCaveFloor1Store.MazeCanBeSeen;
            //currentCard = 2;
            currentRow = 0;
            initCharacter(currentCard);
            initLeftBar(currentCard);
            initRightBar(currentCard);
            initTheMaze();
            System.out.println("After initTheMaze, the currentCard = "+currentCard);
            initAllStep();
            System.out.println("After initAllStep, the currentCard = "+currentCard);
            cardPane.getChildren().remove(pane7);
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
            initPane(Character,390,570,".\\images\\rancewalkingmaze.png");
        });
    }


    //让他根据type返回true和false，暂存在initAllStep里面，然后左中右三个step都要传Boolean进去，true才能用




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





