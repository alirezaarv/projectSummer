package com.q20.projectsummer.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;

import com.q20.projectsummer.Custom.CustomActivity;
import com.q20.projectsummer.R;

import java.io.IOException;
import java.io.InputStream;

import QAPack.V1.Pack;
import Utility.PrimitiveSerializer;

public class MainActivity extends CustomActivity {

    final static int packIDs[] = {R.raw.pack0};
    public static Pack offlinePack[] = new Pack[packIDs.length];

    Explode transition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < packIDs.length; i++) {
            InputStream inStream = getResources().openRawResource(packIDs[i]);
            try {
                byte[] packData = new byte[inStream.available()];
                inStream.read(packData);
                offlinePack[i] = new Pack();
                offlinePack[i].deserialize(PrimitiveSerializer.bytesToLS(packData));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @TargetApi(21)
    private void setupWindowAnimations() {
        // Re-enter transition is executed when returning to this activity
        transition = new Explode();
        //transition.setSlideEdge(Gravity.END);
        transition.setDuration(1000);
        getWindow().setReenterTransition(transition);
        //getWindow().setSharedElementExitTransition(slideTransition);
        //getWindow().setExitTransition(slideTransition);
    }

    //when user click on new game local btn
    public void onNewGame(View view) {
        Intent intent = new Intent(this, NewGameDialog.class);
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this, null).toBundle());
    }

    //when user click on information btn
    public void onInformation(View view) {
        Intent intent = new Intent(this, RegisterPageActivity.class);
        startActivity(intent);
    }

    //when user click on ranking page btn
    public void onRankingMenu(View view) {
        Intent intent = new Intent(this, RankingPageActivity.class);
        startActivity(intent);
    }

    //when user click on about us btn
    public void onAboutUs(View view) {
        Intent intent = new Intent(this, AboutUsActivity.class);
        startActivity(intent);
    }

    public void onCoins(View view) {
        Intent intent = new Intent(this, BuyCoinDialog.class);
        startActivity(intent);
    }

    public void onMute(View view) {
        //TODO mute button
//        ImageButton btn = (ImageButton) findViewById(R.id.mute_fab);
//        if (Settings.isMuted){
//            Settings.isMuted = false;
//            btn.setImageResource(R.drawable.mute);
//        }else {
//            Settings.isMuted = true;
//            btn.setImageResource(R.drawable.speaker);
//        }
    }

    public void onShare(View view) {
        Intent intent = new Intent(this, TrophyPageActivity.class);
        startActivity(intent);
    }

    public void onProfileImage(View view) {
        Intent intent = new Intent(this, ProfileImageActivity.class);
        startActivity(intent);
    }


}