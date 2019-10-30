package com.example.moviecatalogue.api;

import com.example.moviecatalogue.model.ItemResponse;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("movie")
    Call<ItemResponse> getMovieList(@Query("language") String language);

    @GET("tv")
    Call<ItemResponse> getTvShowList(@Query("language") String language);
}
