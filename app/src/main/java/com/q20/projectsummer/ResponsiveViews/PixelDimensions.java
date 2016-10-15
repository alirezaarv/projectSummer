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

    public PixelDimensions(int dpX, int dpY, int dpWidth, int dpHeight) {
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

    public void setFromDp(int dpX, int dpY, int dpWidth, int dpHeight) {
        this.x = (int) ((float) dpX / (float) ScreenDetails.DP_WIDTH * (float) ScreenDetails.pixelWidth);
        this.y = (int) ((float) dpY / (float) ScreenDetails.DP_HEIGHT * (float) ScreenDetails.pixelHeight);
        this.width = (int) ((float) dpWidth / (float) ScreenDetails.DP_WIDTH * (float) ScreenDetails.pixelWidth);
        this.height = (int) ((float) dpHeight / (float) ScreenDetails.DP_HEIGHT * (float) ScreenDetails.pixelHeight);
    }


}