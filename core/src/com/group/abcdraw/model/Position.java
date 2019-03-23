package com.group.abcdraw.model;

/**
 * for holding locations to draw on each letter
 */
public class Position {
    float x;
    float y;
    boolean touched;

    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean isTouched() {
        return touched;
    }

    public void setTouched(boolean touched) {
        this.touched = touched;
    }
}
