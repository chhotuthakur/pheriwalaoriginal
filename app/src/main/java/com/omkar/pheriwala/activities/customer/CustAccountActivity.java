package com.omkar.pheriwala.activities.customer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.omkar.pheriwala.R;

public class CustAccountActivity extends AppCompatActivity {

    Button btn_log, btn_reg, login_btn;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    TextView txxt_log_reg,title_txt;
    EditText mail_log,pass_log;
    String user;

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
                login_btn = v.findViewById(R.id.login_btn);
//                txxt_log_reg = v.findViewById(R.id.txxt_reg_logn);
//                mail_log = v.findViewById(R.id.mail_login);
//                pass_log = v.findViewById(R.id.pass_login);
//                title_txt = view.findViewById(R.id.title_log_txt);

                mAuth = FirebaseAuth.getInstance();


                String mail = edtmail.getText().toString();
                String pass = edtpass.getText().toString();


                login_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        mAuth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(CustAccountActivity.this,"Login Success",Toast.LENGTH_LONG).show();
//                            Intent i = new Intent(getContext(), MainActivity.class);
//                            startActivity(i);

                                    Intent i = new Intent(CustAccountActivity.this,CustHomeActivity.class);
                                    startActivity(i);

                                }
                            }
                        });


                    }
                });




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