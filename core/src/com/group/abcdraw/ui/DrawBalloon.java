/*************************************************
 * DrawBalloon
 *  To add this event to a section first add the following
 *  values:
 *  elapsedTime += Gdx.graphics.getDeltaTime();
 *
 *  Then call it via
 *
 *  batch.begin();
 *  batch.draw(animation.getKeyFrame(elapsedTime),0,0);
 *  batch.end();
 *************************************************/
package com.group.abcdraw.ui;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class DrawBalloon extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    TextureRegion[] animationFrames;
    Animation animation;
    float elapsedTime = 0;
    boolean alive = true;
    int yCoord = 100;


    public void create(){
        batch = new SpriteBatch();
        img = new Texture("baloonImages/balloonCycle.png");
        alive = true;
        // 2 dimensional array splits the sprite into 4 images.
        TextureRegion[][] tmpFrames = TextureRegion.split(img, 400,400);

        animationFrames = new TextureRegion[4];
        int index = 0;

        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                animationFrames[index++] = tmpFrames[j][i];
            }
        }
        // duration per frame is .25 seconds. Alter the frameDuration in below to change.
        animation = new Animation(1f/4f, animationFrames);
    }

    @Override
    public void render(){
        elapsedTime += Gdx.graphics.getDeltaTime();
        batch.begin();
        batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime, alive),100,yCoord);
        batch.end();
    }
    public void kill(){
        alive = false;
        animation = null;
        img = null;
        animationFrames = null;
        batch = null;
    }
}
