package com.group.abcdraw.ui.shapes;

import com.badlogic.gdx.graphics.Color;
import com.group.abcdraw.eventloops.inputevents.ScreenTouchEvent;

/**
 *drawing for completed points
 */
public class CompleteCircle extends ScreenTouchEvent {
    static final float radius = 18f;
    Color color = Color.RED;
    public CompleteCircle(float x, float y) {
        super(x, y);
    }

    public static float getRadius() {
        return radius;
    }
}
