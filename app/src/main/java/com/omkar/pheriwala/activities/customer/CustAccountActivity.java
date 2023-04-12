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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.omkar.pheriwala.R;
import com.omkar.pheriwala.models.Customers;

public class CustAccountActivity extends AppCompatActivity {

    Button btn_log, btn_reg, login_btn, btn_cancel_login,btn_reg_cancel;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    TextView txxt_log_reg,title_txt;
    EditText mail_log,pass_log,edtuname,edtphone,edtadd; ;
    String user;
    private DatabaseReference databaseReference;

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
        Button login = (Button) myDialog.findViewById(R.id.login_btn);

        EditText edtmail = (EditText) myDialog.findViewById(R.id.mail_login);
        EditText edtpass = (EditText) myDialog.findViewById(R.id.pass_login);
        myDialog.show();
        myDialog.setCancelable(true);

        login.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                login_btn = v.findViewById(R.id.login_btn);
//                btn_cancel_login = findViewById(R.id.cancel_login_btn);

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


//                                    if (mAuth.getCurrentUser().toString()==)
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
        Dialog regDialog = new Dialog(this);
        regDialog.setContentView(R.layout.reg_page);
        regDialog.setCancelable(true);
        Button reg = (Button) regDialog.findViewById(R.id.reg_btn);

        EditText edtmail = (EditText) regDialog.findViewById(R.id.edtmail);
        EditText edtpass = (EditText) regDialog.findViewById(R.id.edtpass);
        EditText edtuname = (EditText) regDialog.findViewById(R.id.edtuname);
        EditText edtphone = (EditText) regDialog.findViewById(R.id.edtphone);
        EditText edtadd = (EditText) regDialog.findViewById(R.id.edtadd);

        regDialog.show();

        reg.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

//                edtuname = v.findViewById(R.id.edtuname);
//                edtpass = v.findViewById(R.id.edtpass);
//                edtmail = v.findViewById(R.id.edtmail);
//                edtphone = v.findViewById(R.id.edtphone);
//                edtadd = v.findViewById(R.id.edtadd);
                mAuth = FirebaseAuth.getInstance();


                String username = edtuname.getText().toString();
                String pass = edtpass.getText().toString();
                String mail = edtmail.getText().toString();
                String phone = edtphone.getText().toString();
                String add = edtadd.getText().toString();

                mAuth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(CustAccountActivity.this,"success, please login",Toast.LENGTH_LONG).show();
                            databaseReference = FirebaseDatabase.getInstance().getReference();
//                Products products = new Products();

                            Customers customers = new Customers();



                            String id = username + phone;


                            databaseReference.child("Customer").child(id).child("username").setValue(username);
                            databaseReference.child("Customer").child(id).child("email").setValue(mail);
                            databaseReference.child("Customer").child(id).child("phone").setValue(phone);
                            databaseReference.child("Customer").child(id).child("address").setValue(add);


                            regDialog.dismiss();

                        }
                    }
                });




            }
        });


    }
}