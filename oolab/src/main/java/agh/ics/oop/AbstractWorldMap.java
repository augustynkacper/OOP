package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public abstract  class AbstractWorldMap implements  IWorldMap, IPositionChangeObserver{

    protected HashMap<Vector2d, Animal> animals = new LinkedHashMap<>();
    protected HashMap<Vector2d, Grass> grassPositions = new LinkedHashMap<>();
    protected Vector2d lowerLeft;
    protected Vector2d upperRight;

    public abstract Vector2d getUpperRight();

    public abstract Vector2d getLowerLeft();

    public AbstractWorldMap(int llx, int lly, int urx, int ury){
        this.lowerLeft = new Vector2d(llx, lly);
        this.upperRight = new Vector2d(urx, ury);
    }


    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition, animal);
    }


    @Override
    public boolean canMoveTo(Vector2d newPos){
        return newPos.follows(lowerLeft) &&
                newPos.precedes(upperRight) &&
                (!isOccupied(newPos) || !(objectAt(newPos) instanceof Animal));
    }

    @Override
    public boolean place(Animal animal){
        if ( !this.isOccupied(animal.getPosition()) ||
                this.objectAt(animal.getPosition()) instanceof Grass) {
            this.animals.put(animal.getPosition(), animal);
            animal.addObserver(this);
            return true;
        } return false;
    }

    @Override
    public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    }


    @Override
    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(this.getLowerLeft(), this.getUpperRight());
    }

}
