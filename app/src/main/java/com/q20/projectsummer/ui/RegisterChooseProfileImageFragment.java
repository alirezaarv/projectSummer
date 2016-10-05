package com.q20.projectsummer.ui;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.q20.projectsummer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterChooseProfileImageFragment extends Fragment {


    public RegisterChooseProfileImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_choose_profile_image, container, false);

        ImageView imageView = (ImageView)view.findViewById(R.id.profile_image);
        imageView.setTag(R.drawable.char_m_40);

        // Inflate the layout for this fragment
        return view;
    }

}
