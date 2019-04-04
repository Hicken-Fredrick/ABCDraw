package com.group.abcdraw.eventloops.outputevents;

import com.group.abcdraw.eventloops.OutputGameEvent;
import com.group.abcdraw.ui.shapes.IncompleteCircle;

public class ChangeActiveCircle extends OutputGameEvent {
    private IncompleteCircle incompleteCircle;

    public ChangeActiveCircle(IncompleteCircle incompleteCircle) {
        this.incompleteCircle = incompleteCircle;
    }

    public IncompleteCircle getIncompleteCircle() {
        return incompleteCircle;
    }

    public void setIncompleteCircle(IncompleteCircle incompleteCircle) {
        this.incompleteCircle = incompleteCircle;
    }
}
