package com.group.abcdraw.eventloops.outputevents;

import com.group.abcdraw.eventloops.OutputGameEvent;
import com.group.abcdraw.model.Letter;

public class SetCurrentLetterEvent extends OutputGameEvent {
    private Letter letter;

    public SetCurrentLetterEvent(Letter letter) {
        this.letter = letter;
    }

    public Letter getLetter() {
        return letter;
    }

    public void setLetter(Letter letter) {
        this.letter = letter;
    }
}
