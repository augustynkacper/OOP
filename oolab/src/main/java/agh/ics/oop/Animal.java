package agh.ics.oop;

import java.util.Vector;

public class Animal {

    private Vector2d pos;
    private MapDirection dir;
    private IWorldMap map;

    public Animal(IWorldMap map, Vector2d initialPosition, MapDirection initialDirection){
        this.map = map;
        this.pos = initialPosition;
        this.dir = initialDirection;
    }

    public Animal(){
        this.pos = new Vector2d(2,2);
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

    public MapDirection getDirection(){
        return dir;
    }
    public Vector2d getPosition(){
        return pos;
    }

    public boolean isAt(Vector2d position){
        return pos.x==position.x && pos.y==position.y;
    }

    public boolean checkPos(Vector2d pos){
        return pos.x>=0 && pos.x<=4 && pos.y>=0 && pos.y<=4;
    }

    public void move(MoveDirection direction){
        Vector2d newPos = new Vector2d(-1,-1);

        switch (direction){
            case RIGHT -> this.dir = dir.next();
            case LEFT -> this.dir = dir.previous();
            case FORWARD ->
                newPos = this.pos.add(this.dir.toUnitVector());
            case BACKWARD ->
                newPos = this.pos.subtract(this.dir.toUnitVector());
        }

        if (this.map.canMoveTo(newPos) && !newPos.equals(new Vector2d(-1,-1)))
            this.pos = newPos;

    }


}
