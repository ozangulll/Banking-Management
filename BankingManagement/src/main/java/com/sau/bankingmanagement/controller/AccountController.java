package com.sau.bankingmanagement.controller;

import com.sau.bankingmanagement.repository.AccountRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Account;

import java.sql.SQLException;

public class AccountController {

    @FXML
    private TextField balanceTextField;

    @FXML
    private TextField branchTextField;

    @FXML
    private TextField idTextField;
    @FXML
    private Button closeButton;
    @FXML
    private Button clearButton;
    @FXML
    private AnchorPane scenePane;

    Stage stage;

    private void clearFields() {
        idTextField.clear();
        branchTextField.clear();
        balanceTextField.clear();
    }
    @FXML
    void ClearButtonAction(ActionEvent event) {
        clearFields();
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
    void accountCloseButtonAction(ActionEvent event) {
        stage = (Stage) scenePane.getScene().getWindow();
        boolean result =showAlert("Message", "Are you sure you want to close?");
        if(result)
        {
            stage.close();
        }

    }

    @FXML
    void accountDeleteButtonAction(ActionEvent event) {
        AccountRepository accountRepository= new AccountRepository();
        int accountId = Integer.parseInt(idTextField.getText());
        Account account = accountRepository.getAccountByID(accountId);

        if (account != null) {
            branchTextField.setText(account.getBranch());
            balanceTextField.setText(String.valueOf(account.getBalance()));

        } else {

            showAlert("Message", "The account not found!");
        }
        clearFields();
        accountRepository.deleteAccountById(accountId);
        showAlert("Message", "The account has been deleted successfully!");
    }



    @FXML
    void accountFetchButtonAction(ActionEvent event) {
        try {
            AccountRepository accountRepository = new AccountRepository();
            int accountId = Integer.parseInt(idTextField.getText());
            Account account = accountRepository.getAccountByID(accountId);

            if (account != null) {
                branchTextField.setText(account.getBranch());
                balanceTextField.setText(String.valueOf(account.getBalance()));
            } else {
                showAlert("Message", "The account not found!");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

    @FXML
    void accountSaveButtonAction(ActionEvent event) {
        try {
            Account account = new Account();
            account.setBranch(branchTextField.getText());
                int balance = (Integer.parseInt(balanceTextField.getText()));
            account.setBalance(balance);
            if(!idTextField.getText().isEmpty()){
                account.setAccountId(Integer.parseInt(idTextField.getText()));
            }

            AccountRepository accountRepository = new AccountRepository();
            accountRepository.saveAccount(account);
            clearFields();

            showAlert("Message", "The account has been saved successfully!");

        } catch (NumberFormatException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

    @FXML
    void accountUpdateButtonAction(ActionEvent event) throws SQLException {

            AccountRepository accountRepository=new AccountRepository();
            Account account =new Account();
            account.setAccountId(Integer.parseInt(idTextField.getText()));
            account.setBranch(branchTextField.getText());
            account.setBalance(Integer.parseInt(balanceTextField.getText()));
            accountRepository.updateAccount(account);

            clearFields();
            showAlert("Message", "The account has been updated successfully!");
    }
}
