module com.sau.bankingmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.sau.bankingmanagement to javafx.fxml;
    exports com.sau.bankingmanagement;
}