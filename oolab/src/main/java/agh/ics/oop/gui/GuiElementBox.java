package agh.ics.oop.gui;

import agh.ics.oop.IMapElement;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    public VBox vbox = new VBox();

    public GuiElementBox(IMapElement element) throws FileNotFoundException {

        Image image = new Image(new FileInputStream(element.getImagePath()));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        Label label = new Label(element.getPosition().toString());

        this.vbox.getChildren().addAll(imageView, label);
        this.vbox.setAlignment(Pos.CENTER);
    }
}
