package moviemania.any.com.moviemania.activity;

import android.app.Activity;
import android.os.Bundle;

import moviemania.any.com.moviemania.R;
import moviemania.any.com.moviemania.controller.FragmentController;
import moviemania.any.com.moviemania.fragment.MovieListFragment;


public class MainActivity extends Activity {

    private MovieListFragment movieListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // FragmentController initializing
        FragmentController.getInstance().init(this);

        setContentView(R.layout.main_activity_layout);

        movieListFragment = new MovieListFragment();

        // Add fragment with list of movies on main Activity
        FragmentController.getInstance().add(R.id.fl_container, movieListFragment);
    }
}
