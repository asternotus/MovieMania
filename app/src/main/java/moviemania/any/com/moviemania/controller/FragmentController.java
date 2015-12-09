package moviemania.any.com.moviemania.controller;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

/**
 * Created by ASTER-NOTUS on 09.12.2015.
 */
public class FragmentController
{
    private static FragmentController instance;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private FragmentController()
    {

    }

    public void init(Activity activity)
    {
        fragmentManager = activity.getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
    }

    public static FragmentController getInstance()
    {
        if(instance == null)
        {
            instance = new FragmentController();
        }

        return instance;
    }

    public void add(int container, Fragment fragment)
    {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(container, fragment);
        fragmentTransaction.commit();
    }

    public void replace(int container, Fragment fragment) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(container, fragment);
        fragmentTransaction.commit();
    }
}
