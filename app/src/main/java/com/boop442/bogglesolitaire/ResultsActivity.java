package com.boop442.bogglesolitaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import butterknife.BindView;

public class ResultsActivity extends AppCompatActivity {

    @BindView(R.id.wordsListView) ListView mWordsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        String[] words = getIntent().getStringArrayExtra("words");

        mWordsListView = (ListView) findViewById(R.id.wordsListView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, words);
        mWordsListView.setAdapter(adapter);
    }
}
