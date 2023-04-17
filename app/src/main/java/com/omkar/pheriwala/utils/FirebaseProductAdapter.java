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
import com.omkar.pheriwala.models.Products;

public class FirebaseProductAdapter  extends  FirebaseRecyclerAdapter<Products, FirebaseProductAdapter.productViewHolder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public FirebaseProductAdapter(@NonNull FirebaseRecyclerOptions<Products> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull productViewHolder holder, int position, @NonNull Products model) {

        holder.name.setText(model.getName());
        holder.qty.setText(model.getQty());
        holder.price.setText(model.getPrice());


    }

    @NonNull
    @Override
    public productViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_prod,parent,false);
        return  new productViewHolder(view);
    }

    public class productViewHolder extends RecyclerView.ViewHolder{


        TextView name,qty,price;
        public productViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.pro_list_name);
            qty = itemView.findViewById(R.id.pro_list_quan);
            price = itemView.findViewById(R.id.pro_list_price);



        }
    }

}
