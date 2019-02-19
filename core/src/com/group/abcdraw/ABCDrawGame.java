package com.group.abcdraw;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.group.abcdraw.ui.BackgroundResource;

public class ABCDrawGame extends ApplicationAdapter {

    private Texture backgroundTexture;
    private SpriteBatch spriteBatch;
    private TextureRegion mainBackground;
    BackgroundResource background;



    @Override
	public void create () {
		spriteBatch = new SpriteBatch();
        background = new BackgroundResource("A_01.jpg", 986, 1300);
        loadTextures();
	}

	private void clearScreen(){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

	private void loadTextures() {
		backgroundTexture = new Texture(background.getFileName());
        mainBackground = new TextureRegion(backgroundTexture, 0, 0, background.getWidth(), background.getHeight());
  	}

	public void renderBackground() {
        spriteBatch.draw(mainBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getWidth() * background.getRatio());
		//spriteBatch.draw(backgroundTexture, 0, 0);
	}

	public void drawStuff() {
		//TODO Draw other images
	}

	@Override
	public void render() {
	    clearScreen();
		spriteBatch.begin();
		renderBackground(); //In first place!!!!
		drawStuff();
		spriteBatch.end();
	}

	@Override
	public void dispose () {
		backgroundTexture.dispose();
		spriteBatch.dispose();
	}

}
