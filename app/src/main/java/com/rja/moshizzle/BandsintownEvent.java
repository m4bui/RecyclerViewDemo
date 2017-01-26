package com.rja.moshizzle;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michellebui on 1/25/17.
 */

public class BandsintownEvent {
    //title and array of artist with getters
    @SerializedName("title")
    private String mTitle;
    @SerializedName("artists")
    private List<BandsintownArtist> mArtists;

    public String getTitle() {
        return mTitle;
    }

    public List<BandsintownArtist> getArtists(){
        return mArtists;
    }
}
