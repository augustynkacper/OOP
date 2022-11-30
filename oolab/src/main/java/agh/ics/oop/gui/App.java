package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.io.FileNotFoundException;


public class App extends Application implements IAnimalMove {

    private int size = 40;
    private GridPane grid = new GridPane();
    private GrassField map = new GrassField(10);
    private SimulationEngine engine;

    public void init(){
        String[] s = {"f", "f", "b", "r", "l", "l", "f", "f", "f", "f", "l", "f", "f", "f", "r", "f", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = (new OptionsParser()).parse(s);

        Vector2d[] positions = {new Vector2d(3, 4), new Vector2d(8,8), new Vector2d(9, 3)};
        this.engine = new SimulationEngine(map, directions, positions);
        //engine.run();
        engine.setObserver(this);

    }
    public void start(Stage stage){

        try {

            Vector2d ll = map.getLowerLeft();
            Vector2d ur = map.getUpperRight();

            int width = (ur.getX() - ll.getX() + 2) * this.size;
            int height = (ur.getY() - ll.getY() + 2) * this.size;


            Button runMoves = new Button("Run moves");
            grid.getChildren().add(runMoves);

            runMoves.setOnAction(ev -> {
                Thread engineThread = new Thread(engine);
                engineThread.start();
                grid.getChildren().clear();
                this.drawGrid(ll, ur);
                this.drawObjects(ll, ur);
            });



            Scene scene = new Scene(grid, width, height);
            stage.setScene(scene);
            stage.show();

        } catch(IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }


    }

    public void drawObjects(Vector2d ll, Vector2d ur){
        Vector2d[] objects = this.map.getObjects();
        grid.setGridLinesVisible(true);
        try {
            for (Vector2d v : objects) {
                Object obj = map.objectAt(v);
                IMapElement o;

                if (obj instanceof Animal) o = (Animal) obj;
                else o = (Grass) obj;

                GuiElementBox g = new GuiElementBox(o);
                grid.setHalignment(g.vbox, HPos.CENTER);

                grid.add(g.vbox, 1+v.getX()-ll.getX(), 1+ur.getY() - v.getY());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        }
    }


    public void drawGrid(Vector2d ll, Vector2d ur){

        grid.setGridLinesVisible(true);
        grid.getColumnConstraints().add(new ColumnConstraints(this.size));
        grid.getRowConstraints().add(new RowConstraints(this.size));
        // axis names
        Label l1 = new Label("Y \\ X");
        grid.setHalignment(l1, HPos.CENTER);
        grid.add(l1, 0, 0);

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
            Label l = new Label(String.valueOf(ll.getY()+ ur.getY() - i));
            grid.add(l, 0, y);
            grid.setHalignment(l, HPos.CENTER);
            grid.getRowConstraints().add(new RowConstraints(this.size));
            y++;
        }
    }


    @Override
    public void animalMoved(){
        Platform.runLater(() -> {
            Node n = grid.getChildren().get(0);
            grid.getChildren().clear();
            grid.getChildren().add(0, n);
            Vector2d ll = map.getLowerLeft();
            Vector2d ur = map.getUpperRight();
            this.drawObjects(ll, ur);
            this.drawGrid(ll, ur);

        });
    }

}
