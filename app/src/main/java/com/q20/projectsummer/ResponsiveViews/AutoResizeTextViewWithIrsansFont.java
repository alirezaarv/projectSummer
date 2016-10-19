package com.q20.projectsummer.ResponsiveViews;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class AutoResizeTextViewWithIrsansFont extends ResponsiveAutoResizeTextView {
    public AutoResizeTextViewWithIrsansFont(Context context) {
        super(context);
        changeFont("irsans.ttf");
    }

    public AutoResizeTextViewWithIrsansFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        changeFont("irsans.ttf");
    }

    public AutoResizeTextViewWithIrsansFont(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        changeFont("irsans.ttf");
    }


}