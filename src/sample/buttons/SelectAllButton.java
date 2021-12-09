package sample.buttons;


import javafx.scene.control.Label;
import javafx.scene.text.Font;
import sample.BattlePane;
import sample.ItemPane;
import sample.MainFramePane;
import sample.TentPane;

public class SelectAllButton extends TextButton {
    public SelectAllButton(String text, String type, int X, int Y) {
        super(text, type, X, Y);
        setOnMouseReleased(e->{
//            BattlePane battlePane = BattlePane.getInstance();
//            for (ItemPane i :
//                    battlePane.getItemListPane().getItemList()) {
//                if (i.isSelectable()) {
//                    i.setSelect(true);
//                }
//            }
//            battlePane.getItemListPane().getItemList();
        });
    }
}

