package com.omkar.pheriwala.activities.vendors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.omkar.pheriwala.R;
import com.omkar.pheriwala.activities.customer.CustAccountActivity;
import com.omkar.pheriwala.fragments.ven.AddproFragment;
import com.omkar.pheriwala.fragments.ven.VenPlacesFragment;
import com.omkar.pheriwala.fragments.ven.VenProFragment;
import com.omkar.pheriwala.fragments.ven.VenProfileFragment;
import com.omkar.pheriwala.utils.FragmentChangeListener;

public class VenHomeActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ven_home);

        mAuth = FirebaseAuth.getInstance();

        // drawer and back button to close drawer
        drawerLayout = findViewById(R.id.ven_home_drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        VenPlacesFragment fragment = new VenPlacesFragment() ;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.ven_home_frag_container, fragment, "");
        fragmentTransaction.commit();

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        fragment = null;
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {

            switch (item.getItemId()){
                case R.id.ven_side_pro:

                    fragment = new VenProfileFragment();
                    break;
                case R.id.ven_side_proda:

                    fragment = new VenProFragment();
                    break;
                case R.id.ven_side_locate:

                    fragment = new VenProfileFragment();
                    break;

            }

            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mUser = mAuth.getCurrentUser();
        if (mUser==null){
            Toast.makeText(this,"please log in ",Toast.LENGTH_LONG).show();
            startActivity(new Intent(VenHomeActivity.this, CustAccountActivity.class));
        }
    }

    class HomeActivity extends VenHomeActivity implements FragmentChangeListener{



        @Override
        public void replaceFragment(Fragment fragment) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.ven_home_frag_container,fragment,fragment.toString());
            transaction.addToBackStack(fragment.toString());
            transaction.commit();


        }
    }
}