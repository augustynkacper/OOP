package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{

    private final IWorldMap map;
    private final MoveDirection[] moves;
    private List<Animal> animals;

    public SimulationEngine(IWorldMap map, MoveDirection[] moves, Vector2d[] positions){
        this.moves = moves;
        this.map = map;
        this.animals = this.addAnimals(positions);
    }

    public List<Animal> addAnimals(Vector2d[] positions){
        List<Animal> a = new ArrayList<>();
        for (Vector2d pos : positions) {
            Animal an = new Animal(this.map, pos, MapDirection.NORTH);
            a.add(an);
            map.place(an);
        }
        return a;
    }

    public Animal getAnimal(int i){
        return this.animals.get(i);
    }

    @Override
    public void run(){
        for (int i=0; i<this.moves.length; i++) {
            this.animals.get(i % this.animals.size()).move(this.moves[i]);

        }
    }
}
