package com.q20.projectsummer.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.q20.projectsummer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondProfileImageFragment extends Fragment {


    public SecondProfileImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.profile_image_fragment_template, container, false);

        ImageView view1 = (ImageView)view.findViewById(R.id.profile_image_page_image1);
        ImageView view2 = (ImageView)view.findViewById(R.id.profile_image_page_image2);
        ImageView view3 = (ImageView)view.findViewById(R.id.profile_image_page_image3);
        ImageView view4 = (ImageView)view.findViewById(R.id.profile_image_page_image4);
        ImageView view5 = (ImageView)view.findViewById(R.id.profile_image_page_image5);
        ImageView view6 = (ImageView)view.findViewById(R.id.profile_image_page_image6);
        ImageView view7 = (ImageView)view.findViewById(R.id.profile_image_page_image7);
        ImageView view8 = (ImageView)view.findViewById(R.id.profile_image_page_image8);
        ImageView view9 = (ImageView)view.findViewById(R.id.profile_image_page_image9);
        ImageView view10 = (ImageView)view.findViewById(R.id.profile_image_page_image10);
        ImageView view11 = (ImageView)view.findViewById(R.id.profile_image_page_image11);
        ImageView view12 = (ImageView)view.findViewById(R.id.profile_image_page_image12);

        view1.setImageResource(R.drawable.char_m_14);
        view2.setImageResource(R.drawable.char_m_15);
        view3.setImageResource(R.drawable.char_m_16);
        view4.setImageResource(R.drawable.char_m_17);
        view5.setImageResource(R.drawable.char_m_18);
        view6.setImageResource(R.drawable.char_m_19);
        view7.setImageResource(R.drawable.char_m_20);
        view8.setImageResource(R.drawable.char_m_21);
        view9.setImageResource(R.drawable.char_m_22);
        view10.setImageResource(R.drawable.char_m_23);
        view11.setImageResource(R.drawable.char_m_24);
        view12.setImageResource(R.drawable.char_m_40);

        return view;
    }

}
