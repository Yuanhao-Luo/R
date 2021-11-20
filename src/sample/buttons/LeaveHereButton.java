package sample.buttons;

import sample.MainFramePane;

public class LeaveHereButton extends ActionDialogButton {
    public LeaveHereButton(String text, String type, int X, int Y, String placeName, String actionName) {
        super(text, type, X, Y, placeName, actionName);
        setOnMouseClicked(e -> {
            switch (placeName){
                case "homeofsea":
                    MainFramePane.getInstance().homeofseaPane.setVisible(false);
                    MainFramePane.getInstance().homeofseaPane.getChildren().remove(8);
                    break;
                case "weapons":
                    MainFramePane.getInstance().weaponsPane.setVisible(false);
                    MainFramePane.getInstance().weaponsPane.getChildren().remove(8);
                    break;
                case "hotel":
                    MainFramePane.getInstance().hotelPane.setVisible(false);
                    MainFramePane.getInstance().hotelPane.getChildren().remove(8);
                    break;
                case "level":
                    MainFramePane.getInstance().levelPane.setVisible(false);
                    MainFramePane.getInstance().levelPane.getChildren().remove(8);
                    break;
                case "bistro":
                    MainFramePane.getInstance().bistroPane.setVisible(false);
                    MainFramePane.getInstance().bistroPane.getChildren().remove(8);
                    break;

            }

        });
    }
}
