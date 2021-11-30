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
            BattlePane battlePane = BattlePane.getInstance();
            battle.startBattle();
            int result = battle.getResult();
            int mondamage = battle.getMonsterDamage();
            int perdamage = battle.getPersonDamage();

            battlePane.monsterDamage.setText(String.valueOf(mondamage));
            battlePane.personDamage.setText(String.valueOf(perdamage));
            battlePane.monsterDamage.setVisible(true);
            battlePane.personDamage.setVisible(true);

            if (result == 1){
                BattlePane.getInstance().concludBattle();
                System.out.println("monster die");
            }else if (result == 2){
                //死亡页面



            }

            battlePane.refreshall();
        });
    }
}
