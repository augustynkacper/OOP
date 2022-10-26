package agh.ics.oop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimalTest {
    Animal anOr = new Animal();

    @Test
    public void directionTest(){
        // we are heading north
        anOr.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST, anOr.getDirection());
        anOr.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.SOUTH, anOr.getDirection());
        anOr.move(MoveDirection.LEFT);
        assertEquals(MapDirection.EAST, anOr.getDirection());
        anOr.move(MoveDirection.FORWARD);
        assertEquals(MapDirection.EAST, anOr.getDirection());
        anOr.move(MoveDirection.BACKWARD);
        assertEquals(MapDirection.EAST, anOr.getDirection());
    }

    Animal anMove = new Animal();
    @Test
    public void moveTest(){
        System.out.println(anMove.getDirection());
        anMove.move(MoveDirection.RIGHT);
        anMove.move(MoveDirection.FORWARD);
        anMove.move(MoveDirection.FORWARD);
        anMove.move(MoveDirection.FORWARD);
        assertEquals(anMove.getPosition(), new Vector2d(4,2));

        anMove.move(MoveDirection.RIGHT);
        anMove.move(MoveDirection.FORWARD);
        anMove.move(MoveDirection.BACKWARD);
        anMove.move(MoveDirection.FORWARD);
        assertEquals(anMove.getPosition(), new Vector2d(4,1));

        anMove.move(MoveDirection.LEFT);
        anMove.move(MoveDirection.LEFT);
        anMove.move(MoveDirection.FORWARD);
        anMove.move(MoveDirection.FORWARD);
        assertEquals(anMove.getPosition(), new Vector2d(4,3));

        anMove.move(MoveDirection.LEFT);
        anMove.move(MoveDirection.FORWARD);
        anMove.move(MoveDirection.FORWARD);
        anMove.move(MoveDirection.BACKWARD);
        assertEquals(anMove.getPosition(), new Vector2d(3,3));
    }


    @Test
    public void outOfMapTest(){
        Animal an = new Animal();
        int x=5, y = 5;
        for (int i=0; i<y+1; i++) an.move(MoveDirection.FORWARD);
        assertEquals(an.getPosition(), new Vector2d(2,4));

        an.move(MoveDirection.RIGHT);
        for (int i=0; i<x+1; i++) an.move(MoveDirection.FORWARD);
        assertEquals(an.getPosition(), new Vector2d(4,4));

        an.move(MoveDirection.RIGHT);
        for (int i=0; i<y+1; i++) an.move(MoveDirection.FORWARD);
        assertEquals(an.getPosition(), new Vector2d(4,0));

        an.move(MoveDirection.RIGHT);
        for (int i=0; i<x+1; i++) an.move(MoveDirection.FORWARD);
        assertEquals(an.getPosition(), new Vector2d(0,0));
    }
    @Test
    public void parseTest() {
        OptionsParser parser = new OptionsParser();

        //entry test
        String[] args1 = {"backward", "f", "asdff", "forward", "r", "asdffds"};
        MoveDirection[] valid_output = {MoveDirection.BACKWARD, MoveDirection.FORWARD,
                MoveDirection.FORWARD, MoveDirection.RIGHT};
        Assertions.assertArrayEquals(valid_output, parser.parse(args1));


        String[] args2 = {"f", "b", "forward", "right", "backward", "right", "left"};
        MoveDirection[] valid_output2 = {MoveDirection.FORWARD, MoveDirection.BACKWARD,
                MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD,
                MoveDirection.RIGHT, MoveDirection.LEFT};
        Assertions.assertArrayEquals(valid_output2, parser.parse(args2));

        String[] args3 = {"ASDF", "Adgs", "gsdgd"};
        MoveDirection[] valid_output3 = {};
        Assertions.assertArrayEquals(valid_output3, parser.parse(args3));
    }


    public void main(String[] args) {
        directionTest();
        moveTest();
        outOfMapTest();
        parseTest();
    }
}
