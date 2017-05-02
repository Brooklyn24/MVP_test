package com.bigapps.brooklyn.myapplication.mvp.view;

import com.bigapps.brooklyn.myapplication.mvp.model.Movie;

import java.util.List;

/**
 * Created by Brooklyn on 27-Apr-17.
 */

public interface ShowMovieListView extends BaseFragmentView {
    void showList(List<Movie> list);

    void showRepoDetails(Movie repo);
}
