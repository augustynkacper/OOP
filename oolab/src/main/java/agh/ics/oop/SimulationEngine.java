package agh.ics.oop;

import agh.ics.oop.gui.IAnimalMove;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine, Runnable{

    private final IWorldMap map;
    private final MoveDirection[] moves;
    private List<Animal> animals;
    private IAnimalMove observer;

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

    public void setObserver(IAnimalMove observer){
        this.observer = observer;
    }

    @Override
    public void run(){

        for (int i=0; i<this.moves.length; i++) {
            this.animals.get(i % this.animals.size()).move(this.moves[i]);

            this.observer.animalMoved();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException exception) {
                System.out.println("Couldn't continue the thread");
            }
        }
    }
}
