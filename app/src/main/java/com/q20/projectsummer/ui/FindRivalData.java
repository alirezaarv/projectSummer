package com.q20.projectsummer.ui;


import com.q20.projectsummer.R;

/**
 * Created by mohammadmahdi on 9/26/16.
 */
public class FindRivalData {
    String text;
    int id;

    private FindRivalData(String text, int id){
        this.text = text;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }

    public static final FindRivalData[] datas = {
            new FindRivalData("Alireza 1", R.drawable.char_m_40),
            new FindRivalData("Marzieh", R.drawable.char_f_15),
            new FindRivalData("Mohsen", R.drawable.char_m_40),
            new FindRivalData("Mohammad ali", R.drawable.char_m_40)
    };
}
