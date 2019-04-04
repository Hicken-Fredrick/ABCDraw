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
    TouchCircle touchCircle;
    IncompleteCircle incompleteCircle;
    List<Line> lines = new ArrayList<Line>();
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
        if(completeCircles.size() > 0)
        {
            lines.add(new Line(completeCircles.get(completeCircles.size()-1).getX()
                    ,completeCircles.get(completeCircles.size()-1).getY(),
                    completeCircle.getX(),
                    completeCircle.getY()));
        }
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

    public TouchCircle getTouchCircle() {
        return touchCircle;
    }

    public IncompleteCircle getIncompleteCircle() {
        return incompleteCircle;
    }

    public List<CompleteCircle> getCompleteCircles() {
        return completeCircles;
    }

    public CompleteCircle getFinalCompleteCircle() {
        if (completeCircles.size() == 0)
            return null;
        else
            return completeCircles.get(completeCircles.size()-1);
    }

    public List<Line> getLines() {
        return lines;
    }

}
