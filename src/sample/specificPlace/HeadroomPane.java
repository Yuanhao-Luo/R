package sample.specificPlace;

import javafx.scene.layout.Pane;
import sample.ImageProcess;

import java.io.FileNotFoundException;

public class HeadroomPane extends GeneralPlacePane {
    Pane headroomYou = new Pane();
    public HeadroomPane() throws FileNotFoundException {
        super("headroom");

        this.getChildren().add(headroomYou);
        ImageProcess.initDialogYouImage(headroomYou,".\\images\\headroomYou.png");
        ImageProcess.setXY(headroomYou,350,160);
    }
}
