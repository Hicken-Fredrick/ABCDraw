package com.group.abcdraw.model;

import java.util.ArrayList;
import java.util.List;

/**
 * class for containing the points and completion
 * state for said point and the given letter
 * @author Fred
 */
public class Letter {
    //vars
    char letter;
    List<Position> points;
    boolean complete;
    int activePoint;
    int nextPoint;
    int finalPoint;

    //constructors
    public Letter(char letter) {
        this.letter = letter;
        points = LetterPoints.getPoints(letter);
        //where to go and when letter is complete
        activePoint = 0;
        nextPoint = 1;
        finalPoint = points.size() - 1;
        complete = false;
    }

    public List<Position> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Position> points) {
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
