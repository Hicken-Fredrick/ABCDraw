package com.group.abcdraw;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.group.abcdraw.ui.screen.GameScreen;

public class Navigator {
    private static final Navigator ourInstance = new Navigator();

    public static Navigator getInstance() {
        return ourInstance;
    }

    private Navigator() {
    }

    public GameScreen selectGameScreen(Game aGame){
        return new GameScreen(aGame);
    }

    public GameScreen selectStartScreen(Game aGame){
        return new GameScreen(aGame);
    }
}
