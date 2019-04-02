package com.group.abcdraw.eventloops.outputevents;

import com.group.abcdraw.eventloops.OutputGameEvent;
import com.group.abcdraw.ui.shapes.CompleteCircle;

public class AddCompleteCircle extends OutputGameEvent {
    private CompleteCircle completeCircle;

    public AddCompleteCircle(CompleteCircle completeCircle) {
        this.completeCircle = completeCircle;
    }

    public CompleteCircle getCompleteCircle() {
        return completeCircle;
    }

    public void setCompleteCircle(CompleteCircle completeCircle) {
        this.completeCircle = completeCircle;
    }
}
