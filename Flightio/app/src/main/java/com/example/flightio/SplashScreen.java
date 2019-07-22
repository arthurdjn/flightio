package com.example.flightio;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Send back to the main activity after 2s
        // delay
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // Start a page
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        // handler post delay
        new Handler().postDelayed(runnable, 2000);
    }




}