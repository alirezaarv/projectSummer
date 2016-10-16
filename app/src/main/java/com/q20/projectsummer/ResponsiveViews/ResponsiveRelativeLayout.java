package com.q20.projectsummer.ResponsiveViews;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by alireza on 10/16/16.
 */
public class ResponsiveRelativeLayout extends RelativeLayout {

    private PixelDimensions pixelDimensions;


    public ResponsiveRelativeLayout(Context context) {
        super(context);
    }

    public ResponsiveRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ResponsiveRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ResponsiveRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public PixelDimensions getPixelDimensions() {
        return pixelDimensions;
    }

    public void calculateDimensions(){
        Context context = getContext();
        RelativeLayout parent = (RelativeLayout)getParent();
        int tempW = 0,tempH = 0;
        RelativeLayout.LayoutParams parentParams = null;
        //parent.setBackgroundColor(0xFF00FF00);
        try {
            parentParams = (RelativeLayout.LayoutParams) parent.getLayoutParams();
            tempW = parentParams.width;
            tempH = parentParams.height;
        }catch (Exception e){
        }
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) getLayoutParams();

        float dpWidth = ScreenDetails.px2Dp(context,params.width);
        float dpHeight = ScreenDetails.px2Dp(context,params.height);

        float dpX = ScreenDetails.px2Dp(context,params.leftMargin) + dpWidth / 2;
        float dpY = ScreenDetails.px2Dp(context,params.topMargin) + dpHeight / 2;

        pixelDimensions = new PixelDimensions(dpX,dpY,dpWidth,dpHeight,(View)getParent());
    }

    public void updateDimensions(){
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(pixelDimensions.getWidth(), pixelDimensions.getHeight());
        params.leftMargin = pixelDimensions.getX() - pixelDimensions.getWidth() / 2;
        params.topMargin = pixelDimensions.getY() - pixelDimensions.getHeight() / 2;

        setLayoutParams(params);

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(!isInEditMode()) {
            calculateDimensions();
            updateDimensions();
        }
    }

}
