package sample.buttons;

import javafx.scene.control.Label;

public class ActionButton extends GeneralButton {
    public ActionButton(String s0, String s1, String s2, String s3, String actionName){
        super(s0, s1, s2, s3);
        this.actionName = actionName;
    }
    String actionName;
}
