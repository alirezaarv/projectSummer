package com.q20.projectsummer.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.q20.projectsummer.R;
import com.q20.projectsummer.SQLite.DatabaseAccess;
import com.q20.projectsummer.ui.Adapters.PackRecyclerAdapter;

public class PackSelectorActivity extends AppCompatActivity {
    public static final int packNumbers = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pack_selector);


        //TODO do this in async task
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.openDb();
        String[] names = new String[packNumbers];
        String[] infos = new String[packNumbers];
        for (int i = 0; i < packNumbers; i++) {
            names[i] = databaseAccess.getPackName(i);
            infos[i] = databaseAccess.getPackWordsNumber(i) + "/" + databaseAccess.getPackWordsPassed(i);
        }
        databaseAccess.closeDb();

        PackRecyclerAdapter packRecyclerAdapter = new PackRecyclerAdapter(names, infos);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_trophy_menu);
        recyclerView.setAdapter(packRecyclerAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }


}
