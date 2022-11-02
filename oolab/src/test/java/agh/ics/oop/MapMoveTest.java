package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapMoveTest {

    @Test
    public void mapMoveTest(){
        String[] args = {"r", "b", "l", "f", "b", "f", "f", "r", "f","l","f","l","f","r","f","f","f","f"};
        MoveDirection[] moves  = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(1,1), new Vector2d(3,3), new Vector2d(6,2)  };
        SimulationEngine engine = new SimulationEngine(map, moves , positions);
        engine.run();
        Vector2d[] posResult = { new Vector2d(2,3), new Vector2d(4,0), new Vector2d(4,1)  };
        MapDirection[] dirResult = {MapDirection.NORTH, MapDirection.SOUTH, MapDirection.SOUTH};
        for (int i=0; i<positions.length; i++){
            assertEquals(engine.getAnimal(i).getPosition(), posResult[i]);
            assertEquals(engine.getAnimal(i).getDirection(), dirResult[i]);
        }
    }


    public void main(String[] args){
        mapMoveTest();
    }
}
