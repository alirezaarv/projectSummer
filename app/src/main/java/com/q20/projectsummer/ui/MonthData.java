package com.q20.projectsummer.ui;


import com.q20.projectsummer.R;

public class MonthData {
    String text;
    int id;

    private MonthData(String text, int id){
        this.text = text;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }

    public static final MonthData[] datas = {
            new MonthData("Mohammad hosein 1", R.drawable.char_m_40)
    };
}
