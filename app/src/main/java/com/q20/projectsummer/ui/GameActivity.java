package com.q20.projectsummer.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.q20.projectsummer.R;

import java.util.Random;

/**
 * Created by Alireza Arvandi on 10/11/2016.
 */

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private String word = ".... ...";
    private static int btnsLetterNumber = 18;
    private static int btnsKeyboardNumber = 24;


    Button[] btnsLetter = new Button[btnsLetterNumber];
    Button[] btnskeyboard = new Button[btnsKeyboardNumber];

    public void setWord(String word) {
        this.word = word;
        //TODO check word length is smaller than letters available
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //TODO refactor this
        initializeBtnLetters();
        initializeBtnKeyboard();
    }

    //TODO add listener for btn ask
    @Override
    public void onClick(View v) {

    }

    private void initializeBtnLetters() {

        btnsLetter[0] = (Button) findViewById(R.id.letter_u_1);
        btnsLetter[1] = (Button) findViewById(R.id.letter_u_2);
        btnsLetter[2] = (Button) findViewById(R.id.letter_u_3);
        btnsLetter[3] = (Button) findViewById(R.id.letter_u_4);
        btnsLetter[4] = (Button) findViewById(R.id.letter_u_5);
        btnsLetter[5] = (Button) findViewById(R.id.letter_u_6);
        btnsLetter[6] = (Button) findViewById(R.id.letter_u_7);
        btnsLetter[7] = (Button) findViewById(R.id.letter_u_8);
        btnsLetter[8] = (Button) findViewById(R.id.letter_u_9);
        btnsLetter[9] = (Button) findViewById(R.id.letter_d_1);
        btnsLetter[10] = (Button) findViewById(R.id.letter_d_2);
        btnsLetter[11] = (Button) findViewById(R.id.letter_d_3);
        btnsLetter[12] = (Button) findViewById(R.id.letter_d_4);
        btnsLetter[13] = (Button) findViewById(R.id.letter_d_5);
        btnsLetter[14] = (Button) findViewById(R.id.letter_d_6);
        btnsLetter[15] = (Button) findViewById(R.id.letter_d_7);
        btnsLetter[16] = (Button) findViewById(R.id.letter_d_8);
        btnsLetter[17] = (Button) findViewById(R.id.letter_d_9);




        boolean hasSpace = word.contains(" ");
        boolean hasTwoSpace = false;
        if (hasSpace)
            hasTwoSpace = word.indexOf(' ') != word.lastIndexOf(' ');
        boolean needTwoLine = word.length() > btnsLetterNumber / 2 && hasSpace;



        int wordLetters = word.length();
        if (hasSpace && needTwoLine)
            wordLetters--;
        //TODO check next line
        if (hasTwoSpace)
            wordLetters--;

        //TODO check for two space
        for (int i = 0, j=0; j < btnsLetterNumber; i++,j++) {
            if (i < wordLetters) {
                Character c = word.charAt(i);
                if (c.equals(' ') && !needTwoLine) {
                    btnsLetter[j].setVisibility(View.INVISIBLE);
                } else if (c.equals(' ') && needTwoLine) {
                    while (j < (btnsLetterNumber / 2)){
                        btnsLetter[j].setVisibility(View.GONE);
                        j++;
                    }
                }
            } else if (i >= wordLetters) {
                btnsLetter[j].setVisibility(View.GONE);
            }
        }


    }

    private void initializeBtnKeyboard() {
        btnskeyboard[0] = (Button) findViewById(R.id.keyboard_1_1);
        btnskeyboard[1] = (Button) findViewById(R.id.keyboard_1_2);
        btnskeyboard[2] = (Button) findViewById(R.id.keyboard_1_3);
        btnskeyboard[3] = (Button) findViewById(R.id.keyboard_1_4);
        btnskeyboard[4] = (Button) findViewById(R.id.keyboard_1_5);
        btnskeyboard[5] = (Button) findViewById(R.id.keyboard_1_6);
        btnskeyboard[6] = (Button) findViewById(R.id.keyboard_1_7);
        btnskeyboard[7] = (Button) findViewById(R.id.keyboard_1_8);
        btnskeyboard[8] = (Button) findViewById(R.id.keyboard_2_1);
        btnskeyboard[9] = (Button) findViewById(R.id.keyboard_2_2);
        btnskeyboard[10] = (Button) findViewById(R.id.keyboard_2_3);
        btnskeyboard[11] = (Button) findViewById(R.id.keyboard_2_4);
        btnskeyboard[12] = (Button) findViewById(R.id.keyboard_2_5);
        btnskeyboard[13] = (Button) findViewById(R.id.keyboard_2_6);
        btnskeyboard[14] = (Button) findViewById(R.id.keyboard_2_7);
        btnskeyboard[15] = (Button) findViewById(R.id.keyboard_2_8);
        btnskeyboard[16] = (Button) findViewById(R.id.keyboard_3_1);
        btnskeyboard[17] = (Button) findViewById(R.id.keyboard_3_2);
        btnskeyboard[18] = (Button) findViewById(R.id.keyboard_3_3);
        btnskeyboard[19] = (Button) findViewById(R.id.keyboard_3_4);
        btnskeyboard[20] = (Button) findViewById(R.id.keyboard_3_5);
        btnskeyboard[21] = (Button) findViewById(R.id.keyboard_3_6);
        btnskeyboard[22] = (Button) findViewById(R.id.keyboard_3_7);
        btnskeyboard[23] = (Button) findViewById(R.id.keyboard_3_8);

        Character[] alphabet = {'ا', 'ب', 'پ', 'ت', 'ث', 'ج', 'چ', 'ح', 'خ', 'د', 'ذ', 'ر', 'ز', 'ژ', 'س', 'ش', 'ص', 'ض', 'ط', 'ظ', 'ع', 'غ', 'ف', 'ق', 'ک', 'گ', 'ل', 'م', 'ن', 'و', 'ه', 'ی'};

        Character[] selected = new Character[btnsKeyboardNumber];

        Random rand = new Random();
        for (int i = 0; i < btnsKeyboardNumber; i++) {
            selected[i] = alphabet[rand.nextInt(32)];
        }


        for (int i = 0, j = 0; i < word.length(); i++) {
            int k = 0;
            if (word.length() < btnsKeyboardNumber / 3)
                k = rand.nextInt(3);
            if (word.length() < btnsKeyboardNumber / 2)
                k = rand.nextInt(2);
            j += k+1;
            Character c = word.charAt(i);
            if (!c.equals(' '))
                selected[j] = c;
        }

        //set keyboard text
        for (int i = 0; i < btnsKeyboardNumber; i++) {
            btnskeyboard[i].setText(selected[i].toString());
        }
    }


}
