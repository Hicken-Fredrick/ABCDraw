package com.group.abcdraw.ui.shapes;

import com.badlogic.gdx.graphics.Color;
import com.group.abcdraw.eventloops.inputevents.ScreenTouchEvent;

public class Circle extends ScreenTouchEvent {
    static final float radius = 20f;
    Color color = Color.RED;
    public Circle(float x, float y) {
        super(x, y);
    }

    public static float getRadius() {
        return radius;
    }
}
