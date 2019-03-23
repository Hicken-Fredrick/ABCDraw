package com.group.abcdraw.model;

/**
 * class for containing the points and completion
 * state for said point and the given letter
 * @author Fred
 */
public class Letter {
    //vars
    Position [] points;
    boolean complete;
    int activePoint;
    int nextPoint;
    int finalPoint;

    //constructors
    public Letter() {
        points = new Position[3];
        //!! FOR TESTING PURPOSES !!
        points[0] = new Position(0,0);
        points[1] = new Position(150,700);
        points[2] = new Position(350,1000);
        //where to go and when letter is complete
        activePoint = 0;
        nextPoint = 1;
        finalPoint = points.length;
    }

    public Position[] getPoints() {
        return points;
    }

    public void setPoints(Position[] points) {
        this.points = points;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public int getActivePoint() {
        return activePoint;
    }

    public void setActivePoint(int activePoint) {
        this.activePoint = activePoint;
    }

    public int getNextPoint() {
        return nextPoint;
    }

    public void setNextPoint(int nextPoint) {
        this.nextPoint = nextPoint;
    }

    public int getFinalPoint() {
        return finalPoint;
    }

}
