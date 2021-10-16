package sample;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class mainFramePane extends Pane {
    bButton bBistro = new bButton(".\\images\\bistroButton_hover.png",".\\images\\bistroButton_preparing.png",".\\images\\bistroButton_pressable.png",".\\images\\bistroButton_pressed.png");
    bButton bSea = new bButton(".\\images\\homeofseaButton_hover.png",".\\images\\homeofseaButton_preparing.png",".\\images\\homeofseaButton_pressable.png",".\\images\\homeofseaButton_pressed.png");
    bButton bHotel = new bButton(".\\images\\hotelButton_hover.png",".\\images\\hotelButton_preparing.png",".\\images\\hotelButton_pressable.png",".\\images\\hotelButton_pressed.png");
    bButton bLevel = new bButton(".\\images\\levelhouseButton_hover.png",".\\images\\levelhouseButton_preparing.png",".\\images\\levelhouseButton_pressable.png",".\\images\\levelhouseButton_pressed.png");
    bButton bMaze = new bButton(".\\images\\walkthemazeButton_hover.png",".\\images\\walkthemazeButton_preparing.png",".\\images\\walkthemazeButton_pressable.png",".\\images\\walkthemazeButton_pressed.png");
    bButton bWS = new bButton(".\\images\\weaponstoreButton_hover.png",".\\images\\weaponstoreButton_preparing.png",".\\images\\weaponstoreButton_pressable.png",".\\images\\weaponstoreButton_pressed.png");//WeapomStore
    bButton bKillTime = new bButton(".\\images\\weaponstoreButton_hover.png",".\\images\\weaponstoreButton_preparing.png",".\\images\\weaponstoreButton_pressable.png",".\\images\\weaponstoreButton_pressed.png");
    Pane clockPane = new Pane();
    Pane dot = new Pane();
    Pane CI = new Pane();//ClockIndicator
    cLockStatus[] ClS = new cLockStatus[9];

    private static mainFramePane m = new mainFramePane();
    timeSingleton t = timeSingleton.getInstance();
    public static mainFramePane getInstance(){
        return m;
    }

    private mainFramePane(){
        Image imageBack = null;
        try {
            imageBack = new Image(new FileInputStream(".\\images\\backgroundMain.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView imageView = new ImageView();//imageView帮忙切割好了一个方框
        imageView.setImage(imageBack);
        this.getChildren().add(imageView);


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
        //这里可以给他再做一个别的函数这里先这么用着
        bKillTime.setOnMouseClicked(e->{
            t.addOne();
            changeButtonStatues(bLevel,bLevel.whichUrl(t.getTime()));

        });

        this.getChildren().add(clockPane);
        initPane(clockPane,930,-100,".\\images\\clock.png");

        this.getChildren().add(dot);
        initPane(dot,100,100,".\\images\\dot.png");
        initDot(dot);

        this.getChildren().add(CI);
        initPane(CI,1014,18,selectClockIndicator());
        //这个地方是先测试用才CI做的还需要做一个刷新器



    }


    public void initPane(Pane p,int x, int y,String url){
        Image imageBack = null;
        try {
            imageBack = new Image(new FileInputStream(url));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView imageView = new ImageView();
        imageView.setImage(imageBack);
        p.getChildren().add(imageView);
        p.setLayoutX(x);
        p.setLayoutY(y);
    }

    //得要主界面然后往上加
    public void changeButtonStatues(Pane p,String url){
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
    //改时钟状态一个是图另一个是重设小球位置
//    public void changeClockStatues(Pane dot,Pane clockPane){
//        Image imageBack = null;
//        try {
//            imageBack = new Image(new FileInputStream(url));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        ImageView imageView = new ImageView();
//        imageView.setImage(imageBack);
//        p.getChildren().add(imageView);//图的状态
//    }

    //这个地方涉及到一些判断，所以，最好将button做成一个类，往里面传true，false值来确定
    //
    public void buttonAction(bButton b){
        int time = t.getTime();
        if(b.ifVisiable(time)){
            b.setOnMouseEntered(e->{
                System.out.println("-------------进入-------------");
                changeButtonStatues(b,b.getUrl_hover());
                //有个问题，我看了这个changeStatues似乎是新建了一个图像而不是修改我传进去的bButton,
                //如果真是这样，那就算再加坐标，也会覆盖了导致他不能触发，我希望他是修改这个东西的图片而不是新建
                //有这样一种方法，直接singleton，把几个按钮全都singleton就可以
            });

            b.setOnMouseExited(e->{
                System.out.println("-------------离开-------------");
                changeButtonStatues(b, b.getUrl_pressable());
            });

            b.setOnMouseClicked(e->{
                changeButtonStatues(b, b.getUrl_pressed());
                //空着转页面的内容
            });
        }

    }

    //测试函数，看怎么让他

    public String selectClockIndicator(){
        int time = t.getTime();
        String urlIndi1 = ".\\images\\bistroButton_preparing.png";//仅测验用
        String urlIndi2 = ".\\images\\bistroButton_pressable.png";
        String urlIndi3 = ".\\images\\bistroButton_pressed.png";
        if(time > 5){
            return urlIndi3;
        }else if (time <3){
            return urlIndi1;
        }else
            return urlIndi2;
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





