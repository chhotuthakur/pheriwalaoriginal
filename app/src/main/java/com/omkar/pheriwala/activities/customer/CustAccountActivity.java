package com.omkar.pheriwala.activities.customer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.omkar.pheriwala.R;

public class CustAccountActivity extends AppCompatActivity {

    Button btn_log, btn_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cust_account);

        btn_log = findViewById(R.id.btn_cust_login);
        btn_reg = findViewById(R.id.btn_cust_reg);

        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                callLoginDialog();

            }
        });

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callRegDialog();
            }
        });
    }

    private void callLoginDialog()
    {
        Dialog myDialog = new Dialog(this);
        myDialog.setContentView(R.layout.login_page);
        myDialog.setCancelable(false);
        Button login = (Button) myDialog.findViewById(R.id.login_btn);

        EditText edtmail = (EditText) myDialog.findViewById(R.id.mail_login);
        EditText edtpass = (EditText) myDialog.findViewById(R.id.pass_login);
        myDialog.show();

        login.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                //your login calculation goes here
            }
        });


    }
    private void callRegDialog()
    {
        Dialog myDialog = new Dialog(this);
        myDialog.setContentView(R.layout.reg_page);
        myDialog.setCancelable(false);
        Button login = (Button) myDialog.findViewById(R.id.login_btn);

        EditText edtmail = (EditText) myDialog.findViewById(R.id.mail_login);
        EditText edtpass = (EditText) myDialog.findViewById(R.id.pass_login);
        myDialog.show();

        login.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                //your login calculation goes here
            }
        });


    }
}