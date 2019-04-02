package com.group.abcdraw.presenters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.group.abcdraw.eventloops.InputGameEvent;
import com.group.abcdraw.eventloops.InputEventLoop;
import com.group.abcdraw.eventloops.OutputEventLoop;
import com.group.abcdraw.eventloops.OutputGameEvent;
import com.group.abcdraw.eventloops.inputevents.ScreenTouchEvent;
import com.group.abcdraw.eventloops.outputevents.AddCompleteCircle;
import com.group.abcdraw.eventloops.outputevents.ChangeActiveCircle;
import com.group.abcdraw.eventloops.outputevents.ChangeDragCircle;
import com.group.abcdraw.eventloops.outputevents.GlobalDraw;
import com.group.abcdraw.eventloops.outputevents.RemoveCompleteCircle;
import com.group.abcdraw.eventloops.outputevents.SetBackgroundEvent;
import com.group.abcdraw.model.MainScreenModel;
import com.group.abcdraw.ui.background.BackgroundResource;

public class MainScreenPresenter implements Presenter {

    public MainScreenPresenter() {
    }

    //For background disposal
    Texture backgroundTexture;
    TextureRegion mainBackground;
    int mainBackgroundHeight;
    int mainBackgroundWidth;

    InputEventLoop inputEventLoop = new InputEventLoop();
    OutputEventLoop outputEventLoop = new OutputEventLoop();

    @Override
    public void tick(SpriteBatch spriteBatch) {
        //Processing input events
        if(!inputEventLoop.isEmpty()) {
            Gdx.app.log("MainScreenPresenter", "Parsing input events");
            InputGameEvent inputGameEvent = inputEventLoop.getEvent();
            if (inputGameEvent instanceof ScreenTouchEvent) {
                MainScreenModel.getInstance().addTouch(((ScreenTouchEvent) inputGameEvent).getX(), ((ScreenTouchEvent) inputGameEvent).getY());
            }
        }

        if(!outputEventLoop.isEmpty()) {
            Gdx.app.log("MainScreenPresenter", "Parsing output events");
            OutputGameEvent outputGameEvent = outputEventLoop.getEvent();
            if (outputGameEvent instanceof SetBackgroundEvent) {
                //@TODO process
                BackgroundResource background;
                background = ((SetBackgroundEvent) outputGameEvent).getResource();
                backgroundTexture = new Texture(background.getFileName());
                mainBackground = new TextureRegion(backgroundTexture, 0, 0, background.getWidth(), background.getHeight());
                mainBackgroundWidth = Gdx.graphics.getWidth();
                mainBackgroundHeight = (int) (Gdx.graphics.getWidth() * background.getRatio());
                if (mainBackgroundHeight > Gdx.graphics.getHeight()) mainBackgroundHeight = Gdx.graphics.getHeight();
            }
            else if (outputGameEvent instanceof ChangeActiveCircle) {
                MainScreenModel.getInstance().setIncompleteCircle(((ChangeActiveCircle) outputGameEvent).getIncompleteCircle() );
            }
            else if (outputGameEvent instanceof ChangeDragCircle) {
                MainScreenModel.getInstance().setTouchCircle(((ChangeDragCircle) outputGameEvent).getTouchCircle());
            }
            else if (outputGameEvent instanceof AddCompleteCircle) {
               MainScreenModel.getInstance().addCompleteCircle(((AddCompleteCircle) outputGameEvent).getCompleteCircle());
            }
            else if (outputGameEvent instanceof RemoveCompleteCircle) {
                MainScreenModel.getInstance().popCompleteCircle();
            }

        }
        //Drawing background each tick
        if (mainBackground != null) {
            //draw letter
            spriteBatch.draw(mainBackground, 0, 0, mainBackgroundWidth, mainBackgroundHeight);
            //draw points
        }
        Gdx.app.log("MainScreenPresenter", "Completed Tick");
    }

    //For background disposal
    @Override
    public Texture getBackgroundTexture() {
        return backgroundTexture;
    }

    @Override
    public void addEvent(InputGameEvent event){
        inputEventLoop.add(event);
    }

    @Override
    public void addEvent(OutputGameEvent event){
        outputEventLoop.add(event);
    }

    //Should be called after a sprite batch rendered
    //Otherwise there will be a black screen instead of background
    @Override
    public void drawShapes(SpriteBatch spriteBatch, ShapeRenderer shapeRenderer) {
        GlobalDraw.drawCircles(spriteBatch, shapeRenderer);
        GlobalDraw.drawLines(spriteBatch, shapeRenderer);
    }
}



