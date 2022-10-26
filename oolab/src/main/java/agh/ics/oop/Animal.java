package agh.ics.oop;

public class Animal {

    private Vector2d pos = new Vector2d(2, 2);
    public MapDirection dir = MapDirection.NORTH;

    public String toString() {
        return "Position: " + pos.toString() + ", direction: " + dir.toString();
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
        switch (direction){
            case RIGHT -> this.dir = dir.next();
            case LEFT -> this.dir = dir.previous();
            case FORWARD -> {
                Vector2d newPos = new Vector2d(this.pos.x + dir.toUnitVector().x,
                        this.pos.y + dir.toUnitVector().y);
                if (checkPos(newPos)){
                    this.pos = newPos;
                }
            }
            case BACKWARD -> {
                Vector2d newPos = new Vector2d(this.pos.x - dir.toUnitVector().x,
                        this.pos.y - dir.toUnitVector().y);
                if (checkPos(newPos)){
                    this.pos = newPos;
                }
            }
        }
    }


}
