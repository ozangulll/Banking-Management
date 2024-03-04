package com.example.dimsproject.repository;



import model.Account;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/bankingmanagement";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "ewnlnqwmkssh52";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }
    public Account getAccountByID(int accountId) {
        Account account = null;
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM accounts WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, accountId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String branch = resultSet.getString("branch");
                        int balance = resultSet.getInt("balance");
                        account = new Account(id, branch,balance);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public void saveAccount(Account account) {
        try (Connection connection = getConnection()) {
            String sql;
            if(account.getAccountId()!=0){
                sql = "INSERT INTO accounts (branch,balance,id) VALUES (?,?,?)";
            }
            else sql = "INSERT INTO accounts (branch,balance) VALUES (?,?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                if(account.getAccountId()!=0){
                    preparedStatement.setInt(3,account.getAccountId());
                }
                preparedStatement.setString(1, account.getBranch());
                preparedStatement.setInt(2, account.getBalance());
                preparedStatement.executeUpdate(); // Use executeUpdate() for INSERT operations
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateAccount(Account account) throws SQLException {
        Connection connection= getConnection();
        String sql="UPDATE accounts set branch=?,balance =? where id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,account.getAccountId());
        preparedStatement.setString(2,account.getBranch());
        preparedStatement.setInt(3, account.getBalance());
        preparedStatement.executeUpdate();
        connection.close();
    }

    public boolean deleteAccountById(int accountId) {
        try (Connection connection = getConnection()) {
            String sql = "DELETE FROM accounts WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, accountId);

                // Execute the update, which returns the number of affected rows
                int rowsAffected = preparedStatement.executeUpdate();

                // Check if any rows were affected
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
