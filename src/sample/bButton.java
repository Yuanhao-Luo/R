package sample;

import javafx.scene.layout.Pane;
//写完一个例子就替换一个试一试
public class bButton extends Pane {
    private String url_hover;
    private String url_preparing;
    private String url_pressable;
    private String url_pressed;

    private boolean[] available = {true,true,true,true,false,false,false,false,false};//这是表示自身何时处于可用状态的

    public bButton(String s0,String s1,String s2, String s3){
        this.url_hover = s0;
        this.url_preparing = s1;
        this.url_pressable = s2;
        this.url_pressed = s3;
    }

    public String whichUrl(int time) {
        if (available[time]){
            return url_pressable;
        }else
            return url_preparing;
    }//搭配mainFramePane的initPane使用可以完成更换

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
        return available[i-1];
    }
}
