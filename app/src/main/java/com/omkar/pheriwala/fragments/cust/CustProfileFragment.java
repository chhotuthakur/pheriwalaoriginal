package com.omkar.pheriwala.fragments.cust;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.omkar.pheriwala.R;


public class CustProfileFragment extends Fragment {




    public CustProfileFragment() {
        // Required empty public constructor
    }


    public static CustProfileFragment newInstance(String param1, String param2) {
        CustProfileFragment fragment = new CustProfileFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_cust_profile, container, false);


        return v;
    }
}