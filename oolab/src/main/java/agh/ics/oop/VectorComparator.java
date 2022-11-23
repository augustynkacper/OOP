package agh.ics.oop;

import java.util.Comparator;

public class VectorComparator implements Comparator<Vector2d>{

    private boolean flag;

    // true if we compare by x
    VectorComparator (boolean flag){
        this.flag = flag;
    }

    @Override
    public int compare(Vector2d v1, Vector2d v2){
        if (this.flag) {
            if (v1.getX() - v2.getX() != 0)
                return v1.getX() - v2.getX();
            return v1.getY() - v2.getY();
        } else{
            if (v1.getY() - v2.getY() != 0)
                return v1.getY() - v2.getY();
            return v1.getX() - v2.getX();
        }
    }
}
