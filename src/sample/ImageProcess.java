package sample;

import javafx.scene.Node;
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

    public static void initDialogYouImage(Pane p, String url){
        initPane(p,600,250,url);
    }

    public static void initDialogMeImage(Pane p, String url){
        initPane(p,-50,-120,url);
    }

    public static void initPane(Pane p, int x, int y, String url) {
        ImageProcess.addImage(p, url);
        setXY(p, x, y);
    }

    public static void initImageView(ImageView imageView, int x, int y, String url) {
        try {
            imageView.setImage(new Image(new FileInputStream(url)));
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        setXY(imageView, x, y);
    }

    public static void setXY(Node p, int x, int y){
        p.setLayoutX(x);
        p.setLayoutY(y);
    }
}
