package com.q20.projectsummer.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.transition.Explode;
import android.transition.Slide;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.q20.projectsummer.R;

import Game.*;
import QAPack.V1.Word;

public class NewGameDialog extends Activity {

    Slide transition;

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

        setupWindowAnimations();

    }

    @TargetApi(21)
    private void setupWindowAnimations() {
        // Re-enter transition is executed when returning to this activity
        transition = new Slide();
        //slideTransition.setSlideEdge(Gravity.END);
        transition.setDuration(500);

        Explode explode = new Explode();
        explode.setDuration(500);

        getWindow().setEnterTransition(transition);
        //getWindow().setExitTransition(explode);
        //getWindow().setSharedElementExitTransition(transition);
        //getWindow().setExitTransition(slideTransition);
    }

    public void onBackground(View view) {
        finish();
    }

    public void doNothing(View view) {
    }

    public void onOnline(View view) {
        Toast.makeText(getApplicationContext(), "It will be available soon ;)", Toast.LENGTH_SHORT).show();
    }

    public void onOffline(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        if (MainActivity.player.currentGame == null) {
            MainActivity.initializeGame(true);
        } else {
            GameActivity.currentGame = MainActivity.player.currentGame;
        }
        startActivity(intent,
                ActivityOptionsCompat.
                        makeSceneTransitionAnimation(this, null).
                        toBundle());
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
