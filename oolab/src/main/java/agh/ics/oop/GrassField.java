package agh.ics.oop;


import java.util.*;

public class GrassField extends AbstractWorldMap {

    // grass List
    private int numberOfGrass;

    // map parameters
    private int width = Integer.MAX_VALUE;
    private int height = Integer.MAX_VALUE;
    private MapVisualizer visualizer = new MapVisualizer(this);

    private MapBoundary mapBoundary = new MapBoundary();



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
            while (positions.containsKey(pos)){
                pos = randomField();
            }
            this.mapBoundary.addElement(pos);
            positions.put(pos, new Grass(pos));
        }
        return positions;
    }

    @Override
    public boolean place(Animal animal){
        if ( !this.isOccupied(animal.getPosition()) ||
                this.objectAt(animal.getPosition()) instanceof Grass) {
            this.animals.put(animal.getPosition(), animal);
            this.mapBoundary.addElement(animal.getPosition());

            animal.setObserver(this);
            return true;
        }else if (this.objectAt(animal.getPosition()) instanceof Animal){
            throw new IllegalArgumentException(animal.getPosition() + " is already occupied");
        }
        return false;
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

    public HashMap<Vector2d, Grass> getGrass(){
        return this.grassPositions;
    }

    public HashMap<Vector2d, Animal> getAnimals(){
        return this.animals;
    }

    public Vector2d[] getObjects(){
        Vector2d[] res = new Vector2d[animals.size()+grassPositions.size()];

        int i =0;
        for (Vector2d v : this.animals.keySet()){
            res[i] = v; i++;
        }

        for (Vector2d v : this.grassPositions.keySet()){
            res[i] = v; i++;
        }

        return res;
    }

    @Override
    public Vector2d getLowerLeft(){
        return this.mapBoundary.lowerLeft();
    }
    @Override
    public Vector2d getUpperRight(){
        return this.mapBoundary.upperRight();
    }

}
