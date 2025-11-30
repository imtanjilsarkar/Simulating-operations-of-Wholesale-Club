package com.group16.simulatingoperationsofwholesaleclub.nafiu.Cashier.Controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Apply_Membership_Discount {
    @javafx.fxml.FXML
    private Label updatedBillLabel;
    @javafx.fxml.FXML
    private Label validityLabel;
    @javafx.fxml.FXML
    private TextField membershipIdField;

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/Nafiu/Cashier/cashier_dashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleRecalculateTotal(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleVerifyMembership(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleApplyMembership(ActionEvent actionEvent) {
    }
}
