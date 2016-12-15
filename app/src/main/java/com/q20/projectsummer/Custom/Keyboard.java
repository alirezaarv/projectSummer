package com.q20.projectsummer.Custom;

import android.content.Context;

import com.non_android_programmers.responsivegui.PixelDimensions;

/**
 * Created by alireza on 12/15/16.
 */

public class Keyboard {
    public static final String KEYBOARD_LETTERS = "ضصثقفغعهخحجشسیبلاتنمکگظطژزرذدپوچ";

    int[] keyNumberInRows;

    float marginToKeyW;
    float marginToKeyH;

    float keyWidth;
    float keyHeight;

    float marginWidth;
    float marginHeight;

    float xStartPos;
    float width;
    float yStartPos;

    public Keyboard(PixelDimensions pixelDimensions, int[] keyNumberInRows, float marginToKeyW, float marginToKeyH, boolean isSquareKey) {
        this.keyNumberInRows = keyNumberInRows;
        this.marginToKeyW = marginToKeyW;
        this.marginToKeyH = marginToKeyH;
        calculate(pixelDimensions, isSquareKey);
    }

    private void calculate(PixelDimensions pixelDimensions, boolean isSquareKey) {
        float backgroundHeightPx = pixelDimensions.getHeight();
        keyHeight = backgroundHeightPx / (keyNumberInRows.length + (keyNumberInRows.length + 1) * marginToKeyH);
        marginHeight = keyHeight * marginToKeyH;

        float backgroundWidthPx = pixelDimensions.getWidth();
        width = backgroundWidthPx;
        keyWidth = Float.MAX_VALUE;
        for (int keyNumberInRow : keyNumberInRows) {
            float temp = backgroundWidthPx / (keyNumberInRow + (keyNumberInRow + 1) * marginToKeyW);
            keyWidth = Math.min(keyWidth, temp);
        }
        marginWidth = keyWidth * marginToKeyW;

        if (isSquareKey) {
            float keySize = Math.min(keyHeight, keyWidth);
            keyWidth = keySize;
            keyHeight = keySize;
        }

        xStartPos = pixelDimensions.getX() + pixelDimensions.getWidth();
        yStartPos = pixelDimensions.getY() + (backgroundHeightPx - keyNumberInRows.length * keyHeight - (keyNumberInRows.length - 1) * marginHeight) / 2;
    }

    public String getText(int number) {
        return KEYBOARD_LETTERS.charAt(number) + "";
    }

    public Key[] makeKeys(Context context, String backColor, String textColor) {
        int keyNumbers = 0;
        for (int keyNumberInRow : keyNumberInRows)
            keyNumbers += keyNumberInRow;

        Key keys[] = new Key[keyNumbers];

        float xPos, yPos = yStartPos;
        int j = 0, i, keyNumber = 0;
        while (j < keyNumberInRows.length) {
            xPos = xStartPos - (width - (keyNumberInRows[j] * keyWidth + (keyNumberInRows[j] - 1) * marginWidth)) / 2 - keyWidth;
            i = 0;
            while (i < keyNumberInRows[j]) {
                final Key key = new Key(context);
                key.styleKey(xPos, yPos, keyWidth, keyHeight, backColor);
                key.initTextView(context);
                key.styleText(textColor);
                keys[keyNumber] = key;
                i++;
                keyNumber++;
                xPos -= keyWidth + marginWidth;
            }
            j++;
            yPos += keyHeight + marginHeight;
        }
        return keys;
    }
}