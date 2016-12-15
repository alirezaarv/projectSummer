package com.q20.projectsummer.Custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.q20.projectsummer.R;

/**
 * Created by alireza on 12/15/16.
 */
public class Key extends RelativeLayout{

    public boolean isChecked = false;

    private AutoResizeTextViewWithIrsansFont textView;

    public static RelativeLayout.LayoutParams calculateKeyParams(float xPos, float yPos, float keyWidth, float keyHeight) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(Math.round(keyWidth), Math.round(keyHeight));
        params.topMargin = Math.round(yPos);
        params.leftMargin = Math.round(xPos);
        return params;
    }

    public Key(Context context) {
        super(context);
    }

    public Key(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Key(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public Key(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void check(boolean checked) {
        isChecked = checked;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void styleKey(float xPos, float yPos, float width, float height, String backColor) {
        this.setLayoutParams(calculateKeyParams(xPos, yPos, width, height));
        this.setGravity(Gravity.CENTER);
        this.setBackgroundResource(R.drawable.btn_shape);
        GradientDrawable btnBackground = (GradientDrawable) this.getBackground();
        btnBackground.setColor(Color.parseColor(backColor));
    }

    public void styleText(String textColor){
        textView.setLayoutParams(calculateKeyParams(0, 0, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        textView.setMaxLines(1);
        textView.setTextSize(50);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.parseColor(textColor));
    }

    public void setTextInTextView(String text){
        textView.setText(text);
    }

    public String getTextFromTextView(){
        return textView.getText().toString();
    }

    public void initTextView(Context context){
        textView = new AutoResizeTextViewWithIrsansFont(context);
        this.addView(textView);
    }

}
