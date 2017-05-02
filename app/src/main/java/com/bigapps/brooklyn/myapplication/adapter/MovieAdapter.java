package com.bigapps.brooklyn.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigapps.brooklyn.myapplication.R;
import com.bigapps.brooklyn.myapplication.mvp.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Brooklyn on 28-Apr-17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<Movie> mList;
    MovieClickListener clickListener;
    Context context;

    public MovieAdapter(List<Movie> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie, parent, false);
        return new ViewHolder(view);
    }

    public void setMovieClickListener(MovieClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Movie movie = mList.get(position);
        holder.textView.setText(movie.getTitle());
        holder.textView2.setText(movie.getVoteAverage().toString());
        Picasso.with(context).load("https://image.tmdb.org/t/p/w342/" + movie.getPosterPath())
                .into(holder.posterImage);

        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null) {
                    clickListener.onMovieClicked(movie);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        View rootView;

        @BindView(R.id.nameTxt) TextView textView;
        @BindView(R.id.ratingTxt) TextView textView2;
        @BindView(R.id.posterImage) ImageView posterImage;
        @BindView(R.id.genresTxt) TextView genresTxt;


        public ViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            ButterKnife.bind(this, itemView);
        }
    }

    public interface MovieClickListener{
        void onMovieClicked(Movie movie);
    }
}
