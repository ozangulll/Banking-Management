package com.example.dimsproject.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import com.example.dimsproject.repository.CustomerRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Customer;

import java.sql.SQLException;

public class CustomerController {

    @FXML
    private TextField addressTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField nameTextField;
    @FXML
    public Button updateButton;
    @FXML
    private Button closeButton;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private Button clearButton;


    Stage stage;

    private void clearFields() {
        idTextField.clear();
        addressTextField.clear();
        nameTextField.clear();
        cityTextField.clear();
    }
    private boolean showAlert(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        ButtonType yesButton = new ButtonType("Yes");
        ButtonType noButton = new ButtonType("No");

        alert.getButtonTypes().setAll(yesButton, noButton);
        alert.showAndWait();
        if(alert.getResult()==yesButton){
            return true;
        }else  return false;
    }
    @FXML
    void clearButtonAction(ActionEvent event) {
    clearFields();
    }
    @FXML
    void handleCloseButtonAction(ActionEvent event) {
        stage = (Stage) scenePane.getScene().getWindow();
        boolean result=showAlert("Message", "Are you sure you want to close?");
        if(result)
        {
            stage.close();
        }
    }


    @FXML
    void handleDeleteButtonAction(ActionEvent event) {
        CustomerRepository customerRepository = new CustomerRepository();
        int customerId = Integer.parseInt(idTextField.getText());
        Customer customer = customerRepository.getCustomerByID(customerId);

        if (customer != null) {
            addressTextField.setText(customer.getAddress());
            nameTextField.setText(customer.getName());
            cityTextField.setText(customer.getCity());

        } else {
            showAlert("Message", "The customer not found!");
        }
        clearFields();
        customerRepository.deleteCustomerById(customerId);

        showAlert("Message", "The customer has been deleted successfully!");

    }


    @FXML
    void handleFetchButtonAction(ActionEvent event) {
        CustomerRepository customerRepository = new CustomerRepository();
        int customerId = Integer.parseInt(idTextField.getText());
        Customer customer = customerRepository.getCustomerByID(customerId);

        if (customer != null) {
            addressTextField.setText(customer.getAddress());
            nameTextField.setText(customer.getName());
            cityTextField.setText(customer.getCity());

        } else {

            showAlert("Message", "The customer not found!");;
        }
    }

    @FXML
    void handleSaveButtonAction(ActionEvent event) throws SQLException {
        Customer customer=new Customer();

        customer.setAddress(addressTextField.getText());
        customer.setCity(cityTextField.getText());
        customer.setName(nameTextField.getText());
        if(!idTextField.getText().isEmpty()){
            customer.setUserid((Integer.parseInt(idTextField.getText())));
        }
        CustomerRepository customerRepository=new CustomerRepository();
        customerRepository.saveCustomer(customer);
        clearFields();

        showAlert("Message", "The customer has been saved successfully!");
    }

    @FXML
    void handleUpdateButtonAction(ActionEvent event) throws SQLException {
        CustomerRepository customerRepository=new CustomerRepository();
        Customer customer=new Customer();
        customer.setUserid(Integer.parseInt(idTextField.getText()));
        customer.setAddress(addressTextField.getText());
        customer.setCity(cityTextField.getText());
        customer.setName(nameTextField.getText());
        customerRepository.updateCustomer(customer);

        clearFields();

        showAlert("Message", "The customer has been updated successfully!");
    }

}
