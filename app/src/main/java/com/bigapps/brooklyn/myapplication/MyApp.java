package com.bigapps.brooklyn.myapplication;

import android.app.Application;

import com.bigapps.brooklyn.myapplication.di.component.AppComponent;
import com.bigapps.brooklyn.myapplication.di.component.DaggerAppComponent;
import com.bigapps.brooklyn.myapplication.di.module.AppModule;
import com.bigapps.brooklyn.myapplication.di.module.NetWorkModule;

/**
 * Created by Brooklyn on 27-Apr-17.
 */

public class MyApp extends Application {

    private static AppComponent appComponent;
    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netWorkModule(new NetWorkModule("https://api.themoviedb.org/"))
                .build();
    }
}
