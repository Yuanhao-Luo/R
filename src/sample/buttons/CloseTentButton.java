package sample.buttons;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import sample.MainFramePane;
import sample.buttons.GeneralButton;

public class CloseTentButton extends GeneralButton {
    Label closeTentLabel = new Label("关闭帐篷");

    public CloseTentButton(String s0, String s1, String s2, String s3) {
        super(s0, s1, s2, s3);
        addButtonEvent();
        setOnMouseClicked(e -> {
            MainFramePane.getInstance().tentPane.setVisible(false);
        });
        setLayoutX(900);
        setLayoutY(700);
        closeTentLabel.setFont(Font.font("Kaiti",25));
        getChildren().add(closeTentLabel);
    }
}
