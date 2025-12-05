package com.group16.simulatingoperationsofwholesaleclub.nafiu.Cashier.Controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Balance_Cash_Drawer {
    @javafx.fxml.FXML
    private Label balanceStatusLabel;
    @javafx.fxml.FXML
    private Label comparisonLabel;
    @javafx.fxml.FXML
    private TextField actualCashField;
    @javafx.fxml.FXML
    private Label differenceLabel;

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Cashier/cashier_dashboard.fxml",actionEvent);
    }
    @javafx.fxml.FXML
    public void handleSubmitCash(ActionEvent actionEvent) {
        int expectedCash = 100;
        int actualCash = Integer.parseInt(actualCashField.getText());
        int difference = actualCash - expectedCash;

        comparisonLabel.setText("Expected: " + expectedCash + " Taka, Actual: " + actualCash + " Taka");
        differenceLabel.setText("Difference: " + difference + " Taka");

        if (difference == 0) {
            balanceStatusLabel.setText("Cash Drawer Balanced");
        } else {
            balanceStatusLabel.setText("Mismatch Found");
        }
    }
}
