package sample.specificPlace;

import javafx.scene.layout.Pane;
import sample.ImageProcess;
import sample.buttons.ActionDialogButton;
import sample.buttons.LeaveHereButton;

import java.util.Objects;

public class ActionDialogPane extends Pane {
    String actionName;
    String placeName;
    public ActionDialogPane(String placeName, String actionName){
        this.setLayoutX(200);
        this.placeName = placeName;
        this.actionName = actionName;
        if (Objects.equals(actionName, "foot")){
            adb1 = new LeaveHereButton("      从这里离开","400", actionDialogButtonX,actionDialogButtonYCalculator(actionName,1),placeName,actionName);
        }
        else{
            adb1 = new ActionDialogButton("      这是一段测试用对话","400", actionDialogButtonX,actionDialogButtonYCalculator(actionName,1),placeName,actionName);
        }
        adb2 = new ActionDialogButton("      这是二段测试用对话","400", actionDialogButtonX,actionDialogButtonYCalculator(actionName,2),placeName,actionName);
        adb3 = new ActionDialogButton("      这是三段测试用对话","400", actionDialogButtonX,actionDialogButtonYCalculator(actionName,3),placeName,actionName);
        this.getChildren().add(adb1);
        this.getChildren().add(adb2);
        this.getChildren().add(adb3);
    }


    int secondActionDialogButtonY = GeneralPlacePane.firstActionButtonY + 30;
    int actionDialogButtonX = -100;
    int differentActionInterval = GeneralPlacePane.actionbuttonInterval;
    int differentDialogInterval = 56;
    ActionDialogButton adb1;
    ActionDialogButton adb2;
    ActionDialogButton adb3;

    public int actionDialogButtonYCalculator(String actionName, int number){
        int Y;

        switch(actionName){
            case "eye":
                Y = secondActionDialogButtonY - differentActionInterval;
                break;
            case "mouth":
                Y = secondActionDialogButtonY;
                break;
            case "hand":
                Y = secondActionDialogButtonY + differentActionInterval;
                break;
            case "attack":
                Y = secondActionDialogButtonY + 2 * differentActionInterval;
                break;
            case "foot":
                Y = secondActionDialogButtonY + 3 * differentActionInterval;
                break;
            default:
                Y = -10000;
        }
        return Y + (number-1) * differentDialogInterval;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }
}
