package com.q20.projectsummer.ui;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.non_android_programmers.responsivegui.PixelDimensions;
import com.q20.projectsummer.Custom.AutoResizeTextView;
import com.q20.projectsummer.Custom.CustomActivity;
import com.q20.projectsummer.R;

import java.util.ArrayList;

import QAPack.V1.Question;
import QAPack.V1.Word;

public class GameActivity extends CustomActivity {

    public static Word currentWord;
    public static int wordPack;

    private String characters = "ضصثقفغعهخحجشسیبلاتنمکگظطژزرذدپوچ";
    private String word = currentWord.word;
    private RelativeLayout parentLayout;
    private TextView[] letters;
    private static String[] chars;
    private static int currentQuestionId = 0;
    private TextView currentQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        parentLayout = (RelativeLayout) findViewById(R.id.parent_layout);
        ((TextView) findViewById(R.id.text_view_word_explanation)).setText(currentWord.wordExplanation);
        currentQuestion = ((TextView) findViewById(R.id.text_view_current_q));


        createKeyboard();
        createLetters();

        updateLetters();
        updateCurrentQuestion();

    }


    private void createKeyboard() {
        PixelDimensions pixelDimensions = new PixelDimensions(8, 550, 8, 8, -1, -1, parentLayout);

        //values
        float marginToKeyW = 0.1f;
        float marginToKeyH = 0.2f;

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
                        String letter = textView.getText().toString();
                        for (int i = 0; i < chars.length; i++) {
                            if (chars[i] == null) {
                                chars[i] = letter;
                                updateLetters();
                                break;
                            }
                        }
                    }
                });

                keyNumber++;
                xPos += keyWidthPx + marginToKeyW * keyWidthPx;
            }
            yPos += keyHeightPx + marginToKeyH * keyHeightPx;
        }
    }

    private void createLetters() {
        PixelDimensions pixelDimensions = new PixelDimensions(0, 442, 0, 0, -1, 50, parentLayout);

        float marginToLetterW = 0.2f;


        float backgroundWidthPx = pixelDimensions.getWidth();
        float letterSizeW = backgroundWidthPx / (10 + 11 * marginToLetterW); // max letter numbers = 10

        float backgroundHeightPx = pixelDimensions.getHeight();
        float letterSizeH = backgroundHeightPx;

        float letterSize = Math.min(letterSizeW, letterSizeH);

        float yPos = pixelDimensions.getY();
        float xPos = (backgroundWidthPx + (word.length() + (word.length() + 1) * marginToLetterW) * (letterSize)) / 2 - letterSize - marginToLetterW * letterSize;//:|

        TextView letters[] = new TextView[word.replace(" ", "").length()];//not include space

        int letterNum = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != ' ') {
                RelativeLayout temp = new RelativeLayout(this);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(Math.round(letterSize), Math.round(letterSize));
                params.topMargin = Math.round(yPos);
                params.leftMargin = Math.round(xPos);

                temp.setLayoutParams(params);

                temp.setBackgroundResource(R.drawable.btn_circle);
                temp.setGravity(Gravity.CENTER);
                GradientDrawable btnBackground = (GradientDrawable) temp.getBackground();
                btnBackground.setColor(Color.rgb(149, 165, 166));

                //add text
                final AutoResizeTextView textView = new AutoResizeTextView(this);
                RelativeLayout.LayoutParams btnParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                textView.setLayoutParams(btnParams);
                textView.setMaxLines(1);
                textView.setTextSize(90);
                textView.setGravity(Gravity.CENTER);
                textView.setId(0);
                temp.addView(textView);
                letters[letterNum] = textView;

                final int tempCheck = letterNum;
                temp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        chars[tempCheck] = null;
                        updateLetters();
                    }
                });

                parentLayout.addView(temp);

                letterNum++;
            }
            xPos -= letterSize + letterSize * marginToLetterW;
        }

        this.letters = letters;
        if (chars == null)
            this.chars = new String[word.replace(" ", "").

                    length()

                    ];
    }

    private void updateLetters() {
        for (int i = 0; i < letters.length; i++) {
            if (chars[i] != null) {
                AutoResizeTextView textView = (AutoResizeTextView) letters[i];
                textView.setText(chars[i]);
            } else {
                AutoResizeTextView textView = (AutoResizeTextView) letters[i];
                textView.setText("");
            }
        }
    }

    private void updateCurrentQuestion() {
        ArrayList<Question> questions = MainActivity.offlinePack[wordPack].questions;
        Question question = questions.get(currentQuestionId);
        currentQuestion.setText(question.question);

        findViewById(R.id.btn_prev_q).setEnabled(true);
        findViewById(R.id.btn_next_q).setEnabled(true);

        if (currentQuestionId == 0) {
            findViewById(R.id.btn_prev_q).setEnabled(false);
            //TODO change pic
        } else if (currentQuestionId == questions.size() - 1) {
            findViewById(R.id.btn_next_q).setEnabled(false);

        }
    }

    public void onNextQuestion(View view) {
        currentQuestionId++;
        updateCurrentQuestion();
    }

    public void onPrevQuestion(View view) {
        currentQuestionId--;
        updateCurrentQuestion();
    }



}