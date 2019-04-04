package com.group.abcdraw.eventloops;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class OutputEventLoop implements Realtime {
    private static final OutputEventLoop ourInstance = new OutputEventLoop();

    public static OutputEventLoop getInstance() {
        return ourInstance;
    }

    Queue<OutputGameEvent> queue = new ArrayBlockingQueue<OutputGameEvent>(20);

    public OutputEventLoop() {
    }

    @Override
    public void tick() {

    }

    public OutputGameEvent getEvent() {
        if (queue.isEmpty()) throw new RuntimeException(" OutputEventLoop Need to check queue not empty before getting events");
        return queue.remove();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void add(OutputGameEvent event) {
        queue.add(event);
    }

    public void clear() {
        queue.clear();
    }
}
