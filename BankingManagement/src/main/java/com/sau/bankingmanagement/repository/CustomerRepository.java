package com.sau.bankingmanagement.repository;

import com.sau.bankingmanagement.controller.AccountController;

import com.sau.bankingmanagement.controller.CustomerController;
import model.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.sau.bankingmanagement.repository.JDBC.getConnection;

public class CustomerRepository {

    public Customer getCustomerByID(int customerId) {
        Customer customer = null;
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM customers WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, customerId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String address = resultSet.getString("address");
                        String city = resultSet.getString("city");
                        customer = new Customer(id, name, address, city);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public void saveCustomer(Customer customer) {
        try (Connection connection = getConnection()) {
            String sql;
            if(customer.getUserid()!=0){
                sql = "INSERT INTO customers (name,address,city,id) VALUES (?,?,?,?)";
            }
            else sql = "INSERT INTO customers (name,address,city) VALUES (?,?,?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                if(customer.getUserid()!=0){
                    preparedStatement.setInt(4,customer.getUserid());
                }
                preparedStatement.setString(1, customer.getName());
                preparedStatement.setString(2, customer.getAddress());
                preparedStatement.setString(3, customer.getCity());

                preparedStatement.executeUpdate(); // Use executeUpdate() for INSERT operations
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateCustomer(Customer customer) throws SQLException {
        Connection connection = getConnection();
        String sql="UPDATE customers set name=?,city=?,address=? where id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,customer.getName());
        preparedStatement.setString(2,customer.getCity());
        preparedStatement.setString(3, customer.getAddress());
        preparedStatement.setInt(4,customer.getUserid());
        preparedStatement.executeUpdate();
        connection.close();
    }


    public boolean deleteCustomerById(int customerId) {
        try (Connection connection = getConnection()) {
            String sql = "DELETE FROM customers WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, customerId);

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
