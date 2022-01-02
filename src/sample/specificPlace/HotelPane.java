package sample.specificPlace;

import javafx.scene.layout.Pane;
import sample.ImageProcess;

import java.io.FileNotFoundException;

public class HotelPane extends GeneralPlacePane {
    Pane hotelYou = new Pane();
    public HotelPane() throws FileNotFoundException {
        super("hotel");

        this.getChildren().add(hotelYou);
        ImageProcess.initDialogYouImage(hotelYou,".\\images\\hotelYou.png");
        ImageProcess.setXY(hotelYou,500,160);

    }
}