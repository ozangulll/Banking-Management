package com.sau.bankingmanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        TabPane tabPane = new TabPane();

        Tab customerTab = new Tab("Customer");
        FXMLLoader customerLoader = new FXMLLoader(StartApplication.class.getResource("customer-view.fxml"));
        customerTab.setContent(customerLoader.load());
        tabPane.getTabs().add(customerTab);

        Tab accountTab = new Tab("Account");
        FXMLLoader accountLoader = new FXMLLoader(StartApplication.class.getResource("account-view.fxml"));
        accountTab.setContent(accountLoader.load());

        tabPane.getTabs().add(accountTab);


        Scene scene = new Scene(tabPane, 640, 480);
        primaryStage.setTitle("Banking Management");
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setMaxWidth(566);
        primaryStage.setMaxHeight(416);
    }

    public static void main(String[] args) {
        launch();
    }
}
