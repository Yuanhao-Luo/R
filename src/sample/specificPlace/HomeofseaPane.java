package sample.specificPlace;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import sample.ImageProcess;
import sample.ItemListPane;
import sample.buttons.TextButton;
import sample.characterSystem.Person;
import sample.itemSystem.Item;
import sample.itemSystem.SimpleFactory;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class HomeofseaPane extends GeneralPlacePane {


    Pane homeofseaYou = new Pane();

    public HomeofseaPane() throws FileNotFoundException {
        super("homeofsea");

        this.getChildren().add(homeofseaYou);
        ImageProcess.initDialogYouImage(homeofseaYou,".\\images\\homeofseaYou.png");
        ImageProcess.setXY(homeofseaYou,500,160);
        this.getChildren().add(shopPane);


    }


}
