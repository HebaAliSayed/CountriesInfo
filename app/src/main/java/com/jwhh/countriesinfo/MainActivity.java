package com.jwhh.countriesinfo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.navigation.ui.AppBarConfiguration;

import com.jwhh.countriesinfo.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private countryRecyclerAdapter mCountryRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        intializeDisplayContent();

    }
    @Override
    protected void onResume() {

        super.onResume();
        mCountryRecyclerAdapter.notifyDataSetChanged();
    }

    private void intializeDisplayContent() {
        final RecyclerView recyclerCountries =(RecyclerView) findViewById(R.id.list_country);
        final LinearLayoutManager countriesLayoutManager = new LinearLayoutManager(this);
        recyclerCountries.setLayoutManager(countriesLayoutManager);
        List<contryInfo>country=DataManager.getCountries();
        mCountryRecyclerAdapter=new countryRecyclerAdapter(this,country);
        recyclerCountries.setAdapter(mCountryRecyclerAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}