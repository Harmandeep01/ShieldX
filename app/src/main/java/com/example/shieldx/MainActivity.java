package com.example.shieldx;

import static android.os.StrictMode.*;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.shieldx.transaction;
import com.example.shieldx.verify;
import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    Button btn1, btnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.buttonNext);
        btnv = findViewById(R.id.buttonVerify);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, transaction.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("MainActivity", "Error starting transaction activity: " + e.getMessage());
                }
            }
        });

        btnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, verify.class);
                startActivity(intent);
            }
        });
    }
    }

