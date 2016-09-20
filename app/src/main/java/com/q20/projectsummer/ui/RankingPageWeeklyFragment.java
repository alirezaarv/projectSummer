package com.q20.projectsummer.ui;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.q20.projectsummer.R;
import com.q20.projectsummer.ui.Adapters.RankingPageRecyclerFragmentAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class RankingPageWeeklyFragment extends Fragment {


    public RankingPageWeeklyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ranking_page_aroundme, container, false);

        String[] texts = new String[WeeklyData.datas.length];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = WeeklyData.datas[i].getText();
        }
        int[] ids = new int[WeeklyData.datas.length];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = WeeklyData.datas[i].getId();
        }

        RankingPageRecyclerFragmentAdapter adapter = new RankingPageRecyclerFragmentAdapter(texts, ids);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.ranking_page_aroundme_recycler);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }

}
