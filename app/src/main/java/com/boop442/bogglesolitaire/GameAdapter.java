package com.boop442.bogglesolitaire;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by boop442 on 3/14/2018.
 */

public class GameAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mLetters;

    public GameAdapter(Context mContext, String[] mLetters) {
        this.mContext = mContext;
        this.mLetters = mLetters;
    }

    @Override
    public int getCount() {
        return mLetters.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {
            // get layout from xml file
            gridView = inflater.inflate(R.layout.game_grid_item, null);


            // pull views
            TextView letterView = (TextView) gridView
                    .findViewById(R.id.grid_item_letter);

            // set values into views
            letterView.setText(mLetters[position]);  // using dummy data for now
        } else {
            gridView = (View) convertView;
        }
        return gridView;
    }
}

