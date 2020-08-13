package com.kiduyu.nicholasproject.e_mkulima;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kiduyu.nicholasproject.e_mkulima.StatusBar.StatusBar;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBar.changeStatusBarColor(this);
        setContentView(R.layout.activity_login);
    }

    public void home(View view) {
        startActivity(new Intent(this, HomeActivity.class));
    }
}