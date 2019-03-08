package com.group.abcdraw.ui.background;

public class BackgroundFactory {
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
        return new BackgroundResource(name, 1440, 2960);
    }
}
