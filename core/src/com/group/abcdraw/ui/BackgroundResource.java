package com.group.abcdraw.ui;

public class BackgroundResource {
    String fileName;
    int width;
    int height;

    private BackgroundResource() {
    }

    public BackgroundResource(String fileName, int width, int height) {
        this.fileName = fileName;
        this.width = width;
        this.height = height;
    }

    public String getFileName() {
        return fileName;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getRatio() {
        return (float) height / (float) width;
    }
}
