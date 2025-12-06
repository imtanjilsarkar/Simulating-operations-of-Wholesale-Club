package com.group16.simulatingoperationsofwholesaleclub.nafiu.Inventory.Controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
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
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Inventory/inventory_dashboard.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void verifyPurchaseOrder(ActionEvent actionEvent) {
        String invoice = invoiceField.getText();
        if (invoice == null || invoice.isEmpty()) {
            inventoryDisplayArea.setText("Enter a valid invoice number!");
            return;
        }
        inventoryDisplayArea.setText("Product Verified for Invoice: " + invoice);
    }
    @javafx.fxml.FXML
    public void updateStock(ActionEvent actionEvent) {
        String productList = productListArea.getText();

        if (productList == null || productList.isEmpty()) {
            inventoryDisplayArea.setText("Enter product list to update stock!");
            return;
        }
        StringBuilder inventoryText = new StringBuilder();
        String[] products = productList.split("\n");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Receive_Supplier_Delivery.txt", true))) {
            for (String p : products) {
                String line = p + " → Stock Updated";
                inventoryText.append(line).append("\n");
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            inventoryDisplayArea.setText("Error saving updated stock!");
            e.printStackTrace();
            return;
        }
        inventoryDisplayArea.setText(inventoryText.toString());
    }
}