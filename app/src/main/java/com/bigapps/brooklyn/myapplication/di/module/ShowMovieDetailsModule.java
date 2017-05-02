package com.bigapps.brooklyn.myapplication.di.module;

import com.bigapps.brooklyn.myapplication.di.scopes.ActivityScope;
import com.bigapps.brooklyn.myapplication.mvp.presenter.ShowMovieDetailsPresenter;
import com.bigapps.brooklyn.myapplication.mvp.presenter.impl.ShowMovieDetailsPresenterImpl;
import com.bigapps.brooklyn.myapplication.mvp.view.ShowMovieDetailsView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Brooklyn on 28-Apr-17.
 */

@Module
public class ShowMovieDetailsModule {

    ShowMovieDetailsView view;

    public ShowMovieDetailsModule(ShowMovieDetailsView view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    ShowMovieDetailsView showView() {
        return view;
    }

    @ActivityScope
    @Provides
    ShowMovieDetailsPresenter showMovieDetailsPresenter(ShowMovieDetailsPresenterImpl presenter) {
        return presenter;
    }
}
