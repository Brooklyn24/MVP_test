package com.bigapps.brooklyn.myapplication.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bigapps.brooklyn.myapplication.MyApp;
import com.bigapps.brooklyn.myapplication.R;
import com.bigapps.brooklyn.myapplication.adapter.MovieAdapter;
import com.bigapps.brooklyn.myapplication.di.module.ShowMovieListModule;
import com.bigapps.brooklyn.myapplication.mvp.callback.ShowDetailsFragmentCallback;
import com.bigapps.brooklyn.myapplication.mvp.model.Movie;
import com.bigapps.brooklyn.myapplication.mvp.presenter.ShowMovieListPresenter;
import com.bigapps.brooklyn.myapplication.mvp.view.ShowMovieListView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowMovieListFragment extends BaseFragment implements ShowMovieListView, MovieAdapter.MovieClickListener {

    @Inject ShowMovieListPresenter showMovieListPresenter;
    @BindView(R.id.recycler) RecyclerView recyclerView;
    @Inject MyApp appContext;

    public static ShowMovieListFragment newInstance() {

        Bundle args = new Bundle();
        
        ShowMovieListFragment fragment = new ShowMovieListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_movie_list, container, false);
        ButterKnife.bind(this, view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showMovieListPresenter.loadMovieList();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApp.getAppComponent().plus(new ShowMovieListModule(this)).inject(this);

    }

    @Override
    public void showList(List<Movie> list) {
        MovieAdapter movieAdapter = new MovieAdapter(list, appContext);
        movieAdapter.setMovieClickListener(this);
        recyclerView.setAdapter(movieAdapter);
    }

    @Override
    public void showRepoDetails(Movie movie) {
        ((ShowDetailsFragmentCallback)getActivity()).showDetailsFragmentCallback(movie);
    }

    @Override
    public void onMovieClicked(Movie movie) {
        showMovieListPresenter.onMovieSelected(movie);
    }
}
