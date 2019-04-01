package com.group.abcdraw.eventloops.outputevents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.group.abcdraw.model.MainScreenModel;
import com.group.abcdraw.ui.shapes.Circle;
import com.group.abcdraw.ui.shapes.Line;

import java.util.List;
/* A helper class for drawing shapes like Circles and Lines
   Not really an event, but called each render cycle
   Not added to events queue, but rather directly called from the GameScreen
   The shape drawing must de done after the sprite drawing
 */
public class GlobalDraw {

    public static void drawCircles(SpriteBatch spriteBatch, ShapeRenderer shapeRenderer, List<Circle> touches){
        shapeRenderer.setProjectionMatrix(spriteBatch.getProjectionMatrix());
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for (int i = 0; i < touches.size(); i++) {
            shapeRenderer.circle(touches.get(i).getX(), touches.get(i).getY(), 20);
        }
        shapeRenderer.end();
    }

    public static void drawLines(SpriteBatch spriteBatch, ShapeRenderer shapeRenderer, List<Line> lines){
        shapeRenderer.setProjectionMatrix(spriteBatch.getProjectionMatrix());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.BLUE);
        for (Line l :lines) {
            shapeRenderer.line(l.getX1(), l.getY1(), l.getX2(), l.getY2());
        }
        shapeRenderer.end();
    }
}
