package com.group16.simulatingoperationsofwholesaleclub.nafiu.Inventory.Controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Receive_Supplier_Delivery {
    @javafx.fxml.FXML
    private TextArea productListArea;
    @javafx.fxml.FXML
    private TextField invoiceField;
    @javafx.fxml.FXML
    private TextArea inventoryDisplayArea;

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Inventory/inventory_dashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void verifyPurchaseOrder(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updateStock(ActionEvent actionEvent) {
    }
}
