package com.q20.projectsummer.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.q20.projectsummer.Custom.CustomActivity;
import com.q20.projectsummer.R;

import java.io.IOException;
import java.io.InputStream;

import QAPack.V1.Pack;
import Utility.PrimitiveSerializer;

public class MainActivity extends CustomActivity {

    final static int packIDs[] = {R.raw.pack0};
    public static Pack offlinePack[] = new Pack[packIDs.length];

    Slide transition;
    ImageView profileImageView;
    TextView profileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < packIDs.length; i++) {
            InputStream inStream = getResources().openRawResource(packIDs[i]);
            try {
                byte[] packData = new byte[inStream.available()];
                inStream.read(packData);
                offlinePack[i] = new Pack();
                offlinePack[i].deserialize(PrimitiveSerializer.bytesToLS(packData));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        profileImageView = (ImageView) findViewById(R.id.main_activity_profile_image);
        //profileImageView.setTag(R.drawable.char_m_40);
        profileName = (TextView) findViewById(R.id.main_activity_profile_name);

        //TODO get data from register page
        // it is just for no bug app in xml file
        Intent intent = getIntent();
        if (intent != null){
            profileImageView.setImageResource(intent.getIntExtra("ID", R.drawable.char_m_40));
            profileImageView.setTag(intent.getIntExtra("ID", R.drawable.char_m_40));
            profileName.setText(intent.getStringExtra("USER_NAME"));
        }


        setupWindowAnimations();
    }

    @TargetApi(21)
    private void setupWindowAnimations() {
        // Re-enter transition is executed when returning to this activity
        transition = new Slide(Gravity.END);
        //transition.setSlideEdge(Gravity.END);
        transition.setDuration(300);
        getWindow().setEnterTransition(transition);
        //getWindow().setSharedElementExitTransition(slideTransition);
        //getWindow().setExitTransition(slideTransition);
    }

    //when user click on new game local btn
    public void onNewGame(View view) {
        Intent intent = new Intent(this, NewGameDialog.class);
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this, null).toBundle());
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
        Intent intent = new Intent(this, AboutUsActivity.class);
        startActivity(intent);
    }

    public void onCoins(View view) {
        Intent intent = new Intent(this, BuyCoinDialog.class);
        startActivity(intent);
    }

    public void onMute(View view) {
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

    public void onShare(View view) {
        Intent intent = new Intent(this, TrophyPageActivity.class);
        startActivity(intent);
    }

    public void onProfileImage(View view) {
        Intent intent = new Intent(this, ProfileImageActivity.class);
        intent.putExtra("ID", (Integer) profileImageView.getTag());
        startActivityForResult(intent, 1, ActivityOptionsCompat.makeSceneTransitionAnimation(this, null).toBundle());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == Activity.RESULT_OK){
                int profileImageId = data.getIntExtra("ID", R.drawable.char_m_40);

                //Initialize profile image
                profileImageView.setImageResource(profileImageId);
                profileImageView.setTag(profileImageId);
            }
        }
    }
}