package com.q20.projectsummer.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by mohammadmahdi on 10/5/16.
 */
public class ButtonsWithIrsansFont extends Button {
    public ButtonsWithIrsansFont(Context context) {
        super(context);
        initialize();
    }

    public ButtonsWithIrsansFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public ButtonsWithIrsansFont(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ButtonsWithIrsansFont(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize();
    }

    private void initialize(){
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "irsans.ttf");
        setTypeface(tf);
    }
}
