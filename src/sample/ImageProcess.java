package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImageProcess {
    public ImageProcess(){}

    public static void dealImage(Pane p, String url, int width, int height){
        Image imageBack = null;
        try {
            imageBack = new Image(new FileInputStream(url));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView imageView = new ImageView();
        imageView.setImage(imageBack);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        p.getChildren().add(imageView);
    }

    public static void addImage(Pane p, String url) {
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

    public static void changeImage(ImageView imageView, String url) {
        Image imageBack = null;
        try {
            imageBack = new Image(new FileInputStream(url));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        imageView.setImage(imageBack);
    }
}
