package com.bigapps.brooklyn.myapplication.di.component;

import com.bigapps.brooklyn.myapplication.fragments.ShowMovieListFragment;
import com.bigapps.brooklyn.myapplication.di.module.ShowMovieListModule;
import com.bigapps.brooklyn.myapplication.di.scopes.ActivityScope;

import dagger.Subcomponent;

/**
 * Created by Brooklyn on 27-Apr-17.
 */

@Subcomponent(modules = ShowMovieListModule.class)
@ActivityScope
public interface ShowMovieListComponent {

    void inject(ShowMovieListFragment showMovieListActivity);
}
