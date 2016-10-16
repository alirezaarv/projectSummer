package com.q20.projectsummer.ResponsiveViews;

import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by alireza on 10/15/16.
 */
public class PixelDimensions {
    private int x;
    private int y;
    private int width;
    private int height;

    private float dpX;
    private float dpY;
    private float dpW;
    private float dpH;

    public PixelDimensions() {
    }

    public PixelDimensions(float dpX, float dpY, float dpWidth, float dpHeight, View parent) {
        this.dpX = dpX;
        this.dpY = dpY;
        this.dpW = dpWidth;
        this.dpH = dpHeight;
        setFromDp(dpX, dpY, dpWidth, dpHeight, parent);
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

    public void setFromDp(float dpX, float dpY, float dpWidth, float dpHeight, View parent) {
        RelativeLayout.LayoutParams params = null;
        float screenDPW = 0, screenDPH = 0, screenPXW = 0, screenPXH = 0;
        try {
            params = (RelativeLayout.LayoutParams) parent.getLayoutParams();
            ResponsiveRelativeLayout responsiveRelativeLayout = (ResponsiveRelativeLayout) parent;
            screenDPW = responsiveRelativeLayout.getPixelDimensions().dpW;
            screenDPH = responsiveRelativeLayout.getPixelDimensions().dpH;
            screenPXW = responsiveRelativeLayout.getPixelDimensions().width;
            screenPXH = responsiveRelativeLayout.getPixelDimensions().height;
        } catch (Exception e) {
            screenDPW = ScreenDetails.DP_WIDTH;
            screenDPH = ScreenDetails.DP_HEIGHT;
            screenPXW = ScreenDetails.pixelWidth;
            screenPXH = ScreenDetails.pixelHeight;
        }
        float minRation = Math.min((float) ScreenDetails.pixelWidth / (float) ScreenDetails.DP_WIDTH, (float) ScreenDetails.pixelHeight/(float) ScreenDetails.DP_HEIGHT);
        this.x = (int) ( dpX / screenDPW * screenPXW);
        this.y = (int) ( dpY / screenDPH * screenPXH);
        this.width = (int) ( dpWidth * minRation);
        this.height = (int) ( dpHeight * minRation);
    }


}