package sample.buttons;


import javafx.scene.control.Label;
import javafx.scene.text.Font;
import sample.MainFramePane;
import sample.TentPane;

public class OpenTentButton extends TextButton {
    //这个放在最高层级上
    public OpenTentButton(String text, String type, int X, int Y) {
        super(text, type, X, Y);
        setOnMouseClicked(e->{
            TentPane tentPane = TentPane.getInstance();
            if (!tentPane.isVisible()){
                tentPane.setVisible(true);
                tentPane.refreshNum();
                tentPane.getItemListPane().refreshAll();
            }
        });
    }
}
