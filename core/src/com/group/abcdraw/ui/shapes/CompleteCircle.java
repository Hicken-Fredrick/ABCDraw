package com.group.abcdraw.ui.shapes;

import com.badlogic.gdx.graphics.Color;
import com.group.abcdraw.eventloops.inputevents.ScreenTouchEvent;
import com.group.abcdraw.model.Position;
import com.group.abcdraw.utils.Utils;

/**
 *drawing for completed points
 */
public class CompleteCircle extends ScreenTouchEvent {
    static final float radius = 18f;
    Color color = Color.RED;

    public CompleteCircle(float x, float y) {
        super(x, y);
    }

    @Override
    public float getX() {
        return super.getX();
    }

    @Override
    public float getY() {
        return super.getY();
    }

    public CompleteCircle(Position p) {
        super(p.getX(), p.getY());
    }

    public static float getRadius() {
        return radius;
    }
}
