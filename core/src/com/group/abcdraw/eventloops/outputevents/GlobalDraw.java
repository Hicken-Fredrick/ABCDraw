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

    //Transforming Y coordinates into actual screen coordinates
    //the touches coordinates are 0,0 upper left
    //the screen coordinates 0,0 are lower left
    private static float transformY(float y) {
        return Gdx.graphics.getHeight() - y;
    }

    public static void drawCircles(SpriteBatch spriteBatch, ShapeRenderer shapeRenderer){
        shapeRenderer.setProjectionMatrix(spriteBatch.getProjectionMatrix());
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        List<Circle> touches = MainScreenModel.getInstance().getCircles();
        for (int i = 0; i < touches.size(); i++) {
            shapeRenderer.circle(touches.get(i).getX(), transformY(touches.get(i).getY()), 20);
        }
        shapeRenderer.end();
    }

    public static void drawLines(SpriteBatch spriteBatch, ShapeRenderer shapeRenderer){
        shapeRenderer.setProjectionMatrix(spriteBatch.getProjectionMatrix());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.BLUE);
        for (Line l :MainScreenModel.getInstance().getLines()) {
            shapeRenderer.line(l.getX1(), transformY(l.getY1()), l.getX2(), transformY(l.getY2()));
        }
        shapeRenderer.end();
    }
}
