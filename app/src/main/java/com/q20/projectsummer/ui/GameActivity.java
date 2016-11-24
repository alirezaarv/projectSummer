package com.q20.projectsummer.ui;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.non_android_programmers.responsivegui.PixelDimensions;
import com.non_android_programmers.responsivegui.ResponsiveAutoResizeTextView;
import com.non_android_programmers.responsivegui.ResponsiveRelativeLayout;
import com.non_android_programmers.responsivegui.ScreenDetails;
import com.q20.projectsummer.Custom.AutoResizeTextView;
import com.q20.projectsummer.Custom.CustomActivity;
import com.q20.projectsummer.R;

public class GameActivity extends CustomActivity implements View.OnClickListener {

    private String characters = "ضصثقفغعهخحجشسیبلاتنمکگظطژزرذدپوچ";
    private String word = "sala ngk m";
    private RelativeLayout parentLayout;
    private int check = 0;
    private RelativeLayout[] letters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        parentLayout = (RelativeLayout) findViewById(R.id.parent_layout);

        createKeyboard();
        createLetters();
    }


    @Override
    public void onClick(View v) {

    }

    private void createKeyboard() {
        PixelDimensions pixelDimensions = new PixelDimensions(8, 600, 8, 8, -1, -1, parentLayout);

        //values
        float marginToKeyW = 0.1f;
        float marginToKeyH = 0.1f;

        float backgroundWidthPx = pixelDimensions.getWidth();
        float keyWidthPx = backgroundWidthPx / (8 + 7 * marginToKeyW);

        float backgroundHeightPx = pixelDimensions.getHeight();
        float keyHeightPx = backgroundHeightPx / (4 + 5 * marginToKeyH);

        RelativeLayout keys[] = new RelativeLayout[33];

        int keyNumber = 0;
        float xPos = pixelDimensions.getX();
        float yPos = pixelDimensions.getY() + keyHeightPx * marginToKeyH;
        for (int j = 0; j < 4; j++) {
            xPos = pixelDimensions.getX();
            for (int i = 0; i < 8; i++) {
                keys[keyNumber] = new RelativeLayout(this);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(Math.round(keyWidthPx), Math.round(keyHeightPx));
                params.topMargin = Math.round(yPos);
                params.leftMargin = Math.round(xPos);

                keys[keyNumber].setLayoutParams(params);
                keys[keyNumber].setBackgroundResource(R.drawable.btn_shape);
                keys[keyNumber].setGravity(Gravity.CENTER);
                GradientDrawable btnBackground = (GradientDrawable) keys[keyNumber].getBackground();
                btnBackground.setColor(Color.rgb(149, 165, 166));

                parentLayout.addView(keys[keyNumber]);

                //add text
                final AutoResizeTextView textView = new AutoResizeTextView(this);
                RelativeLayout.LayoutParams btnParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                textView.setLayoutParams(btnParams);
                textView.setText("" + characters.charAt(keyNumber));
                textView.setMaxLines(1);
                textView.setTextSize(90);
                textView.setGravity(Gravity.CENTER);
                keys[keyNumber].addView(textView);

                //set listener
                keys[keyNumber].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        keyboardPressed(textView.getText().toString());
                    }
                });

                keyNumber++;
                xPos += keyWidthPx + marginToKeyW * keyWidthPx;
            }
            yPos += keyHeightPx + marginToKeyH * keyHeightPx;
        }
    }

    private void createLetters() {
        PixelDimensions pixelDimensions = new PixelDimensions(0, 467, 0, 0, -1, 50, parentLayout);

        float marginToLetterW = 0.1f;


        float backgroundWidthPx = pixelDimensions.getWidth();
        float letterSizeW = backgroundWidthPx / (10 + 11 * marginToLetterW); // max letter numbers = 10

        float backgroundHeightPx = pixelDimensions.getHeight();
        float letterSizeH = backgroundHeightPx;

        float letterSize = Math.min(letterSizeW, letterSizeH);

        float yPos = pixelDimensions.getY();
        float xPos = (backgroundWidthPx + (word.length() + (word.length()+1) * marginToLetterW) * (letterSize)) / 2 - letterSize - marginToLetterW * letterSize ;//:|

        RelativeLayout letters[] = new RelativeLayout[word.replace(" ","").length()];//not include space

        int letterNum = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != ' ') {
                letters[letterNum] = new RelativeLayout(this);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(Math.round(letterSize), Math.round(letterSize));
                params.topMargin = Math.round(yPos);
                params.leftMargin = Math.round(xPos);

                letters[letterNum].setLayoutParams(params);

                letters[letterNum].setBackgroundResource(R.drawable.btn_circle);
                letters[letterNum].setGravity(Gravity.CENTER);
                GradientDrawable btnBackground = (GradientDrawable) letters[letterNum].getBackground();
                btnBackground.setColor(Color.rgb(149, 165, 166));

                //add text
                final AutoResizeTextView textView = new AutoResizeTextView(this);
                RelativeLayout.LayoutParams btnParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                textView.setLayoutParams(btnParams);
                textView.setMaxLines(1);
                textView.setTextSize(90);
                textView.setGravity(Gravity.CENTER);
                textView.setId(0);
                letters[letterNum].addView(textView);

                final int temp = letterNum + 1;
                letters[letterNum].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (check == temp) {
                            textView.setText(null);
                            check--;
                        }
                    }
                });

                parentLayout.addView(letters[letterNum]);

                letterNum++;
            }
            xPos -= letterSize + letterSize * marginToLetterW;
        }

        this.letters = letters;
    }

    private void keyboardPressed(String letter) {
        if (check < letters.length) {
            AutoResizeTextView textView = (AutoResizeTextView) letters[check].findViewById(0);
            textView.setText(letter);
            check++;
        }
    }


}
