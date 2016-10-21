package com.q20.projectsummer.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.q20.projectsummer.Custom.CustomActivity;
import com.q20.projectsummer.R;
import com.q20.projectsummer.ResponsiveViews.ScreenDetails;

/**
 * Created by Alireza Arvandi on 10/11/2016.
 */

public class GameActivity extends CustomActivity implements View.OnClickListener {

    private int maxRow = 4;
    private int maxColumn = 8;
    private float btnSizePx;
    private float btnMarginSizePx;
    private float btnToMarginRatio = 10f;
    private int maxWidthPx;
    private int maxHeightPx;
    private int topMarginPx;
    private int mainMarginPx;
    private float keyboadToWordLettersH = 1.5f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mainMarginPx = Math.round(8.f / 411.f * (float) ScreenDetails.pixelWidth);
        maxWidthPx = Math.round(395.f / 411.f * (float) ScreenDetails.pixelWidth);
        //keyboard and word letters
        maxHeightPx = Math.round(378.5f / 731.f * (float) ScreenDetails.pixelHeight);

        //word letters height


        createKeyboard();
    }

    @Override
    public void onClick(View v) {

    }

    private void createKeyboard() {
        float keyboardHPx = ((float) maxHeightPx) * 3.f / 5.f;

        float btnMarginSizeHPx = keyboardHPx / (maxRow * btnToMarginRatio + maxRow);
        float btnSizeHPx = btnToMarginRatio * btnMarginSizeHPx;

        float btnMarginSizeWPx = maxWidthPx / (maxColumn * btnToMarginRatio + maxColumn - 1);
        btnMarginSizeWPx = Math.min(btnMarginSizeWPx, btnMarginSizeHPx);
        float btnSizeWPx = (maxWidthPx - btnMarginSizeWPx * (maxColumn - 1)) / maxColumn;

        int yPos = Math.round(ScreenDetails.pixelHeight - keyboardHPx - mainMarginPx);

        RelativeLayout parentLayout = (RelativeLayout) findViewById(R.id.parent_layout);
        RelativeLayout relativeLayout[] = new RelativeLayout[32];
        for (int j = 0; j < maxRow; j++) {
            int xPos = mainMarginPx;
            for (int i = 0; i < maxColumn; i++) {

                relativeLayout[i] = new RelativeLayout(this);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(Math.round(btnSizeWPx), Math.round(btnSizeHPx));
                params.topMargin = yPos;
                params.leftMargin = xPos;
                relativeLayout[i].setLayoutParams(params);
                relativeLayout[i].setBackgroundColor(Color.rgb(70, 80, 90));

                parentLayout.addView(relativeLayout[i]);

                xPos += btnSizeWPx + btnMarginSizeWPx;
            }
            yPos += btnSizeHPx + btnMarginSizeHPx;
        }
    }


}
