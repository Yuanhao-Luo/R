package sample.specificPlace;

import javafx.scene.layout.Pane;
import sample.ImageProcess;

public class HotelPane extends GeneralPlacePane {
    Pane hotelYou = new Pane();
    public HotelPane(){
        super("hotel");

        this.getChildren().add(hotelYou);
        ImageProcess.initDialogYouImage(hotelYou,".\\images\\hotelYou.png");
        ImageProcess.setXY(hotelYou,500,160);

    }
}