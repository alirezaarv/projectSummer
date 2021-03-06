package com.q20.projectsummer.Custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.github.lzyzsd.circleprogress.DonutProgress;
import com.non_android_programmers.responsivegui.PixelDimensions;
import com.non_android_programmers.responsivegui.ResponsiveView;
import com.non_android_programmers.responsivegui.ScreenDetails;


public class CircularResponsiveProgressBar extends DonutProgress implements ResponsiveView {

    private PixelDimensions pixelDimensions;
    private float polarOriginX = 0;
    private float polarOriginY = 0;
    private float polarRad = 0;
    private float polarTheta = 0;
    private boolean usePolar = false;


    public CircularResponsiveProgressBar(Context context) {
        super(context);
    }

    public CircularResponsiveProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupPolarCoord(attrs);
    }

    public CircularResponsiveProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupPolarCoord(attrs);
    }

    public PixelDimensions getPixelDimensions() {
        return pixelDimensions;
    }


    public void setupPolarCoord(AttributeSet attrs) {
        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs, com.non_android_programmers.responsivegui.R.styleable.ResponsiveProgressBar, 0, 0);
        int[] attrsRes = {com.non_android_programmers.responsivegui.R.styleable.ResponsiveProgressBar_PolarCoordOriginX, com.non_android_programmers.responsivegui.R.styleable.ResponsiveProgressBar_PolarCoordOriginY, com.non_android_programmers.responsivegui.R.styleable.ResponsiveProgressBar_PolarCoordRad, com.non_android_programmers.responsivegui.R.styleable.ResponsiveProgressBar_PolarCoordTheta, com.non_android_programmers.responsivegui.R.styleable.ResponsiveProgressBar_UsePolar};
        polarOriginX = typedArray.getFloat(attrsRes[0], 0);
        polarOriginY = typedArray.getFloat(attrsRes[1], 0);
        polarRad = typedArray.getFloat(attrsRes[2], 0);
        polarTheta = typedArray.getFloat(attrsRes[3], 0);
        usePolar = typedArray.getBoolean(attrsRes[4], false);
        typedArray.recycle();
    }

    public void calculateDimensions() {
        Context context = getContext();

        ViewGroup.LayoutParams params = getLayoutParams();

        float dpX = 0;
        float dpY = 0;
        float dpEX = 0;
        float dpEY = 0;

        try {
            ViewGroup.MarginLayoutParams marginParams = (ViewGroup.MarginLayoutParams) params;

            dpX = ScreenDetails.px2Dp(context, marginParams.leftMargin);
            dpY = ScreenDetails.px2Dp(context, marginParams.topMargin);
            dpEX = ScreenDetails.px2Dp(context, marginParams.rightMargin);
            dpEY = ScreenDetails.px2Dp(context, marginParams.topMargin);
        } catch (Exception e) {
        }

        float dpWidth = ScreenDetails.px2Dp(context, params.width);
        float dpHeight = ScreenDetails.px2Dp(context, params.height);

        pixelDimensions = new PixelDimensions(dpX, dpY, dpEX, dpEY, dpWidth, dpHeight, (View) getParent(), polarOriginX, polarOriginY, polarRad, polarTheta, usePolar);
    }

    public void updateDimensions() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = pixelDimensions.getWidth();
        layoutParams.height = pixelDimensions.getHeight();

        try {
            ViewGroup.MarginLayoutParams marginParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginParams.leftMargin = pixelDimensions.getX();
            marginParams.topMargin = pixelDimensions.getY();
            marginParams.rightMargin = 0;
            marginParams.bottomMargin = 0;
        } catch (Exception e) {
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        boolean editMode = false;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
            editMode=isInEditMode();
        if (!editMode) {
            calculateDimensions();
            updateDimensions();
        }
    }
}
