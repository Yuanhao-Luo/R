package sample.buttons;

import sample.MainFramePane;
import sample.TimeSingleton;

public class MapButton extends GeneralButton {
    public boolean[] available = {true,true,true,true,false,false,false,false,false};//表示何时处于可用状态的
    TimeSingleton t = TimeSingleton.getInstance();



    public MapButton(String s0, String s1, String s2, String s3, boolean[] available){
        super(s0, s1, s2, s3);
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

    public void buttonAction(MapButton b, int a){
        int time = t.getCurrentTime();
        b.setOnMouseEntered(e->{
            if(b.ifVisiable(time))
                changeButtonStatues(b,b.getUrl_hover());
        });

        b.setOnMouseExited(e->{
            if(b.ifVisiable(time))
                changeButtonStatues(b, b.getUrl_pressable());
        });

        b.setOnMousePressed(e->{
            if(b.ifVisiable(time)){
                changeButtonStatues(b, b.getUrl_pressed());
            }
        });
        b.setOnMouseClicked(e->{
            if(b.ifVisiable(time)&&a==1){
                MainFramePane.getInstance().timeChange(b);
            }else
                MainFramePane.getInstance().bKillTimeChangeTime(b);
        });
    }

    public boolean ifVisiable(int i){
        return this.available[i];
    }

}
