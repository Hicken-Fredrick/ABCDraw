package com.group.abcdraw.ui.shapes;

import com.badlogic.gdx.graphics.Color;
import com.group.abcdraw.eventloops.inputevents.ScreenTouchEvent;

/**
 * drawing for next point
 * if finger is off screen this will be the point to touch
 */
public class IncompleteCircle extends ScreenTouchEvent {
    static final float radius = 30f;
    Color color = Color.ORANGE;

    public IncompleteCircle(float x, float y) { super(x, y); }

    public static float getRadius() {
        return radius;
    }
}
