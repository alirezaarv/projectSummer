package com.q20.projectsummer.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.transition.Explode;
import android.transition.Slide;
import android.util.Log;
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
import QAPack.V1.QA;
import QAPack.V1.Question;
import QAPack.V1.Word;

public class GameActivity extends CustomActivity {

    public static Word currentWord;
    public static int wordPack;
    public static String[] chars;

    private static int currentQuestionId = 0;


    private String characters = "ضصثقفغعهخحجشسیبلاتنمکگظطژزرذدپوچ";

    private RelativeLayout parentLayout;
    private TextView[] letters;
    private TextView currentQuestionTextView;
    private RelativeLayout btnPrevQuestion;
    private RelativeLayout btnNextQuestion;
    private RelativeLayout btnAsk;
    private TextView textViewBtnAsk;


    private boolean[] askedQuestion;

    Slide transition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //TODO make method
        askedQuestion = new boolean[MainActivity.offlinePack[wordPack].questions.size()];

        initializeViews();

        createKeyboard();
        createLetters(currentWord.word);

        updateLetters();
        updateCurrentQuestion();

        Log.v("word ", currentWord.word);

        setupWindowAnimations();
    }

    @TargetApi(21)
    private void setupWindowAnimations() {
        // Re-enter transition is executed when returning to this activity
        transition = new Slide();
        transition.setSlideEdge(Gravity.END);
        transition.setDuration(1000);
        getWindow().setEnterTransition(transition);
        //getWindow().setSharedElementExitTransition(slideTransition);
        //getWindow().setExitTransition(slideTransition);
    }

    //TODO make back button to back to mainActivity not newGameActivity
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent,
//                ActivityOptionsCompat.
//                        makeSceneTransitionAnimation(this, null).
//                        toBundle());
//    }

    private void createKeyboard() {
        PixelDimensions pixelDimensions = new PixelDimensions(8, 550, 8, 8, -1, -1, parentLayout);

        //values
        float marginToKeyW = 0.1f;
        float marginToKeyH = 0.2f;

        float backgroundWidthPx = pixelDimensions.getWidth();
        float keyWidth = backgroundWidthPx / (8 + 7 * marginToKeyW);

        float backgroundHeightPx = pixelDimensions.getHeight();
        float keyHeight = backgroundHeightPx / (4 + 5 * marginToKeyH);

        RelativeLayout keys[] = new RelativeLayout[33];

        int keyNumber = 0;
        float xPos;
        float yPos = pixelDimensions.getY() + keyHeight * marginToKeyH;
        for (int j = 0; j < 4; j++) {
            xPos = pixelDimensions.getX();
            for (int i = 0; i < 8; i++) {

                keys[keyNumber] = new RelativeLayout(this);
                styleKey(keys[keyNumber], xPos, yPos, keyWidth, keyHeight);
                parentLayout.addView(keys[keyNumber]);

                //add text
                final AutoResizeTextView textView = new AutoResizeTextView(this);
                styleTextView(textView, keyNumber, true);
                keys[keyNumber].addView(textView);

                //set listener
                keys[keyNumber].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        keyPressed(textView.getText().toString());
                    }
                });

                keyNumber++;
                xPos += keyWidth + marginToKeyW * keyWidth;
            }
            yPos += keyHeight + marginToKeyH * keyHeight;
        }
    }

    private void keyPressed(String letter) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == null) {
                chars[i] = letter;
                updateLetters();
                if (i == chars.length - 1) {
                    respondToUserAnswer();
                }
                break;
            }
        }
    }

    private void styleKey(RelativeLayout key, float xPos, float yPos, float keyWidth, float keyHeight) {
        key.setLayoutParams(getViewParams(xPos, yPos, keyWidth, keyHeight));
        key.setBackgroundResource(R.drawable.btn_shape);
        key.setGravity(Gravity.CENTER);
        GradientDrawable btnBackground = (GradientDrawable) key.getBackground();
        btnBackground.setColor(Color.rgb(149, 165, 166));
    }


    private void createLetters(String word) {
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
                styleLetter(temp, xPos, yPos, letterSize);
                parentLayout.addView(temp);

                //add text
                final AutoResizeTextView textView = new AutoResizeTextView(this);
                styleTextView(textView, 0, false);
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
                letterNum++;
            }
            xPos -= letterSize + letterSize * marginToLetterW;
        }

        this.letters = letters;
    }

    private void styleLetter(RelativeLayout letter, float xPos, float yPos, float letterSize) {
        letter.setLayoutParams(getViewParams(xPos, yPos, letterSize, letterSize));
        letter.setBackgroundResource(R.drawable.btn_circle);
        letter.setGravity(Gravity.CENTER);
        GradientDrawable btnBackground = (GradientDrawable) letter.getBackground();
        btnBackground.setColor(Color.rgb(149, 165, 166));
    }

    private RelativeLayout.LayoutParams getViewParams(float xPos, float yPos, float keyWidth, float keyHeight) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(Math.round(keyWidth), Math.round(keyHeight));
        params.topMargin = Math.round(yPos);
        params.leftMargin = Math.round(xPos);
        return params;
    }

    private void styleTextView(AutoResizeTextView textView, int keyNumber, boolean isKeyBoard) {
        textView.setLayoutParams(getViewParams(0, 0, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        textView.setMaxLines(1);
        textView.setTextSize(90);
        textView.setGravity(Gravity.CENTER);
        if (isKeyBoard)
            textView.setText("" + characters.charAt(keyNumber));
    }

    private void initializeViews() {
        parentLayout = (RelativeLayout) findViewById(R.id.parent_layout);
        ((TextView) findViewById(R.id.text_view_word_explanation)).setText(currentWord.wordExplanation);
        currentQuestionTextView = ((TextView) findViewById(R.id.text_view_current_q));
        btnPrevQuestion = (RelativeLayout) findViewById(R.id.btn_prev_q);
        btnNextQuestion = (RelativeLayout) findViewById(R.id.btn_next_q);
        btnAsk = (RelativeLayout) findViewById(R.id.btn_ask);
        textViewBtnAsk = (TextView) findViewById(R.id.text_view_btn_ask);
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
        Question currentQuestion = MainActivity.offlinePack[wordPack].questions.get(currentQuestionId);
        currentQuestionTextView.setText(currentQuestion.question);

        btnPrevQuestion.setEnabled(true);
        btnNextQuestion.setEnabled(true);
        btnAsk.setEnabled(true);
        textViewBtnAsk.setText("بپرس");

        if (askedQuestion[currentQuestionId]) {
            btnAsk.setEnabled(false);
            int answer = getCurrentQuestionAnswer(currentWord.questions, currentQuestionId);
            String answerText = "بی معنی";
            if (answer == 0) {
                answerText = currentQuestion.choice1;
            } else if (answer == 1) {
                answerText = currentQuestion.choice2;
            } else if (answer == 2) {
                answerText = "بستگی دارد";
            }
            textViewBtnAsk.setText(answerText);
        }

        if (currentQuestionId == 0) {
            btnPrevQuestion.setEnabled(false);
            //TODO change pic
        } else if (currentQuestionId == MainActivity.offlinePack[wordPack].questions.size() - 1) {
            btnNextQuestion.setEnabled(false);

        }
    }

    private void respondToUserAnswer() {
        if (checkUserAnswer()) {
            //TODO need a dialog
        } else {
            //TODO play false sound
            for (int i = 0; i < chars.length; i++) {
                chars[i] = null;
            }
            updateLetters();
        }
    }

    private Boolean checkUserAnswer() {
        if (currentWord.word.replace(" ", "").equals(getUserAnswer()))
            return true;
        return false;
    }

    private String getUserAnswer() {
        String userAnswer = "";
        for (int i = 0; i < chars.length; i++) {
            userAnswer += chars[i];
        }
        return userAnswer;
    }

    private int getCurrentQuestionAnswer(ArrayList<QA> qaArrayList, int currentQuestionId) {
        int answer = -1;
        for (QA qa : qaArrayList) {
            if (qa.q == currentQuestionId) {
                answer = qa.a;
                break;
            }
        }
        return answer;
    }

    public void onNextQuestion(View view) {
        currentQuestionId++;
        updateCurrentQuestion();
    }

    public void onPrevQuestion(View view) {
        currentQuestionId--;
        updateCurrentQuestion();
    }

    public void onAsk(View view) {
        askedQuestion[currentQuestionId] = true;
        updateCurrentQuestion();
    }

}