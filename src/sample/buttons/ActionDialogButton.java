package sample.buttons;

import sample.specificPlace.GeneralPlacePane;

public class ActionDialogButton extends TextButton {

    public ActionDialogButton(String text, String type, int X, int Y, String placeName, String actionName){
        super(text, type, X, Y);
        this.actionName = actionName;
        this.placeName = placeName;
        this.setOnMouseClicked(e->{
            
        });
    }

    String actionName;
    String placeName;

}
