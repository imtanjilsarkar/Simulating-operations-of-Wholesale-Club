package com.group16.simulatingoperationsofwholesaleclub.nafiu.Cashier.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Process_Payment {
    @javafx.fxml.FXML
    private ComboBox paymentMethodBox;
    @javafx.fxml.FXML
    private TextField paymentDetailsField;
    @javafx.fxml.FXML
    private Label validationLabel;
    @javafx.fxml.FXML
    private Label balanceLabel;
    @javafx.fxml.FXML
    private Label paymentStatusLabel;

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) {
    }

    @Deprecated
    public void handleGenerateReceipt(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleSubmitPaymentInfo(ActionEvent actionEvent) {
    }
}
