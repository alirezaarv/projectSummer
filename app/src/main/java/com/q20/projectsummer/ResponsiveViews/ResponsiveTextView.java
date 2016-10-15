package com.q20.projectsummer.ResponsiveViews;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by alireza on 10/15/16.
 */
public class ResponsiveTextView extends TextView{

    private PixelDimensions pixelDimensions;



    public ResponsiveTextView(Context context) {
        super(context);
    }


    public ResponsiveTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ResponsiveTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ResponsiveTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void calculateDimensions(Context context){
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) getLayoutParams();
        int dpX = ScreenDetails.px2Dp(context,params.leftMargin);
        int dpY = ScreenDetails.px2Dp(context,params.topMargin);


        int dpWidth = ScreenDetails.px2Dp(context,params.width);
        int dpHeight = ScreenDetails.px2Dp(context,params.height);

        pixelDimensions = new PixelDimensions(dpX,dpY,dpWidth,dpHeight);
    }

    public void updateDimensions(){
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(pixelDimensions.getWidth(), pixelDimensions.getHeight());
        params.leftMargin = pixelDimensions.getX();
        params.topMargin = pixelDimensions.getY();

        setLayoutParams(params);

    /*    setX(pixelDimensions.getX());
        setY(pixelDimensions.getY());
        setWidth(pixelDimensions.getWidth());
        setHeight(pixelDimensions.getHeight());
    */
    }

}
