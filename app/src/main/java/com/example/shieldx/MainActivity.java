package com.example.shieldx;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn1, btnv;
    ImageView aboutus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.buttonNext);
        btnv = findViewById(R.id.buttonVerify);
        aboutus = findViewById(R.id.about);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Button 'Next' clicked");

                // Create an Intent to start the 'transaction' activity
                Intent intent = new Intent(MainActivity.this, transaction.class);
                startActivity(intent);
            }
        });

        btnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Button 'Verify' clicked");

                // Create an Intent to start the 'verifyall' activity
                Intent vss = new Intent(MainActivity.this, verifyall.class);
                startActivity(vss);
            }
        });

        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "ImageView 'About Us' clicked");

                // Create an Intent to start the 'About' activity
                Intent nextpage = new Intent(MainActivity.this, About.class);
                startActivity(nextpage);
            }
        });
    }
}

