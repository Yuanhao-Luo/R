package sample.Event;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import sample.MainFramePane;
import sample.TimeSingleton;
import sample.Toolkit;
import sample.buttons.MapButton;


public class PassOneTime implements EventHandler {
    @Override
    public void handle(Event event) {
        MapButton mapButton = Toolkit.peaceKeeperImageView(event.getTarget());
        TimeSingleton t = TimeSingleton.getInstance();
        if (mapButton.ifVisiable(t.getCurrentTime())) {
            MainFramePane.getInstance().timeChange(mapButton);
        }
    }
}
