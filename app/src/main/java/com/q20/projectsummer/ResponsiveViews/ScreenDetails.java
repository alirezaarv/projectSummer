package com.q20.projectsummer.ResponsiveViews;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by alireza on 10/15/16.
 */
public class ScreenDetails {
    final public static int DP_WIDTH = 411;
    final public static int DP_HEIGHT = 731;

    public static int pixelWidth;
    public static int pixelHeight;

    public static void getScreenDimensions(Context context){

        Display display = ((Activity)context).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getRealSize(size);
        pixelWidth = size.x;
        pixelHeight = size.y;

    }

    public static int px2Dp(Context context,int px) {
        DisplayMetrics displayMetrics = context.getResources().getSystem().getDisplayMetrics();//context.getResources().getDisplayMetrics();
        int dp = Math.round((float) px / displayMetrics.density);
        return dp;
    }
}