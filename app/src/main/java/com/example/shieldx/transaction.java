package com.example.shieldx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class transaction extends AppCompatActivity {

    EditText accountNum;
    EditText amountNum;
    Button btnInsertData;
    DatabaseReference shieldXdBref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        accountNum = findViewById(R.id.editTextNumber);
        amountNum = findViewById(R.id.editTextNumber2);
        btnInsertData = findViewById(R.id.buttonSubmit);

        shieldXdBref = FirebaseDatabase.getInstance().getReference().child("transactions");
        btnInsertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertTransactionData();
            }
        });
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
    private void insertTransactionData(){
        String account = accountNum.getText().toString();
        String amt     = amountNum.getText().toString();

        transactions Transaction = new transactions(accountNum, amountNum);

        shieldXdBref .push().setValue(transactions);
        Toast.makeText(transaction.this, "data inserted", Toast.LENGTH_SHORT).show();
    }
}