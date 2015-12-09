package moviemania.any.com.moviemania.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import moviemania.any.com.moviemania.R;

/**
 * Created by ASTER-NOTUS on 09.12.2015.
 */
public class MovieListFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.movie_list_fragment_layout, null);

        return view;
    }
}
