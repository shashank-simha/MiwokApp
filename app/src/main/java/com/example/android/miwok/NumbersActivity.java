package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> numbers = new ArrayList<Word>();

        numbers.add(new Word("One", "Lutti", R.drawable.number_one, R.raw.number_one));
        numbers.add(new Word("Two", "Otiiko", R.drawable.number_two, R.raw.number_two));
        numbers.add(new Word("Three", "Tolookosu", R.drawable.number_three, R.raw.number_three));
        numbers.add(new Word("Four", "Oyyisa", R.drawable.number_four, R.raw.number_four));
        numbers.add(new Word("Five", "Massokka", R.drawable.number_five, R.raw.number_five));
        numbers.add(new Word("Six", "Temmokka", R.drawable.number_six, R.raw.number_six));
        numbers.add(new Word("Seven", "Kenekaku", R.drawable.number_seven, R.raw.number_seven));
        numbers.add(new Word("Eight", "Kawinta", R.drawable.number_eight, R.raw.number_eight));
        numbers.add(new Word("Nine", "Wo'e", R.drawable.number_nine, R.raw.number_nine));
        numbers.add(new Word("Ten", "Na'aacha", R.drawable.number_ten, R.raw.number_ten));

        WordAdapter Adapter = new WordAdapter(this, numbers, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word number = numbers.get(position);

                /*
                Release the media player if it already exist because we are about
                play other media file
                 */
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, number.getAudioResourceId());

                //start autio file
                mMediaPlayer.start();

                /*
                 setup a listener on the mediaplayer so that we can stop and release the media player
                 once the audio has finished playing
                 */
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
