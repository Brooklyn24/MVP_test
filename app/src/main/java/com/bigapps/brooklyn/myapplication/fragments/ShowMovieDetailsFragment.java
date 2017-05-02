package com.bigapps.brooklyn.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigapps.brooklyn.myapplication.MyApp;
import com.bigapps.brooklyn.myapplication.R;
import com.bigapps.brooklyn.myapplication.di.module.ShowMovieDetailsModule;
import com.bigapps.brooklyn.myapplication.mvp.model.Movie;
import com.bigapps.brooklyn.myapplication.mvp.presenter.ShowMovieDetailsPresenter;
import com.bigapps.brooklyn.myapplication.mvp.view.ShowMovieDetailsView;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowMovieDetailsFragment extends BaseFragment implements ShowMovieDetailsView {

    public static String EXTRA_MOVIE = "movie_extra";
    @Inject
    ShowMovieDetailsPresenter presenter;

    @BindView(R.id.movieNameTxt) TextView movieNameTxt;
    @BindView(R.id.movieOverView) TextView movieOverView;
    @BindView(R.id.movieRatingTxt) TextView movieRatingTxt;
    @BindView(R.id.imageView) ImageView imageView;

    Movie movie;

    public static ShowMovieDetailsFragment newInstance(Movie movie) {

        Bundle args = new Bundle();
        args.putSerializable(EXTRA_MOVIE, movie);
        ShowMovieDetailsFragment fragment = new ShowMovieDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_movie_details, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.loadMovieDetails(movie);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApp.getAppComponent().plus(new ShowMovieDetailsModule(this)).inject(this);
        movie = (Movie) getArguments().getSerializable(EXTRA_MOVIE);
    }


    @Override
    public void showDetails(Movie movie) {
        Picasso.with(getActivity().getApplicationContext()).load("https://image.tmdb.org/t/p/w342/" + movie.getPosterPath()).into(imageView);
        movieNameTxt.setText(movie.getTitle());
        movieOverView.setText(movie.getOverview());
        movieRatingTxt.setText(movie.getVoteAverage().toString());
    }
}
