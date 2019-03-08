package com.group.abcdraw.eventloops.inputevents;

import com.group.abcdraw.eventloops.InputGameEvent;

public class ScreenTouchEvent extends InputGameEvent {
    int x;
    int y;

    public ScreenTouchEvent(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private ScreenTouchEvent() {

    }
}
