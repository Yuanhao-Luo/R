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
        this.getChildren().add(congratulations);
        ImageProcess.initImageView(congratulations,250,0,".\\images\\congratulations.png");
        congratulations.setVisible(false);
        congratulations.setOnMouseClicked(e->{
            congratulations.setVisible(false);
        });
    }
}