package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {

    Vector2d v1 = new Vector2d(-2, -3);
    Vector2d v2 = new Vector2d(3, -3);
    Vector2d v3 = new Vector2d(-2, 8);
    Vector2d v4 = new Vector2d(3, 8);
    Vector2d v11 = new Vector2d(-2, -3);
    Vector2d v22 = new Vector2d(3, -3);
    Vector2d v33 = new Vector2d(-2, 8);
    Vector2d v44 = new Vector2d(3, 8);

    @Test
    public void testToString(){
        assertEquals("(-2, -3)", v1.toString());
        assertEquals("(3, -3)", v2.toString());
        assertEquals("(-2, 8)", v3.toString());
        assertEquals("(3, 8)", v4.toString());
        assertEquals("(-2, -3)", v11.toString());
        assertEquals("(3, -3)", v22.toString());
        assertEquals("(-2, 8)", v33.toString());
        assertEquals("(3, 8)", v44.toString());
    }

    @Test
    public void testPredeces(){
        assertTrue(v1.precedes(v2));
        assertTrue(v1.precedes(v4));
        assertTrue(v3.precedes(v4));
        assertTrue(v2.precedes(v4));
        assertFalse(v3.precedes(v2));
        assertFalse(v4.precedes(v2));
        assertFalse(v4.precedes(v1));
        assertFalse(v2.precedes(v1));
        assertFalse(v2.precedes(v3));
    }

    @Test
    public void testFollows(){
        assertTrue(v3.follows(v1));
        assertTrue(v2.follows(v1));
        assertTrue(v4.follows(v1));
        assertTrue(v4.follows(v2));
        assertTrue(v4.follows(v3));
        assertFalse(v3.follows(v2));
        assertFalse(v3.follows(v4));
        assertFalse(v2.follows(v3));
        assertFalse(v1.follows(v2));
        assertFalse(v1.follows(v3));
        assertFalse(v1.follows(v4));
    }

    @Test
    public void testUpperRight(){
        assertEquals(v4, v2.upperRight(v3));
        assertEquals(v2, v1.upperRight(v2));
        assertEquals(v3, v3.upperRight(v1));

        assertNotEquals(v3, v2.upperRight(v1));
        assertNotEquals(v2, v3.upperRight(v1));
        assertNotEquals(v1, v2.upperRight(v3));
    }

    @Test
    public void testLowerLeft(){
        assertEquals(v1, v2.lowerLeft(v3));
        assertEquals(v1, v2.lowerLeft(v1));
        assertEquals(v1, v3.lowerLeft(v1));

        assertNotEquals(v2, v1.lowerLeft(v3));
        assertNotEquals(v4, v2.lowerLeft(v3));
        assertNotEquals(v3, v1.lowerLeft(v2));
    }

    @Test
    public void testAdd(){
        assertEquals( new Vector2d(1,-6) , v1.add(v2));
        assertEquals( new Vector2d(1,5) , v1.add(v4));
        assertEquals( new Vector2d(-4,5) , v1.add(v3));
        assertEquals( new Vector2d(6, 5) , v2.add(v4));

        assertNotEquals( v1, v4.add(v2));
        assertNotEquals( v2, v3.add(v1));
        assertNotEquals( v4, v1.add(v2));
        assertNotEquals( v3, v4.add(v1) );
    }

    @Test
    public void testSubstract(){
        assertEquals(  new Vector2d(0, -11) ,  v2.subtract(v4));
        assertEquals(  new Vector2d(0,11) , v3.subtract(v1));
        assertEquals(  new Vector2d(-5,-11) , v1.subtract(v4));
        assertEquals( new Vector2d(5,0) ,  v4.subtract(v3));

        assertNotEquals( new Vector2d(1,4) , v2.subtract(v4));
        assertNotEquals( new Vector2d(-3,5) , v1.subtract(v2));
        assertNotEquals( new Vector2d(-1,14) , v2.subtract(v4));
        assertNotEquals( new Vector2d(0,0) , v3.subtract(v2));
    }

    @Test
    public void testOpposite(){
        assertEquals(new Vector2d(2,3), v1.opposite());
        assertEquals(new Vector2d(-3,3), v2.opposite());
        assertEquals(new Vector2d(2,-8), v3.opposite());
        assertEquals(new Vector2d(-3,-8), v4.opposite());
        assertNotEquals(new Vector2d(2,-3), v1.opposite());
        assertNotEquals(new Vector2d(3,3), v2.opposite());
        assertNotEquals(new Vector2d(2,8), v3.opposite());
        assertNotEquals(new Vector2d(-3,8), v4.opposite());
    }

    @Test
    public void testEquals(){
        assertTrue(v1.equals(v11));
        assertTrue(v2.equals(v22));
        assertTrue(v3.equals(v33));
        assertTrue(v4.equals(v44));

        assertFalse(v1.equals(v2));
        assertFalse(v3.equals(v4));
        assertFalse(v2.equals(v3));
        assertFalse(v4.equals(v1));
    }

    public void main(String[] args){
        testToString();
        testPredeces();
        testFollows();
        testUpperRight();
        testLowerLeft();
        testAdd();
        testSubstract();
        testOpposite();
        testEquals();
    }

}
