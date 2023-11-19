package com.example.shieldx;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class transaction extends AppCompatActivity {

    private EditText editTextNumber;
    private EditText editTextNumber2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        Button btn1 = findViewById(R.id.buttonBack);
        Button clear = findViewById(R.id.clear);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);

        editTextNumber = findViewById(R.id.editTextNumber);
        editTextNumber2 = findViewById(R.id.editTextNumber2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(transaction.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNumber2.setText("");
                editTextNumber.setText("");
            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String accountNumber = editTextNumber.getText().toString();
                String amount = editTextNumber2.getText().toString();
                String transactionId = generateRandomTransactionId();

                // Call the method to save to the database
                saveToDatabase(accountNumber, amount, transactionId);

                Intent intent = new Intent(transaction.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private String generateRandomTransactionId() {
        Random rand = new Random();
        int randomNum = rand.nextInt(1000000) + 1;
        return "TX" + randomNum;
    }

    private void saveToDatabase(String accountNumber, String amount, String transactionId) {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://192.168.220.227:3306/shieldx_txn?user=root&password=Boathead90.";
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(true);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            String query = "INSERT INTO transactions (account_number, amount, transaction_id) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, accountNumber);
            preparedStatement.setString(2, amount);
            preparedStatement.setString(3, transactionId);  // Added this line

            Log.d("Debug Info", "Query: " + preparedStatement.toString());
            Log.d("Debug Info", "Before executing insert statement");
            preparedStatement.executeUpdate();
            Log.d("Debug Info", "After executing insert statement");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            Log.e("Database Error", "Error during database operation", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    Log.e("Database Error", "Error closing database connection", e);
                }
            }
        }
    }
}
