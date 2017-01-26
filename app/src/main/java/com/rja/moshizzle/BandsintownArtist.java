package com.rja.moshizzle;

import com.google.gson.annotations.SerializedName;

/**
 * Created by michellebui on 1/25/17.
 */

public class BandsintownArtist {
    //name and image url with getters
    @SerializedName("name")
    private String mName;
    @SerializedName("image_url")
    private String mImageUrl;
    @SerializedName("thumb_url")
    private String mThumbUrl;

    public String getName(){
        return mName;
    }

    public String getImageUrl(){
        return mImageUrl;
    }

    public String getThumbUrl(){
        return mThumbUrl;
    }
}
