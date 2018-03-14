package com.boop442.bogglesolitaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.baseGridView) GridView mBaseGridView;
    @BindView(R.id.submitButton) Button mSubmitButton;
    @BindView(R.id.getResultsButton) Button mGetResultsButton;
    @BindView(R.id.inputWordEditText) EditText mInputWordEditText;

    String[] mLetters = new String[] {"a", "a", "a", "a", "a", "a", "a", "a"};
    List<String> mWords = new ArrayList<String>();


    @Override
    public void onClick(View v) {
//        Toast.makeText(GameActivity.this, "Hello World!", Toast.LENGTH_LONG).show();

        if (v == mGetResultsButton) {
            Intent intent = new Intent(GameActivity.this, ResultsActivity.class);


            String[] wordsArr = new String[mWords.size()];
            wordsArr = mWords.toArray(wordsArr);

            intent.putExtra("words", wordsArr);
            startActivity(intent);
        }
        else if (v == mSubmitButton) {
            String word = mInputWordEditText.getText().toString();
            mWords.add(word);
        }
    }

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

        ButterKnife.bind(this);

        mBaseGridView.setAdapter(new GameAdapter(this, mLetters));




        mGetResultsButton.setOnClickListener(this);
        mSubmitButton.setOnClickListener(this);
    }
}
