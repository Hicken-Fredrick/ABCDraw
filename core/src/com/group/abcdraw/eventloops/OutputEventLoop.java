package com.group.abcdraw.eventloops;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class OutputEventLoop implements Realtime {
    private static final OutputEventLoop ourInstance = new OutputEventLoop();

    public static OutputEventLoop getInstance() {
        return ourInstance;
    }

    Queue<GameEvent> queue = new ArrayBlockingQueue<GameEvent>(20);

    private OutputEventLoop() {
    }

    @Override
    public void tick() {

    }

    public GameEvent getEvent() {
        if (queue.isEmpty()) throw new RuntimeException(" InputEventLoop Need to check queue not empty before getting events");
        return queue.remove();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
