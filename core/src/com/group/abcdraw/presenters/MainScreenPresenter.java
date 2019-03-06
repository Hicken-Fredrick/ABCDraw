package com.group.abcdraw.presenters;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.group.abcdraw.eventloops.GameEvent;
import com.group.abcdraw.eventloops.InputEventLoop;
import com.group.abcdraw.eventloops.OutputEventLoop;
import com.group.abcdraw.eventloops.Realtime;
import com.group.abcdraw.eventloops.inputevents.ScreenTouchEvent;
import com.group.abcdraw.eventloops.outputevents.DrawBackgroundEvent;
import com.group.abcdraw.ui.BackgroundResource;

public class MainScreenPresenter {
    private static final MainScreenPresenter ourInstance = new MainScreenPresenter();

    public static MainScreenPresenter getInstance() {
        return ourInstance;
    }

    private MainScreenPresenter() {
    }

    BackgroundResource background;
    private Texture backgroundTexture;
    private TextureRegion mainBackground;

    InputEventLoop inputEventLoop = InputEventLoop.getInstance();
    OutputEventLoop outputEventLoop = OutputEventLoop.getInstance();

    public void tick(SpriteBatch spriteBatch) {
        if(!inputEventLoop.isEmpty()) {
            GameEvent inputGameEvent = inputEventLoop.getEvent();
            if (inputGameEvent instanceof ScreenTouchEvent) {
                //@TODO process screen touches
            }
        }

        if(!outputEventLoop.isEmpty()) {
            GameEvent outputGameEvent = outputEventLoop.getEvent();
            if (outputGameEvent instanceof DrawBackgroundEvent) {
                //@TODO process
                background = new BackgroundResource("A_01.jpg", 986, 1300);
                backgroundTexture = new Texture(background.getFileName());
                mainBackground = new TextureRegion(backgroundTexture, 0, 0, background.getWidth(), background.getHeight());
            }
        }
    }

    public Texture getBackgroundTexture() {
        return backgroundTexture;

    }
}



