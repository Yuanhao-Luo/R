package sample.buttons;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import sample.MainFramePane;
import sample.TimeSingleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MapButton extends GeneralButton {
    public boolean[] available = {true,true,true,true,false,false,false,false,false};//表示何时处于可用状态的
    TimeSingleton t = TimeSingleton.getInstance();



    public MapButton(String s0, String s1, String s2, String s3, boolean[] available){
        this.url_hover = s0;
        this.url_preparing = s1;
        this.url_pressable = s2;
        this.url_pressed = s3;
        this.available = available;
        try {
            imageView.setImage(new Image(new FileInputStream(whichUrl(t.getCurrentTime()))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        getChildren().add(imageView);
        addButtonEvent();
    }

    public String whichUrl(int time) {
        if (available[time]){
            return url_pressable;
        }else
            return url_preparing;
    }

    public void addButtonEvent(){
        setOnMouseEntered(e->{
            if(ifVisiable(t.getCurrentTime()))
                changeImage(getUrl_hover());
        });

        setOnMouseExited(e->{
            if(ifVisiable(t.getCurrentTime()))
                changeImage(getUrl_pressable());
        });

        setOnMousePressed(e->{
            if(ifVisiable(t.getCurrentTime())){
                changeImage(getUrl_pressed());
            }
        });
    }

    public boolean ifVisiable(int i){
        return this.available[i];
    }

}
