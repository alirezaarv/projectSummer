package com.q20.projectsummer.ResponsiveViews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by mohammadmahdi on 10/17/16.
 */
public class ResponsiveRecyclerView extends RecyclerView implements ResponsiveView{
    public ResponsiveRecyclerView(Context context) {
        super(context);
    }

    public ResponsiveRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ResponsiveRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    PixelDimensions pixelDimensions;

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
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(pixelDimensions.getWidth(), pixelDimensions.getHeight());
        params.leftMargin = pixelDimensions.getX();
        params.topMargin = pixelDimensions.getY();

        setLayoutParams(params);
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
