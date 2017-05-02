package com.bigapps.brooklyn.myapplication.mvp.presenter.impl;

import com.bigapps.brooklyn.myapplication.mvp.model.Movie;
import com.bigapps.brooklyn.myapplication.mvp.presenter.ShowMovieDetailsPresenter;
import com.bigapps.brooklyn.myapplication.mvp.view.ShowMovieDetailsView;

import javax.inject.Inject;

/**
 * Created by Brooklyn on 28-Apr-17.
 */

public class ShowMovieDetailsPresenterImpl implements ShowMovieDetailsPresenter {

    ShowMovieDetailsView view;

    @Inject
    public ShowMovieDetailsPresenterImpl(ShowMovieDetailsView view) {
        this.view = view;
    }

    @Override
    public void cancel() {

    }

    @Override
    public void loadMovieDetails(Movie movie) {
        view.showDetails(movie);
    }
}
