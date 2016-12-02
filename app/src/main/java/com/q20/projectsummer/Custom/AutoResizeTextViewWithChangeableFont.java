package com.q20.projectsummer.Custom;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;

import com.non_android_programmers.responsivegui.ResponsiveAutoResizeTextView;


public class AutoResizeTextViewWithChangeableFont extends ResponsiveAutoResizeTextView {
    public AutoResizeTextViewWithChangeableFont(Context context) {
        super(context);
    }

    public AutoResizeTextViewWithChangeableFont(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoResizeTextViewWithChangeableFont(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    public void changeFont(String fontName) {
        boolean editMode = false;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
            editMode=isInEditMode();
        if (!editMode) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), fontName);
            setTypeface(tf);
        }
    }
}
