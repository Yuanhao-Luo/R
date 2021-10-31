package sample.Event;

import javafx.event.Event;
import javafx.event.EventHandler;
import sample.MainFramePane;
import sample.TentPane;
import sample.TimeSingleton;
import sample.Toolkit;
import sample.buttons.MapButton;
import sample.specificPlace.GeneralPlacePane;

public class EnterPlace extends PassOneTime {
    @Override
    public void handle(Event event) {
        MapButton mapButton = Toolkit.peaceKeeperImageView(event.getTarget());
        TimeSingleton t = TimeSingleton.getInstance();
        if (mapButton.ifVisiable(t.getCurrentTime())) {
            MainFramePane.getInstance().timeChange(mapButton);
        }
        System.out.println("clicked");

        switch (mapButton.getName()){

            case "homeofsea":
                System.out.println("clicked");
                GeneralPlacePane generalPlacePane = MainFramePane.getInstance().generalPlacePane;
                if (!generalPlacePane.isVisible()){
                    generalPlacePane.setVisible(true);
                };
                break;
        }
    }

}
