package com.q20.projectsummer.ResponsiveViews;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.q20.projectsummer.R;

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

        float dpWidth = ScreenDetails.px2Dp(context,params.width);
        float dpHeight = ScreenDetails.px2Dp(context,params.height);

        float dpX = ScreenDetails.px2Dp(context,params.leftMargin) + dpWidth / 2;
        float dpY = ScreenDetails.px2Dp(context,params.topMargin) + dpHeight / 2;

        pixelDimensions = new PixelDimensions(dpX,dpY,dpWidth,dpHeight);
    }

    public void updateDimensions(){
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(pixelDimensions.getWidth(), pixelDimensions.getHeight());
        params.leftMargin = pixelDimensions.getX() - pixelDimensions.getWidth() / 2;
        params.topMargin = pixelDimensions.getY() - pixelDimensions.getHeight() / 2;

        setLayoutParams(params);

    }


}
