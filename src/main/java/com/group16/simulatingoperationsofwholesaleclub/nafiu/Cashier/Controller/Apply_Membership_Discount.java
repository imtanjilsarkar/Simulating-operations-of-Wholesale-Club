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
    int productPrice = 100;
    boolean isMember = false;

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Cashier/cashier_dashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleRecalculateTotal(ActionEvent actionEvent) {
        if (isMember) {
            int discountedPrice = productPrice / 2;
            updatedBillLabel.setText("Updated Bill: " + discountedPrice + " taka");
        } else {
            updatedBillLabel.setText("Membership not valid! updated bill "  + productPrice );
        }
    }

    @javafx.fxml.FXML
    public void handleVerifyMembership(ActionEvent actionEvent) {
        String enteredId = membershipIdField.getText();
        if (enteredId.equals("111")) {
            isMember = true;
            validityLabel.setText("Positive");
        } else {
            isMember = false;
            validityLabel.setText("Invalid ID");
        }
    }
}
