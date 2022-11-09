package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract  class AbstractWorldMap implements  IWorldMap{

    protected List<Animal> animals = new ArrayList<>();
    protected List<Grass> grassPositions = new ArrayList<>();
    protected Vector2d lowerLeft;
    protected Vector2d upperRight;

    public abstract Vector2d getUpperRight();

    public abstract Vector2d getLowerLeft();

    public AbstractWorldMap(int llx, int lly, int urx, int ury){
        this.lowerLeft = new Vector2d(llx, lly);
        this.upperRight = new Vector2d(urx, ury);
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
        for(Grass grass : this.grassPositions){
            if (grass.getPosition().equals(position)) return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position){
        for (Animal animal : this.animals){
            if (animal.getPosition().equals(position))
                return animal;
        }
        for (Grass grass : this.grassPositions){
            if (grass.getPosition().equals(position))
                return grass;
        }
        return null;
    }




    @Override
    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(this.getLowerLeft(), this.getUpperRight());
    }

}
