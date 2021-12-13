package sample.buttons;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import sample.BattlePane;
import sample.MainFramePane;
import sample.MazePane;
import sample.TentPane;
import sample.buttons.GeneralButton;
import sample.characterSystem.Person;

public class RunAwayButton extends TextButton {

    public RunAwayButton(String text, String type, int X, int Y) {
        super(text, type, X, Y);
        addButtonEvent();
        setOnMouseClicked(e -> {
            Person person = Person.getInstance();
            int money = person.getMoney();
            person.setMoney((int)(money - (money*0.1)));
            BattlePane.getInstance().setVisible(false);
            MazePane.getInstance().setVisible(false);
            MazePane.getInstance().jumpCard7();
            //MazePane.getInstance().currentCard = 2;
            MainFramePane.getInstance().setVisible(true);
        });
    }
}

