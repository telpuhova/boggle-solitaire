package com.boop442.bogglesolitaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.Arrays;
import java.util.List;
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
        String letter;
        String[] vowels = new String[] {"a", "o", "e", "i", "u"};
        List vowelsList = Arrays.asList(vowels);



        boolean[] itemIsAConsonant = new boolean[8];
        int vowelCount = 0;

        for (int i=0; i<8; i++) {
            letter = Character.toString( (char)(rnd.nextInt(26) + 'a') );
            if (vowelsList.contains(letter)) {
                vowelCount++;
            } else {
                itemIsAConsonant[i] = true;
            }

            mLetters[i] = letter;
        }

        if (vowelCount < 2) {
            int j = 0;
            int i = 0;
            int k;
            while (j < (2 - vowelCount)) {
                if (!vowelsList.contains(mLetters[i])) {
                    k = (rnd.nextInt(5));
                    mLetters[i] = vowels[k];
                    j++;
                    i++;
                } else {
                    i++;
                }
            }
        }


        gridView = (GridView) findViewById(R.id.baseGridView);
        gridView.setAdapter(new GameAdapter(this, mLetters));
    }
}
