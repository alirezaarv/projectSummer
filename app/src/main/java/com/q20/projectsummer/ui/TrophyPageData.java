package com.q20.projectsummer.ui;

import com.q20.projectsummer.R;

/**
 * Created by mohammadmahdi on 9/28/16.
 */
public class TrophyPageData {
    String text;
    int id;

    private TrophyPageData(String text, int id){
        this.text = text;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public static final TrophyPageData[] datas = {
            new TrophyPageData("first trophy", R.drawable.char_m_40),
            new TrophyPageData("second trophy", R.drawable.char_m_40),
            new TrophyPageData("third trophy", R.drawable.char_f_15),
            new TrophyPageData("4th trophy", R.drawable.char_m_40),
            new TrophyPageData("5th trophy", R.drawable.char_f_15),
            new TrophyPageData("6th trophy", R.drawable.char_f_15),
            new TrophyPageData("7th trophy", R.drawable.char_f_15)
    };
}
