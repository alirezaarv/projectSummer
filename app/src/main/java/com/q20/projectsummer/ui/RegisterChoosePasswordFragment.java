package com.q20.projectsummer.ui;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.q20.projectsummer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterChoosePasswordFragment extends Fragment {


    public RegisterChoosePasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register_choose_password, container, false);

        ImageView imageView = (ImageView)view.findViewById(R.id.register_password_profile_image);
        TextView textView = (TextView)view.findViewById(R.id.register_password_page_username_text_view);

        if (getArguments() != null){
            imageView.setImageResource(getArguments().getInt("ID"));
            imageView.setTag(getArguments().getInt("ID"));
            textView.setText(getArguments().getString("USER_NAME"));
        }

        // Inflate the layout for this fragment
        return view;
    }

}
