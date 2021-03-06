package com.example.standard.popularmoviesstageone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        setTitle(getString(R.string.title_details));

        ImageView poster = (ImageView) findViewById(R.id.poster_image);
        TextView titleTextView = (TextView) findViewById(R.id.title_tv);
        TextView overviewTextView = (TextView) findViewById(R.id.story_tv);
        TextView ratingTextView = (TextView) findViewById(R.id.rating_tv);
        TextView dateTextView = (TextView) findViewById(R.id.date_tv);

        /*
        * Receive Data from MovieActivity and set them into Views of detail layout
        */
        Movie movie = getIntent().getParcelableExtra("data");

        String posterImage = movie.getmPoster();
        Picasso.with(this).load(posterImage).into(poster);
        titleTextView.setText(movie.getmTitle());
        overviewTextView.setText(movie.getmOverview());
        dateTextView.setText(movie.getmDate());
        ratingTextView.setText(movie.getmRating());


        // don't know how to continue
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, MovieActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
        }
        return true;
    }

    public void mamaClick (View view){
        Toast.makeText(this, "Mama wurde angeklickt!", Toast.LENGTH_LONG).show();
    }

    //Todo: access Reviews and Trailer

    //Todo: figure out if Reviews und Trailer need one Utils for each
}
