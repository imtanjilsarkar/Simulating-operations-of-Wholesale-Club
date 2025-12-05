package com.group16.simulatingoperationsofwholesaleclub.nafiu.Inventory.Controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Organize_Warehouse {
    @javafx.fxml.FXML
    private TextArea statusArea;
    @javafx.fxml.FXML
    private TextField productIdField;
    @javafx.fxml.FXML
    private TextField shelfField;

    @javafx.fxml.FXML
    public void validateLocation(ActionEvent actionEvent) {
        statusArea.setText("Location Available");
    }

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Inventory/inventory_dashboard.fxml",actionEvent);
    }
    @javafx.fxml.FXML
    public void updatePlacement(ActionEvent actionEvent) {
        String productId = productIdField.getText();
        String shelf = shelfField.getText();
        statusArea.setText("Product " + productId + " placed in " + shelf);
    }
}
