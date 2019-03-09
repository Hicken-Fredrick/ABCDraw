package com.group.abcdraw;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.group.abcdraw.eventloops.InputGameEvent;
import com.group.abcdraw.eventloops.inputevents.ScreenTouchEvent;
import com.group.abcdraw.eventloops.outputevents.SetBackgroundEvent;
import com.group.abcdraw.presenters.MainScreenPresenter;
import com.group.abcdraw.ui.background.BackgroundFactory;
import com.group.abcdraw.ui.background.BackgroundResource;
import java.lang.reflect.Array;
import java.util.ArrayList;

import sun.rmi.runtime.Log;

public class GameScreen extends ApplicationAdapter implements InputProcessor {

    private SpriteBatch spriteBatch;
    private char letter;
    MainScreenPresenter presenter = MainScreenPresenter.getInstance();
    ArrayList<ScreenTouchEvent> touches;
    ShapeRenderer shapeRenderer;


    @Override
	public void create () {
        letter ='a';
		spriteBatch = new SpriteBatch();
		presenter.addEvent(new SetBackgroundEvent(BackgroundFactory.getInstance().getByLetter(letter)));
		Gdx.input.setInputProcessor(this);
        shapeRenderer = new ShapeRenderer();
        touches = new ArrayList<ScreenTouchEvent>();
	}

	//TODO Create event
	private void clearScreen(){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
	public void render() {
	    clearScreen();
		spriteBatch.begin();
		//Draw stuff
		presenter.tick(spriteBatch, shapeRenderer);
		spriteBatch.end();
        //Should be called after a sprite batch rendered
        presenter.drawShapes(spriteBatch, shapeRenderer);
	}

	@Override
	public void dispose () {
		presenter.getBackgroundTexture().dispose();
		spriteBatch.dispose();
	}

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(letter != 'Z') {
           if (letter == Character.toUpperCase(letter)){
               letter++;
               letter = Character.toLowerCase(letter);
           }
           else {
               letter = Character.toUpperCase(letter);
           }
        }
        else
            letter = 'a';

        presenter.addEvent(new ScreenTouchEvent(screenX, screenY));
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        presenter.addEvent(new SetBackgroundEvent(BackgroundFactory.getInstance().getByLetter(letter)));
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
