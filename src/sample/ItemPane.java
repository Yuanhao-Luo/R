package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ItemPane extends Pane {
    String url;
    ImageView imageView;

    public ItemPane(int num){
        super();
        int[] itemx = {177,275,373,470,564,659,755};
        int itemy = 595;
        setLayoutX(itemx[num]);
        setLayoutY(itemy);

        imageView = new ImageView();
        imageView.setFitWidth(88);
        imageView.setFitHeight(88);
        getChildren().add(imageView);
    }

    public void setImage(String url){
        this.url = url;
        Image image = new Image("file:"+url);
        imageView.setImage(image);
    }
}
