package sample.specificPlace;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import sample.characterSystem.Person;
import sample.itemSystem.Arms;
import sample.itemSystem.Item;

public class GoodPane extends Pane {
    String url;
    boolean select = false;
    boolean selectable = false;
    ImageView imageView;
    ImageView hover;
    ImageView bet;
    ImageView cooldownClock;
    ImageView cooldown;
    Label currentCooldownLabel;
    int index;


    public GoodPane(int num){
        super();
        index = num;
        int[] itemx = {177,275,373,470,564,659,755};
        int itemy = 88;
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

        cooldownClock = new ImageView(new Image("file:.\\images\\cooldown_clock.png"));
        cooldownClock.setVisible(false);
        getChildren().add(cooldownClock);

        cooldown = new ImageView(new Image("file:.\\images\\cooldown.png"));
        cooldown.setVisible(false);
        getChildren().add(cooldown);

        currentCooldownLabel = new Label();
        currentCooldownLabel.setVisible(false);
        getChildren().add(currentCooldownLabel);

        setOnMouseEntered(e -> {
            if (isSelectable()){
                hover.setVisible(true);

            }
        });
        setOnMouseExited(e -> {
            if (isSelectable()){
                hover.setVisible(false);

            }
        });
        setOnMouseReleased(e -> {



            //System.out.println(index);
            if (isSelectable()){
                setSelect(!isSelect());
            }
        });
    }

    public void setImage(String url){
        this.url = url;
        Image image = new Image("file:"+url);
        imageView.setImage(image);
    }

    public int getIndex() {
        return index;
    }

    public boolean isSelect() {
        return select;
    }

    public boolean isSelectable() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }

    public void setSelect(boolean select) {
        this.select = select;
        bet.setVisible(select);

    }

    public void changeCooldown(int currentCooldown){
        if (currentCooldown > 0){
            setSelectable(false);
            cooldownClock.setVisible(true);
            cooldown.setVisible(true);
            currentCooldownLabel.setVisible(true);
            currentCooldownLabel.setText(String.valueOf(currentCooldown));
        }else {
            setSelectable(true);
            cooldownClock.setVisible(false);
            cooldown.setVisible(false);
            currentCooldownLabel.setVisible(false);
        }

    }

    public void refresh(Item item){
        setSelect(false);
        if (item == null){
            setSelectable(false);
            imageView.setVisible(false);
            return;
        }
        setSelectable(true);
        setImage(item.getUrl());
        imageView.setVisible(true);
        if (item instanceof Arms){
            Arms a = (Arms) item;
            changeCooldown(a.getCurrentCoolDown());
        }
    }
}
