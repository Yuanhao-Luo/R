package sample.MazePart;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import sample.ImageProcess;

public class CardPane extends Pane {
    private Card card;

    public CardPane(){}

    public CardPane(Card card){
        ImageProcess.addImage(this,card.getUrl());
    }

    public Card getCard() {
        return card;
    }
}
