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
        primaryStage.setScene(new Scene(p1, 1124, 868));
        p1.getChildren().add(m);
        p1.setOnMouseClicked(e ->{
            System.out.println(e.getX());
            System.out.println(e.getY());
        });
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
