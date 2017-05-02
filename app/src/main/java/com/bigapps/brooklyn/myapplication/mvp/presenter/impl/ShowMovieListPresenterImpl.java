package com.bigapps.brooklyn.myapplication.mvp.presenter.impl;

import com.bigapps.brooklyn.myapplication.mvp.model.Genres;
import com.bigapps.brooklyn.myapplication.mvp.model.Records;
import com.bigapps.brooklyn.myapplication.mvp.model.Movie;
import com.bigapps.brooklyn.myapplication.mvp.presenter.ShowMovieListPresenter;
import com.bigapps.brooklyn.myapplication.mvp.view.ShowMovieListView;
import com.bigapps.brooklyn.myapplication.webApi.MovieApi;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Brooklyn on 27-Apr-17.
 */

public class ShowMovieListPresenterImpl implements ShowMovieListPresenter {

    private ShowMovieListView mView;
    @Inject Retrofit retrofit;

    @Inject
    public ShowMovieListPresenterImpl(ShowMovieListView view) {
        this.mView = view;
    }

    @Override
    public void cancel() {

    }

    @Override
    public void loadMovieList() {
        Call<Records> posts = retrofit.create(MovieApi.class).getPopularMovies();
        Call<List<Genres>> genres = retrofit.create(MovieApi.class).getGenres();

        posts.enqueue(new Callback<Records>() {
            @Override
            public void onResponse(Call<Records> call, Response<Records> response) {
                if (response.body() == null) {
                    mView.showError("List is empty");
                } else{
                    mView.showList(response.body().getMovies());
                }
            }

            @Override
            public void onFailure(Call<Records> call, Throwable t) {
                mView.showError("Error");
            }
        });

        genres.enqueue(new Callback<List<Genres>>() {
            @Override
            public void onResponse(Call<List<Genres>> call, Response<List<Genres>> response) {

            }

            @Override
            public void onFailure(Call<List<Genres>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onMovieSelected(Movie movie) {
        mView.showRepoDetails(movie);
    }
}
