package sample.buttons;

import sample.TimeSingleton;

public class MapButton extends GeneralButton {
    public boolean[] available = {true,true,true,true,false,false,false,false,false};//表示何时处于可用状态的
    static TimeSingleton t = TimeSingleton.getInstance();



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

    public static void buttonAction(MapButton b){
        int time = t.getTime();
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
    }

    public boolean ifVisiable(int i){
        return this.available[i];
    }

}
