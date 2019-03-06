package com.group.abcdraw;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.group.abcdraw.presenters.MainScreenPresenter;
import com.group.abcdraw.ui.BackgroundResource;

public class GameScreen extends ApplicationAdapter {


    private SpriteBatch spriteBatch;

//    BackgroundResource background;
//	private Texture backgroundTexture;

    MainScreenPresenter presenter = MainScreenPresenter.getInstance();


    @Override
	public void create () {

		spriteBatch = new SpriteBatch();

	}

	private void clearScreen(){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }


	public void drawStuff() {
		presenter.tick(spriteBatch);
		//TODO Draw other images
	}

	@Override
	public void render() {
	    clearScreen();
		spriteBatch.begin();

		//spriteBatch.draw(mainBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getWidth() * background.getRatio());
		drawStuff();
		spriteBatch.end();
	}

	@Override
	public void dispose () {
		presenter.getBackgroundTexture().dispose();
		spriteBatch.dispose();
	}

}
