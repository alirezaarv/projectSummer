package com.q20.projectsummer.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.pixelcan.inkpageindicator.InkPageIndicator;
import com.q20.projectsummer.R;
import com.q20.projectsummer.ui.Adapters.PackViewerAdapter;

public class PackSelectorActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pack_selector);

        ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        viewPager.setAdapter(new PackViewerAdapter(getSupportFragmentManager()));

        InkPageIndicator inkPageIndicator = (InkPageIndicator)findViewById(R.id.indicator);
        inkPageIndicator.setViewPager(viewPager);
    }

}
