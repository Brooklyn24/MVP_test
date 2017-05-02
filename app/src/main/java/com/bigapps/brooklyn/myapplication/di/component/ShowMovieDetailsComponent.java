package com.bigapps.brooklyn.myapplication.di.component;

import com.bigapps.brooklyn.myapplication.fragments.ShowMovieDetailsFragment;
import com.bigapps.brooklyn.myapplication.di.module.ShowMovieDetailsModule;
import com.bigapps.brooklyn.myapplication.di.scopes.ActivityScope;

import dagger.Subcomponent;

/**
 * Created by Brooklyn on 28-Apr-17.
 */

@Subcomponent(modules = ShowMovieDetailsModule.class)
@ActivityScope
public interface ShowMovieDetailsComponent {
    void inject(ShowMovieDetailsFragment activity);
}
