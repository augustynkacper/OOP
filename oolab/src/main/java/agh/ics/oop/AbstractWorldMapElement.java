package agh.ics.oop;

public class AbstractWorldMapElement implements IMapElement{
    protected Vector2d position;

    public AbstractWorldMapElement(Vector2d position){
        this.position = position;
    }

    @Override
    public boolean isAt(Vector2d pos){
        return this.position.equals(pos);
    }

    @Override
    public Vector2d getPosition() {
        return this.position;
    }

    @Override
    public String getImagePath(){
        return "src/main/resources/grass.png";
    }
}
