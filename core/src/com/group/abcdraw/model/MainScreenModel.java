package com.group.abcdraw.model;

import com.group.abcdraw.ui.shapes.Circle;
import com.group.abcdraw.ui.shapes.Line;

import java.util.ArrayList;
import java.util.List;

/* A data keeper class of the on-screen shapes
  Processes touch events (that is an anti-pattern and possibly should be refactored) @TODO refactor
  adds a circle and a corresponding line to a list of circles and lines
 */
public class MainScreenModel {
    private static final MainScreenModel ourInstance = new MainScreenModel();

    List<Circle> circles = new ArrayList<Circle>();
    List<Line> lines = new ArrayList<Line>();
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
        return circles;
    }

    public List<Line> getLines() {
        return lines;
    }
}
