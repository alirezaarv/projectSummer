package com.q20.projectsummer.ui;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.q20.projectsummer.R;
import com.q20.projectsummer.ui.RegisterActivity;
import com.q20.projectsummer.utilities.Settings;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        Intent intent = new Intent(this, RegisterActivity.class);
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
        FragmentManager fm = getFragmentManager();
        BuyCoinDialog buyCoinDialog = new BuyCoinDialog();
        buyCoinDialog.setContext(this);
        //TODO check next line
        buyCoinDialog.show(fm, "salam");
    }

    public void onMute(View view){
        ImageButton btn = (ImageButton) findViewById(R.id.btn_mute);
        if (Settings.isMuted){
            Settings.isMuted = false;
            btn.setImageResource(R.drawable.mute);
        }else {
            Settings.isMuted = true;
            btn.setImageResource(R.drawable.speaker);
        }
    }

    public void onShare(View view){

    }
}