package com.brex.galangue.sampleweatherapp.controller.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.brex.galangue.sampleweatherapp.R;
import com.brex.galangue.sampleweatherapp.helper.SharedPref;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText tiFullname, tiUserName, tiPassword;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeIds();
    }

    private void initializeIds(){

        tiFullname = findViewById(R.id.tiFullname);
        tiUserName = findViewById(R.id.tiUserName);
        tiPassword = findViewById(R.id.tiPassword);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!tiFullname.getText().toString().isEmpty() && !tiUserName.getText().toString().isEmpty() && !tiPassword.getText().toString().isEmpty()){
                    SharedPref.saveString(MainActivity.this, SharedPref.FULLNAME, tiFullname.getText().toString());
                    SharedPref.saveString(MainActivity.this, SharedPref.USERNAME, tiUserName.getText().toString());
                    SharedPref.saveString(MainActivity.this, SharedPref.PASSWORD, tiPassword.getText().toString());

                    Intent intent = new Intent(MainActivity.this, LoginPageActivity.class);
                    startActivity(intent);
                    finish();

                }else{
                    Toast.makeText(MainActivity.this, "Please complete all fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}