package com.example.myapplication;

import android.os.Bundle;

import android.widget.Toast;
import android.graphics.Color;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.widget.Toolbar;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Country> countryList = new ArrayList<>();
        countryList.add(new Country("Vietnam", "98,000,000", R.drawable.vn));
        countryList.add(new Country("United States", "320,000,000", R.drawable.usa));
        countryList.add(new Country("Russia", "142,000,000", R.drawable.russia));

        CountryAdapter adapter = new CountryAdapter(countryList, country -> {
            String message = "Selected: " + country.getName() + " (Population: " + country.getPopulation() + ")";
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();


        });



        recyclerView.setAdapter(adapter);
    }
}
