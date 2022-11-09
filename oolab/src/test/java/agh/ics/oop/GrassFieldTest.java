package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GrassFieldTest {

    @Test
    public void moveTest(){
        String[] args = {"f", "f", "b",   "r", "l", "l",   "f", "f", "f",   "f", "l", "f",   "f", "f", "r",   "f", "f", "f",   "f", "f", "f",   "f", "f", "f"};
        MoveDirection[] directions = (new OptionsParser()).parse(args);

        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(3,4), new Vector2d(8,8), new Vector2d(9,3)   };
        SimulationEngine engine = new SimulationEngine(map, directions, positions);

        engine.run();

        assertTrue(engine.getAnimal(0).isAt(new Vector2d(9,5)));
        assertTrue(engine.getAnimal(1).isAt(new Vector2d(7,5)));
        assertTrue(engine.getAnimal(2).isAt(new Vector2d(7,4)));


    }

    public void main(String[] args){
        moveTest();
    }

}
