package com.rja.moshizzle;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by michellebui on 1/25/17
 */

public class ApiHelper {

    private static final String TAG = ApiHelper.class.getSimpleName();

    public void getGifs(Callback<GifyApiResponse> callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.giphy.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GifyApi gifyApi = retrofit.create(GifyApi.class);
        gifyApi.getRandomGifs().enqueue(callback);
    }

    public void getBandsintownImage(String artistName, Callback<List<BandsintownEvent>> callback) {
        // add param artistName
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.bandsintown.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BandsintownPublicApi api = retrofit.create(BandsintownPublicApi.class);
        Call<List<BandsintownEvent>> call = api.getEvents(artistName);
        call.enqueue(callback);
        Log.d(TAG, call.request().url().toString());
    }
}
