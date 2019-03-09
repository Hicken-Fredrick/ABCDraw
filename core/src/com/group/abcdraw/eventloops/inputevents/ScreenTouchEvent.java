package com.group.abcdraw.eventloops.inputevents;

import com.group.abcdraw.eventloops.InputGameEvent;

public class ScreenTouchEvent extends InputGameEvent {
    float x;
    float y;

    public ScreenTouchEvent(int x, int y) {
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
