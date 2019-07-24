package com.example.kuttr.stockpredictor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class recents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recents);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
