package com.q20.projectsummer.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.q20.projectsummer.R;

public class PackFragmentFirst extends Fragment {

    public PackFragmentFirst(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_template, container, false);
        return view;
    }
}
