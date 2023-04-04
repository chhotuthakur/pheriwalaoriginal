package com.omkar.pheriwala.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.omkar.pheriwala.R;
import com.omkar.pheriwala.activities.customer.CustAccountActivity;
import com.omkar.pheriwala.activities.vendors.VenAccountActivity;

public class AccountActivity extends AppCompatActivity {

    LinearLayout l1,l2;
//    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        l1 = findViewById(R.id.cust_lay);
        l2 = findViewById(R.id.vend_lay);
//        t1 = findViewById(R.id.reg_txt_btn);

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountActivity.this, CustAccountActivity.class));
            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountActivity.this, VenAccountActivity.class));


            }
        });
    }
}