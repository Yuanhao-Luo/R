package sample.specificPlace;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import sample.ImageProcess;
import sample.ItemListPane;
import sample.buttons.ActionDialogButton;
import sample.buttons.LeaveHereButton;
import sample.buttons.TextButton;
import sample.characterSystem.Person;
import sample.characterSystem.Schedule;
import sample.itemSystem.Item;
import sample.itemSystem.SimpleFactory;

import java.util.ArrayList;
import java.util.Objects;

public class ActionDialogPane extends Pane {

    public ActionDialogPane(GeneralPlacePane gpp,String placeName, String actionName){
        this.setLayoutX(200);
        this.placeName = placeName;
        this.actionName = actionName;
        adb1 = new ActionDialogButton("      "+new Dialogue(placeName+actionName+"1").getButton(),"400", actionDialogButtonX,actionDialogButtonYCalculator(actionName,1),placeName,actionName);
        adb2 = new ActionDialogButton("      "+new Dialogue(placeName+actionName+"2").getButton(),"400", actionDialogButtonX,actionDialogButtonYCalculator(actionName,2),placeName,actionName);
        adb3 = new ActionDialogButton("      "+new Dialogue(placeName+actionName+"3").getButton(),"400", actionDialogButtonX,actionDialogButtonYCalculator(actionName,3),placeName,actionName);
        adb1.setOnMouseClicked(e->{ gpp.dialogBegin(placeName,actionName,1,new Dialogue(placeName+actionName+"1").getSentence(),new Dialogue(placeName+actionName+"1").getFirst()); });
        adb2.setOnMouseClicked(e->{ gpp.dialogBegin(placeName,actionName,2,new Dialogue(placeName+actionName+"2").getSentence(),new Dialogue(placeName+actionName+"2").getFirst()); });
        adb3.setOnMouseClicked(e->{ gpp.dialogBegin(placeName,actionName,3,new Dialogue(placeName+actionName+"3").getSentence(),new Dialogue(placeName+actionName+"3").getFirst()); });

        switch (actionName){

            case "eye":
                switch (placeName){
                    case "homeofsea":
                        adb3.setOnMouseClicked(e->{
                            gpp.dialogBegin(placeName,actionName,3,new Dialogue(placeName+actionName+"3").getSentence(),new Dialogue(placeName+actionName+"3").getFirst(),"openHomeofseaShop");
                        });

                        break;
                    case "weapons":
                        adb2.setOnMouseClicked(e->{
                            gpp.dialogBegin(placeName,actionName,2,new Dialogue(placeName+actionName+"2").getSentence(),new Dialogue(placeName+actionName+"2").getFirst(),"openWeaponShop");
                        });
                        break;
//                    default:
//                        adb1 = new ActionDialogButton("      ???????????????????????????","400", actionDialogButtonX,actionDialogButtonYCalculator(actionName,1),placeName,actionName);
//                        adb1.setOnMouseClicked(e->{
//                            gpp.dialogBegin(placeName,actionName,1,new String[]{"???????????????????????????","??????"},2);
//                        });
                }
                break;
            case "mouth":
                switch (placeName){
                    case "bistro":
                        if (Person.getInstance().getSchedule() == Schedule.START){
                            adb3.setOnMouseClicked(e->{
                                gpp.dialogBegin(placeName,actionName,3,new Dialogue(placeName+actionName+"3"+"0").getSentence(),new Dialogue(placeName+actionName+"3"+"0").getFirst());
                                Person.getInstance().setSchedule(Schedule.BEAT_THIEF);
                            });
                        }else if (Person.getInstance().getSchedule() == Schedule.GET_DAUGHTER){
                            adb3 = new ActionDialogButton("      ??????????????????","400", actionDialogButtonX,actionDialogButtonYCalculator(actionName,3),placeName,actionName);
                            adb3.setOnMouseClicked(e->{
                                gpp.dialogBegin(placeName,actionName,3,new Dialogue(placeName+actionName+"3"+"2").getSentence(),new Dialogue(placeName+actionName+"3"+"2").getFirst(),"congratulations");
                                Person.getInstance().setSchedule(Schedule.FINISH);
                            });
                        }else if (Person.getInstance().getSchedule() == Schedule.FINISH){
                            adb3 = new ActionDialogButton("      ?????????????????????","400", actionDialogButtonX,actionDialogButtonYCalculator(actionName,3),placeName,actionName);
                            adb3.setOnMouseClicked(e->{
                                gpp.dialogBegin(placeName,actionName,3,new Dialogue(placeName+actionName+"3"+"3").getSentence(),new Dialogue(placeName+actionName+"3"+"3").getFirst());
                                Person.getInstance().setSchedule(Schedule.FINISH);
                            });
                        }

                }
            case "hand":
                switch (placeName){
                    case "level" :
                        adb1 = new ActionDialogButton("      ??????","400", actionDialogButtonX,actionDialogButtonYCalculator(actionName,1),placeName,actionName);
                        if (Person.getInstance().canLevelUp()){
                            adb1.setOnMouseClicked(e->{
                                gpp.dialogBegin(placeName,actionName,1,new String[]{"???"},2,"levelUp");
                            });
                        }else {
                            adb1.setOnMouseClicked(e->{
                                gpp.dialogBegin(placeName,actionName,1,new String[]{"????????????"},2);
                            });
                        }


                }

            case "attack":
                switch (placeName){
                    case "headroom":
                        adb3.setOnMouseClicked(e->{
                            gpp.dialogBegin(placeName,actionName,3,new Dialogue(placeName+actionName+"3").getSentence(),new Dialogue(placeName+actionName+"3").getFirst(),"attackHead");
                        });
                }

                break;

            case "foot":
                adb1 = new LeaveHereButton("      ???????????????","400", actionDialogButtonX,actionDialogButtonYCalculator(actionName,1),placeName,actionName);
                adb2 = new LeaveHereButton("      ???????????????","400", actionDialogButtonX,actionDialogButtonYCalculator(actionName,2),placeName,actionName);
                adb3 = new LeaveHereButton("      ???????????????","400", actionDialogButtonX,actionDialogButtonYCalculator(actionName,3),placeName,actionName);
                break;
//            default:
//                adb1 = new ActionDialogButton("      ???????????????????????????","400", actionDialogButtonX,actionDialogButtonYCalculator(actionName,1),placeName,actionName);
//                adb1.setOnMouseClicked(e->{
//                    gpp.dialogBegin(placeName,actionName,1,new String[]{"???????????????????????????","??????"},2);
//                });
        }
//        if (Objects.equals(actionName, "foot")){
//            adb1 = new LeaveHereButton("      ???????????????","400", actionDialogButtonX,actionDialogButtonYCalculator(actionName,1),placeName,actionName);
//        }
//        else{
//            adb1 = new ActionDialogButton("      ???????????????????????????","400", actionDialogButtonX,actionDialogButtonYCalculator(actionName,1),placeName,actionName);
//            adb1.setOnMouseClicked(e->{
//                gpp.dialogBegin(placeName,actionName,1,new String[]{"???????????????????????????","??????"},2);
//            });
//        }
        this.getChildren().add(adb1);
        this.getChildren().add(adb2);
        this.getChildren().add(adb3);

    }

    String actionName;
    String placeName;
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
