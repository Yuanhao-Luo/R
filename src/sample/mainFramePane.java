package sample;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class mainFramePane extends Pane {
    Pane clockPane = new Pane();
    Pane p1 = new Pane();//这是进入具体场景按钮
    Pane dot = new Pane();
    LocationOfColockDot[] locd = new LocationOfColockDot[9];

    private static mainFramePane m = new mainFramePane();

    private mainFramePane(){
        Image imageBack = null;
        try {
            imageBack = new Image(new FileInputStream(".\\images\\backgroundMain.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView imageView = new ImageView();
        imageView.setImage(imageBack);
        this.getChildren().add(imageView);
        this.getChildren().add(p1);
        initPane(p1,300,400,".\\images\\hotelButton_pressable.png");

        this.getChildren().add(clockPane);
        initPane(clockPane,930,-100,".\\images\\clock.png");

        this.getChildren().add(dot);
        initPane(dot,100,100,".\\images\\dot.png");
        initDot(dot);
    }


    public static mainFramePane getInstance(){
        return m;
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
        p.setPrefSize(119,52);
        p.setLayoutX(x);
        p.setLayoutY(y);

        p.setOnMouseClicked(e ->{
            System.out.println("ohhhh");
                });
    }

    //did not finish
//    public void initClock(Pane clockPane, Pane dot, ){
//        Image img1 = null;
//        Image img1 = null;
//        try {
//            imageBack = new Image(new FileInputStream(url));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        ImageView imageView = new ImageView();
//        imageView.setImage(imageBack);
//        p.getChildren().add(imageView);
//        p.setPrefSize(119,52);
//        p.setLayoutX(x);
//        p.setLayoutY(y);
//
//        p.setOnMouseClicked(e ->{
//            System.out.println("ohhhh");
//        });
//    }

    public void initAll(){

    }

    public void initDot(Pane d){
        int time = 5;
        double[] dx = {1109, 1080, 1054, 1029, 1004, 985, 972, 964, 964};
        double[] dy = {128, 139, 139, 137, 117, 98, 77, 50, 23};
        for (int i = 0; i < locd.length; i++) {
            locd[i] = new LocationOfColockDot(dx[i], dy[i], i);
        }

        locd[time].setLocation(d);
        }
    }



