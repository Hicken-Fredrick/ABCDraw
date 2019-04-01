package com.group.abcdraw.ui.shapes;

import com.badlogic.gdx.graphics.Color;
import com.group.abcdraw.eventloops.inputevents.ScreenTouchEvent;
import com.group.abcdraw.model.Position;

public class Circle extends ScreenTouchEvent {
    static final float radius = 20f;
    Color color = Color.RED;
    public Circle(float x, float y) {
        super(x, y);
    }

    public Circle(Position p) {
        super(p.getX(), p.getY());
    }

    public static float getRadius() {
        return radius;
    }
}
