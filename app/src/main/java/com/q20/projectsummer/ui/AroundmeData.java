package com.q20.projectsummer.ui;

import com.q20.projectsummer.R;

public class AroundmeData {
    String text;
    int id;

    private AroundmeData(String text, int id){
        this.text = text;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }

    public static final AroundmeData[] datas = {
            new AroundmeData("Alireza 1", R.drawable.char_m_40),
            new AroundmeData("Alireza 2", R.drawable.char_m_40)
    };
}
