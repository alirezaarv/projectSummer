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
        setFromDp(parent);
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

    public void setFromDp(View parent) {

        ResponsiveView responsiveView = null;
        float screenDPW = 0, screenDPH = 0, screenPXW = 0, screenPXH = 0;
        try {
            responsiveView = (ResponsiveView) parent;
            screenDPW = responsiveView.getPixelDimensions().dpW;
            screenDPH = responsiveView.getPixelDimensions().dpH;
            screenPXW = responsiveView.getPixelDimensions().width;
            screenPXH = responsiveView.getPixelDimensions().height;
        } catch (Exception e) {
            screenDPW = ScreenDetails.DP_WIDTH;
            screenDPH = ScreenDetails.DP_HEIGHT;
            screenPXW = ScreenDetails.pixelWidth;
            screenPXH = ScreenDetails.pixelHeight;
        }


        float minRatio = Math.min((float) ScreenDetails.pixelWidth / (float) ScreenDetails.DP_WIDTH, (float) ScreenDetails.pixelHeight/(float) ScreenDetails.DP_HEIGHT);
        float xRatioRatio =  screenPXW / screenDPW / minRatio;
        float yRatioRatio =  screenPXH / screenDPH / minRatio;

        dpW = (dpW < 0) ? (screenDPW - dpX) * xRatioRatio: dpW;//this is magic, do not touch
        dpH = (dpH < 0) ? (screenDPH - dpY) * yRatioRatio: dpH;

        this.x = (int) ((dpX + dpW / 2 / xRatioRatio)/ screenDPW * screenPXW);
        this.y = (int) ((dpY + dpH / 2 / yRatioRatio) / screenDPH * screenPXH);
        this.width = (int) ( dpW * minRatio);
        this.height = (int) ( dpH * minRatio);
        this.x -= this.width/2;
        this.y -= this.height/2;
    }


}