package agh.ics.oop;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{

    private final int width;
    private final int height;

    private final MapVisualizer visualizer = new MapVisualizer(this);


    public RectangularMap(int width, int height){
        super(0,0,width,height);
        this.width = width;
        this.height = height;
        this.animals = new LinkedHashMap<>();
    }


    @Override
    public boolean place(Animal animal){
        if ( !this.isOccupied(animal.getPosition())) {
            this.animals.put(animal.getPosition(), animal);
            animal.addObserver(this);
            return true;
        }else {
            throw new IllegalArgumentException(animal.getPosition() + " is already taken");
        }
    }

    private Animal getAnimalAt(Vector2d pos){
        return animals.get(pos);
    }

    @Override
    public Object objectAt(Vector2d pos){
        Animal a = getAnimalAt(pos);
        if (a != null) return a;
        return null;
    }


    @Override
    public Vector2d getLowerLeft(){
        return new Vector2d(0, 0);
    }

    @Override
    public Vector2d getUpperRight(){
        return new Vector2d(this.width, this.height);
    }
}
