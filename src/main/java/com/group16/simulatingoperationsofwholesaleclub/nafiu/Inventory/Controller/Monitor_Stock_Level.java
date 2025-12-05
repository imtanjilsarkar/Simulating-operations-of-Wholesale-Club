package com.group16.simulatingoperationsofwholesaleclub.nafiu.Inventory.Controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Monitor_Stock_Level {
    @javafx.fxml.FXML
    private TextField productNameField;
    @javafx.fxml.FXML
    private TextField quantityField;
    @javafx.fxml.FXML
    private Button checkButton;
    @javafx.fxml.FXML
    private Button backButton;

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Inventory/inventory_dashboard.fxml",actionEvent);
    }
    @javafx.fxml.FXML
    public void handleInventory(ActionEvent actionEvent) {
        String productName = productNameField.getText();

        if (productName != null && productName.equalsIgnoreCase("fish")) {
            quantityField.setText("5");
        } else {
            quantityField.setText("0");
        }
    }
}
