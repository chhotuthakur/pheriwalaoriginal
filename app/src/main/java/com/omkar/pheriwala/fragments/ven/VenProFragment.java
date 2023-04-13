package com.omkar.pheriwala.fragments.ven;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseReference;
import com.omkar.pheriwala.R;


public class VenProFragment extends Fragment {


    RecyclerView recyclerView;
    DatabaseReference reference;



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


}