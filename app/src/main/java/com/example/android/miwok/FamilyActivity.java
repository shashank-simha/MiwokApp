package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> family = new ArrayList<Word>();

        family.add(new Word("Father", "әpә", R.drawable.family_father));
        family.add(new Word("Mother", "әṭa", R.drawable.family_mother));
        family.add(new Word("Son", "angsi", R.drawable.family_son));
        family.add(new Word("Daughter", "tune", R.drawable.family_daughter));
        family.add(new Word("Older brother", "taachi", R.drawable.family_older_brother));
        family.add(new Word("Younger brother", "chalitti", R.drawable.family_younger_brother));
        family.add(new Word("Older sister", "teṭe", R.drawable.family_older_sister));
        family.add(new Word("Younger sister", "kolliti", R.drawable.family_younger_sister));
        family.add(new Word("Grandmother", "ama", R.drawable.family_grandmother));
        family.add(new Word("Grandfather", "paapa", R.drawable.family_grandfather));

        WordAdapter Adapter = new WordAdapter(this, family, R.color.category_family);

        ListView rootView = (ListView) findViewById(R.id.rootView);
        rootView.setAdapter(Adapter);
    }
}
