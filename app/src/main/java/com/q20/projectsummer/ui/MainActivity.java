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
import com.q20.projectsummer.ResponsiveViews.ScreenDetails;
import com.q20.projectsummer.utilities.Settings;

public class MainActivity extends CustomActivity implements View.OnClickListener{

    private Animation fab_open, fab_close, rotate_forward, rotate_backward, zoom_in, zoom_out
            , bounce;
    private ImageButton main_fab, share_fab, mute_fab;
    private Boolean isFabOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        main_fab = (ImageButton) findViewById(R.id.main_fab);
        share_fab = (ImageButton) findViewById(R.id.share_fab);
        mute_fab = (ImageButton) findViewById(R.id.mute_fab);

        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.open_fab);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.close_fab);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_backward_fab);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_forward_fab);
        zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
        bounce = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);

        main_fab.setOnClickListener(this);
        share_fab.setOnClickListener(this);
        mute_fab.setOnClickListener(this);

        RoundedImageView mainPlayButton = (RoundedImageView) findViewById(R.id.main_play_button);
        RoundedImageView questionButton = (RoundedImageView) findViewById(R.id.view);
        RoundedImageView rankingButton = (RoundedImageView) findViewById(R.id.view3);
        RoundedImageView informationButton = (RoundedImageView) findViewById(R.id.view2);*/
    }

    //when user click on new game local btn
    public void onNewGame(View view) {
        FragmentManager fm = getFragmentManager();
        NewGameDialog newGameDialog = new NewGameDialog();
        newGameDialog.setContext(this);
        //TODO check next line
        newGameDialog.show(fm, "salam");
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

        view.startAnimation(bounce);

        Intent intent = new Intent(this,AboutUsActivity.class);
        startActivity(intent);
    }

    public void onCoins(View view) {
        FragmentManager fm = getFragmentManager();
        BuyCoinDialog buyCoinDialog = new BuyCoinDialog();
        buyCoinDialog.setContext(this);
        //TODO check next line
        buyCoinDialog.show(fm, "salam");
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

    public void animateFab(){
        if(isFabOpen){

            main_fab.startAnimation(rotate_forward);
            share_fab.startAnimation(fab_close);
            mute_fab.startAnimation(fab_close);
            share_fab.setClickable(false);
            mute_fab.setClickable(false);
            isFabOpen = false;
            Log.d("Raj", "close");

        } else {

            main_fab.startAnimation(rotate_backward);
            share_fab.startAnimation(fab_open);
            mute_fab.startAnimation(fab_open);
            share_fab.setClickable(true);
            mute_fab.setClickable(true);
            isFabOpen = true;
            Log.d("Raj","open");

        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.main_fab:

                animateFab();
                break;
            case R.id.share_fab:

                Intent intent1 = new Intent(this, TrophyPageActivity.class);
                startActivity(intent1);
                break;
            case R.id.mute_fab:

                ImageButton btn = (ImageButton) findViewById(R.id.mute_fab);
                if (Settings.isMuted){
                    Settings.isMuted = false;
                    btn.setImageResource(R.drawable.mute);
                }else {
                    Settings.isMuted = true;
                    btn.setImageResource(R.drawable.speaker);
                }
//
//                Intent intent2 = new Intent(this, FindRivalActivity.class);
//                startActivity(intent2);
                break;
        }
    }
}