package com.q20.projectsummer.Custom;

import android.content.Context;
import android.util.AttributeSet;

import com.non_android_programmers.responsivegui.ResponsiveAutoResizeTextView;


public class AutoResizeTextViewWithAfsanehFont extends ResponsiveAutoResizeTextView {
    public AutoResizeTextViewWithAfsanehFont(Context context) {
        super(context);
        changeFont("afsaneh.ttf");
    }

    public AutoResizeTextViewWithAfsanehFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        changeFont("afsaneh.ttf");
    }

    public AutoResizeTextViewWithAfsanehFont(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        changeFont("afsaneh.ttf");
    }


}
