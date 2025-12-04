package com.group16.simulatingoperationsofwholesaleclub.nafiu.Cashier.Controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import java.io.IOException;

public class Queue_Management {
    @javafx.fxml.FXML
    private Label readyStatusLabel;
    @javafx.fxml.FXML
    private Label transactionLogLabel;
    private int customerCount = 0;

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Cashier/cashier_dashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleNextCustomer(ActionEvent actionEvent) {
        customerCount++;

        // Log the transaction order
        transactionLogLabel.setText("Customer " + customerCount + " served");

        // Show ready status
        readyStatusLabel.setText("Ready for Next Customer");
    }
}
