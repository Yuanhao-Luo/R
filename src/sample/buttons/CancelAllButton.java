package sample.buttons;


import javafx.scene.control.Label;
import sample.BattlePane;
import sample.ItemPane;
import sample.MainFramePane;

public class CancelAllButton extends TextButton {
    public CancelAllButton(String text, String type, int X, int Y) {
        super(text, type, X, Y);
        setOnMouseReleased(e->{
            BattlePane battlePane = BattlePane.getInstance();
            for (ItemPane i :
                    battlePane.getItemList()) {
                if (i.isSelectable()){
                    i.setSelect(false);
                }
            }
        });
    }
}
