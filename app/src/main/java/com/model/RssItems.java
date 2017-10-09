package com.model;

import java.io.Serializable;

/**
 * Created by Le on 09-Jan-16.
 */
public class RssItems implements Serializable {
    private String mTitle;
    private String mDescipe;
    private String mLink;
    private String mDateTime;
    private String mImageLink;

    public RssItems(String mTitle, String mDescipe, String mLink, String mDateTime, String mImageLink) {
        this.mTitle = mTitle;
        this.mDescipe = mDescipe;
        this.mLink = mLink;
        this.mDateTime = mDateTime;
        this.mImageLink = mImageLink;
    }

    public String getmDescipe() {
        return mDescipe;
    }

    public String getmDateTime() {
        return mDateTime;
    }

    public String getmImageLink() {
        return mImageLink;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmLink() {
        return mLink;
    }

    @Override
    public String toString() {
        return "RssItems{" +
                "mTitle='" + mTitle + '\'' +
                ", mDescipe='" + mDescipe + '\'' +
                ", mLink='" + mLink + '\'' +
                ", mDateTime='" + mDateTime + '\'' +
                ", mImageLink='" + mImageLink + '\'' +
                '}';
    }
}
