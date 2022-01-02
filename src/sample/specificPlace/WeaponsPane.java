package sample.specificPlace;

import javafx.scene.layout.Pane;
import sample.ImageProcess;

import java.io.FileNotFoundException;

public class WeaponsPane extends GeneralPlacePane {
    Pane weaponsYou = new Pane();
    public WeaponsPane() throws FileNotFoundException {
        super("weapons");

        this.getChildren().add(weaponsYou);
        ImageProcess.initDialogYouImage(weaponsYou,".\\images\\weaponsYou.png");
        ImageProcess.setXY(weaponsYou,500,160);
        this.getChildren().add(weaponShopPane);
    }
}