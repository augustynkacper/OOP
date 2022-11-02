package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{

    private final int width;
    private final int height;
    private List<Animal> animals;
    private final Vector2d leftDownCorner;
    private final Vector2d rightTopCorner;
    private final MapVisualizer visualizer = new MapVisualizer(this);


    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        this.animals = new ArrayList<>();
        this.leftDownCorner = new Vector2d(0, 0);
        this.rightTopCorner = new Vector2d(width-1, height-1);
    }

    @Override
    public boolean canMoveTo(Vector2d newPos){
        return newPos.follows(this.leftDownCorner) &&
                newPos.precedes(this.rightTopCorner) &&
                !isOccupied(newPos);
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

    public String toString(){
        return this.visualizer.draw(this.leftDownCorner, this.rightTopCorner);
    }
}
