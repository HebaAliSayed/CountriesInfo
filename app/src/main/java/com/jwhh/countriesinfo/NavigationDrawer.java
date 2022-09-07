package com.jwhh.countriesinfo;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.snackbar.Snackbar;
import androidx.core.view.GravityCompat;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Menu;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.ui.AppBarConfiguration;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.jwhh.countriesinfo.databinding.ActivityNavigationDrawerBinding;

import java.util.List;

public class NavigationDrawer extends AppCompatActivity
implements NavigationView.OnNavigationItemSelectedListener{

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavigationDrawerBinding binding;
    private countryRecyclerAdapter mCountryRecyclerAdapter;
    private RecyclerView recyclerCountries;
    private LinearLayoutManager countriesLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNavigationDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarNavigationDrawer.toolbar);
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        navigationView.setNavigationItemSelectedListener(this);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_aboutme, R.id.nav_setting)
                .setDrawerLayout(drawer)
                .build();
        /*NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation_drawer);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);*/

        intializeDisplayContent();
    }

    @Override
    protected void onResume() {

        super.onResume();
        mCountryRecyclerAdapter.notifyDataSetChanged();
    }

    private void intializeDisplayContent() {
        recyclerCountries = (RecyclerView) findViewById(R.id.list_items);
        countriesLayoutManager = new LinearLayoutManager(this);
        List<contryInfo> country=DataManager.getCountries();
        mCountryRecyclerAdapter=new countryRecyclerAdapter(this,country);
        setPrefDefaultValues();
        displayCountry();

    }

    private void setPrefDefaultValues(){
        PreferenceManager.setDefaultValues(this,R.xml.pref_personal,false);
    }
    private void displayCountry() {
        recyclerCountries.setLayoutManager(countriesLayoutManager);
        recyclerCountries.setAdapter(mCountryRecyclerAdapter);

        selectNavigationMenuItem(R.id.nav_home);
    }
    private void selectNavigationMenuItem(int id){
        NavigationView navigationView = binding.navView;
        Menu menu=navigationView.getMenu();
        menu.findItem(id).setChecked(true);
    }
    private void displayAbout(){
        Intent intent=new Intent(this,AboutMeActivity.class);
        this.startActivity(intent);
        selectNavigationMenuItem(R.id.nav_aboutme);

    }
    private void dispalySettings(){
        Intent intent=new Intent(this,SettingsActivity.class);
        this.startActivity(intent);
        selectNavigationMenuItem(R.id.nav_setting);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }
    @Override
    public void onBackPressed(){
        DrawerLayout drawer = binding.drawerLayout;
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id=menuItem.getItemId();
        if(id==R.id.nav_home){
            displayCountry();
        }else if(id==R.id.nav_aboutme){
            displayAbout();
        }else if(id==R.id.nav_setting){
            dispalySettings();
        }else if(id==R.id.nav_shareApp){
            handleSellection("Send");
        }

        DrawerLayout drawer = binding.drawerLayout;
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void handleSellection(String message) {
        View view=findViewById(R.id.list_items);
        Snackbar.make(view,message,Snackbar.LENGTH_LONG).show();


    }
/*
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation_drawer);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }*/
}