package com.example.and1app.homepage.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.and1app.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class HomeFragment extends Fragment {



    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;


    }



    public void onContactUs(View view)
    {
        /*
        Send user to company contact us homepage
         */
    }

    public void onHelp(View view)
    {
        /*
        Send user to company help homepage
         */
    }
}