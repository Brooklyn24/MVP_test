package com.bigapps.brooklyn.myapplication.di.component;


import com.bigapps.brooklyn.myapplication.di.module.AppModule;
import com.bigapps.brooklyn.myapplication.di.module.NetWorkModule;
import com.bigapps.brooklyn.myapplication.di.module.ShowMovieDetailsModule;
import com.bigapps.brooklyn.myapplication.di.module.ShowMovieListModule;
import com.bigapps.brooklyn.myapplication.mvp.presenter.impl.ShowMovieListPresenterImpl;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Brooklyn on 27-Apr-17.
 */

@Component(modules = {AppModule.class, NetWorkModule.class})
@Singleton
public interface AppComponent {
    void inject(ShowMovieListPresenterImpl showMovieListPresenterImpl);
    ShowMovieListComponent plus(ShowMovieListModule showMovieListModule);
    ShowMovieDetailsComponent plus(ShowMovieDetailsModule showMovieDetailsModule);
}
