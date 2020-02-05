package com.marcos.primeiroprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //Retirar ActionBar da activity
        getSupportActionBar().hide();

       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               startActivity(new Intent(getActivity(), LoginActivity.class));
               finish();
           }
       }, 2000);
    }

    //Retornar propria activity
    public Context getActivity() {
        return this;
    }
}
