package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ItemPane extends Pane {
    String url;
    ImageView imageView;
    boolean select = false;
    ImageView hover;
    ImageView bet;


    public ItemPane(int num){
        super();
        int[] itemx = {177,275,373,470,564,659,755};
        int itemy = 595;
        setLayoutX(itemx[num%7]);
        setLayoutY(itemy);
        setVisible(false);

        imageView = new ImageView();
        imageView.setFitWidth(88);
        imageView.setFitHeight(88);
        getChildren().add(imageView);

        hover = new ImageView(new Image("file:.\\images\\Item_hover.png"));
        hover.setVisible(false);
        getChildren().add(hover);

        bet = new ImageView(new Image("file:.\\images\\bet.png"));
        bet.setVisible(false);
        bet.setX(3.6);
        bet.setY(3);
        getChildren().add(bet);

        setOnMouseEntered(e -> {
            hover.setVisible(true);
        });
        setOnMouseExited(e -> {
            hover.setVisible(false);
        });
        setOnMouseReleased(e -> {
            setSelect(!isSelect());
            System.out.println("adsfouhiaoeiuhfa");
        });
    }

    public void setImage(String url){
        this.url = url;
        Image image = new Image("file:"+url);
        imageView.setImage(image);
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
        bet.setVisible(select);
    }


}
