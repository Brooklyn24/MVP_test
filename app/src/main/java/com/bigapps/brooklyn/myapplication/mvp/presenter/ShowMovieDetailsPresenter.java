package com.bigapps.brooklyn.myapplication.mvp.presenter;

import com.bigapps.brooklyn.myapplication.mvp.model.Movie;

/**
 * Created by Brooklyn on 28-Apr-17.
 */

public interface ShowMovieDetailsPresenter extends BasePresenter {
    void loadMovieDetails(Movie movie);
}
