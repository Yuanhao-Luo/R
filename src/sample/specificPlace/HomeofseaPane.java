package sample.specificPlace;

import javafx.scene.layout.Pane;
import sample.ImageProcess;

public class HomeofseaPane extends GeneralPlacePane {
    Pane homeofseaYou = new Pane();
    public HomeofseaPane(){
        super("homeofsea");

        this.getChildren().add(homeofseaYou);
        ImageProcess.initDialogYouImage(homeofseaYou,".\\images\\homeofseaYou.png");

    }
}
