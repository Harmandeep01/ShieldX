package com.example.shieldx;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class verifyall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifyall);
        Button py=findViewById(R.id.payment);
        Button ar=findViewById(R.id.milatray);
        py.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent xx = new Intent(verifyall.this, verify.class);
                startActivity(xx);
            }
        });

        ar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mil = new Intent(verifyall.this, milatry.class);
                startActivity(mil);
            }
        });


    }
}