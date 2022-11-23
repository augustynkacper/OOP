package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.HashMap;

public class App extends Application {

    private int size = 20;


    public void start(Stage stage){

        try {
            String[] s = {"f", "f", "b", "r", "l", "l", "f", "f", "f", "f", "l", "f", "f", "f", "r", "f", "f", "f", "f", "f", "f", "f", "f", "f"};
            MoveDirection[] directions = (new OptionsParser()).parse(s);
            GrassField map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(3, 4), new Vector2d(8, 8), new Vector2d(9, 3)};
            IEngine engine = new SimulationEngine(map, directions, positions);
            engine.run();
            System.out.println(map);

            Vector2d[] objects = map.getObjects();
            Vector2d ll = map.getLowerLeft();
            Vector2d ur = map.getUpperRight();

            int width = (ur.getX() - ll.getX() + 2) * this.size;
            int height = (ur.getY() - ll.getY() + 2) * this.size;

            // ====================================
            // initialize grid
            GridPane grid = new GridPane();
            grid.setGridLinesVisible(true);
            grid.getColumnConstraints().add(new ColumnConstraints(this.size));
            grid.getRowConstraints().add(new RowConstraints(this.size));
            // axis names
            grid.add(new Label("y\\x"), 0, 0);

            // x coordinates
            int x = 1;
            for (int i = ll.getX(); i <= ur.getX(); i++) {
                Label l = new Label(String.valueOf(i));
                grid.add(l, x, 0);
                grid.setHalignment(l, HPos.CENTER);
                grid.getColumnConstraints().add(new ColumnConstraints(this.size));
                x++;
            }

            // y coordinates
            int y = 1;
            for (int i = ll.getY(); i <= ur.getY(); i++) {
                Label l = new Label(String.valueOf(ur.getY() - i));
                grid.add(l, 0, y);
                grid.setHalignment(l, HPos.CENTER);
                grid.getRowConstraints().add(new RowConstraints(this.size));
                y++;
            }

            for (Vector2d v : objects) {
                Object obj = map.objectAt(v);
                Label l = new Label(obj.toString());
                grid.setHalignment(l, HPos.CENTER);
                grid.add(l, 1 + v.getX(), 1 + ur.getY() - v.getY());
            }

            Scene scene = new Scene(grid, width, height);
            stage.setScene(scene);
            stage.show();
        } catch(IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }


    }




}
