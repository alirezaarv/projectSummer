package com.q20.projectsummer.ui;

import com.q20.projectsummer.R;

public class WeeklyData {
    String text;
    int id;

    private WeeklyData(String text, int id){
        this.text = text;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }

    public static final WeeklyData[] datas = {
            new WeeklyData("Mohammad mahdi 1", R.drawable.char_m_40),
            new WeeklyData("Mohammad mahdi 2", R.drawable.char_m_40),
            new WeeklyData("Mohammad mahdi 3", R.drawable.char_m_40),
            new WeeklyData("Mohammad mahdi 4", R.drawable.char_m_40),
            new WeeklyData("Mohammad mahdi 5", R.drawable.char_m_40),
            new WeeklyData("Mohammad mahdi 6", R.drawable.char_m_40),
            new WeeklyData("Mohammad mahdi 7", R.drawable.char_m_40),
            new WeeklyData("Mohammad mahdi 8", R.drawable.char_m_40),
    };
}