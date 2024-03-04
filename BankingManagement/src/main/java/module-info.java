module com.sau.bankingmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.sau.bankingmanagement.controller to javafx.fxml;

    exports com.sau.bankingmanagement to javafx.graphics;
}
