package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{

    private final int width;
    private final int height;
    private List<Animal> animals;
    private final MapVisualizer visualizer = new MapVisualizer(this);


    public RectangularMap(int width, int height){
        super(0,0,width,height);
        this.width = width;
        this.height = height;
        this.animals = new ArrayList<>();
    }


    @Override
    public boolean place(Animal animal){
        if ( this.canMoveTo(animal.getPosition())) {
            this.animals.add(animal);
            return true;
        } return false;
    }

    @Override
    public boolean isOccupied(Vector2d position){
        for (Animal animal : this.animals){
            if (animal.getPosition().equals(position))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position){
        for (Animal animal : this.animals){
            if (animal.getPosition().equals(position))
                return animal;
        }
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
