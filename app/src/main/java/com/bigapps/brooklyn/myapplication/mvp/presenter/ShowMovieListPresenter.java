package com.bigapps.brooklyn.myapplication.mvp.presenter;

import com.bigapps.brooklyn.myapplication.mvp.model.Movie;

/**
 * Created by Brooklyn on 27-Apr-17.
 */

public interface ShowMovieListPresenter extends BasePresenter {

    void loadMovieList();
    void onMovieSelected(Movie repo);
}
