package com.bigapps.brooklyn.myapplication.webApi;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;

import com.bigapps.brooklyn.myapplication.R;
import com.bigapps.brooklyn.myapplication.mvp.model.Genres;
import com.bigapps.brooklyn.myapplication.mvp.model.Records;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Brooklyn on 27-Apr-17.
 */

public interface MovieApi {
    @GET("3/movie/popular?api_key=0e1167c76e061f65cb570b74c42baf0f")
    Call<Records> getPopularMovies();

    @GET("3/genre/movie/list?api_key=0e1167c76e061f65cb570b74c42baf0f")
    Call<List<Genres>> getGenres();
}
