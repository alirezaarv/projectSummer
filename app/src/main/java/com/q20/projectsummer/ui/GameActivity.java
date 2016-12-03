package com.q20.projectsummer.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.non_android_programmers.responsivegui.PixelDimensions;
import com.non_android_programmers.responsivegui.ResponsiveImageView;
import com.q20.projectsummer.Custom.AutoResizeTextViewWithIrsansFont;
import com.q20.projectsummer.Custom.CustomActivity;
import com.q20.projectsummer.R;

import java.util.ArrayList;

import Game.Game;
import QAPack.V1.QA;
import QAPack.V1.Question;

public class GameActivity extends CustomActivity {


    private static int currentQuestionId = 0;

    public static GameActivity currentInstance;

    private static final String characters = "ضصثقفغعهخحجشسیبلاتنمکگظطژزرذدپوچ";

    public static long timerReducerTime = 5000;

    private RelativeLayout parentLayout;
    private TextView[] lettersTextView;
    private TextView currentQuestionTextView;
    private ResponsiveImageView btnPrevQuestion;
    private ResponsiveImageView btnNextQuestion;
    private RelativeLayout btnAsk;
    private TextView textViewBtnAsk;

    private Slide transition;

    public static void addCurrentGameToGameHistory() {
        MainActivity.player.gameHistory.add(MainActivity.player.currentGame);
        MainActivity.player.currentGame = null;
    }

    public GameActivity() {
        super();
        currentInstance = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();

        setContentView(R.layout.activity_game);

        //TODO make method

        initializeViews();

        createKeyboard();
        createLetters(MainActivity.player.currentGame.currentWord.word);

        updateLetters();
        updateCurrentQuestion();

        Log.v("word ", MainActivity.player.currentGame.currentWord.word);

        setupWindowAnimations();

        setTimerTextView();
    }

