package com.omkar.pheriwala.fragments.ven;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.omkar.pheriwala.R;


public class AddproFragment extends Fragment {

    Button add,cancel;
    EditText proname,proqty,proprice;
    String id,name,qty,price;

    DatabaseReference prodb;
    FirebaseAuth mAuth;



    //TODO : Done editing Do Not Touch
    public AddproFragment() {

    }


    public static AddproFragment newInstance(String param1, String param2) {
        AddproFragment fragment = new AddproFragment();

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
        View v = inflater.inflate(R.layout.fragment_addpro, container, false);

        add=  v.findViewById(R.id.btn_pro_add);
        cancel=  v.findViewById(R.id.btn_pro_add_cancel);



        proname =  v.findViewById(R.id.edt_pro_ven_name);
        proqty =  v.findViewById(R.id.edt_pro_ven_qty);
        proprice =  v.findViewById(R.id.edt_pro_ven_price);






        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = proname.getText().toString();
                qty = proqty.getText().toString();
                price = proprice.getText().toString();
//        id = name+qty;
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


                id = name+qty;
                prodb = FirebaseDatabase.getInstance().getReference();
                prodb.child("Products").child(id).child("name").setValue(name);
                prodb.child("Products").child(id).child("qty").setValue(qty);
                prodb.child("Products").child(id).child("price").setValue(price);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proname.setText("");
                proqty.setText("");
                proprice.setText("");

            }
        });












        return v;
    }
}