package com.omkar.pheriwala.fragments.cust;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.omkar.pheriwala.R;
import com.omkar.pheriwala.fragments.ven.VenPlacesFragment;
import com.omkar.pheriwala.models.Customers;
import com.omkar.pheriwala.models.Products;
import com.omkar.pheriwala.utils.FirebaseCustomerAdapter;
import com.omkar.pheriwala.utils.FirebaseProductAdapter;
import com.omkar.pheriwala.utils.GetAddressIntentService;


public class CustProfileFragment extends Fragment {


  RecyclerView proRecyc;
    DatabaseReference reference;
    FirebaseCustomerAdapter adapter;
    FirebaseAuth cAuth;
    public static String uid;
    public static String cmail;





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

            TextView loca_tx = (TextView) v.findViewById(R.id.locas_tocas);
            proRecyc = v.findViewById(R.id.cust_profile_recy);

            FirebaseAuth auth = FirebaseAuth.getInstance();
            FirebaseUser user = auth.getCurrentUser();

        FirebaseUser mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (mCurrentUser != null) {
            uid = mCurrentUser.getUid();
            cmail = mCurrentUser.getEmail();
        }



        proRecyc.setLayoutManager(new LinearLayoutManager(getContext()));



        FirebaseRecyclerOptions<Customers> customer =
                new FirebaseRecyclerOptions.Builder<Customers>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Customer").child("email"), Customers.class)
                        .build();


        adapter = new FirebaseCustomerAdapter(customer);
        proRecyc.setAdapter(adapter);








        return v;
    }

}