package com.group.abcdraw.ui.background;

public class BackgroundFactory {
    public static final int BACKGROUND_WIDTH = 1440;
    public static final int BACKGROUND_HEIGHT = 2960;
    private static final BackgroundFactory ourInstance = new BackgroundFactory();

    public static BackgroundFactory getInstance() {
        return ourInstance;
    }

    private BackgroundFactory() {
    }

    public BackgroundResource getByLetter(char letter){
        String name;
        if (Character.isLowerCase(letter)) {
            name = "letterImages/lowercase"+Character.toUpperCase(letter)+".png";
        } else {
            name = "letterImages/uppercase"+letter+".png";
        }
        return new BackgroundResource(name, BACKGROUND_WIDTH, BACKGROUND_HEIGHT, PositionsRepository.getInstance().getByLetter(letter));
    }
}
