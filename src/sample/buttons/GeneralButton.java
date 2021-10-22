package sample.buttons;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GeneralButton extends Pane {
    public String url_hover;
    public String url_preparing;
    public String url_pressable;
    public String url_pressed;
    public boolean available = true;

    public GeneralButton(String s0, String s1, String s2, String s3){
        this.url_hover = s0;
        this.url_preparing = s1;
        this.url_pressable = s2;
        this.url_pressed = s3;
    }

    public void buttonAction(GeneralButton b){
        b.setOnMouseEntered(e->{
            if(b.available)
                changeButtonStatues(b,b.getUrl_hover());
        });

        b.setOnMouseExited(e->{
            if(b.available)
                changeButtonStatues(b, b.getUrl_pressable());
        });

        b.setOnMousePressed(e->{
            if(b.available){
                changeButtonStatues(b, b.getUrl_pressed());
            }
        });
    }

    public static void changeButtonStatues(Pane p, String url){
        dealImage(p, url);
    }

    public static void dealImage(Pane p, String url) {
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

    public static void dealImage(Pane p, String url, int width, int height) {
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

    public String whichUrl() {
        if (available){
            return url_pressable;
        }else
            return url_preparing;
    }


    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getUrl_hover() {
        return url_hover;
    }

    public String getUrl_preparing() {
        return url_preparing;
    }

    public String getUrl_pressable() {
        return url_pressable;
    }

    public String getUrl_pressed() {
        return url_pressed;
    }

}
