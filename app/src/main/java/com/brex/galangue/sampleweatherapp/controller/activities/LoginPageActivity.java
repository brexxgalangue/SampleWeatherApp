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

public class LoginPageActivity extends AppCompatActivity {


    TextInputEditText  tiUserName, tiPassword;
    Button btnSubmit, btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        initializIds();
    }

    private void initializIds(){
        tiUserName = findViewById(R.id.tiUserName);
        tiPassword = findViewById(R.id.tiPassword);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnCreateAccount =  findViewById(R.id.btnCreateAccount);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!tiUserName.getText().toString().isEmpty() || !tiPassword.getText().toString().isEmpty() ){
                    if(tiUserName.getText().toString().equalsIgnoreCase(getUserName()) && tiPassword.getText().toString().equalsIgnoreCase(getPassword())){
                        Toast.makeText(LoginPageActivity.this, "Successfully Logged In!", Toast.LENGTH_SHORT).show();
                        Intent intent =  new Intent(LoginPageActivity.this, DashboardActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(LoginPageActivity.this, "Incorrect Login credentials", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(LoginPageActivity.this, "Please complete all fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(LoginPageActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private String getUserName(){
        return SharedPref.getString(LoginPageActivity.this, SharedPref.USERNAME, "");
    }

    private String getPassword(){
        return SharedPref.getString(LoginPageActivity.this, SharedPref.PASSWORD, "");
    }
}