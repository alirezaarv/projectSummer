package com.q20.projectsummer.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.q20.projectsummer.Custom.CustomActivity;
import com.q20.projectsummer.R;
import com.q20.projectsummer.ResponsiveViews.ScreenDetails;

import java.nio.BufferUnderflowException;
import java.util.Random;

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
    private int heightPx;
    private int mainMarginPx = 21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        maxWidthPx =Math.round(395.f/411.f * (float) ScreenDetails.pixelWidth);


        createKeyboard();
    }

    @Override
    public void onClick(View v) {

    }

    private void createKeyboard() {
        RelativeLayout parentLayout = (RelativeLayout) findViewById(R.id.parent_layout);

        btnMarginSizePx = maxWidthPx / (maxColumn * btnToMarginRatio + maxColumn - 1);
        btnSizePx = btnToMarginRatio * btnMarginSizePx;
        heightPx = Math.round(maxRow * btnSizePx + (maxRow - 1) * btnMarginSizePx);

        int yPos = ScreenDetails.pixelHeight - heightPx - mainMarginPx;

        RelativeLayout relativeLayout[] = new RelativeLayout[32];
        for (int j = 0; j < maxRow; j++) {
            int xPos = mainMarginPx;
            for (int i = 0; i < maxColumn; i++) {

                relativeLayout[i] = new RelativeLayout(this);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(Math.round(btnSizePx),Math.round(btnSizePx));
                params.topMargin = yPos;
                params.leftMargin = xPos;
                relativeLayout[i].setLayoutParams(params);
                relativeLayout[i].setBackgroundColor(Color.rgb(70, 80, 90));

                parentLayout.addView(relativeLayout[i]);

                xPos += btnSizePx + btnMarginSizePx;
            }
            yPos += btnSizePx + btnMarginSizePx;
        }


    }

}
