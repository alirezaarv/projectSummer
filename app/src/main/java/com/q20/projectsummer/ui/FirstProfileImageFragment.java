package com.q20.projectsummer.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.q20.projectsummer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstProfileImageFragment extends Fragment {


    public FirstProfileImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.profile_image_fragment_template, container, false);

        ImageView view1 = (ImageView)view.findViewById(R.id.profile_image_page_image1);

        view1.setImageResource(R.drawable.char_m_40);

        return view;
    }

}
