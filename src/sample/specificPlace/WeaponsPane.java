package sample.specificPlace;

import javafx.scene.layout.Pane;
import sample.ImageProcess;

public class WeaponsPane extends GeneralPlacePane {
    Pane weaponsYou = new Pane();
    public WeaponsPane(){
        super("weapons");

        this.getChildren().add(weaponsYou);
        ImageProcess.initDialogYouImage(weaponsYou,".\\images\\weaponsYou.png");
        ImageProcess.setXY(weaponsYou,500,160);

    }
}