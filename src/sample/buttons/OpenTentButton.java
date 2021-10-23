package sample.buttons;


import javafx.scene.control.Label;
import javafx.scene.text.Font;
import sample.MainFramePane;
import sample.TentPane;

public class OpenTentButton extends GeneralButton {
    public Label openTentLabel = new Label("打开帐篷");

    public OpenTentButton(String s0, String s1, String s2, String s3) {
        super(s0, s1, s2, s3);
        setOnMouseClicked(e->{
            TentPane tentPane = MainFramePane.getInstance().tentPane;
            if (!tentPane.isVisible()){
                tentPane.setVisible(true);
            }
        });
        openTentLabel.setFont(Font.font("Kaiti",25));
        this.getChildren().add(openTentLabel);
    }
}
