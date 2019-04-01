package com.group.abcdraw.utils;

import com.group.abcdraw.model.Position;

public class Utils {
    /**
     * A method to transform screen coordinates to texture coordinates
     * @param x coordinate - width
     * @param y coordinate - height
     * @param screenMaxX  max screen resolution X
     * @param screenMaxY max screen resolution Y
     * @param textureMaxX max texture resolution X
     * @param textureMaxY max texture resolution Y
     * @return
     */
    public static Position toTexture(float x, float y, float screenMaxX, float screenMaxY, float textureMaxX, float textureMaxY){
        assert(x >= 0 && x<= screenMaxX);
        assert(y >= 0 && y<= screenMaxY);
        float screenRatio = screenMaxX/ screenMaxY;

        //X transforms directly
        float toX = x * textureMaxX/screenMaxX;
        //either assert or clipping
        if(toX > textureMaxX) toX = textureMaxX;

        float toY = y * textureMaxY/screenMaxY * screenRatio;
        //either assert or clipping
        if(toY > textureMaxY) toY = textureMaxY;
        return new Position(toX,toY);
    }

    /** A method to transform texture coordinates to screen coordinates
     *
     * @param x - width
     * @param y -height
     * @param screenMaxX
     * @param screenMaxY
     * @param textureMaxX
     * @param textureMaxY
     * @return
     */
    public static Position toScreen(float x, float y, float screenMaxX, float screenMaxY, float textureMaxX, float textureMaxY){
        assert(x >= 0 && x<= textureMaxX);
        assert(y >= 0 && y<= textureMaxY);
        float screenRatio = screenMaxX/ screenMaxY;

        //X transforms directly
        float toX = x * screenMaxX/textureMaxX;
        //either assert or clipping
        if(toX > screenMaxX) toX = screenMaxX;

        float toY = y * screenMaxY /textureMaxY / screenRatio;
        //either assert or clipping
        if(toY > screenMaxY) toY = screenMaxY;
        return new Position(toX,toY);
    }

    public static Position toScreen(Position p, float screenMaxX, float screenMaxY, float textureMaxX, float textureMaxY){
        float x = p.getX();
        float y = p.getY();
        return toScreen(x, y, screenMaxX, screenMaxY, textureMaxX, textureMaxY);
    }
}
