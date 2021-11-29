package sample.buttons;


import javafx.scene.control.Label;
import javafx.scene.text.Font;
import sample.BattlePane;
import sample.MainFramePane;
import sample.TentPane;
import sample.battle.Battle;

public class StartBattleButton extends TextButton {
    public StartBattleButton(String text, String type, int X, int Y) {
        super(text, type, X, Y);
        setOnMouseReleased(e->{
            Battle battle = Battle.getInstance();
            int result = battle.startBattle();
            if (result == 1){
                BattlePane.getInstance().concludBattle();
            }else if (result == 2){
                //死亡页面



            }
        });
    }
}
