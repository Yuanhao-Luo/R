package sample.Event;

import javafx.event.Event;
import sample.MainFramePane;
import sample.MazePane;
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
                HomeofseaPane homeofseaPane = MainFramePane.getInstance().homeofseaPane;
                if (!homeofseaPane.isVisible() && mapButton.getVisiable(TimeSingleton.getInstance().getCurrentTime())){
                    homeofseaPane.setVisible(true);
                };
//                homeofseaPane.dialogBegin(homeofseaPane.getPlaceName(), new String[]{"我来到了海之家","欢迎光临"},1);
                homeofseaPane.dialogBegin(homeofseaPane.getPlaceName(), new Dialogue(homeofseaPane.getPlaceName()).getSentence(),new Dialogue(homeofseaPane.getPlaceName()).getFirst());
                break;
            case "weapons":
                WeaponsPane weaponsPane = MainFramePane.getInstance().weaponsPane;
                if (!weaponsPane.isVisible() && mapButton.getVisiable(TimeSingleton.getInstance().getCurrentTime())){
                    weaponsPane.setVisible(true);
                };
                weaponsPane.dialogBegin(weaponsPane.getPlaceName(), new String[]{"我来到了武器店","欢迎光临"},1);

                break;

            case "hotel":
                HotelPane hotelPane = MainFramePane.getInstance().hotelPane;
                if (!hotelPane.isVisible() && mapButton.getVisiable(TimeSingleton.getInstance().getCurrentTime())){
                    hotelPane.setVisible(true);
                };
                hotelPane.dialogBegin(hotelPane.getPlaceName(), new String[]{"我来到了旅馆","欢迎光临"},1);

                break;

            case "level":
                LevelPane levelPane = MainFramePane.getInstance().levelPane;
                if (!levelPane.isVisible() && mapButton.getVisiable(TimeSingleton.getInstance().getCurrentTime())){
                    levelPane.setVisible(true);
                };
                levelPane.dialogBegin(levelPane.getPlaceName(), new String[]{"我来到了等级店","欢迎光临"},1);

                break;
            case "bistro":
                BistroPane bistroPane = MainFramePane.getInstance().bistroPane;
                if (!bistroPane.isVisible() && mapButton.getVisiable(TimeSingleton.getInstance().getCurrentTime())){
                    bistroPane.setVisible(true);
                };
                bistroPane.dialogBegin(bistroPane.getPlaceName(), new String[]{"我来到了酒馆","欢迎光临"},1);

                break;

            case "maze":
                MazePane mazePane = MainFramePane.getInstance().mazePane;
                if (!mazePane.isVisible() && mapButton.getVisiable(TimeSingleton.getInstance().getCurrentTime())){
                    mazePane.setVisible(true);
                    System.out.println("q");
                };
                System.out.println("qw");
        }
    }

}
