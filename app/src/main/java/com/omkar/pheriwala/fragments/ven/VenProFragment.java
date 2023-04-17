package com.omkar.pheriwala.fragments.ven;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.omkar.pheriwala.R;
import com.omkar.pheriwala.models.Products;
import com.omkar.pheriwala.utils.FirebaseProductAdapter;
import com.omkar.pheriwala.utils.FragmentChangeListener;


public class VenProFragment extends Fragment {


    RecyclerView recyclerView;
    DatabaseReference reference;
    FirebaseProductAdapter adapter;
    Button add_pro_btn;



    public VenProFragment() {
        // Required empty public constructor
    }


    public static VenProFragment newInstance(String param1, String param2) {
        VenProFragment fragment = new VenProFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View v = inflater.inflate(R.layout.fragment_ven_pro, container, false);




        recyclerView = v.findViewById(R.id.pro_holder_recyc);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



        FirebaseRecyclerOptions<Products> products =
                new FirebaseRecyclerOptions.Builder<Products>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Products"), Products.class)
                        .build();


        adapter = new FirebaseProductAdapter(products);
        recyclerView.setAdapter(adapter);

        return v;
    }
//    Dialog myDialog = new Dialog(getContext());
//                myDialog.setContentView(R.layout.pro_edit);
//    Button update = (Button)myDialog.findViewById(R.id.btn_pro_update);
//    Button cancel = (Button)myDialog.findViewById(R.id.btn_pro_update_cancel);
//
//    EditText pro_ed_name = (EditText)myDialog.findViewById(R.id.edt_pro_ven_name) ;
//    EditText pro_ed_qty = (EditText)myDialog.findViewById(R.id.edt_pro_ven_qty) ;
//    EditText pro_ed_price = (EditText)myDialog.findViewById(R.id.edt_pro_ven_price) ;
//    EditText pro_ed_desc = (EditText)myDialog.findViewById(R.id.edt_pro_ven_desc) ;
//
//
//
//
//                myDialog.setCancelable(true);
//                myDialog.show();

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}