package sample.buttons;


import javafx.scene.control.Label;
import javafx.scene.text.Font;
import sample.MainFramePane;
import sample.TentPane;

public class StartBattleButton extends TextButton {
    public StartBattleButton(String text, String type, int X, int Y) {
        super(text, type, X, Y);
//        setOnMouseClicked(e->{
//            TentPane tentPane = MainFramePane.getInstance().tentPane;
//            if (!tentPane.isVisible()){
//                tentPane.setVisible(true);
//            }
//        });
    }
}