package com.omkar.pheriwala.fragments.common;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.omkar.pheriwala.R;


public class ProeditFragment extends Fragment {


    public ProeditFragment() {
        // Required empty public constructor
    }


    public static ProeditFragment newInstance(String param1, String param2) {
        ProeditFragment fragment = new ProeditFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_proedit, container, false);






        return v;
    }
}