package com.digzdigital.eaglesconnect.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.digzdigital.eaglesconnect.R;

/**
 * Created by Digz on 27/08/2016.
 */
public class HomeFragment extends Fragment {
    public HomeFragment() {

    }


    @Override
    public void onCreate(Bundle a) {
        super.onCreate(a);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle a) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

}
