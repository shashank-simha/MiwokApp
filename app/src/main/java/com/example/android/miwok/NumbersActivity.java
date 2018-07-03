package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> numbers = new ArrayList<Word>();

        numbers.add(new Word("One", "Lutti", R.drawable.number_one));
        numbers.add(new Word("Two", "Otiiko", R.drawable.number_two));
        numbers.add(new Word("Three", "Tolookosu", R.drawable.number_three));
        numbers.add(new Word("Four", "Oyyisa", R.drawable.number_four));
        numbers.add(new Word("Five", "Massokka", R.drawable.number_five));
        numbers.add(new Word("Six", "Temmokka", R.drawable.number_six));
        numbers.add(new Word("Seven", "Kenekaku", R.drawable.number_seven));
        numbers.add(new Word("Eight", "Kawinta", R.drawable.number_eight));
        numbers.add(new Word("Nine", "Wo'e", R.drawable.number_nine));
        numbers.add(new Word("Ten", "Na'aacha", R.drawable.number_ten));

        WordAdapter Adapter = new WordAdapter(this, numbers, R.color.category_numbers);

        ListView rootView = (ListView) findViewById(R.id.rootView);
        rootView.setAdapter(Adapter);
    }
}
