package com.group.abcdraw.model;

import com.group.abcdraw.ui.shapes.CompleteCircle;
import com.group.abcdraw.ui.shapes.IncompleteCircle;
import com.group.abcdraw.ui.shapes.Line;
import com.group.abcdraw.ui.shapes.TouchCircle;

import java.util.ArrayList;
import java.util.List;

/* A data keeper class of the on-screen shapes
  Processes touch events (that is an anti-pattern and possibly should be refactored) @TODO refactor
  adds a circle and a corresponding line to a list of completeCircles and lines
 */
public class MainScreenModel {
    private static final MainScreenModel ourInstance = new MainScreenModel();

    List<CompleteCircle> completeCircles = new ArrayList<CompleteCircle>();
    List<Line> lines = new ArrayList<Line>();
    TouchCircle touchCircle;
    IncompleteCircle incompleteCircle;
    public static MainScreenModel getInstance() {
        return ourInstance;
    }

    private MainScreenModel() {
    }

    public void clear(){
        completeCircles.clear();
        lines.clear();
    }

    public void addTouch(float x, float y) {
        if(completeCircles.size() > 0) {
            CompleteCircle lastCompleteCircle = completeCircles.get(completeCircles.size()-1);
            lines.add(new Line(lastCompleteCircle.getX(), lastCompleteCircle.getY(), x, y));
        };
        completeCircles.add(new CompleteCircle(x, y));
    }

    public void addCompleteCircle(CompleteCircle completeCircle)
    {
        completeCircles.add(completeCircle);
    }

    public void popCompleteCircle()
    {
        if (completeCircles != null)
            completeCircles.remove(completeCircles.size()-1);
    }

    public void setTouchCircle(TouchCircle touchCircle) {
        this.touchCircle = touchCircle;
    }

    public void setIncompleteCircle(IncompleteCircle incompleteCircle) {
        this.incompleteCircle = incompleteCircle;
    }

    public List<CompleteCircle> getCompleteCircles() {
        return completeCircles;
    }

    public List<Line> getLines() {
        return lines;
    }
}
