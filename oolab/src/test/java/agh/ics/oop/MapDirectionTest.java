package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {

    @Test
    public void testNext(){
        assertEquals(MapDirection.EAST, MapDirection.NORTH.next(),
                "Next direction for NORTH is not correct.");
        assertEquals(MapDirection.SOUTH, MapDirection.EAST.next(),
                "Next direction for EAST is not correct.");
        assertEquals(MapDirection.WEST, MapDirection.SOUTH.next(),
                "Next direction for SOUTH is not correct.");
        assertEquals(MapDirection.NORTH, MapDirection.WEST.next(),
                "Next direction for WEST is not correct.");
    }

    @Test
    public void testPrevious(){
        assertEquals(MapDirection.WEST, MapDirection.NORTH.previous(),
                "Previous direction for NORTH is not correct.");
        assertEquals(MapDirection.NORTH, MapDirection.EAST.previous(),
                "Previous direction for EAST is not correct.");
        assertEquals(MapDirection.EAST, MapDirection.SOUTH.previous(),
                "Previous direction for SOUTH is not correct.");
        assertEquals(MapDirection.SOUTH, MapDirection.WEST.previous(),
                "Previous direction for WEST is not correct.");
    }

    public void main(String[] args){
        testNext();
        testPrevious();
    }
}
