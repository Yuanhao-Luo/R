package sample.buttons;

import javafx.scene.image.Image;
import sample.TimeSingleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class  MapButton extends GeneralButton {
    public boolean[] available = {true,true,true,true,false,false,false,false,false};//表示何时处于可用状态的
    TimeSingleton t = TimeSingleton.getInstance();
    private String name;


    public MapButton(String s0, String s1, String s2, String s3, boolean[] available, String name){
        this.url_hover = s0;
        this.url_preparing = s1;
        this.url_pressable = s2;
        this.url_pressed = s3;
        this.available = available;
        this.name = name;
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
            if(getVisiable(t.getCurrentTime()))
                changeImage(getUrl_hover());
        });

        setOnMouseExited(e->{
            if(getVisiable(t.getCurrentTime()))
                changeImage(getUrl_pressable());
        });

        setOnMousePressed(e->{
            if(getVisiable(t.getCurrentTime())){
                changeImage(getUrl_pressed());
            }
        });
    }

    public String getName() {
        return name;
    }

    public boolean getVisiable(int i){
        return this.available[i];
    }

}