    @TargetApi(21)
    private void setupWindowAnimations() {
        // Re-enter transition is executed when returning to this activity
        transition = new Slide();
        transition.setSlideEdge(Gravity.END);
        transition.setDuration(300);
        getWindow().setEnterTransition(transition);
        //getWindow().setSharedElementExitTransition(slideTransition);
        //getWindow().setExitTransition(slideTransition);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MainActivity.terminateTimer();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent,
                ActivityOptionsCompat.
                        makeSceneTransitionAnimation(this, null).
                        toBundle());

    }

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
                final AutoResizeTextViewWithIrsansFont textView = new AutoResizeTextViewWithIrsansFont(this);
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

    //TODO check if last letter is hinted
    private void keyPressed(String letter) {
        for (int i = 0; i < MainActivity.player.currentGame.letters.length; i++) {
            if (MainActivity.player.currentGame.letters[i].letter == null && !MainActivity.player.currentGame.letters[i].hinted) {
                MainActivity.player.currentGame.letters[i].letter = letter;
                updateLetters();
                break;
            }
        }
        if (userAnswerComplete()) {
            respondToUserAnswer();
        }
    }

    private boolean userAnswerComplete() {
        boolean userAnswerComplete = true;
        for (int i = 0; i < MainActivity.player.currentGame.letters.length; i++) {
            if (MainActivity.player.currentGame.letters[i].letter == null) {
                userAnswerComplete = false;
                break;
            }
        }
        return userAnswerComplete;
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
        float letterSizeW = backgroundWidthPx / (8 + 9 * marginToLetterW); // max letter numbers = 10

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
                final AutoResizeTextViewWithIrsansFont textView = new AutoResizeTextViewWithIrsansFont(this);
                styleTextView(textView, 0, false);
                temp.addView(textView);
                letters[letterNum] = textView;

                final int tempCheck = letterNum;
                temp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!MainActivity.player.currentGame.letters[tempCheck].hinted) {
                            MainActivity.player.currentGame.letters[tempCheck].letter = null;
                            updateLetters();
                        }
                    }
                });
                letterNum++;
            }
            xPos -= letterSize + letterSize * marginToLetterW;
        }

        this.lettersTextView = letters;
    }

    private void styleLetter(RelativeLayout letter, float xPos, float yPos, float letterSize) {
        letter.setLayoutParams(getViewParams(xPos, yPos, letterSize, letterSize));
        letter.setBackgroundResource(R.drawable.btn_circle);
        letter.setGravity(Gravity.CENTER);
        GradientDrawable btnBackground = (GradientDrawable) letter.getBackground();
        btnBackground.setColor(Color.parseColor("#F39C12"));
    }

    private RelativeLayout.LayoutParams getViewParams(float xPos, float yPos, float keyWidth, float keyHeight) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(Math.round(keyWidth), Math.round(keyHeight));
        params.topMargin = Math.round(yPos);
        params.leftMargin = Math.round(xPos);
        return params;
    }

    private void styleTextView(AutoResizeTextViewWithIrsansFont textView, int keyNumber, boolean isKeyBoard) {
        textView.setLayoutParams(getViewParams(0, 0, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        textView.setMaxLines(1);
        textView.setTextSize(50);
        textView.setGravity(Gravity.CENTER);
        if (isKeyBoard)
            textView.setText("" + characters.charAt(keyNumber));
    }

    private void initializeViews() {
        parentLayout = (RelativeLayout) findViewById(R.id.parent_layout);
        ((TextView) findViewById(R.id.text_view_word_explanation)).setText(MainActivity.player.currentGame.currentWord.wordExplanation);
        currentQuestionTextView = ((TextView) findViewById(R.id.text_view_current_q));
        btnPrevQuestion = (ResponsiveImageView) findViewById(R.id.btn_prev_q);
        btnNextQuestion = (ResponsiveImageView) findViewById(R.id.btn_next_q);
        btnAsk = (RelativeLayout) findViewById(R.id.btn_ask);
        textViewBtnAsk = (TextView) findViewById(R.id.text_view_btn_ask);
    }

    public void setTimerTextView() {
        AutoResizeTextViewWithIrsansFont textView = (AutoResizeTextViewWithIrsansFont) findViewById(R.id.text_view_timer);
        if (textView != null && MainActivity.player.currentGame != null)
            textView.setText(MainActivity.player.currentGame.timeLeft/1000 + "");
    }

    private void updateLetters() {
        for (int i = 0; i < lettersTextView.length; i++) {
            if (MainActivity.player.currentGame.letters[i].letter != null) {
                AutoResizeTextViewWithIrsansFont textView = (AutoResizeTextViewWithIrsansFont) lettersTextView[i];
                if (MainActivity.player.currentGame.letters[i].hinted) {
                    textView.setTextColor(Color.parseColor("#27AE60"));
                } else {
                    textView.setTextColor(Color.parseColor("#2C3E50"));
                }
                textView.setText(MainActivity.player.currentGame.letters[i].letter);
            } else {
                AutoResizeTextViewWithIrsansFont textView = (AutoResizeTextViewWithIrsansFont) lettersTextView[i];
                textView.setText("");
            }
        }
    }

    private void makeLettersRed() {
        for (int i = 0; i < lettersTextView.length; i++) {
            if (!MainActivity.player.currentGame.letters[i].hinted)
                lettersTextView[i].setTextColor(Color.parseColor("#E74C3C"));
        }
    }

    private void updateCurrentQuestion() {
        Question currentQuestion = MainActivity.offlinePack[MainActivity.player.currentGame.wordPack].questions.get(currentQuestionId);
        currentQuestionTextView.setText(currentQuestion.question);

        btnPrevQuestion.setEnabled(true);
        btnPrevQuestion.setImageResource(R.drawable.right_arrow_1);
        btnNextQuestion.setEnabled(true);
        btnNextQuestion.setImageResource(R.drawable.left_arrow_1);
        btnAsk.setEnabled(true);
        textViewBtnAsk.setText("بپرس");

        if (MainActivity.player.currentGame.askedQuestion[currentQuestionId]) {
            btnAsk.setEnabled(false);
            int answer = getCurrentQuestionAnswer(MainActivity.player.currentGame.currentWord.questions, currentQuestionId);
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
            btnPrevQuestion.setImageResource(R.drawable.right_arrow_2);
        } else if (currentQuestionId == MainActivity.offlinePack[MainActivity.player.currentGame.wordPack].questions.size() - 1) {
            btnNextQuestion.setEnabled(false);
            btnNextQuestion.setImageResource(R.drawable.left_arrow_2);
        }
    }

    private void respondToUserAnswer() {
        if (checkUserAnswer()) {
            MediaPlayer.create(this, R.raw.win).start();
            win();
        } else {
            wrongAnswer();
        }
    }

    public void win() {
        MainActivity.terminateTimer();
        Intent intent = new Intent(this, WinDialog.class);
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this, null).toBundle());

    }

    public void lose() {
        MainActivity.terminateTimer();
        Intent intent = new Intent(this, LoseDialog.class);
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this, null).toBundle());
    }

    private void wrongAnswer() {
        MediaPlayer.create(this, R.raw.buzzer).start();
        makeLettersRed();
        long timeToReduce = Math.min(timerReducerTime,MainActivity.player.currentGame.timeLeft);
        MainActivity.player.currentGame.timeLeft -= timeToReduce;
        MainActivity.player.currentGame.timePassed += timeToReduce;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                GameActivity.currentInstance.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        disableActivity();
                    }
                });
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < MainActivity.player.currentGame.letters.length; i++) {
                    if (!MainActivity.player.currentGame.letters[i].hinted)
                        MainActivity.player.currentGame.letters[i].letter = null;
                }
                GameActivity.currentInstance.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        enableActivity();
                        updateLetters();
                    }
                });
            }
        });
        thread.start();
    }

    private void disableActivity(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    private void enableActivity(){
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    private Boolean checkUserAnswer() {
        String wordCheck = MainActivity.player.currentGame.currentWord.word.replace(" ", "");
        wordCheck = wordCheck.replace("آ", "ا");
        if (wordCheck.equals(getUserAnswer()))
            return true;
        return false;
    }

    private String getUserAnswer() {
        String userAnswer = "";
        for (int i = 0; i < MainActivity.player.currentGame.letters.length; i++) {
            userAnswer += MainActivity.player.currentGame.letters[i].letter;
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

    public void onHint(View view) {
        int random = getRandomValidLetter();
        MainActivity.player.currentGame.letters[random].letter = "" + MainActivity.player.currentGame.currentWord.word.charAt(random);
        MainActivity.player.currentGame.letters[random].hinted = true;
        updateLetters();
        if (userAnswerComplete()) {
            respondToUserAnswer();
        }
    }

    private int getRandomValidLetter() {
        int random = 0;
        if (!userAnswerComplete()) {
            do {
                random = (int) (Math.random() * MainActivity.player.currentGame.currentWord.word.replace(" ","").length());
            } while (MainActivity.player.currentGame.letters[random].hinted);
        }
        return random;
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
        MainActivity.player.currentGame.askedQuestion[currentQuestionId] = true;
        updateCurrentQuestion();
    }

}