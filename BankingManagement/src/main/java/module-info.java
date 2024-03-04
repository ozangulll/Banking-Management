module com.sau.bankingmanagement {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sau.bankingmanagement to javafx.fxml;
    exports com.sau.bankingmanagement;
}