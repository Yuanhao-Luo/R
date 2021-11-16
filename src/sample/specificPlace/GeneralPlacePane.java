package sample.specificPlace;

import javafx.scene.layout.Pane;
import sample.ImageProcess;
import sample.MainFramePane;
import sample.TimeSingleton;
import sample.buttons.ActionButton;

public class GeneralPlacePane extends Pane {
    Pane dialogMe = new Pane();
    String placeName;
    int actionButtonX = 10;
    static final int firstActionButtonY = 150;
    static final int actionbuttonInterval = 82;
    ActionButton beyeButton;
    ActionButton bmouthButton;
    ActionButton bhandButton;
    ActionButton battackButton;
    ActionButton bfootButton;


    public GeneralPlacePane(String placeName){
        this.placeName = placeName;
        beyeButton = new ActionButton(this,".\\images\\eyeButton_hover.png",".\\images\\eyeButton_unpressable.png",".\\images\\eyeButton_pressable.png",".\\images\\eyeButton_pressed.png",placeName,"eye");
        bmouthButton = new ActionButton(this,".\\images\\mouthButton_hover.png",".\\images\\mouthButton_unpressable.png",".\\images\\mouthButton_pressable.png",".\\images\\mouthButton_pressed.png",placeName,"mouth");
        bhandButton = new ActionButton(this,".\\images\\handButton_hover.png",".\\images\\handButton_unpressable.png",".\\images\\handButton_pressable.png",".\\images\\handButton_pressed.png",placeName,"hand");
        battackButton = new ActionButton(this,".\\images\\attackButton_hover.png",".\\images\\attackButton_unpressable.png",".\\images\\attackButton_pressable.png",".\\images\\attackButton_pressed.png",placeName,"attack");
        bfootButton = new ActionButton(this,".\\images\\footButton_hover.png",".\\images\\footButton_unpressable.png",".\\images\\footButton_pressable.png",".\\images\\footButton_pressed.png",placeName,"foot");

        ImageProcess.addImage(this,".\\images\\" + placeName + "Background.png");
        this.getChildren().add(dialogMe);
//        ImageProcess.setXY(dialogMe,220,320);

        this.getChildren().add(beyeButton);
        ImageProcess.setXY(beyeButton,actionButtonX,firstActionButtonY);

        this.getChildren().add(bmouthButton);
        ImageProcess.setXY(bmouthButton,actionButtonX,firstActionButtonY + actionbuttonInterval);

        this.getChildren().add(bhandButton);
        ImageProcess.setXY(bhandButton,actionButtonX,firstActionButtonY + actionbuttonInterval*2);

        this.getChildren().add(battackButton);
        ImageProcess.setXY(battackButton,actionButtonX,firstActionButtonY + actionbuttonInterval*3);

        this.getChildren().add(bfootButton);
        ImageProcess.setXY(bfootButton,actionButtonX,firstActionButtonY + actionbuttonInterval*4);


        ImageProcess.initDialogMeImage(dialogMe,".\\images\\dialogMe.png");
    }

}
