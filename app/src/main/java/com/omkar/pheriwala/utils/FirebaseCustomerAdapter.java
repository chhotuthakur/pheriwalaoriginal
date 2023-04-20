package com.omkar.pheriwala.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.omkar.pheriwala.R;
import com.omkar.pheriwala.models.Customers;
import com.omkar.pheriwala.models.Products;

public class FirebaseCustomerAdapter  extends FirebaseRecyclerAdapter<Customers, FirebaseCustomerAdapter.productViewHolder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public FirebaseCustomerAdapter(@NonNull FirebaseRecyclerOptions<Customers> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull productViewHolder holder, int position, @NonNull Customers model) {

        holder.username.setText(model.getUsername());
        holder.email.setText(model.getEmail());
        holder.phone.setText(model.getPhone());
        holder.address.setText(model.getAddress());


    }

    @NonNull
    @Override
    public productViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custprofilee,parent,false);
        return  new productViewHolder(view);
    }

    public class productViewHolder extends RecyclerView.ViewHolder{


        TextView username,email,phone,address;
        public productViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.cust_frag_name);
            email = itemView.findViewById(R.id.cust_frag_mail);
            phone = itemView.findViewById(R.id.cust_frag_phone);
            address = itemView.findViewById(R.id.cust_frag_add);



        }
    }

}
