package agh.ics.oop;


import java.util.*;

public class GrassField extends AbstractWorldMap {

    // grass List
    private int numberOfGrass;

    // map parameters
    private int width = Integer.MAX_VALUE;
    private int height = Integer.MAX_VALUE;
    private MapVisualizer visualizer = new MapVisualizer(this);



    public GrassField(int n){
        super(0,0,Integer.MAX_VALUE,Integer.MAX_VALUE);
        this.numberOfGrass = n;
        this.grassPositions = this.createFields(n);
        this.animals = new LinkedHashMap<>();
    }

    public HashMap<Vector2d, Grass> createFields(int n){
        HashMap<Vector2d, Grass> positions = new LinkedHashMap<>();
        for (int i=0; i<n; i++){
            Vector2d pos = randomField();
            while (getGrassAt(pos) != null){
                pos = randomField();
            }
            positions.put(pos, new Grass(pos));
        }
        return positions;
    }

    private Grass getGrassAt(Vector2d pos){
        return grassPositions.get(pos);
    }

    private Animal getAnimalAt(Vector2d pos){
        return animals.get(pos);
    }

    @Override
    public Object objectAt(Vector2d pos){
        if (animals.containsKey(pos)) return getAnimalAt(pos);
        if (grassPositions.containsKey(pos)) return getGrassAt(pos);
        return null;
    }

    /*
    @Override
    public Object objectAt(Vector2d pos){
        Animal a = getAnimalAt(pos);
        if (a != null) return a;
        Grass g = getGrassAt(pos);
        if (g!= null) return g;
        return null;
    }
    */
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public Vector2d randomField(){
        Vector2d pos = new Vector2d(
                getRandomNumber(0, (int)Math.sqrt(this.numberOfGrass*10)),
                getRandomNumber(0, (int)Math.sqrt(this.numberOfGrass*10))
        );
        return pos;
    }

    @Override
    public Vector2d getLowerLeft(){
        Vector2d v = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (Animal animal : animals.values()) {
            v = v.lowerLeft(animal.getPosition());
        }
        for (Grass grass : grassPositions.values()) {
            v = v.lowerLeft(grass.getPosition());
        }
        return v;
    }
    @Override
    public Vector2d getUpperRight(){
        Vector2d v = new Vector2d(0, 0);
        for (Animal animal : animals.values()) {
            v = v.upperRight(animal.getPosition());
        }
        for (Grass grass : grassPositions.values()) {
            v = v.upperRight(grass.getPosition());
        }
        return v;
    }

}
