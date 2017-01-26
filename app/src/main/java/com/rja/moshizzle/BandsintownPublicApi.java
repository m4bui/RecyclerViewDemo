package com.rja.moshizzle;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by michellebui on 1/25/17
 */

public interface BandsintownPublicApi {

    @GET("/artists/{artist_name}/events.json?api_version=2.0&app_id=demo")
    public Call<List<BandsintownEvent>> getEvents(@Path("artist_name") String name);

}
