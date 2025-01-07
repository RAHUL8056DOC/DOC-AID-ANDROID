package com.rahulji.mobile.app.docaidrahul;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationView;
import com.rahulji.mobile.app.docaidrahul.Fragments.Accounts;
import com.rahulji.mobile.app.docaidrahul.Fragments.Appointments;
import com.rahulji.mobile.app.docaidrahul.Fragments.Clinic;
import com.rahulji.mobile.app.docaidrahul.Fragments.Dashboard;
import com.rahulji.mobile.app.docaidrahul.Fragments.Help;

public class Home extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FrameLayout frameLayout;
    MaterialButton btnLogout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerLayout= findViewById(R.id.drawerLay);
        navigationView= findViewById(R.id.navView);
        frameLayout= findViewById(R.id.container);
        btnLogout= findViewById(R.id.btnLogout);
        toolbar= findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        toggle=new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.OpenDrawer, R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        loadFrag(new Dashboard());
        getSupportActionBar().setTitle("Dashboard");

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login= new Intent(Home.this, MainActivity.class);
                login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(login);
                finish();
            }
        });
        
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                
                int id= item.getItemId();
                if (id==R.id.dash){
                    loadFrag(new Dashboard());
                    toolbar.setTitle("Dashboard");
                } else if (id==R.id.clinic) {
                    loadFrag(new Clinic());
                    toolbar.setTitle("Clinic");
                } else if (id==R.id.appt) {
                    loadFrag(new Appointments());
                    toolbar.setTitle("Appointments");
                } else if (id==R.id.acc) {
                    loadFrag(new Accounts());
                    toolbar.setTitle("Accounts");
                } else if (id==R.id.help) {
                    loadFrag(new Help());
                    toolbar.setTitle("Help");
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    public void loadFrag(Fragment fragment){
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.commit();
    }
}