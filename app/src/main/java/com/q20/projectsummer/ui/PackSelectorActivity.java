package com.q20.projectsummer.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.github.lzyzsd.circleprogress.DonutProgress;
import com.q20.projectsummer.R;
import com.q20.projectsummer.utilities.User;

public class PackSelectorActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pack_selector);


        long levelsPassed = User.levelsPassed;
        DonutProgress progress = (DonutProgress) findViewById(R.id.donut_progress);
        //TODO
        progress.setProgress(10);
        progress.setMax(100);
    }

}
