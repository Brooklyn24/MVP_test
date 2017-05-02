package com.bigapps.brooklyn.myapplication.di.module;

import com.bigapps.brooklyn.myapplication.MyApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Brooklyn on 27-Apr-17.
 */
@Module
public class AppModule {

    MyApp app;

    public AppModule(MyApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    MyApp myApp(){
        return app;
    }

}
