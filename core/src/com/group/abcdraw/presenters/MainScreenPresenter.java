package com.group.abcdraw.presenters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.group.abcdraw.eventloops.InputGameEvent;
import com.group.abcdraw.eventloops.InputEventLoop;
import com.group.abcdraw.eventloops.OutputEventLoop;
import com.group.abcdraw.eventloops.OutputGameEvent;
import com.group.abcdraw.eventloops.inputevents.ScreenTouchEvent;
import com.group.abcdraw.eventloops.outputevents.SetBackgroundEvent;
import com.group.abcdraw.ui.BackgroundResource;

public class MainScreenPresenter {
    private static final MainScreenPresenter ourInstance = new MainScreenPresenter();

    public static MainScreenPresenter getInstance() {
        return ourInstance;
    }

    private MainScreenPresenter() {
    }

    //For background disposal
    private Texture backgroundTexture;
    private TextureRegion mainBackground;
    private int mainBackgroundHeight;
    private int mainBackgroundWidth;

    InputEventLoop inputEventLoop = InputEventLoop.getInstance();
    OutputEventLoop outputEventLoop = OutputEventLoop.getInstance();

    public void tick(SpriteBatch spriteBatch) {
        if(!inputEventLoop.isEmpty()) {
            InputGameEvent inputGameEvent = inputEventLoop.getEvent();
            if (inputGameEvent instanceof ScreenTouchEvent) {
                //@TODO process screen touches
            }
        }

        if(!outputEventLoop.isEmpty()) {
            OutputGameEvent outputGameEvent = outputEventLoop.getEvent();
            if (outputGameEvent instanceof SetBackgroundEvent) {
                //@TODO process
                BackgroundResource background;
                background = ((SetBackgroundEvent) outputGameEvent).getResource();
                backgroundTexture = new Texture(background.getFileName());
                mainBackground = new TextureRegion(backgroundTexture, 0, 0, background.getWidth(), background.getHeight());
                mainBackgroundWidth = Gdx.graphics.getWidth();
                mainBackgroundHeight = (int) (Gdx.graphics.getWidth() * background.getRatio());
            }
        }
        //Drawing background each tick
        if (mainBackground != null) spriteBatch.draw(mainBackground, 0, 0, mainBackgroundWidth, mainBackgroundHeight);
    }

    //For background disposal
    public Texture getBackgroundTexture() {
        return backgroundTexture;
    }

    public void addEvent(InputGameEvent event){
        inputEventLoop.add(event);
    }

    public void addEvent(OutputGameEvent event){
        outputEventLoop.add(event);
    }
}



