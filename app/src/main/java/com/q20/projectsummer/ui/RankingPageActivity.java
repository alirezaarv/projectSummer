package com.q20.projectsummer.ui;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.q20.projectsummer.R;

public class RankingPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking_page);

        changeFragment(new RankingPageAroundmeFragment());
    }

    private void changeFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.ranking_page_fragment_container, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }

    public void onWeekButtonClicked(View view){
        changeFragment(new RankingPageWeeklyFragment());
    }
    public void onAroundButtonClicked(View view){changeFragment(new RankingPageAroundmeFragment());}
    public void onMonthButtonClicked(View view){
        changeFragment(new RankingPageMonthFragment());
    }
}
