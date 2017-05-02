package com.bigapps.brooklyn.myapplication.di.module;

import com.bigapps.brooklyn.myapplication.di.scopes.ActivityScope;
import com.bigapps.brooklyn.myapplication.mvp.presenter.ShowMovieListPresenter;
import com.bigapps.brooklyn.myapplication.mvp.presenter.impl.ShowMovieListPresenterImpl;
import com.bigapps.brooklyn.myapplication.mvp.view.ShowMovieListView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Brooklyn on 27-Apr-17.
 */

@Module
public class ShowMovieListModule {

    ShowMovieListView view;

    public ShowMovieListModule(ShowMovieListView showMovieListView) {
        view = showMovieListView;
    }

    @ActivityScope
    @Provides
    public ShowMovieListView provideView() {
        return view;
    }

    @ActivityScope
    @Provides
    ShowMovieListPresenter showGitListPresenter(ShowMovieListPresenterImpl showGitListPresenter){
        return showGitListPresenter;
    }
}
