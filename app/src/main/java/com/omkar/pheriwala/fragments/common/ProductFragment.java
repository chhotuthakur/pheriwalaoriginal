package com.omkar.pheriwala.fragments.common;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.omkar.pheriwala.R;


public class ProductFragment extends Fragment {





    public static ProductFragment newInstance(String param1, String param2) {
        ProductFragment fragment = new ProductFragment();

        return fragment;
    }

    public ProductFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v = inflater.inflate(R.layout.fragment_product, container, false);



        return v;
    }

}