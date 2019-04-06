package com.group.abcdraw.presenters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.group.abcdraw.eventloops.InputEventLoop;
import com.group.abcdraw.eventloops.InputGameEvent;
import com.group.abcdraw.eventloops.OutputEventLoop;
import com.group.abcdraw.eventloops.OutputGameEvent;
import com.group.abcdraw.eventloops.inputevents.ScreenTouchEvent;
import com.group.abcdraw.eventloops.outputevents.GlobalDraw;
import com.group.abcdraw.eventloops.outputevents.SetBackgroundEvent;
import com.group.abcdraw.model.MainScreenModel;
import com.group.abcdraw.model.Position;
import com.group.abcdraw.ui.background.BackgroundFactory;
import com.group.abcdraw.ui.background.BackgroundResource;
import com.group.abcdraw.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class EditorScreenPresenter extends MainScreenPresenter {
    public EditorScreenPresenter() {
    }

    List<Position> positionList = new ArrayList<Position>();

    @Override
    public void tick(SpriteBatch spriteBatch) {
        //Processing input events
        if(!inputEventLoop.isEmpty()) {

            InputGameEvent inputGameEvent = inputEventLoop.peekEvent();
            if (inputGameEvent instanceof ScreenTouchEvent) {
                //Recording each screen touch to the array and outputting it into logcat
                ScreenTouchEvent event = ((ScreenTouchEvent) inputGameEvent);
                positionList.add(new Position(event.getX(),event.getY()));
                for(Position p : positionList) {
                    Position texturePosition = Utils.toTexture(
                        p.getX(),
                        p.getY(),
                        MainScreenModel.getInstance().getScreenWidth(),
                        MainScreenModel.getInstance().getScreenHeight(),
                        BackgroundFactory.BACKGROUND_WIDTH,
                        BackgroundFactory.BACKGROUND_HEIGHT
                    );
                    Gdx.app.log("EditorScreenPresenter", String.format("points.add(new Position(%d, %d));",
                        (int)texturePosition.getX(),
                        (int)texturePosition.getY()));
                }
            }
        }
        super.tick(spriteBatch);
    }

    //For background disposal
    @Override
    public Texture getBackgroundTexture() {
        return super.getBackgroundTexture();
    }

    @Override
    public void addEvent(InputGameEvent event){
        super.addEvent(event);
    }

    @Override
    public void addEvent(OutputGameEvent event){
        super.addEvent(event);
    }

    //Should be called after a sprite batch rendered
    //Otherwise there will be a black screen instead of background
    @Override
    public void drawShapes(SpriteBatch spriteBatch, ShapeRenderer shapeRenderer) {
        super.drawShapes(spriteBatch, shapeRenderer);
    }
}



