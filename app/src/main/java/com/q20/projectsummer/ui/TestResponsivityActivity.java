package com.q20.projectsummer.ui;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.q20.projectsummer.R;
import com.q20.projectsummer.ResponsiveViews.ResponsiveTextView;
import com.q20.projectsummer.ResponsiveViews.ScreenDetails;

public class TestResponsivityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_responsivity);
        }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        ScreenDetails.getScreenDimensions(this);
        ResponsiveTextView textView = (ResponsiveTextView) findViewById(R.id.text_test);
        textView.calculateDimensions(this);
        textView.updateDimensions();
        super.onPostCreate(savedInstanceState, persistentState);
    }

    public void onBtn(View view){
        }
}
