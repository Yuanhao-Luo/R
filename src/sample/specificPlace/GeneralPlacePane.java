package sample.specificPlace;

import javafx.scene.layout.Pane;
import sample.ImageProcess;
import sample.MainFramePane;
import sample.buttons.ActionButton;
import sample.buttons.OpenTentButton;

public class GeneralPlacePane extends Pane {
    Pane homeofseaYou = new Pane();
    Pane DialogMe = new Pane();
    String actionName;
    int actionButtonX = 10;
    int firstActionButtonY = 150;
    int actionbuttonInterval = 75;
    ActionButton beyeButton = new ActionButton(".\\images\\eyeButton_pressable.png",".\\images\\eyeButton_unpressable.png",".\\images\\eyeButton_pressable.png",".\\images\\eyeButton_pressed.png",actionName);
    ActionButton bmouthButton = new ActionButton(".\\images\\mouthButton_pressable.png",".\\images\\mouthButton_unpressable.png",".\\images\\mouthButton_pressable.png",".\\images\\mouthButton_pressed.png",actionName);
    ActionButton bhandButton = new ActionButton(".\\images\\handButton_pressable.png",".\\images\\handButton_unpressable.png",".\\images\\handButton_pressable.png",".\\images\\handButton_pressed.png",actionName);
    ActionButton battackButton = new ActionButton(".\\images\\attackButton_pressable.png",".\\images\\attackButton_unpressable.png",".\\images\\attackButton_pressable.png",".\\images\\attackButton_pressed.png",actionName);
    ActionButton bfootButton = new ActionButton(".\\images\\footButton_pressable.png",".\\images\\footButton_unpressable.png",".\\images\\footButton_pressable.png",".\\images\\footButton_pressed.png",actionName);


    public GeneralPlacePane(){
        ImageProcess.addImage(this,".\\images\\homeofseaBackground.png");

        this.getChildren().add(homeofseaYou);
        this.getChildren().add(DialogMe);

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

        ImageProcess.initDialogYouImage(homeofseaYou,".\\images\\homeofseaYou.png");
        ImageProcess.initDialogMeImage(DialogMe,".\\images\\DialogMe.png");
    }
}
