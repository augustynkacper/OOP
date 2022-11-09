package agh.ics.oop;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class RectangularMapTest {
    @Test
    public void rectTest() {
        MoveDirection[] directions = OptionsParser.parse(new String[]{"f", "b",   "r", "l",    "f", "f",    "r", "r",    "f", "f",    "f", "f",    "f", "f",    "f", "f"});
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        SimulationEngine engine = new SimulationEngine(map, directions, positions);
        engine.run();
        System.out.println(map);
        assertTrue(engine.getAnimal(0).isAt(new Vector2d(2, 0)));
        assertTrue(engine.getAnimal(1).isAt(new Vector2d(3, 5)));

    }

    public void main(String[] args){
        rectTest();
    }
}
