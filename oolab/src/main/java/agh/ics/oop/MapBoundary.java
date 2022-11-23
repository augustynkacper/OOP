package agh.ics.oop;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;

public class MapBoundary implements IPositionChangeObserver {
    public SortedSet<Vector2d> sortedX =
            new TreeSet<>(new VectorComparator(true));
    public SortedSet<Vector2d> sortedY =
            new TreeSet<>(new VectorComparator(false));

    @Override
    public void positionChanged(Vector2d oldPos, Vector2d newPos){
        this.removeElement(oldPos);
        this.addElement(newPos);
    }

    public void removeElement(Vector2d oldPos){
        this.sortedX.remove(oldPos);
        this.sortedY.remove(oldPos);
    }

    public void addElement(Vector2d newPos){
        this.sortedX.add(newPos);
        this.sortedY.add(newPos);
    }

    public Vector2d upperRight(){
        return this.sortedX.last().upperRight(this.sortedY.last());
    }

    public Vector2d lowerLeft(){
        return this.sortedX.first().lowerLeft(this.sortedY.first());
    }
}
