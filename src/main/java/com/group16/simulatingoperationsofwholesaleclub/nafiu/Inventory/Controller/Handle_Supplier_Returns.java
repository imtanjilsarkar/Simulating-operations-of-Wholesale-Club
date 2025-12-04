package com.group16.simulatingoperationsofwholesaleclub.nafiu.Inventory.Controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Handle_Supplier_Returns {
    @javafx.fxml.FXML
    private TextArea confirmationArea;
    @javafx.fxml.FXML
    private TextField productIdField;
    @javafx.fxml.FXML
    private TextField quantityField;

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Inventory/inventory_dashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void verifyReturn(ActionEvent actionEvent) {
        confirmationArea.setText("Return Eligible");
    }

    @javafx.fxml.FXML
    public void processReturn(ActionEvent actionEvent) {
        String productId = productIdField.getText();
        String quantity = quantityField.getText();
        confirmationArea.setText("Product " + productId + " with quantity " + quantity + " returned successfully");
    }
}
