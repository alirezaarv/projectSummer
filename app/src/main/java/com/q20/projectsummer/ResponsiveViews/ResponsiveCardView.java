package com.q20.projectsummer.ResponsiveViews;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by mohammadmahdi on 10/17/16.
 */
public class ResponsiveCardView extends CardView implements ResponsiveView{
    public ResponsiveCardView(Context context) {
        super(context);
    }

    public ResponsiveCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ResponsiveCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
