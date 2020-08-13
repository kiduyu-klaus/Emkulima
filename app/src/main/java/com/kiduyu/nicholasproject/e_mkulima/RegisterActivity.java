package com.kiduyu.nicholasproject.e_mkulima;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kiduyu.nicholasproject.e_mkulima.StatusBar.StatusBar;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBar.changeStatusBarColor(this);
        setContentView(R.layout.activity_register);
    }
}