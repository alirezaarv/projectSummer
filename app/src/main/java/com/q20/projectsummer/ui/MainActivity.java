package com.q20.projectsummer.ui;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.q20.projectsummer.Custom.CustomActivity;
import com.q20.projectsummer.R;
import com.q20.projectsummer.utilities.Settings;

public class MainActivity extends CustomActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //when user click on new game local btn
    public void onNewGame(View view) {

        Intent intent = new Intent(this, NewGameDialog.class);
        startActivity(intent);

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
        Intent intent = new Intent(this,AboutUsActivity.class);
        startActivity(intent);
    }

    public void onCoins(View view) {
        Intent intent = new Intent(this, BuyCoinDialog.class);
        startActivity(intent);
    }

    public void onMute(View view){
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

    public void onShare(View view){
        Intent intent = new Intent(this, TrophyPageActivity.class);
        startActivity(intent);
    }

    public void onProfileImage(View view){
        Intent intent = new Intent(this, ProfileImageActivity.class);
        startActivity(intent);
    }


}