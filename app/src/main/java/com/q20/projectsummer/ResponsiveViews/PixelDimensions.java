package com.q20.projectsummer.ResponsiveViews;

/**
 * Created by alireza on 10/15/16.
 */
public class PixelDimensions {
    private int x;
    private int y;
    private int width;
    private int height;

    public PixelDimensions() {
    }

    public PixelDimensions(float dpX, float dpY, float dpWidth, float dpHeight) {
        setFromDp(dpX, dpY, dpWidth, dpHeight);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setFromDp(float dpX, float dpY, float dpWidth, float dpHeight) {
        float minRation = Math.min((float) ScreenDetails.pixelWidth / (float) ScreenDetails.DP_WIDTH, (float) ScreenDetails.pixelHeight/(float) ScreenDetails.DP_HEIGHT);
        this.x = (int) ( dpX / (float) ScreenDetails.DP_WIDTH * (float) ScreenDetails.pixelWidth);
        this.y = (int) ( dpY / (float) ScreenDetails.DP_HEIGHT * (float) ScreenDetails.pixelHeight);
        this.width = (int) ( dpWidth * minRation);
        this.height = (int) ( dpHeight * minRation);
    }


}