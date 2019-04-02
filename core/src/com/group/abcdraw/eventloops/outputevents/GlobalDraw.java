package com.group.abcdraw.eventloops.outputevents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.group.abcdraw.model.MainScreenModel;
import com.group.abcdraw.ui.shapes.CompleteCircle;
import com.group.abcdraw.ui.shapes.IncompleteCircle;
import com.group.abcdraw.ui.shapes.Line;
import com.group.abcdraw.ui.shapes.TouchCircle;

import java.util.List;

import sun.applet.Main;

/* A helper class for drawing shapes like Circles and Lines
   Not really an event, but called each render cycle
   Not added to events queue, but rather directly called from the GameScreen
   The shape drawing must de done after the sprite drawing
 */
public class GlobalDraw {

    public static void drawCircles(SpriteBatch spriteBatch, ShapeRenderer shapeRenderer){
        shapeRenderer.setProjectionMatrix(spriteBatch.getProjectionMatrix());
        //draw all completed circles
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        List<CompleteCircle> completeCircles = MainScreenModel.getInstance().getCompleteCircles();
        for (int i = 0; i < completeCircles.size(); i++) {
            shapeRenderer.circle(completeCircles.get(i).getX(), completeCircles.get(i).getY(), completeCircles.get(i).getRadius());
        }

        //draw touch circle
        if (MainScreenModel.getInstance().getTouchCircle() != null) {
            shapeRenderer.setColor(Color.ORANGE);
            TouchCircle touchCircle = MainScreenModel.getInstance().getTouchCircle();
            shapeRenderer.circle(touchCircle.getX(), touchCircle.getY(), touchCircle.getRadius());
        }
        shapeRenderer.end();

        //draw next / inactive circle
        if (MainScreenModel.getInstance().getIncompleteCircle() != null) {
            shapeRenderer.setProjectionMatrix(spriteBatch.getProjectionMatrix());
            shapeRenderer.setColor(Color.ORANGE);
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            IncompleteCircle incompleteCircle = MainScreenModel.getInstance().getIncompleteCircle();
            shapeRenderer.circle(incompleteCircle.getX(), incompleteCircle.getY(), incompleteCircle.getRadius());
            Gdx.gl.glLineWidth(7);
            shapeRenderer.end();
        }
    }

    public static void drawLines(SpriteBatch spriteBatch, ShapeRenderer shapeRenderer){
        shapeRenderer.setProjectionMatrix(spriteBatch.getProjectionMatrix());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.BLUE);
        for (Line l :MainScreenModel.getInstance().getLines()) {
            shapeRenderer.line(l.getX1(), l.getY1(), l.getX2(), l.getY2());
        }
        //if touch isn't null draw from complete circle to finger
        if(MainScreenModel.getInstance().getFinalCompleteCircle() == null)
        {
            shapeRenderer.end();
            return;
        }
        if (MainScreenModel.getInstance().getTouchCircle() != null)
        {

            shapeRenderer.line(MainScreenModel.getInstance().getFinalCompleteCircle().getX(),
                    MainScreenModel.getInstance().getFinalCompleteCircle().getY(),
                    MainScreenModel.getInstance().getTouchCircle().getX(),
                    MainScreenModel.getInstance().getTouchCircle().getY());
        }
        //if touch is null draw line to last "checkpoint"
        else
        {
            shapeRenderer.line(MainScreenModel.getInstance().getFinalCompleteCircle().getX(),
                    MainScreenModel.getInstance().getFinalCompleteCircle().getY(),
                    MainScreenModel.getInstance().getIncompleteCircle().getX(),
                    MainScreenModel.getInstance().getIncompleteCircle().getY());
        }
        shapeRenderer.end();
    }
}
