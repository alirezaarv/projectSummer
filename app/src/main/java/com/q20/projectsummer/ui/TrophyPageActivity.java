package com.q20.projectsummer.ui;

import android.annotation.TargetApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.view.Gravity;

import com.q20.projectsummer.Custom.CustomActivity;
import com.q20.projectsummer.R;
import com.q20.projectsummer.ui.Adapters.TrophyPageRecyclerAdapter;

public class TrophyPageActivity extends CustomActivity {


    Slide transition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trophy_page);

        String[] texts = new String[TrophyPageData.datas.length];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = TrophyPageData.datas[i].getText();
        }
        int[] ids = new int[TrophyPageData.datas.length];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = TrophyPageData.datas[i].getId();
        }

        TrophyPageRecyclerAdapter adapter = new TrophyPageRecyclerAdapter(texts, ids);
        RecyclerView recycler = (RecyclerView) findViewById(R.id.trophy_page_recycler_container);
        recycler.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recycler.setLayoutManager(manager);

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
}
