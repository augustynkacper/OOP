package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class Animal extends AbstractWorldMapElement {


    private MapDirection dir;
    private IWorldMap map;
    private final List<IPositionChangeObserver> observers = new LinkedList<>();

    public Animal(IWorldMap map, Vector2d initialPosition, MapDirection initialDirection){
        super(initialPosition);
        this.map = map;
        this.dir = initialDirection;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        super(initialPosition);
        this.map = map;
        this.dir = MapDirection.NORTH;
    }

    public Animal(IWorldMap map){
        super(new Vector2d(2,2));
        this.map = map;
    }

    public Animal(){
        super(new Vector2d(2,2));
        this.dir = MapDirection.NORTH;
        this.map = new RectangularMap(5,5);
    }

    public String toString() {
        String s;
        switch(this.dir){
            case NORTH -> s = "N";
            case EAST -> s = "E";
            case SOUTH -> s = "S";
            case WEST -> s = "W";
            default -> s = "";
        }
        return s;
    }

    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer : observers) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    public MapDirection getDirection(){
        return dir;
    }

    public void move(MoveDirection direction){
        Vector2d newPos = new Vector2d(-1,-1);

        switch (direction){
            case RIGHT -> this.dir = dir.next();
            case LEFT -> this.dir = dir.previous();
            case FORWARD ->
                    newPos = this.position .add(this.dir.toUnitVector());
            case BACKWARD ->
                    newPos = this.position .subtract(this.dir.toUnitVector());
        }

        if (this.map.canMoveTo(newPos) && !newPos.equals(new Vector2d(-1,-1))) {

            for(IPositionChangeObserver observer : observers){
                observer.positionChanged(this.getPosition(), newPos);
            }
            this.position = newPos;
        }

    }
    /*
    public void move(MoveDirection direction){
        Vector2d newPos = new Vector2d(-1,-1);

        switch (direction){
            case RIGHT -> this.dir = dir.next();
            case LEFT -> this.dir = dir.previous();
            case FORWARD ->
                newPos = this.position .add(this.dir.toUnitVector());
            case BACKWARD ->
                newPos = this.position .subtract(this.dir.toUnitVector());
        }

        if (this.map.canMoveTo(newPos) && !newPos.equals(new Vector2d(-1,-1)))
            this.position  = newPos;

    }
    */



}
