package com.group.abcdraw;

import com.badlogic.gdx.ApplicationAdapter;

public class Navigator {
    private static final Navigator ourInstance = new Navigator();

    public static Navigator getInstance() {
        return ourInstance;
    }

    private ApplicationAdapter currentScreen;

    private Navigator() {
    }

    public ApplicationAdapter selectGameScreen(){
        return new GameScreen();
    }

    public ApplicationAdapter selectStartScreen(){
        return new GameScreen();
    }
}
