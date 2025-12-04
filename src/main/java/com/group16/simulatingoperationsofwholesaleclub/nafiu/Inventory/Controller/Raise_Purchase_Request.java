package com.group16.simulatingoperationsofwholesaleclub.nafiu.Inventory.Controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Raise_Purchase_Request {
    @javafx.fxml.FXML
    private TextField productIdField;
    @javafx.fxml.FXML
    private Label validationMessage;
    @javafx.fxml.FXML
    private TextField quantityField;
    @javafx.fxml.FXML
    private Label confirmationMessage;

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Inventory/inventory_dashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleSubmitRequest(ActionEvent actionEvent) {
        String productId = productIdField.getText();
        String quantityText = quantityField.getText();

        // Basic validation
        if (productId == null || productId.isEmpty()) {
            validationMessage.setText("Enter Product ID");
            confirmationMessage.setText("");
            return;
        }
        if (quantityText == null || quantityText.isEmpty()) {
            validationMessage.setText("Enter Quantity");
            confirmationMessage.setText("");
            return;
        }

        // If productId = fish1 and quantity = 10, show success
        if (productId.equalsIgnoreCase("fish1") && quantityText.equals("10")) {
            confirmationMessage.setText("Request Successfully Submitted");
            validationMessage.setText("");
        } else {
            confirmationMessage.setText("Request Submitted");
            validationMessage.setText("");
        }
    }
}
