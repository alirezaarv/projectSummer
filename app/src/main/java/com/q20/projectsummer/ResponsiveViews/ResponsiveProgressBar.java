package com.q20.projectsummer.ResponsiveViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.github.lzyzsd.circleprogress.DonutProgress;
import com.q20.projectsummer.R;

public class ResponsiveProgressBar extends DonutProgress implements ResponsiveView{

    private PixelDimensions pixelDimensions;
    private float polarCenterX=0;
    private float polarCenterY=0;
    private float polarRad=0;
    private float polarTheta=0;
    private boolean usePolar = false;


    public ResponsiveProgressBar(Context context) {
        super(context);
    }

    public ResponsiveProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupPolarCoord(attrs);
    }

    public ResponsiveProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupPolarCoord(attrs);
    }
    public PixelDimensions getPixelDimensions() {
        return pixelDimensions;
    }


    public void setupPolarCoord(AttributeSet attrs) {
        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.ResponsiveProgressBar, 0, 0);
        int[] attrsRes= {R.styleable.ResponsiveProgressBar_PolarCoordCenterX, R.styleable.ResponsiveProgressBar_PolarCoordCenterY, R.styleable.ResponsiveProgressBar_PolarCoordRad, R.styleable.ResponsiveProgressBar_PolarCoordTheta, R.styleable.ResponsiveProgressBar_UsePolar};
        polarCenterX = typedArray.getFloat(attrsRes[0], 0);
        polarCenterY = typedArray.getFloat(attrsRes[1], 0);
        polarRad = typedArray.getFloat(attrsRes[2], 0);
        polarTheta = typedArray.getFloat(attrsRes[3], 0);
        usePolar = typedArray.getBoolean(attrsRes[4], false);
        typedArray.recycle();
    }

    public void calculateDimensions(){
        Context context = getContext();
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) getLayoutParams();

        float dpWidth = ScreenDetails.px2Dp(context,params.width);
        float dpHeight = ScreenDetails.px2Dp(context,params.height);

        float dpX = ScreenDetails.px2Dp(context,params.leftMargin);
        float dpY = ScreenDetails.px2Dp(context,params.topMargin);

        pixelDimensions = new PixelDimensions(dpX,dpY,dpWidth,dpHeight,(View)getParent(), polarCenterX, polarCenterY, polarRad, polarTheta, usePolar);
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
