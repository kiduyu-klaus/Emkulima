package com.kiduyu.nicholasproject.e_mkulima;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kiduyu.nicholasproject.e_mkulima.Loading.Loading;
import com.kiduyu.nicholasproject.e_mkulima.StatusBar.StatusBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBar.changeStatusBarColor(this);
        Loading.hideProgressDialog(this);
        Loading.showProgressDialog(this);

    }

    public void login(View view) {
        startActivity(new Intent(this,LoginActivity.class));
    }

    public void register(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }
}
