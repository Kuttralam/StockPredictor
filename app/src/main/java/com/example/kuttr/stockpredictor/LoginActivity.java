package com.example.kuttr.stockpredictor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;


public class LoginActivity extends AppCompatActivity implements OnClickListener {
    EditText username, password;
    Button signin;
    CheckBox checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        checkbox=findViewById(R.id.cb);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        signin = findViewById(R.id.signin_button);
        signin.setOnClickListener(this);

        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        Fabric.with(this, new Crashlytics());

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == signin.getId()) {
            if (TextUtils.isEmpty(username.getText())) {
                username.setError("You must enter a valid username");
            }
            if (TextUtils.isEmpty(password.getText()) || password.getText().toString().length() < 8) {

                password.setError("You must have 8 characters in your password");
                return;
            } else {
                Log.d("username",username.getText().toString());
                Toast.makeText(this, username.getText().toString(), Toast.LENGTH_SHORT).show();

                Log.d("password",password.getText().toString());
                Toast.makeText(this, password.getText().toString(), Toast.LENGTH_SHORT).show();

                Intent i = new Intent
                        (LoginActivity.this,
                                Main2Activity.class);
                i.putExtra("name", username.getText().toString());
                i.putExtra("password", password.getText().toString());

                startActivityForResult(i,4);
            }
        }
    }




    }


