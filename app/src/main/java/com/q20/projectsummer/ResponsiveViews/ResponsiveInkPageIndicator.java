package com.q20.projectsummer.ResponsiveViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.pixelcan.inkpageindicator.InkPageIndicator;
import com.q20.projectsummer.R;

/**
 * Created by mohammadmahdi on 10/25/16.
 */
public class ResponsiveInkPageIndicator extends InkPageIndicator implements ResponsiveView{
    private PixelDimensions pixelDimensions;
    private float polarCenterX=0;
    private float polarCenterY=0;
    private float polarRad=0;
    private float polarTheta=0;
    private boolean usePolar = false;

    public ResponsiveInkPageIndicator(Context context) {
        super(context);
    }

    public ResponsiveInkPageIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ResponsiveInkPageIndicator(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public PixelDimensions getPixelDimensions() {
        return pixelDimensions;
    }

    public void setupPolarCoord(AttributeSet attrs) {
        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.ResponsiveRecyclerView, 0, 0);
        int[] attrsRes= {R.styleable.ResponsiveRecyclerView_PolarCoordCenterX, R.styleable.ResponsiveRecyclerView_PolarCoordCenterY, R.styleable.ResponsiveRecyclerView_PolarCoordRad, R.styleable.ResponsiveRecyclerView_PolarCoordTheta, R.styleable.ResponsiveRecyclerView_UsePolar};
        polarCenterX = typedArray.getFloat(attrsRes[0], 0);
        polarCenterY = typedArray.getFloat(attrsRes[1], 0);
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
            dpEX = ScreenDetails.px2Dp(context, marginParams.bottomMargin);
            dpEY = ScreenDetails.px2Dp(context, marginParams.leftMargin);
        } catch (Exception e) {
        }

        float dpWidth = ScreenDetails.px2Dp(context, params.width);
        float dpHeight = ScreenDetails.px2Dp(context, params.height);

        pixelDimensions = new PixelDimensions(dpX, dpY, dpEX, dpEY, dpWidth, dpHeight, (View) getParent(), polarCenterX, polarCenterY, polarRad, polarTheta, usePolar);
    }

    public void updateDimensions(){
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        layoutParams.width = pixelDimensions.getWidth();
        layoutParams.height = pixelDimensions.getHeight();
        layoutParams.leftMargin = pixelDimensions.getX();
        layoutParams.topMargin = pixelDimensions.getY();
        layoutParams.rightMargin = 0;
        layoutParams.bottomMargin = 0;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            calculateDimensions();
            updateDimensions();
        }
    }
}
