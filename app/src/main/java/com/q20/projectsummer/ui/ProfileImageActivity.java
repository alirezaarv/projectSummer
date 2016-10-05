package com.q20.projectsummer.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.anton46.stepsview.StepsView;
import com.pixelcan.inkpageindicator.InkPageIndicator;
import com.q20.projectsummer.R;
import com.q20.projectsummer.ui.Adapters.ProfileImageFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

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

//        String[] steps = {"step1", "step2"};
//        StepsView stepsView = (StepsView)findViewById(R.id.steps_view);
//        stepsView.setLabels(steps)
//                .setBarColorIndicator(this.getResources().getColor(R.color.material_blue_grey_800))
//                .setProgressColorIndicator(this.getResources().getColor(R.color.orange))
//                .setLabelColorIndicator(this.getResources().getColor(R.color.orange))
//                .setCompletedPosition(0)
//                .drawView();
    }
}
