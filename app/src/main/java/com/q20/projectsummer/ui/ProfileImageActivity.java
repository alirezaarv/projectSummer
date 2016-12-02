package com.q20.projectsummer.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import com.anton46.stepsview.StepsView;
import com.pixelcan.inkpageindicator.InkPageIndicator;
import com.q20.projectsummer.Custom.CustomActivity;
import com.q20.projectsummer.R;
import com.q20.projectsummer.ui.Adapters.ProfileImageFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProfileImageActivity extends CustomActivity {

    ImageView imageView;
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

        imageView = (ImageView)findViewById(R.id.profile_image_page_main_image_image_view);
        Intent intent = getIntent();
        if (intent != null){
            imageView.setImageResource(intent.getIntExtra("ID", R.drawable.char_m_40));
            imageView.setTag(intent.getIntExtra("ID", R.drawable.char_m_40));

        }

        setupWindowAnimations();
    }

    @TargetApi(21)
    private void setupWindowAnimations(){
        Slide slide = new Slide(Gravity.END);
        slide.setDuration(300);
        getWindow().setEnterTransition(slide);
    }

    private void onImagesClickingMethod(int IMAGES_ID){
        imageView.setImageResource(IMAGES_ID);
        imageView.setTag(IMAGES_ID);
        Intent intent = new Intent();
        intent.putExtra("ID", (Integer) imageView.getTag());
        setResult(Activity.RESULT_OK, intent);
    }

    public void image1(View view){
        onImagesClickingMethod((Integer) view.getTag());
    }
    public void image2(View view){
        onImagesClickingMethod((Integer) view.getTag());
    }
    public void image3(View view){
        onImagesClickingMethod((Integer) view.getTag());
    }
    public void image4(View view){
        onImagesClickingMethod((Integer) view.getTag());
    }
    public void image5(View view){
        onImagesClickingMethod((Integer) view.getTag());
    }
    public void image6(View view){
        onImagesClickingMethod((Integer) view.getTag());
    }
    public void image7(View view){
        onImagesClickingMethod((Integer) view.getTag());
    }
    public void image8(View view){
        onImagesClickingMethod((Integer) view.getTag());
    }
    public void image9(View view){
        onImagesClickingMethod((Integer) view.getTag());
    }
    public void image10(View view){
        onImagesClickingMethod((Integer) view.getTag());
    }
    public void image11(View view){
        onImagesClickingMethod((Integer) view.getTag());
    }
    public void image12(View view){
        onImagesClickingMethod((Integer) view.getTag());
    }
}
