package com.q20.projectsummer.ui;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.q20.projectsummer.R;
import com.q20.projectsummer.ui.Adapters.FindRivalRecyclerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindRivalPageFragment extends Fragment {


    public FindRivalPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find_rival_page, container, false);

        String[] texts = new String[FindRivalData.datas.length];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = FindRivalData.datas[i].getText();
        }
        int[] ids = new int[FindRivalData.datas.length];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = FindRivalData.datas[i].getId();
        }

        FindRivalRecyclerAdapter adapter = new FindRivalRecyclerAdapter(texts, ids);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.find_rival_recycler);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(manager);

        // Inflate the layout for this fragment
        return view;
    }

}
