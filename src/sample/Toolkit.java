package sample;

import javafx.scene.image.ImageView;
import sample.buttons.MapButton;

public class Toolkit {
    public static MapButton peaceKeeperImageView(Object o){
        if (o instanceof MapButton){
            return (MapButton)o;
        }else{
            ImageView imageView = (ImageView)o;
            return (MapButton) imageView.getParent();
        }
    }
}
