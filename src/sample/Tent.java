//package sample;
//
//import javafx.application.Application;
//import javafx.event.EventHandler;
//import javafx.scene.Group;
//import javafx.scene.control.Button;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.paint.Color;
//import javafx.stage.Stage;
//import javafx.scene.Scene;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.BorderPane;
//
//import javax.swing.*;
//
//
//public class tent extends Application {
//    @Override
//    public void start(Stage primaryStage) {
//        try {
//            BorderPane root = new BorderPane();
//
//            Image image = new Image(".\\images\\button.png");
//            ImageView imageView = new ImageView();
//            imageView.setFitHeight(image.getHeight());
//            imageView.setFitWidth(image.getWidth());
//            imageView.setLayoutX(100);
//            imageView.setY(0);
//            imageView.setImage(image);
//            root.setCenter(imageView);
//            //取出宽度和高度
//
//            EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
//                @Override
//                public void handle(MouseEvent e) {
//                    tentPane tentPane = new tentPane();
//
//                }
//            };
//
//            imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
////            root.getChildren().add(tentPane);
//
//            Scene scene = new Scene(root, 600, 300);
//            primaryStage.setScene(scene);
//            primaryStage.show();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
