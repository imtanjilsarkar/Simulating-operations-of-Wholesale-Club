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

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Cashier/cashier_dashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleNextCustomer(ActionEvent actionEvent) {
    }
}
