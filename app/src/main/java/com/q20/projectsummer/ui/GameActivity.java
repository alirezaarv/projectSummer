package com.q20.projectsummer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.non_android_programmers.responsivegui.PixelDimensions;
import com.q20.projectsummer.Custom.AutoResizeTextViewWithIrsansFont;
import com.q20.projectsummer.Custom.CustomActivity;
import com.q20.projectsummer.Custom.Key;
import com.q20.projectsummer.R;

import Game.Letter;
import QAPack.V1.Word;

import com.q20.projectsummer.Custom.Keyboard;

public class GameActivity extends CustomActivity {

    public static GameActivity currentInstance;


    private AutoResizeTextViewWithIrsansFont timerTextView;
    private AutoResizeTextViewWithIrsansFont wordExplanationTextView;
    private RelativeLayout parentLayout;
    private Key[] offsetLettersKeys;
    private Key[] lettersKeys;
    private Key[] keyboardKeys;

    public static void addCurrentGameToGameHistory() {
        MainActivity.player.gameHistory.add(MainActivity.player.currentGame);
        MainActivity.player.currentGame = null;
    }

    public static void reverseKeysArray(Key[] keys) {
        for (int i = 0; i < keys.length / 2; i++) {
            Key temp = keys[i];
            keys[i] = keys[keys.length - i - 1];
            keys[keys.length - i - 1] = temp;
        }
    }

    public GameActivity() {
        super();
        currentInstance = this;
    }

    public void setTimerTextView() {
        if (MainActivity.player.currentGame != null)
            updateTimer(MainActivity.player.currentGame.timeLeft / 1000 + "");
    }

    public void lose() {
        MainActivity.terminateTimer();
        Intent intent = new Intent(this, LoseDialog.class);
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this, null).toBundle());
    }

    public void win() {
        MainActivity.terminateTimer();
        Intent intent = new Intent(this, WinDialog.class);
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this, null).toBundle());
    }

    @Override
    public void onBackPressed() {
        MainActivity.terminateTimer();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this, null).toBundle());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initGUI(R.layout.activity_game, MainActivity.player.currentGame.currentWord);
    }

    private void initGUI(int layout, Word word) {
        setContentView(layout);
        initViews();
        updateWordExplanation(word.wordExplanation);
        createKeyboard();
        createLetters(word.word);
        Log.v("word : ", word.word);
        createOffsetLetters();
        updateKeyboard();
        updateLetters();
        setTimerTextView();
    }

    private void initViews() {
        parentLayout = (RelativeLayout) findViewById(R.id.parent_layout_game_activity);
        wordExplanationTextView = (AutoResizeTextViewWithIrsansFont) findViewById(R.id.text_view_word_explanation);
        timerTextView = (AutoResizeTextViewWithIrsansFont) findViewById(R.id.text_view_timer);
    }

    private void updateWordExplanation(String explanation) {
        wordExplanationTextView.setText(explanation);
    }

    private void createKeyboard() {
        PixelDimensions pixelDimensions = new PixelDimensions(2, 552, 2, 0, -1, -1, parentLayout);
        Keyboard keyboard = new Keyboard(pixelDimensions, new int[]{8, 8, 8, 8}, 0.1f, 0.2f, false);
        keyboardKeys = keyboard.makeKeys(this, "#BDC3C7", "#2C3E50");
        for (int i = 0; i < keyboardKeys.length; i++) {
            keyboardKeys[i].setTextInTextView(Keyboard.KEYBOARD_LETTERS.charAt(i) + "");
            final int temp = i;
            keyboardKeys[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addToUserLetter(keyboardKeys[temp].getTextFromTextView());
                    updateKeyboard();
                    updateLetters();
                    checkEnd();
                }
            });
        }
        drawKeyboard(keyboardKeys);
    }

    private void createLetters(String word) {
        String wordParts[] = word.split(" ");
        int keyNumberInRows[] = new int[wordParts.length];
        for (int i = 0; i < keyNumberInRows.length; i++)
            keyNumberInRows[i] = wordParts[i].length();
        PixelDimensions pixelDimensions = new PixelDimensions(8, 94, 8, 0, -1, 376, parentLayout);
        Keyboard keyboard = new Keyboard(pixelDimensions, keyNumberInRows, 0.1f, 0.1f, true);
        lettersKeys = keyboard.makeKeys(this, "#ECF0F1", "#2C3E50");
        drawKeyboard(lettersKeys);
    }

    private void createOffsetLetters() {
        PixelDimensions pixelDimensions = new PixelDimensions(40, 470, 40, 0, -1, 78, parentLayout);
        Keyboard keyboard = new Keyboard(pixelDimensions, new int[]{5}, 0.1f, 0.2f, true);
        offsetLettersKeys = keyboard.makeKeys(this, "#F39C12", "#C0392B");
        drawKeyboard(offsetLettersKeys);
    }

    private void drawKeyboard(Key[] keys) {
        for (int i = 0; i < keys.length; i++) {
            parentLayout.addView(keys[i]);
        }
    }

    private void updateTimer(String timeLeft) {
        if (timerTextView != null)
            timerTextView.setText(timeLeft);
    }

    private void updateKeyboard() {
        for (Key key : keyboardKeys) {
            inner:
            for (Letter letter : MainActivity.player.currentGame.letters) {
                String ltrInUserLetters = letter.letter;
                if (ltrInUserLetters == null)
                    break inner;
                else {
                    if (key.getTextFromTextView().equals(ltrInUserLetters)) {
                        key.changeBackColor("#2980B9");
                        key.setEnabled(false);
                        break inner;
                    }
                }
            }
        }
    }

    private void updateLetters() {
        String word = MainActivity.player.currentGame.currentWord.word.replace(" ", "");
        for (Letter ltrInUserLtr : MainActivity.player.currentGame.letters) {
            String ltr = ltrInUserLtr.letter;
            if (ltr == null)
                break;
            boolean isContain = false;
            for (int i = 0; i < word.length(); i++) {
                if (ltr.equals(word.charAt(i) + "")) {
                    lettersKeys[i].setTextInTextView(ltr);
                    isContain = true;
                }
            }
            if (!isContain) {
                for (Key key : offsetLettersKeys)
                    if (key.getTextFromTextView().equals("")) {
                        key.setTextInTextView(ltr);
                        break;
                    } else if (key.getTextFromTextView().equals(ltr)){
                        break;
                    }
            }
        }
    }

    private void addToUserLetter(String ltr) {
        for (Letter letter : MainActivity.player.currentGame.letters) {
            if (letter.letter == null) {
                letter.letter = ltr;
                break;
            }
        }
    }

    private void checkEnd(){
        if (answerIsTrue()) {
            win();
        }
        if (answerIsFalse()) {
            lose();
        }
    }

    private boolean answerIsTrue() {
        for (Key key : lettersKeys)
            if (key.getTextFromTextView().equals(""))
                return false;
        return true;
    }

    private boolean answerIsFalse() {
        for (Key key : offsetLettersKeys)
            if (key.getTextFromTextView().equals(""))
                return false;
        return true;
    }
}