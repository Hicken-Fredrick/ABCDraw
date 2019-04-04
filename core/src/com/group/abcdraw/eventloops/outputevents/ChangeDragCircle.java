package com.group.abcdraw.eventloops.outputevents;

import com.group.abcdraw.eventloops.OutputGameEvent;
import com.group.abcdraw.ui.shapes.TouchCircle;

public class ChangeDragCircle extends OutputGameEvent {
    private TouchCircle touchCircle;

    public ChangeDragCircle(TouchCircle touchCircle) {
        this.touchCircle = touchCircle;
    }

    public TouchCircle getTouchCircle() {
        return touchCircle;
    }

    public void setTouchCircle(TouchCircle touchCircle) {
        this.touchCircle = touchCircle;
    }
}
