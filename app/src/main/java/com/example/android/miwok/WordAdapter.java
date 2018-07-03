package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by simha on 30/6/18.
 */

public class WordAdapter extends ArrayAdapter<Word>
{
    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.

        super(context, 0, words);
        mColorResourceId = colorResourceId;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView mivocTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current Word object and
        // set this text on the miwok TextView
        mivocTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID default_text_view
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version number from the current Word object and
        // set this text on the default TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        //Find the Linear layout in list_item.xml layout with the id text_container
        View textContainer = listItemView.findViewById(R.id.text_container);
        //Find the color that the ResourceId maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        //Set the background color of the textContainer view
        textContainer.setBackgroundColor(color);

        // Find the ImageView in the list_item.xml layout with the ID image
        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWord.hasImage())
        {
            // Get the image id  from the current Word object and
            // set this image on the ImageView
            image.setImageResource(currentWord.getImageResourceId());
        }
        else
        {
            //hide the ImageView
            image.setVisibility(View.GONE);
        }

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
