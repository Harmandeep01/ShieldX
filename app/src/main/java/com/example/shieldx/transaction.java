package com.example.shieldx;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Transaction;

    public class transaction extends AppCompatActivity {

        EditText accountNumEditText, amountNumEditText;
        Button btnInsertData;
        DatabaseReference shieldXdBref;

        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_transaction);

            accountNumEditText = findViewById(R.id.editTextNumber);
            amountNumEditText = findViewById(R.id.editTextNumber2);
            btnInsertData = findViewById(R.id.buttonSubmit);

            shieldXdBref = FirebaseDatabase.getInstance().getReference().child("transactions");

            btnInsertData.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String accountNumber = accountNumEditText.getText().toString();
                    String amount = amountNumEditText.getText().toString();
                    shieldXdBref = FirebaseDatabase.getInstance().getReference().child("transactions");
                    if (!accountNumber.isEmpty() && !amount.isEmpty()) {

                        String transactionId = shieldXdBref.push().getKey();
                        // Create a MyTransaction object
                        Transactions myTransaction = new Transactions(transactionId,accountNumber, amount);

                        // Push the transaction object to the "transactions" node in Firebase
                        shieldXdBref.push().setValue(myTransaction);

                        // Clear the EditText fields after inserting data
                        accountNumEditText.setText("");
                        amountNumEditText.setText("");

                        Toast.makeText(transaction.this, "Transaction added successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(transaction.this, "Please enter account number and amount", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
}
