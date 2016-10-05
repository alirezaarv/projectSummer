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
public class RegisterChooseUserNameFragment extends Fragment {


    public RegisterChooseUserNameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register_choose_user_name, container, false);

        ImageView imageView = (ImageView)view.findViewById(R.id.register_username_profile_image);

        int tag;
        if (getArguments() != null) {
            tag = getArguments().getInt("ID");
            imageView.setImageResource(tag);
            imageView.setTag(tag);
        }
//        if (getArguments() != null){
//            imageView.setImageResource(getArguments().getInt("ID"));
//        }

        // Inflate the layout for this fragment
        return view;
    }

}
