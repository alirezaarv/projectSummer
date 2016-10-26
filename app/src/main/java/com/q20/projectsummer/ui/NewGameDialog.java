package com.q20.projectsummer.ui;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
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

import com.q20.projectsummer.Custom.CustomDialogActivity;
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

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.height = 1000;
        params.width = 100;
        this.getWindow().setAttributes(params);
    }
}
