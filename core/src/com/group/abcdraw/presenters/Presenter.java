package com.group.abcdraw.presenters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.group.abcdraw.eventloops.InputGameEvent;
import com.group.abcdraw.eventloops.OutputGameEvent;

public interface Presenter {
    void tick(SpriteBatch spriteBatch);

    //For background disposal
    Texture getBackgroundTexture();

    void addEvent(InputGameEvent event);

    void addEvent(OutputGameEvent event);

    //Should be called after a sprite batch rendered
    //Otherwise there will be a black screen instead of background
    void drawShapes(SpriteBatch spriteBatch, ShapeRenderer shapeRenderer);
}
