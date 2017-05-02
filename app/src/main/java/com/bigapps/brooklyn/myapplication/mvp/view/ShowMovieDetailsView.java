package com.bigapps.brooklyn.myapplication.mvp.view;

import com.bigapps.brooklyn.myapplication.mvp.model.Movie;

/**
 * Created by Brooklyn on 28-Apr-17.
 */

public interface ShowMovieDetailsView extends BaseFragmentView {

    void showDetails(Movie movie);

}
