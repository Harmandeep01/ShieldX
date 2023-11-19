package com.example.shieldx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class transaction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        // Assuming you have a button with id btn1 in activity_transaction.xml
        Button btn1 = this.<Button>findViewById(R.id.buttonBack);

        // Set a click listener for the button
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to go back to MainActivity
                Intent intent = new Intent(transaction.this, MainActivity.class);

                // Start the MainActivity and finish the current activity
                startActivity(intent);
                finish();
            }
        });
    }
}