package sample.specificPlace;

import javafx.scene.layout.Pane;
import sample.ImageProcess;

import java.io.FileNotFoundException;

public class LevelPane extends GeneralPlacePane {
    Pane levelYou = new Pane();
    public LevelPane() throws FileNotFoundException {
        super("level");

        this.getChildren().add(levelYou);
        ImageProcess.initDialogYouImage(levelYou,".\\images\\levelYou.png");
        ImageProcess.setXY(levelYou,500,160);

    }
}