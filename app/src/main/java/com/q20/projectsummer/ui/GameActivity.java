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

import com.non_android_programmers.responsivegui.ScreenDetails;
import com.q20.projectsummer.Custom.AutoResizeTextView;
import com.q20.projectsummer.Custom.CustomActivity;
import com.q20.projectsummer.R;

public class GameActivity extends CustomActivity implements View.OnClickListener {

    private int maxRow = 3;
    private int maxColumn = 11;
    private float btnToMarginRatioW = 10f;
    private float btnToMarginRatioH = 5f;
    private int maxWidthPx;
    private int maxHeightPx;
    private int mainMarginPx;
    private float keyboardToWordLettersH = 0.7f;
    private String characters = "ضصثقفغعهخحجشسیبلاتنمکگظطژزرذدپوچ";
    private String word = "salam";
    private RelativeLayout parentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        parentLayout = (RelativeLayout) findViewById(R.id.parent_layout);

        mainMarginPx = Math.round(4.f / ScreenDetails.DP_WIDTH * (float) ScreenDetails.pixelWidth);
        maxWidthPx = Math.round((float) ScreenDetails.pixelWidth - 2 * mainMarginPx);
        //keyboard and word letters
        maxHeightPx = Math.round(334.5f / ScreenDetails.DP_HEIGHT * (float) ScreenDetails.pixelHeight);

        //word letters height


        //ResponsiveRelativeLayout responsiveRelativeLayout = findViewById()

        createKeyboard();
        createLetters();
    }

    @Override
    public void onClick(View v) {

    }

    private void createKeyboard(){

    }

    private void createLetters() {
        float letterLayoutWPx = (403.f * Math.min((float) ScreenDetails.pixelWidth / ScreenDetails.DP_WIDTH, ScreenDetails.pixelHeight / ScreenDetails.DP_HEIGHT));
        float lettersLayoutHPx = ((float) maxHeightPx) * keyboardToWordLettersH;

        boolean needTwoLine = false;
        float circleSizeToMarginW = 10;
        int maxLettersInLine = 11;

        String[] parts = word.split(" ");
        int numberOfParts = parts.length;
        float lettersMarginWPx = letterLayoutWPx / (maxLettersInLine * circleSizeToMarginW + maxLettersInLine - 1);
        float lettersWSizePx = lettersMarginWPx * circleSizeToMarginW;
        float lettersHSizePx = (lettersLayoutHPx - 3 * mainMarginPx) / 2;

        float lettersSizePx = Math.min(lettersHSizePx, lettersWSizePx);

        //how many lines is need
        if (parts.length == 1) {
            needTwoLine = false;
        } else if (parts.length == 2) {
            if (parts[0].length() + parts[1].length() + 1 <= maxLettersInLine) {
                needTwoLine = false;
            } else if (parts[0].length() + parts[1].length() + 1 > maxLettersInLine) {
                needTwoLine = true;
            }
        } else if (parts.length == 3) {
            if (parts[0].length() + parts[1].length() + parts[2].length() + 2 <= maxLettersInLine) {
                needTwoLine = false;
            } else if (parts[0].length() + parts[1].length() + parts[2].length() + 2 > maxLettersInLine) {
                needTwoLine = true;
            }
        } else if (parts.length == 4) {
            needTwoLine = true;
        }

        int xPos;
        int yPos;
        RelativeLayout letters[];

        //for one line
        if (!needTwoLine) {
            yPos = (int) (Math.round(ScreenDetails.pixelHeight - maxHeightPx - 2 * mainMarginPx)
                    + lettersLayoutHPx / 2.f - lettersSizePx / 2.f);
            if (parts.length == 1) {
                letters = new RelativeLayout[parts[0].length()];
                float sizeNeeded = (lettersSizePx * parts[0].length()
                        + lettersMarginWPx * (parts[0].length() - 1));
                xPos = Math.round(ScreenDetails.pixelWidth - (ScreenDetails.pixelWidth - sizeNeeded) / 2 - lettersSizePx);
                for (int i = 0; i < parts[0].length(); i++) {
                    letters[i] = new RelativeLayout(this);
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(Math.round(lettersSizePx), Math.round(lettersSizePx));
                    params.topMargin = yPos;
                    params.leftMargin = xPos;
                    letters[i].setLayoutParams(params);
                    letters[i].setBackgroundResource(R.drawable.btn_circle);
                    letters[i].setGravity(Gravity.CENTER);
                    GradientDrawable btnBackground = (GradientDrawable) letters[i].getBackground();
                    btnBackground.setColor(Color.rgb(149, 165, 166));

                    parentLayout.addView(letters[i]);

                    xPos -= lettersSizePx + lettersMarginWPx;
                }
            } else if (parts.length == 2) {

            } else if (parts.length == 3) {

            }
        }

        //for two line
        if (needTwoLine) {
            if (parts.length == 1) {

            } else if (parts.length == 2) {

            } else if (parts.length == 3) {

            } else if (parts.length == 4) {

            }
        }

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void _createKeyboard() {
        float keyboardHPx = ((float) maxHeightPx) * keyboardToWordLettersH / (keyboardToWordLettersH + 1);

        float btnMarginSizeHPx = keyboardHPx / (maxRow * btnToMarginRatioH + maxRow);
        float btnSizeHPx = btnToMarginRatioH * btnMarginSizeHPx;

        float btnMarginSizeWPx = maxWidthPx / (maxColumn * btnToMarginRatioW + maxColumn - 1);
        btnMarginSizeWPx = Math.min(btnMarginSizeWPx, btnMarginSizeHPx);
        float btnSizeWPx = (maxWidthPx - btnMarginSizeWPx * (maxColumn - 1)) / maxColumn;

        int yPos = Math.round(ScreenDetails.pixelHeight - keyboardHPx - mainMarginPx);


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
