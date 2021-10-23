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
    public ImageView imageView = new ImageView();

    public GeneralButton(String s0, String s1, String s2, String s3){
        this.url_hover = s0;
        this.url_preparing = s1;
        this.url_pressable = s2;
        this.url_pressed = s3;
        try {
            imageView.setImage(new Image(new FileInputStream(whichUrl())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        getChildren().add(imageView);
        addButtonEvent();
    }

    public GeneralButton(){

    }

    public void addButtonEvent(){
        setOnMouseEntered(e->{
            if(available)
                changeImage(getUrl_hover());
        });

        setOnMouseExited(e->{
            if(available)
                changeImage(getUrl_pressable());
        });

        setOnMousePressed(e->{
            if(available){
                changeImage(getUrl_pressed());
            }
        });
    }

//    public void changeImage(Pane p, String url){
//        changeImage(p, url);
//    }

//    public void changeImage(MapButton b, String url) {
//        Image imageBack = null;
//        try {
//            imageBack = new Image(new FileInputStream(url));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        b.imageView.setImage(imageBack);
//    }

    public void changeImage(String url) {
        Image imageBack = null;
        try {
            imageBack = new Image(new FileInputStream(url));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        imageView.setImage(imageBack);
//        ImageView imageView = new ImageView(imageBack);
//        getChildren().add(imageView);
    }

//    public void dealImage(Pane p, String url, int width, int height) {
//        Image imageBack = null;
//        try {
//            imageBack = new Image(new FileInputStream(url));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        imageView.setImage(imageBack);
//        imageView.setFitWidth(width);
//        imageView.setFitHeight(height);
//    }

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
