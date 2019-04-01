package com.group.abcdraw.ui.screen;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.group.abcdraw.eventloops.inputevents.ScreenTouchEvent;
import com.group.abcdraw.eventloops.outputevents.SetBackgroundEvent;
import com.group.abcdraw.model.MainScreenModel;
import com.group.abcdraw.presenters.MainScreenPresenter;
import com.group.abcdraw.presenters.Presenter;
import com.group.abcdraw.ui.background.BackgroundFactory;

import java.util.ArrayList;

/**
 * Created by julienvillegas on 17/01/2017.
 */
public class GameScreen implements Screen {

    private Stage stage;
    private Game game;
    private SpriteBatch spriteBatch;
    private char letter;
    Presenter presenter = new MainScreenPresenter();
    ShapeRenderer shapeRenderer;

    public GameScreen(Game aGame) {
        game = aGame;
        stage = new Stage(new ScreenViewport());

        MainScreenModel.getInstance().setScreenHeight(Gdx.graphics.getHeight());
        MainScreenModel.getInstance().setScreenWidth(Gdx.graphics.getWidth());

        Label title = new Label("Playing Screen", MainGame.gameSkin,"big-black");
        title.setAlignment(Align.center);
        title.setY(Gdx.graphics.getHeight()*2/3);
        title.setWidth(Gdx.graphics.getWidth());
        stage.addActor(title);

        TextButton backButton = new TextButton("Back",MainGame.gameSkin);
        backButton.setWidth(Gdx.graphics.getWidth()/2);
        backButton.setPosition(Gdx.graphics.getWidth()/2-backButton.getWidth()/2,Gdx.graphics.getHeight()/4-backButton.getHeight()/2);
        backButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new TitleScreen(game));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(backButton);
        stage.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float screenX, float screenY, int pointer, int button) {
                Gdx.app.log("GameScreen", "Touch Down Registered");
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
                //return true;
                return super.touchDown(event, screenX, screenY, pointer, button);
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                Gdx.app.log("Stage Listener","inside touch dragged");

                super.touchDragged(event, x, y, pointer);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("GameScreen", "Touch Up Registered");
                presenter.addEvent(new SetBackgroundEvent(BackgroundFactory.getInstance().getByLetter(letter)));
                //return true;
                //super.touchUp(event, x, y, pointer, button);
            }
        });
    }

    @Override
    public void show() {
        Gdx.app.log("MainScreen","show");
        letter ='a';
        spriteBatch = new SpriteBatch();
        presenter.addEvent(new SetBackgroundEvent(BackgroundFactory.getInstance().getByLetter(letter)));
        shapeRenderer = new ShapeRenderer();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        clearScreen();
        spriteBatch.begin();
        //Draw stuff
        presenter.tick(spriteBatch);
        spriteBatch.end();
        //Should be called after a sprite batch rendered
        presenter.drawShapes(spriteBatch, shapeRenderer);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
        presenter.getBackgroundTexture().dispose();
        spriteBatch.dispose();
    }

    //TODO Create event
    private void clearScreen(){
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}
