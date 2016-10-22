package com.q20.projectsummer.ui;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.q20.projectsummer.Custom.AutoResizeTextView;
import com.q20.projectsummer.Custom.CustomActivity;
import com.q20.projectsummer.R;
import com.q20.projectsummer.ResponsiveViews.ScreenDetails;

/**
 * Created by Alireza Arvandi on 10/11/2016.
 */

public class GameActivity extends CustomActivity implements View.OnClickListener {

    private int maxRow = 3;
    private int maxColumn = 11;
    private float btnToMarginRatioW = 10f;
    private float btnToMarginRatioH = 5f;
    private int maxWidthPx;
    private int maxHeightPx;
    private int mainMarginPx;
    private float keyboardToWordLettersH = 0.6f;
    private String characters = "ضصثقفغعهخحجشسیبلاتنمکگظطژزرذدپوچ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mainMarginPx = Math.round(4.f / 411.f * (float) ScreenDetails.pixelWidth);
        maxWidthPx = Math.round((float) ScreenDetails.pixelWidth - 2 * mainMarginPx);
        //keyboard and word letters
        maxHeightPx = Math.round(378.5f / 731.f * (float) ScreenDetails.pixelHeight);

        //word letters height


        createKeyboard();
    }

    @Override
    public void onClick(View v) {

    }

    private void createLetters() {

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void createKeyboard() {
        float keyboardHPx = ((float) maxHeightPx) * keyboardToWordLettersH / (keyboardToWordLettersH + 1);

        float btnMarginSizeHPx = keyboardHPx / (maxRow * btnToMarginRatioH + maxRow);
        float btnSizeHPx = btnToMarginRatioH * btnMarginSizeHPx;

        float btnMarginSizeWPx = maxWidthPx / (maxColumn * btnToMarginRatioW + maxColumn - 1);
        btnMarginSizeWPx = Math.min(btnMarginSizeWPx, btnMarginSizeHPx);
        float btnSizeWPx = (maxWidthPx - btnMarginSizeWPx * (maxColumn - 1)) / maxColumn;

        int yPos = Math.round(ScreenDetails.pixelHeight - keyboardHPx - mainMarginPx);

        RelativeLayout parentLayout = (RelativeLayout) findViewById(R.id.parent_layout);

        //create background
        RelativeLayout relativeLayoutBack = new RelativeLayout(this);
        RelativeLayout.LayoutParams backParams = new RelativeLayout.LayoutParams(ScreenDetails.pixelWidth, Math.round(keyboardHPx + mainMarginPx * 3));
        backParams.topMargin = ScreenDetails.pixelHeight - Math.round(keyboardHPx + mainMarginPx * 2);
        relativeLayoutBack.setLayoutParams(backParams);
        relativeLayoutBack.setBackgroundResource(R.drawable.keyboard_background);

        GradientDrawable background = (GradientDrawable) relativeLayoutBack.getBackground();
        background.setColor(Color.rgb(189, 195, 199));

        parentLayout.addView(relativeLayoutBack);

        //create btn
        RelativeLayout relativeLayout[] = new RelativeLayout[32];
        int c = 0;
        for (int j = 0; j < maxRow; j++) {
            int xPos = mainMarginPx;
            for (int i = 0; i < maxColumn; i++) {

                relativeLayout[i] = new RelativeLayout(this);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(Math.round(btnSizeWPx), Math.round(btnSizeHPx));
                params.topMargin = yPos;
                params.leftMargin = xPos;
                relativeLayout[i].setLayoutParams(params);
                relativeLayout[i].setBackgroundResource(R.drawable.btn_shape);
                relativeLayout[i].setGravity(Gravity.CENTER);
                GradientDrawable btnBackground = (GradientDrawable) relativeLayout[i].getBackground();
                btnBackground.setColor(Color.rgb(149, 165, 166));

                parentLayout.addView(relativeLayout[i]);

                //add text
                AutoResizeTextView textView = new AutoResizeTextView(this);
                RelativeLayout.LayoutParams btnParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                textView.setLayoutParams(btnParams);
                if (c < 32) {
                    textView.setText("" + characters.charAt(c));
                    c++;
                }
                textView.setMaxLines(1);
                textView.setTextSize(90);
                textView.setGravity(Gravity.CENTER);
                relativeLayout[i].addView(textView);


                xPos += btnSizeWPx + btnMarginSizeWPx;
            }
            yPos += btnSizeHPx + btnMarginSizeHPx;
        }
    }

}
