package sample.buttons;

import sample.MainFramePane;

public class LeaveHereButton extends ActionDialogButton {
    public LeaveHereButton(String text, String type, int X, int Y, String placeName, String actionName) {
        super(text, type, X, Y, placeName, actionName);
        setOnMouseClicked(e -> {
            MainFramePane.getInstance().homeofseaPane.setVisible(false);
            MainFramePane.getInstance().homeofseaPane.getChildren().remove(8);
        });
    }
}
