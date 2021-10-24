package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    MainFramePane m = MainFramePane.getInstance();
    TimeSingleton t = TimeSingleton.getInstance();
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello World");
        Pane p1 = new Pane();
        primaryStage.setScene(new Scene(p1, 1025, 770));
        p1.getChildren().add(m);
        p1.setOnMouseClicked(e ->{
            System.out.println(e.getX());
            System.out.println(e.getY());
        });
        primaryStage.setWidth(1040);
        primaryStage.setMaxWidth(1040);
        primaryStage.setMinWidth(1040);
        primaryStage.setHeight(808);
        primaryStage.setMaxHeight(808);
        primaryStage.setMinHeight(808);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
