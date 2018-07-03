package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> colors = new ArrayList<Word>();

        colors.add(new Word("Red", "weṭeṭṭi", R.drawable.color_red));
        colors.add(new Word("Green", "chokokki", R.drawable.color_green));
        colors.add(new Word("Brown", "ṭakaakki", R.drawable.color_brown));
        colors.add(new Word("Gray", "ṭopoppi", R.drawable.color_gray));
        colors.add(new Word("Black", "kululli", R.drawable.color_black));
        colors.add(new Word("White", "kelelli", R.drawable.color_white));
        colors.add(new Word("Dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow));
        colors.add(new Word("Mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow));

        WordAdapter Adapter = new WordAdapter(this, colors, R.color.category_colors);

        ListView rootView = (ListView) findViewById(R.id.rootView);
        rootView.setAdapter(Adapter);
    }
}
