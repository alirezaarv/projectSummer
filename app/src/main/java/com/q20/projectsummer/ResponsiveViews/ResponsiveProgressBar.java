package com.q20.projectsummer.ResponsiveViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.github.lzyzsd.circleprogress.DonutProgress;

public class ResponsiveProgressBar extends DonutProgress implements ResponsiveView{

    private PixelDimensions pixelDimensions;


    public ResponsiveProgressBar(Context context) {
        super(context);
    }

    public ResponsiveProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ResponsiveProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public PixelDimensions getPixelDimensions() {
        return pixelDimensions;
    }

    public void calculateDimensions(){
        Context context = getContext();
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) getLayoutParams();

        float dpWidth = ScreenDetails.px2Dp(context,params.width);
        float dpHeight = ScreenDetails.px2Dp(context,params.height);

        float dpX = ScreenDetails.px2Dp(context,params.leftMargin);
        float dpY = ScreenDetails.px2Dp(context,params.topMargin);

        pixelDimensions = new PixelDimensions(dpX,dpY,dpWidth,dpHeight,(View)getParent());
    }

    public void updateDimensions(){
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        layoutParams.width = pixelDimensions.getWidth();
        layoutParams.height = pixelDimensions.getHeight();
        layoutParams.leftMargin = pixelDimensions.getX();
        layoutParams.topMargin = pixelDimensions.getY();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            calculateDimensions();
            updateDimensions();
        }
    }}
