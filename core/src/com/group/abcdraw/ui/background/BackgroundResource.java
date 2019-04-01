package com.group.abcdraw.ui.background;

import com.group.abcdraw.model.Position;

import java.util.List;

public class BackgroundResource {
    String fileName;
    int width;
    int height;
    List<Position> positions;

    private BackgroundResource() {
    }

    public BackgroundResource(String fileName, int width, int height, List<Position> positions) {
        this.fileName = fileName;
        this.width = width;
        this.height = height;
        this.positions = positions;
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

    public List<Position> getPositions() {
        return positions;
    }
}
