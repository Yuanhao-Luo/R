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

    private static mainFramePane m = new mainFramePane();

    private mainFramePane(){
        Image imageBack = null;
        try {
            imageBack = new Image(new FileInputStream("E:\\programming\\java\\Test\\R\\images\\backgroundMain.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView imageView = new ImageView();
        imageView.setImage(imageBack);
        this.getChildren().add(imageView);
        this.getChildren().add(p1);
        initPane(p1,300,400,"E:\\programming\\java\\Test\\R\\images\\hotelButton_avaliable.png");

        this.getChildren().add(clockPane);
        initPane(clockPane,930,-100,"E:\\programming\\java\\Test\\R\\images\\clock.png");

        this.getChildren().add(dot);
        initPane(dot,100,100,"E:\\programming\\java\\Test\\R\\images\\dot.png");
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

    public void initAll(){

    }

    public void initDot(Pane d){
        int time = 5;
        switch (time){
            case 0:
                d.setLayoutX(1109);
                d.setLayoutY(128);
                break;
            case 1:
                d.setLayoutX(1080);
                d.setLayoutY(139);
                break;
            case 2:
                d.setLayoutX(1054);
                d.setLayoutY(139);
            case 3:
                d.setLayoutX(1029);
                d.setLayoutY(137);
                break;
            case 4:
                d.setLayoutX(1004);
                d.setLayoutY(117);
                break;
            case 5:
                d.setLayoutX(985);
                d.setLayoutY(98);
                break;
            case 6:
                d.setLayoutX(972);
                d.setLayoutY(77);
                break;
            case 7:
                d.setLayoutX(964);
                d.setLayoutY(50);
                break;
            case 8:
                d.setLayoutX(964);
                d.setLayoutY(23);
                break;


        }
    }
    //   00
//          1109.0
//        128.0
//    1
//          1080.0
//        139.0
//    2
//          1054.0
//        137.0
//    3
//          1029.0
//        130.0
//    4
//          1004.0
//        117.0
//    5
//          985.0
//        98.0
//    6
//          972.0
//        77.0
//    7
//          964.0
//        50.0
//    8
//          964.0
//        23.0

}
