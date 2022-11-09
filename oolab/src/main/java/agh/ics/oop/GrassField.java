package agh.ics.oop;


import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
        this.animals = new ArrayList<>();
    }

    public List<Grass> createFields(int n){
        List<Grass> positions = new ArrayList<>();
        for (int i=0; i<n; i++){
            Vector2d pos = randomField();
            while (isGrassAt(pos, positions)){
                pos = randomField();
            }
            positions.add(new Grass(pos));
        }

        System.out.println(positions.size());
        for(Grass x: positions){
            System.out.println(x.getPosition());
        }
        return positions;
    }

    public boolean isGrassAt(Vector2d pos, List<Grass> g){
        if(g == null) return false;
        for (Grass v : g){
            if(v.getPosition().equals(pos)) return true;
        }
        return false;
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

    @Override
    public Vector2d getLowerLeft(){
        Vector2d v = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (Animal animal : animals) {
            v = v.lowerLeft(animal.getPosition());
        }
        for (Grass grass : grassPositions) {
            v = v.lowerLeft(grass.getPosition());
        }
        return v;
    }
    @Override
    public Vector2d getUpperRight(){
        Vector2d v = new Vector2d(0, 0);
        for (Animal animal : animals) {
            v = v.upperRight(animal.getPosition());
        }
        for (Grass grass : grassPositions) {
            v = v.upperRight(grass.getPosition());
        }
        return v;
    }

}
