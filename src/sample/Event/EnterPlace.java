package sample.Event;

import javafx.event.Event;
import sample.MainFramePane;
import sample.TimeSingleton;
import sample.Toolkit;
import sample.buttons.MapButton;
import sample.specificPlace.HomeofseaPane;

public class EnterPlace extends PassOneTime {
    @Override
    public void handle(Event event) {
        MapButton mapButton = Toolkit.peaceKeeperImageView(event.getTarget());
        TimeSingleton t = TimeSingleton.getInstance();
        if (mapButton.getVisiable(t.getCurrentTime())) {
            MainFramePane.getInstance().timeChange(mapButton);
        }
        System.out.println("clicked");

        switch (mapButton.getName()){

            case "homeofsea":
                System.out.println("clicked");
                HomeofseaPane homeofseaPane = (HomeofseaPane) MainFramePane.getInstance().homeofseaPane;
                if (!homeofseaPane.isVisible() && mapButton.getVisiable(TimeSingleton.getInstance().getCurrentTime())){
                    homeofseaPane.setVisible(true);
                };
                break;
        }
    }

}
