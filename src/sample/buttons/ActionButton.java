package sample.buttons;

import sample.specificPlace.ActionDialogPane;
import sample.specificPlace.GeneralPlacePane;

public class ActionButton extends GeneralButton {
    public ActionButton(GeneralPlacePane gpp, String s0, String s1, String s2, String s3, String placeName, String actionName){
        super(s0, s1, s2, s3);
        this.actionName = actionName;
        this.placeName = placeName;
        this.gpp = gpp;

        setOnMouseClicked(e->{
            openActionDialogPane();
        });
    }
    String actionName;
    String placeName;
    GeneralPlacePane gpp;

    public void openActionDialogPane(){
        ActionDialogPane actionDialogPane = new ActionDialogPane(placeName,actionName);
        try{
            gpp.getChildren().remove(8);
        }
        catch (Exception ignored){
        }
        gpp.getChildren().add(actionDialogPane);
        actionDialogPane.setVisible(true);
    }
}
