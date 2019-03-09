package com.group.abcdraw.eventloops.inputevents;

import com.group.abcdraw.eventloops.InputGameEvent;

public class ScreenTouchEvent extends InputGameEvent {
    private float x;
    private float y;

    public ScreenTouchEvent(float x, float y) {
        this.x = x;
        this.y = y;
    }

    private ScreenTouchEvent() {

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
