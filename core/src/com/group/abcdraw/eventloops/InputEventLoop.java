package com.group.abcdraw.eventloops;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class InputEventLoop implements Realtime {
    private static final InputEventLoop ourInstance = new InputEventLoop();

    public static InputEventLoop getInstance() {
        return ourInstance;
    }

    private InputEventLoop() {
    }

    Queue<GameEvent> queue = new ArrayBlockingQueue<GameEvent>(20);

    @Override
    public void tick() {
        if (!queue.isEmpty()) {
            GameEvent event = queue.remove();

        }
    }

    public GameEvent getEvent() {
        if (queue.isEmpty()) throw new RuntimeException(" InputEventLoop Need to check queue not empty before getting events");
        return queue.remove();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
