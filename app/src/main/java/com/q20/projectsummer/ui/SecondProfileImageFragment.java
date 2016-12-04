package com.q20.projectsummer.ui;


import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
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

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.profile_image_fragment_template, container, false);

//        ImageView view1 = (ImageView)view.findViewById(R.id.profile_image_page_image1);
//        ImageView view2 = (ImageView)view.findViewById(R.id.profile_image_page_image2);
//        ImageView view3 = (ImageView)view.findViewById(R.id.profile_image_page_image3);
//        ImageView view4 = (ImageView)view.findViewById(R.id.profile_image_page_image4);
//        ImageView view5 = (ImageView)view.findViewById(R.id.profile_image_page_image5);
//        ImageView view6 = (ImageView)view.findViewById(R.id.profile_image_page_image6);
//        ImageView view7 = (ImageView)view.findViewById(R.id.profile_image_page_image7);
//        ImageView view8 = (ImageView)view.findViewById(R.id.profile_image_page_image8);
//        ImageView view9 = (ImageView)view.findViewById(R.id.profile_image_page_image9);
//        ImageView view10 = (ImageView)view.findViewById(R.id.profile_image_page_image10);
//        ImageView view11 = (ImageView)view.findViewById(R.id.profile_image_page_image11);
//        ImageView view12 = (ImageView)view.findViewById(R.id.profile_image_page_image12);
//
//        view1.setImageResource(R.drawable.char_m_14);
//        view2.setImageResource(R.drawable.char_m_15);
//        view3.setImageResource(R.drawable.char_m_16);
//        view4.setImageResource(R.drawable.char_m_17);
//        view5.setImageResource(R.drawable.char_m_18);
//        view6.setImageResource(R.drawable.char_m_19);
//        view7.setImageResource(R.drawable.char_m_20);
//        view8.setImageResource(R.drawable.char_m_21);
//        view9.setImageResource(R.drawable.char_m_22);
//        view10.setImageResource(R.drawable.char_m_23);
//        view11.setImageResource(R.drawable.char_m_24);
//        view12.setImageResource(R.drawable.char_m_40);
//
//        view1.setTag(R.drawable.char_m_14);
//        view2.setTag(R.drawable.char_m_15);
//        view3.setTag(R.drawable.char_m_16);
//        view4.setTag(R.drawable.char_m_17);
//        view5.setTag(R.drawable.char_m_18);
//        view6.setTag(R.drawable.char_m_19);
//        view7.setTag(R.drawable.char_m_20);
//        view8.setTag(R.drawable.char_m_21);
//        view9.setTag(R.drawable.char_m_22);
//        view10.setTag(R.drawable.char_m_23);
//        view11.setTag(R.drawable.char_m_24);
//        view12.setTag(R.drawable.char_m_40);

        final Integer[] IDs= {R.drawable.char_m_14,R.drawable.char_m_15, R.drawable.char_m_16, R.drawable.char_m_17,
                R.drawable.char_m_18, R.drawable.char_m_19, R.drawable.char_m_20, R.drawable.char_m_21,
                R.drawable.char_m_22, R.drawable.char_m_23,R.drawable.char_m_24, R.drawable.char_m_40};

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                new SetImagesAsync().execute(IDs);
            }
        }, 1000);
        return view;
    }


    private class SetImagesAsync extends AsyncTask<Integer, Void, Boolean> {
        ImageView view1;
        ImageView view2;
        ImageView view3;
        ImageView view4;
        ImageView view5;
        ImageView view6;
        ImageView view7;
        ImageView view8;
        ImageView view9;
        ImageView view10;
        ImageView view11;
        ImageView view12;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            view1 = (ImageView)view.findViewById(R.id.profile_image_page_image1);
            view2 = (ImageView)view.findViewById(R.id.profile_image_page_image2);
            view3 = (ImageView)view.findViewById(R.id.profile_image_page_image3);
            view4 = (ImageView)view.findViewById(R.id.profile_image_page_image4);
            view5 = (ImageView)view.findViewById(R.id.profile_image_page_image5);
            view6 = (ImageView)view.findViewById(R.id.profile_image_page_image6);
            view7 = (ImageView)view.findViewById(R.id.profile_image_page_image7);
            view8 = (ImageView)view.findViewById(R.id.profile_image_page_image8);
            view9 = (ImageView)view.findViewById(R.id.profile_image_page_image9);
            view10 = (ImageView)view.findViewById(R.id.profile_image_page_image10);
            view11 = (ImageView)view.findViewById(R.id.profile_image_page_image11);
            view12 = (ImageView)view.findViewById(R.id.profile_image_page_image12);
        }

        @Override
        protected Boolean doInBackground(final Integer... params) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    view1.setImageResource(params[0]);
                    view2.setImageResource(params[1]);
                    view3.setImageResource(params[2]);
                    view4.setImageResource(params[3]);
                    view5.setImageResource(params[4]);
                    view6.setImageResource(params[5]);
                    view7.setImageResource(params[6]);
                    view8.setImageResource(params[7]);
                    view9.setImageResource(params[8]);
                    view10.setImageResource(params[9]);
                    view11.setImageResource(params[10]);
                    view12.setImageResource(params[11]);


                    view1.setTag(params[0]);
                    view2.setTag(params[1]);
                    view3.setTag(params[2]);
                    view4.setTag(params[3]);
                    view5.setTag(params[4]);
                    view6.setTag(params[5]);
                    view7.setTag(params[6]);
                    view8.setTag(params[7]);
                    view9.setTag(params[8]);
                    view10.setTag(params[9]);
                    view11.setTag(params[10]);
                    view12.setTag(params[11]);
                }
            });
            return null;
        }
    }
}
