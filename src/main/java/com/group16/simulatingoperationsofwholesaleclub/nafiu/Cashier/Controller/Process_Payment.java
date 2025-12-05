package com.group16.simulatingoperationsofwholesaleclub.nafiu.Cashier.Controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Process_Payment {
    @javafx.fxml.FXML
    private ComboBox paymentMethodBox;
    @javafx.fxml.FXML
    private TextField paymentDetailsField;
    @javafx.fxml.FXML
    private Label validationLabel;
    @javafx.fxml.FXML
    private Label paymentStatusLabel;

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Cashier/cashier_dashboard.fxml",actionEvent);
    }
    @Deprecated
    public void handleGenerateReceipt(ActionEvent actionEvent) {
    }
    @javafx.fxml.FXML
    public void handleSubmitPaymentInfo(ActionEvent actionEvent) {
        String method = (String) paymentMethodBox.getValue();
        String amountEntered = paymentDetailsField.getText();
        if (method == null || amountEntered.isEmpty()) {
            validationLabel.setText("Please fill all fields!");
            return;
        }
        if (amountEntered.equals("50")) {
            validationLabel.setText("valid");
        } else {
            validationLabel.setText("Invalid Amount");
            paymentStatusLabel.setText("Payment Incomplete");
            return;
        }
        paymentStatusLabel.setText("Payment Complete");
    }
}
