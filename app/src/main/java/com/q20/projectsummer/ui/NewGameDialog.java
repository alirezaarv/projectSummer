package com.q20.projectsummer.ui;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.q20.projectsummer.R;

public class NewGameDialog extends Activity {

//    private Context context;
//
//    public void setContext(Context context) {
//        this.context = context;
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.fragment_new_game, container, false);
//
//        /*((ImageButton) rootView.findViewById(R.id.newGameOnline)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, FindRivalActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        ((ImageButton) rootView.findViewById(R.id.newGameOffline)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, GameActivity.class);
//                startActivity(intent);
//            }
//        });*/
//
//        return rootView;
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_new_game);


        this.getWindow().getDecorView().setBackgroundColor(Color.argb(0, 0, 0, 0));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.height = 1920;
        params.width = 1080;
        this.getWindow().setAttributes(params);
    }

    @Override
    protected void onResume() {
        super.onResume();

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);

    }
}
