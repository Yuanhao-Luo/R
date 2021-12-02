package sample.buttons;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import sample.MainFramePane;
import sample.TentPane;

public class TextButton extends GeneralButton {
    String text = "";
    Label textLabel = new Label(text);

    public TextButton(String text, String type, int X, int Y) {
        super(".\\images\\normalButton" + type + "_hover.png", ".\\images\\normalButton" + type + "_unpressable.png", ".\\images\\normalButton" + type + "_pressable.png", ".\\images\\normalButton" + type + "_pressed.png");
        this.text = text;
        addButtonEvent();
        setLayoutX(X);
        setLayoutY(Y);
        textLabel.setText(text);
        getChildren().add(textLabel);
        switch (type){
            case "200":
                this.textLabel.setLayoutY(6);
                textLabel.setFont(Font.font("Kaiti",25));
                break;
            case "400":
                this.textLabel.setLayoutY(7);
                textLabel.setFont(Font.font("Kaiti",25));
                break;
        }
    }
}
