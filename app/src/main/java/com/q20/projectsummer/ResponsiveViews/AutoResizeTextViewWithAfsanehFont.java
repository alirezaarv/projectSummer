package com.q20.projectsummer.ResponsiveViews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class AutoResizeTextViewWithAfsanehFont extends ResponsiveAutoResizeTextView {
    public AutoResizeTextViewWithAfsanehFont(Context context) {
        super(context);
        changeFont();
    }

    public AutoResizeTextViewWithAfsanehFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        changeFont();
    }

    public AutoResizeTextViewWithAfsanehFont(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        changeFont();
    }

    private void changeFont() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "afsaneh.ttf");
            setTypeface(tf);
        }
    }

}
