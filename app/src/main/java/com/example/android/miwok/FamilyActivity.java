package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
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

        final ArrayList<Word> family = new ArrayList<Word>();

        family.add(new Word("Father", "әpә", R.drawable.family_father, R.raw.family_father));
        family.add(new Word("Mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        family.add(new Word("Son", "angsi", R.drawable.family_son, R.raw.family_son));
        family.add(new Word("Daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        family.add(new Word("Older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        family.add(new Word("Younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        family.add(new Word("Older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        family.add(new Word("Younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        family.add(new Word("Grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        family.add(new Word("Grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

        WordAdapter Adapter = new WordAdapter(this, family, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word family_member = family.get(position);

                /*
                Release the media player if it already exist because we are about
                play other media file
                 */
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, family_member.getAudioResourceId());

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

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
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
