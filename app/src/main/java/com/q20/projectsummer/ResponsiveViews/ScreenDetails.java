package com.q20.projectsummer.ResponsiveViews;

import android.content.Context;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/**
 * Created by alireza on 10/15/16.
 */
public class ScreenDetails {
    final public static int DP_WIDTH = 411;
    final public static int DP_HEIGHT = 731;

    public static int pixelWidth;
    public static int pixelHeight;

    public static void getScreenDimensions(Context context){

        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE); // the results will be higher than using the activity context object or the getWindowManager() shortcut
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        pixelWidth = displayMetrics.widthPixels;
        pixelHeight = displayMetrics.heightPixels;
    }

    public static int px2Dp(Context context,int px) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int dp = Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return dp;
    }
}