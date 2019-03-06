package com.group.abcdraw.eventloops.outputevents;

import com.group.abcdraw.eventloops.OutputGameEvent;
import com.group.abcdraw.ui.background.BackgroundResource;

public class SetBackgroundEvent extends OutputGameEvent {
    private BackgroundResource resource;


    public SetBackgroundEvent(BackgroundResource resource) {
        this.resource = resource;
    }

    public BackgroundResource getResource() {
        return resource;
    }
}

