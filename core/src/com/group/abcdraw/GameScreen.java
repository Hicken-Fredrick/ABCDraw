package com.group.abcdraw;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group.abcdraw.eventloops.outputevents.SetBackgroundEvent;
import com.group.abcdraw.presenters.MainScreenPresenter;
import com.group.abcdraw.ui.BackgroundResource;

public class GameScreen extends ApplicationAdapter {

    private SpriteBatch spriteBatch;
    MainScreenPresenter presenter = MainScreenPresenter.getInstance();

    @Override
	public void create () {
		spriteBatch = new SpriteBatch();
		presenter.addEvent(new SetBackgroundEvent(new BackgroundResource("A_01.jpg", 986, 1300)));
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
		presenter.tick(spriteBatch);
		spriteBatch.end();
	}

	@Override
	public void dispose () {
		presenter.getBackgroundTexture().dispose();
		spriteBatch.dispose();
	}
}
