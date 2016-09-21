package com.q20.projectsummer.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.pixelcan.inkpageindicator.InkPageIndicator;
import com.q20.projectsummer.R;
import com.q20.projectsummer.ui.Adapters.ProfileImageFragmentAdapter;

public class ProfileImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_image);

        ViewPager viewPager = (ViewPager)findViewById(R.id.profile_page_view_pager);
        viewPager.setAdapter(new ProfileImageFragmentAdapter(getSupportFragmentManager()));
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        InkPageIndicator indicator = (InkPageIndicator)findViewById(R.id.profile_image_indicator);
        indicator.setViewPager(viewPager);
    }
}
