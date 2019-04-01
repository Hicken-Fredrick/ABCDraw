package com.group.abcdraw.model;

import com.group.abcdraw.ui.background.BackgroundResource;
import com.group.abcdraw.ui.shapes.Circle;
import com.group.abcdraw.ui.shapes.Line;
import com.group.abcdraw.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/* A data keeper class of the on-screen shapes
  Processes touch events (that is an anti-pattern and possibly should be refactored) @TODO refactor
  adds a circle and a corresponding line to a list of circles and lines
 */
public class MainScreenModel {
    private static final MainScreenModel ourInstance = new MainScreenModel();

    private List<Circle> circles = null;
    private List<Line> lines = new ArrayList<Line>();
    private float screenWidth, screenHeight;
    private BackgroundResource backgroundResource;

    public static MainScreenModel getInstance() {
        return ourInstance;
    }

    private MainScreenModel() {
    }

    public void clear(){
        circles.clear();
        lines.clear();
    }

    public void addTouch(float x, float y) {
        if(circles.size() > 0) {
            Circle lastCircle = circles.get(circles.size()-1);
            lines.add(new Line(lastCircle.getX(), lastCircle.getY(), x, y));
        };
        circles.add(new Circle(x, y));
    }

    public List<Circle> getCircles() {
        //Preliminary optimisation
        //if there are no circles, we are creating new ones
        if (null == circles) {
            circles = new ArrayList<Circle>();
            for (Position p : backgroundResource.getPositions()) {
                Position onScreenPos = Utils.toScreen(p, screenWidth, screenHeight, backgroundResource.getWidth(), backgroundResource.getHeight());
                circles.add(new Circle(onScreenPos));
            }
        }
        //We were returning circles from here, right now we are creating cirlces from
        //the list if points inside backgroundResource
        return circles;
    }

    public List<Line> getLines() {
        return lines;
    }

    public static MainScreenModel getOurInstance() {
        return ourInstance;
    }

    public float getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(float screenWidth) {
        this.screenWidth = screenWidth;
    }

    public float getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(float screenHeight) {
        this.screenHeight = screenHeight;
    }

    public BackgroundResource getBackgroundResource() {
        return backgroundResource;
    }

    public void setBackgroundResource(BackgroundResource backgroundResource) {
        this.backgroundResource = backgroundResource;
    }
}
