package com.example.android.miwok;
/**
 * Created by simha on 30/6/18.
 */

public class Word
{
    private String mDefaultTranslation;

    private String mMiwokTranslation;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String DefaultTranslation, String MiwokTranslation)
    {
        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;
    }
    public Word(String DefaultTranslation, String MiwokTranslation, int ImageResourceId)
    {
        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;
        mImageResourceId = ImageResourceId;
    }

    public String getDefaultTranslation()
    {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation()
    {
        return mMiwokTranslation;
    }

    public int getImageResourceId()
    {
        return mImageResourceId;
    }

    /**
     * Returns whether the image is set or not
     */

    public boolean hasImage()
    {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
