package com.group.abcdraw.ui.shapes;

import com.badlogic.gdx.graphics.Color;
import com.group.abcdraw.eventloops.inputevents.ScreenTouchEvent;

/**
 * this will be the point under the finger
 */
public class TouchCircle extends ScreenTouchEvent {
    static final float radius = 10f;
    Color color = Color.ORANGE;

    public TouchCircle(float x, float y) { super(x, y); }

    public static float getRadius() {
        return radius;
    }
}
