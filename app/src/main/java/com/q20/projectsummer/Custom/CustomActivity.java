package com.q20.projectsummer.Custom;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.non_android_programmers.responsivegui.ScreenDetails;
import com.q20.projectsummer.R;

public class CustomActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {

        ScreenDetails.getScreenDimensions(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_responsivity);



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

    @Override
    protected void onStart() {
        super.onStart();
}


    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);

    }
}
