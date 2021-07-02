package com.example.Notes.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.Notes.MainActivity;
import com.example.Notes.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        // if we wsnt to remove the  tool baar from spalsh screen
        getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                   startActivity(new Intent(SplashScreen.this, MainActivity.class));
                   finish();
            }
        },2000);

    }
}