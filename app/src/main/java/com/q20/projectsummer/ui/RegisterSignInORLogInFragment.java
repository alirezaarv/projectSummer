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

public class RegisterSignInORLogInFragment extends Fragment {


    public RegisterSignInORLogInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_sign_in_orlog_in, container, false);

        // Inflate the layout for this fragment
        return view;
    }

}
