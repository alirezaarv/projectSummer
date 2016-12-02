package com.q20.projectsummer.Custom;

import android.content.Context;
import android.util.AttributeSet;
import com.non_android_programmers.responsivegui.ResponsiveAutoResizeTextView;


public class AutoResizeTextViewWithAfsanehFont extends AutoResizeTextViewWithChangeableFont {
    public AutoResizeTextViewWithAfsanehFont(Context context) {
        super(context);
        changeFont("lalezar.ttf");
    }

    public AutoResizeTextViewWithAfsanehFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        changeFont("lalezar.ttf");
    }

    public AutoResizeTextViewWithAfsanehFont(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        changeFont("lalezar.ttf");
    }


}
