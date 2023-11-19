package com.example.shieldx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
class connection {
    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/shieldx_txn";
        String user = "root";
        String password = "Boathead90.";

        // JDBC variables for opening, closing, and managing the connection
        Connection connection = null;

        try {
            // Step 1: Register JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establishing a Connection
            connection = DriverManager.getConnection(url, user, password);

            // Do something with the connection (e.g., execute SQL queries)

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Step 3: Closing the Connection
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}