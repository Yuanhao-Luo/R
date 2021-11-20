package sample.specificPlace;

import javafx.scene.layout.Pane;
import sample.ImageProcess;

public class BistroPane extends GeneralPlacePane {
    Pane bistroYou = new Pane();
    public BistroPane(){
        super("bistro");
        this.getChildren().add(bistroYou);
        ImageProcess.initDialogYouImage(bistroYou,".\\images\\bistroYou.png");
        ImageProcess.setXY(bistroYou,500,160);

    }
}