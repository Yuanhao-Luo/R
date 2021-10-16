package sample;

import javafx.scene.layout.Pane;

public class bButton extends Pane {
    private String url_hover;
    private String url_preparing;
    private String url_pressable;
    private String url_pressed;

    public boolean[] available = {true,true,true,true,false,false,false,false,false};//表示何时处于可用状态的

    public bButton(String s0,String s1,String s2, String s3,boolean[] available){
        this.url_hover = s0;
        this.url_preparing = s1;
        this.url_pressable = s2;
        this.url_pressed = s3;
        this.available = available;
    }

    public String whichUrl(int time) {
        if (available[time]){
            return url_pressable;
        }else
            return url_preparing;
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

    public boolean ifVisiable(int i){
        return this.available[i];
    }

}
