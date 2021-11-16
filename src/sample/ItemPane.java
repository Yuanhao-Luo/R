package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ItemPane extends Pane {
    String url;
    ImageView imageView;

    public ItemPane(int num){
        super();
        int[] itemx = {190,287,383,477,572,674,765};
        int itemy = 595;
        setLayoutX(itemx[num]);
        setLayoutY(itemy);

        imageView = new ImageView();
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        getChildren().add(imageView);
    }

    public void setImage(String url){
        this.url = url;
        Image image = new Image("file:"+url);
        imageView.setImage(image);
    }
}
