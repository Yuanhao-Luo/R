package sample.buttons;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import sample.MainFramePane;
import sample.TentPane;
import sample.buttons.GeneralButton;

public class RunAwayButton extends TextButton {

    public RunAwayButton(String text, String type, int X, int Y) {
        super(text, type, X, Y);
        addButtonEvent();
        setOnMouseClicked(e -> {
            TentPane.getInstance().setVisible(false);
        });
    }
}

