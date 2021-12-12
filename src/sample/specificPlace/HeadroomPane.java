package sample.specificPlace;

import javafx.scene.layout.Pane;
import sample.ImageProcess;

public class HeadroomPane extends GeneralPlacePane {
    Pane headroomYou = new Pane();
    public HeadroomPane(){
        super("headroom");

        this.getChildren().add(headroomYou);
        ImageProcess.initDialogYouImage(headroomYou,".\\images\\headroomYou.png");
        ImageProcess.setXY(headroomYou,350,160);
    }
}
