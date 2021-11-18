package sample.Event;

import javafx.event.Event;
import sample.MainFramePane;
import sample.TimeSingleton;
import sample.Toolkit;
import sample.buttons.MapButton;
import sample.specificPlace.*;

public class EnterPlace extends PassOneTime {
    @Override
    public void handle(Event event) {
        MapButton mapButton = Toolkit.peaceKeeperImageView(event.getTarget());
        TimeSingleton t = TimeSingleton.getInstance();
        if (mapButton.getVisiable(t.getCurrentTime())) {
            MainFramePane.getInstance().timeChange(mapButton);
        }

        switch (mapButton.getName()){

            case "homeofsea":
                System.out.println("clicked");
                HomeofseaPane homeofseaPane = (HomeofseaPane) MainFramePane.getInstance().homeofseaPane;
                if (!homeofseaPane.isVisible() && mapButton.getVisiable(TimeSingleton.getInstance().getCurrentTime())){
                    homeofseaPane.setVisible(true);
                };
                break;
//            case "weapons":
//                WeaponsPane weaponsPane = (WeaponsPane) MainFramePane.getInstance().weaponsPane;
//                System.out.println("clicked1");
//                if (!weaponsPane.isVisible() && mapButton.getVisiable(TimeSingleton.getInstance().getCurrentTime())){
//                    weaponsPane.setVisible(true);
//                };
//                break;
//
//            case "hotel":
//                HotelPane hotelPane = (HotelPane) MainFramePane.getInstance().hotelPane;
//                System.out.println("clicked1");
//                if (!hotelPane.isVisible() && mapButton.getVisiable(TimeSingleton.getInstance().getCurrentTime())){
//                    hotelPane.setVisible(true);
//                };
//                break;
//
//            case "level":
//                LevelPane levelPane = (LevelPane) MainFramePane.getInstance().levelPane;
//                System.out.println("clicked1");
//                if (!levelPane.isVisible() && mapButton.getVisiable(TimeSingleton.getInstance().getCurrentTime())){
//                    levelPane.setVisible(true);
//                };
//                break;
//            case "bistro":
//                BistroPane bistroPane = (BistroPane) MainFramePane.getInstance().bistroPane;
//                System.out.println("clicked1");
//                if (!bistroPane.isVisible() && mapButton.getVisiable(TimeSingleton.getInstance().getCurrentTime())){
//                    bistroPane.setVisible(true);
//                };
//                break;
        }
    }

}
