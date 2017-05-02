package com.bigapps.brooklyn.myapplication.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.bigapps.brooklyn.myapplication.R;
import com.bigapps.brooklyn.myapplication.fragments.ShowMovieDetailsFragment;
import com.bigapps.brooklyn.myapplication.fragments.ShowMovieListFragment;
import com.bigapps.brooklyn.myapplication.mvp.callback.ShowDetailsFragmentCallback;
import com.bigapps.brooklyn.myapplication.mvp.model.Movie;

import butterknife.ButterKnife;

/**
 * Created by Brooklyn on 01-May-17.
 */

public class MainActivity extends BaseActivity implements ShowDetailsFragmentCallback {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragmentLayout, ShowMovieListFragment.newInstance()).commit();
        }
    }



    @Override
    public void showDetailsFragmentCallback(Movie movie) {
        getFragmentManager().beginTransaction()
                .replace(R.id.fragmentLayout, ShowMovieDetailsFragment.newInstance(movie))
                .addToBackStack(null)
                .commit();
    }
}
