package agh.ics.oop;

public interface IPositionChangeObserver {
    public void positionChanged(Vector2d oldPos, Vector2d newPos);
}
