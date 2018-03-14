package com.boop442.bogglesolitaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    GridView gridView;
//    char[] mLetters = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    String[] mLetters = new String[] {"a", "a", "a", "a", "a", "a", "a", "a"};
//    String[] mLetters = new String[]{};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Random rnd = new Random();
        char ch;

        for (int i=0; i<8; i++) {
            ch = (char) (rnd.nextInt(26) + 'a');
            mLetters[i] = Character.toString(ch);
        }

        gridView = (GridView) findViewById(R.id.baseGridView);
        gridView.setAdapter(new GameAdapter(this, mLetters));
    }
}
