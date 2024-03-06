package com.sau.bankingmanagement.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    // This is a jdbc class to hide the database information.
    private static final String URL = "jdbc:mysql://localhost:3306/bankingmanagement";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "ewnlnqwmkssh52";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }

}
