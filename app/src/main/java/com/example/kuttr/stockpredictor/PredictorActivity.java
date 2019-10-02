package com.example.kuttr.stockpredictor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PredictorActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView StockTView,CompanyTView, predictView;
    final static String fileName = "fav.txt";
    final static String path = "MLMarksman" ;
    String data="";
    ImageView imageView,imageView1,fav;
    Button addtofav,remfromfav;
    double prevValue=0;
    private Spinner spinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predictoractivity);
        final Intent intent = getIntent();
        final String st = intent.getStringExtra("STOCK");
        final String cp = intent.getStringExtra("COMPANY");
        final int img = intent.getIntExtra("IMAGE", 0);
        imageView = (ImageView) findViewById(R.id.logoholder);
        imageView.setImageResource(img);
        StockTView = (TextView) findViewById(R.id.StockName);
        CompanyTView = (TextView) findViewById(R.id.CompanyName);
        StockTView.setText(st);
        CompanyTView.setText(cp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fav=findViewById(R.id.fav);
        addtofav=findViewById(R.id.addtofav);
        remfromfav=findViewById(R.id.remfromfav);
        addtofav.setOnClickListener(this);
        remfromfav.setOnClickListener(this);
        spinner = (Spinner) findViewById(R.id.spinner1);
        List<String> spin = new ArrayList<String>();
        for (int i = 0; i < 375; i++) {
            spin.add("Predicted Value after " + i + " days");
        }
        predictView = (TextView) findViewById(R.id.predict);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spin);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);


        imageView1 = (ImageView) findViewById(R.id.upordown);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position <= 100) {

                    String s1 = "120";
                    predictView.setText(s1);
                    prevValue = 120;
                    Log.d("VALUE", Double.toString(prevValue));
                    if (prevValue > 5) {
                        imageView1.setImageResource(R.drawable.reddown);
                        predictView.setTextColor(getResources().getColor(R.color.red));
                    } else {
                        imageView1.setImageResource(R.drawable.greenup);
                        predictView.setTextColor(getResources().getColor(R.color.green));
                    }


                } else {
                    String s1 = "120";
                    predictView.setText(s1);
                    prevValue = 120;
                    Log.d("VALUE", Double.toString(prevValue));
                    if (prevValue > 150) {
                        imageView1.setImageResource(R.drawable.reddown);
                        predictView.setTextColor(getResources().getColor(R.color.red));
                    } else {
                        imageView1.setImageResource(R.drawable.greenup);
                        predictView.setTextColor(getResources().getColor(R.color.green));
                    }
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                imageView1.setImageResource(R.drawable.greenup);
                predictView.setTextColor(getResources().getColor(R.color.green));
                int n = 120;
                String s1 = Integer.toString(n);
                predictView.setText(s1);
            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==addtofav.getId())
        {
            Toast.makeText(this,"Added to favourites", Toast.LENGTH_SHORT).show();
        }
        if(v.getId()==remfromfav.getId())
        {
            Toast.makeText(this,"Removed from favourites", Toast.LENGTH_SHORT).show();
        }
    }
}