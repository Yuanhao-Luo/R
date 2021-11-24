package sample.specificPlace;

import javafx.scene.layout.Pane;
import sample.ImageProcess;

public class LevelPane extends GeneralPlacePane {
    Pane levelYou = new Pane();
    public LevelPane(){
        super("level");

        this.getChildren().add(levelYou);
        ImageProcess.initDialogYouImage(levelYou,".\\images\\levelYou.png");
        ImageProcess.setXY(levelYou,500,160);

    }
}