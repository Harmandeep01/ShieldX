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

        // Assuming you have a button with id btn1 in activity_transaction.xml
        Button btn1 = findViewById(R.id.buttonBack);
        Button clear = findViewById(R.id.clear);

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
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNumber2.setText("");
                editTextNumber.setText("");
            }
        });
        Button buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Save the values of editTextNumber and editTextNumber2
                String accountNumber = editTextNumber.getText().toString();
                String amount = editTextNumber2.getText().toString();

                // Generate a random Transaction ID
                String transactionId = generateRandomTransactionId();


                // After saving, you might want to navigate to another activity or perform other actions
                // For example, you can navigate back to MainActivity
                Intent intent = new Intent(transaction.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private String generateRandomTransactionId() {
        // Generate a random Transaction ID (you can customize this based on your requirements)
        Random rand = new Random();
        int randomNum = rand.nextInt(1000000) + 1;
        return "TX" + randomNum;
    }

    private void saveToDatabase(String accountNumber, String amount, String transactionId) {
        // Save the data to MySQL database
        Connection connection = null;

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create the database connection
            String url = "jdbc:mysql://192.168.220.227::3306/shieldx_txn?user=root&password=Boathead90.";
            connection = DriverManager.getConnection(url);

            // Set auto-commit mode to true
            connection.setAutoCommit(true);

            // Set transaction isolation level (optional)
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            // Assuming you have a table named 'transactions' with columns 'account_number', 'amount', and 'transaction_id'
            String query = "INSERT INTO transactions (account_number, amount, transaction_id) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            String account_number = "";
            preparedStatement.setString(1, account_number);
            preparedStatement.setString(2, amount);
            String transaction_id = "";
            preparedStatement.setString(3, transaction_id);

            Log.d("Debug Info", "Query: " + preparedStatement.toString());  // Log the query

            Log.d("Debug Info", "Before executing insert statement");
            preparedStatement.executeUpdate();
            Log.d("Debug Info", "After executing insert statement");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            Log.e("Database Error", "Error during database operation", e);
        } finally {
            // Close the connection in the 'finally' block to ensure it gets closed even if an exception occurs
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
