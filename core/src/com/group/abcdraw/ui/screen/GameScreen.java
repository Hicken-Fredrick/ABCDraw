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
import com.group.abcdraw.eventloops.outputevents.AddCompleteCircle;
import com.group.abcdraw.eventloops.outputevents.ChangeActiveCircle;
import com.group.abcdraw.eventloops.outputevents.ChangeDragCircle;
import com.group.abcdraw.eventloops.outputevents.RemoveCompleteCircle;
import com.group.abcdraw.eventloops.outputevents.SetBackgroundEvent;
import com.group.abcdraw.model.Letter;
import com.group.abcdraw.model.MainScreenModel;
import com.group.abcdraw.model.Position;
import com.group.abcdraw.presenters.MainScreenPresenter;
import com.group.abcdraw.presenters.Presenter;
import com.group.abcdraw.ui.background.BackgroundFactory;
import com.group.abcdraw.ui.shapes.CompleteCircle;
import com.group.abcdraw.ui.shapes.IncompleteCircle;
import com.group.abcdraw.ui.shapes.TouchCircle;

/**
 * Created by julienvillegas on 17/01/2017.
 */
public class GameScreen implements Screen {
    static final int TOLERANCE = 25;
    private Stage stage;
    private Game game;
    private SpriteBatch spriteBatch;
    private char letter;
    private Letter currentLetter;
    Presenter presenter = new MainScreenPresenter();
    ShapeRenderer shapeRenderer;

    public GameScreen(Game aGame) {
        game = aGame;
        stage = new Stage(new ScreenViewport());

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
                if(checkCloseEnough(screenX, screenY)) {
                    //add drag circle for finger position
                    presenter.addEvent(new ChangeDragCircle(new TouchCircle(screenX, screenY)));

                    //push to next circle and make touched circle complete
                    Position completed = currentLetter.getSpecificPoint(currentLetter.getActivePoint());
                    presenter.addEvent(new AddCompleteCircle( new CompleteCircle( completed.getX(), completed.getY() ) ) );

                    //display next circle as the inactive circle
                    Position nextPoint = currentLetter.getSpecificPoint(currentLetter.getNextPoint());
                    presenter.addEvent(new ChangeActiveCircle(new IncompleteCircle(nextPoint.getX(), nextPoint.getY())));

                    //increment points within letter
                    currentLetter.setNextPoint(currentLetter.getNextPoint() + 1);
                    currentLetter.setActivePoint(currentLetter.getActivePoint() + 1);
                }

                return true;
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                //make sure touch is within range of position
                //presenter.addEvent(new ScreenTouchEvent(x, y));

                if(checkCloseEnough(x, y) && !currentLetter.isComplete()) {
                    //add drag circle for finger position
                    presenter.addEvent(new ChangeDragCircle(new TouchCircle(x, y)));

                    //push to next circle and make touched circle complete
                    Position completed = currentLetter.getSpecificPoint(currentLetter.getActivePoint());
                    presenter.addEvent(new AddCompleteCircle( new CompleteCircle( completed.getX(), completed.getY() ) ) );

                    if (currentLetter.getActivePoint() == currentLetter.getFinalPoint()) {
                        currentLetter.setComplete(true);
                        return;
                    }

                    //display next circle as the inactive circle
                    Position nextPoint = currentLetter.getSpecificPoint(currentLetter.getNextPoint());
                    presenter.addEvent(new ChangeActiveCircle(new IncompleteCircle(nextPoint.getX(), nextPoint.getY())));

                    //increment points within letter
                    currentLetter.setNextPoint(currentLetter.getNextPoint() + 1);
                    currentLetter.setActivePoint(currentLetter.getActivePoint() + 1);
                }

                else if (MainScreenModel.getInstance().getTouchCircle() != null) {
                   presenter.addEvent(new ChangeDragCircle(new TouchCircle(x, y)));
                }

                super.touchDragged(event, x, y, pointer);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                //if position was last position move to next letter
                if (currentLetter.isComplete()) {
                    if (letter != 'Z') {
                        if (letter == Character.toUpperCase(letter)) {
                            letter++;
                            letter = Character.toLowerCase(letter);
                        } else {
                            letter = Character.toUpperCase(letter);
                        }
                    } else
                        letter = 'a';

                    MainScreenModel.getInstance().clear();
                    presenter.addEvent(new SetBackgroundEvent(BackgroundFactory.getInstance().getByLetter(letter)));
                    currentLetter = new Letter(letter);
                    super.touchDragged(event, x, y, pointer);
                }

                else if (MainScreenModel.getInstance().getTouchCircle() != null) {
                    presenter.addEvent(new RemoveCompleteCircle());
                    presenter.addEvent(new ChangeDragCircle(null));
                }

                super.touchUp(event, x, y, pointer, button);
            }
        });
    }

    private boolean checkCloseEnough(float touchX, float touchY) {
        //!! ADD CHECK TO SEE IF TOUCH / DRAG WITHIN RANGE
        float pointX = MainScreenModel.getInstance().getIncompleteCircle().getX();
        float pointY = MainScreenModel.getInstance().getIncompleteCircle().getY();
        //check
        if (touchX < pointX + TOLERANCE && touchX > pointX - TOLERANCE &&
                touchY < pointY + TOLERANCE && touchY > pointX - TOLERANCE)
            return true;
        else
            return false;
    }

    @Override
    public void show() {
        Gdx.app.log("MainScreen","show");
        letter ='a';
        currentLetter = new Letter(letter);
        spriteBatch = new SpriteBatch();
        presenter.addEvent(new SetBackgroundEvent(BackgroundFactory.getInstance().getByLetter(letter)));
        shapeRenderer = new ShapeRenderer();
        Gdx.input.setInputProcessor(stage);
        //set up letter
        currentLetter = new Letter(letter);
        Position position = currentLetter.getSpecificPoint(currentLetter.getActivePoint());
        IncompleteCircle incompleteCircle = new IncompleteCircle(position.getX(),position.getY());
        presenter.addEvent(new ChangeActiveCircle(incompleteCircle));
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
