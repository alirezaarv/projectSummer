package com.q20.projectsummer.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import com.q20.projectsummer.R;
import QAPack.V1.Word;

public class NewGameDialog extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_new_game);


        this.getWindow().getDecorView().setBackgroundColor(Color.argb(0, 0, 0, 0));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.horizontalMargin = 0;
        params.verticalMargin = 0;
        this.getWindow().setAttributes(params);

    }

    public void onBackground(View view) {
        finish();
    }

    public void doNothing(View view) {
    }

    public void onOnline(View view) {

    }

    public void onOffline(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        initializeGame(true);
        startActivity(intent);
    }

    public static void passRandomWordToGameActivity(int packId) {
        GameActivity.wordPack = packId;
        GameActivity.currentWord = getRandomWord(packId);
        GameActivity.chars = new String[GameActivity.currentWord.word.replace(" ", "").length()];
    }

    public static void initializeGame(boolean newGame) {
        passRandomWordToGameActivity(0);
    }
    public static Word getRandomWord(int packNumber) {
        int random = (int) (Math.random() * MainActivity.offlinePack[packNumber].words.size());
        return MainActivity.offlinePack[packNumber].words.get(random);
    }
    @Override
    protected void onResume() {
        super.onResume();

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);

    }
}
