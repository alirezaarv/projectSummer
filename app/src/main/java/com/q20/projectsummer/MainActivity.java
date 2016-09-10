package com.q20.projectsummer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /////////////////////////
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.openDb();
        Log.v("name", databaseAccess.getPlayerName());
        Log.v("coins", databaseAccess.getPlayerCoins() + "");
        Log.v("score", databaseAccess.getPlayerScore() + "");
        databaseAccess.closeDb();
        ////////////////////////
    }

    //when user click on new game btn
    public void onNewGame(View view) {
    }

    //when user click on trophy menu btn
    public void onTrophyMenu(View view) {
    }

    //when user click on ranking page btn
    public void onRankingMenu(View view) {
    }

    //when user click on about us btn
    public void onAboutUs(View view) {
    }
}
