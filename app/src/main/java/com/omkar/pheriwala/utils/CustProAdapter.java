package com.omkar.pheriwala.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.omkar.pheriwala.models.Customers;

public class CustProAdapter extends FirebaseRecyclerAdapter<Customers, CustProAdapter.ViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public CustProAdapter(@NonNull FirebaseRecyclerOptions<Customers> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull CustProAdapter.ViewHolder holder, int position, @NonNull Customers model) {

    }

    @NonNull
    @Override
    public CustProAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView username,email,phone,address,type;
        public ViewHolder(@NonNull View itemView) {




            super(itemView);
        }
    }
}
