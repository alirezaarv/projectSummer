package com.q20.projectsummer.ui;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
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


    Context innerContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        innerContext = context;
    }

    public FirstProfileImageFragment() {
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

//        final ImageView[] VIEWs = {(ImageView)view.findViewById(R.id.profile_image_page_image1),
//                (ImageView)view.findViewById(R.id.profile_image_page_image2),
//                (ImageView)view.findViewById(R.id.profile_image_page_image3),
//                (ImageView)view.findViewById(R.id.profile_image_page_image4),
//                (ImageView)view.findViewById(R.id.profile_image_page_image5),
//                (ImageView)view.findViewById(R.id.profile_image_page_image6),
//                (ImageView)view.findViewById(R.id.profile_image_page_image7),
//                (ImageView)view.findViewById(R.id.profile_image_page_image8),
//                (ImageView)view.findViewById(R.id.profile_image_page_image9),
//                (ImageView)view.findViewById(R.id.profile_image_page_image10),
//                (ImageView)view.findViewById(R.id.profile_image_page_image11),
//                (ImageView)view.findViewById(R.id.profile_image_page_image12)};
//
//        final int[] IDs= {R.drawable.char_m_2,R.drawable.char_m_3, R.drawable.char_m_4, R.drawable.char_m_5,
//                R.drawable.char_m_6, R.drawable.char_m_7, R.drawable.char_m_8, R.drawable.char_m_9,
//                R.drawable.char_m_10, R.drawable.char_m_11, R.drawable.char_m_12};
//
//        final int[] i = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
//        final Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                VIEWs[i[0]].setImageResource(IDs[i[0]]);
//                VIEWs[i[0]].setTag(IDs[i[0]]);
//
//                //VIEWs[i].postDelayed(runnable, 1000);
//            }
//        };
//        VIEWs[i[0]].postDelayed(runnable, 1000);


//        view1.setImageResource(R.drawable.char_m_2);
//        view2.setImageResource(R.drawable.char_m_3);
//        view3.setImageResource(R.drawable.char_m_4);
//        view4.setImageResource(R.drawable.char_m_5);
//        view5.setImageResource(R.drawable.char_m_6);
//        view6.setImageResource(R.drawable.char_m_7);
//        view7.setImageResource(R.drawable.char_m_8);
//        view8.setImageResource(R.drawable.char_m_9);
//        view9.setImageResource(R.drawable.char_m_10);
//        view10.setImageResource(R.drawable.char_m_11);
//        view11.setImageResource(R.drawable.char_m_12);
//        view12.setImageResource(R.drawable.char_m_13);
//
//
//        view1.setTag(R.drawable.char_m_2);
//        view2.setTag(R.drawable.char_m_3);
//        view3.setTag(R.drawable.char_m_4);
//        view4.setTag(R.drawable.char_m_5);
//        view5.setTag(R.drawable.char_m_6);
//        view6.setTag(R.drawable.char_m_7);
//        view7.setTag(R.drawable.char_m_8);
//        view8.setTag(R.drawable.char_m_9);
//        view9.setTag(R.drawable.char_m_10);
//        view10.setTag(R.drawable.char_m_11);
//        view11.setTag(R.drawable.char_m_12);
//        view12.setTag(R.drawable.char_m_13);

        final Integer[] IDs= {R.drawable.char_m_2,R.drawable.char_m_3, R.drawable.char_m_4, R.drawable.char_m_5,
                R.drawable.char_m_6, R.drawable.char_m_7, R.drawable.char_m_8, R.drawable.char_m_9,
                R.drawable.char_m_10, R.drawable.char_m_11, R.drawable.char_m_12, R.drawable.char_m_13};

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                new SetImagesAsync().execute(IDs);
            }
        }, 1000);
        return view;
    }

    private class SetImagesAsync extends AsyncTask<Integer, Void, Boolean>{
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
