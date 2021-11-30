package sample;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import sample.itemPart.characterSystem.Person;
import sample.itemPart.itemSystem2.Item;
import sample.itemPart.itemSystem2.arms;

public class ItemPane extends Pane {
    String url;
    boolean select = false;
    boolean selectable = true;
    ImageView imageView;
    ImageView hover;
    ImageView bet;
    ImageView coodownClock;
    ImageView cooldown;
    Label currentCooldownLabel;
    int index;


    public ItemPane(int num){
        super();
        index = num;
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

        coodownClock = new ImageView(new Image(""));
        getChildren().add(coodownClock);

        cooldown = new ImageView(new Image(""));
        getChildren().add(cooldown);

        currentCooldownLabel = new Label();
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

        Person person = Person.getInstance();
        if (select){
            person.getSelectArms().add(person.getItemList().get(getIndex()));
        }else {
            person.getSelectArms().remove(person.getItemList().get(getIndex()));
        }
    }

    public void changeCooldown(int currentCooldown){
        if (currentCooldown > 0){
            coodownClock.setVisible(true);
            cooldown.setVisible(true);
            currentCooldownLabel.setVisible(true);
            currentCooldownLabel.setText();
        }
    }

    public void refresh(Item item){
        setImage(item.getUrl());
        if (item instanceof arms){

        }
    }
}
