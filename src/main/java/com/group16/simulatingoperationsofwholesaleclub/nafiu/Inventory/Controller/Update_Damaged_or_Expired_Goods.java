package com.group16.simulatingoperationsofwholesaleclub.nafiu.Inventory.Controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Update_Damaged_or_Expired_Goods {
    @javafx.fxml.FXML
    private TextArea statusArea;
    @javafx.fxml.FXML
    private TextField productIdField;
    @javafx.fxml.FXML
    private TextField quantityField;

    // Newly added fields
    @javafx.fxml.FXML
    private TextField productNameField;
    @javafx.fxml.FXML
    private TextField reasonField;

    private int fishStock = 50;

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Inventory/inventory_dashboard.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void deductStock(ActionEvent actionEvent) {
        String qtyText = quantityField.getText();

        if (qtyText == null || qtyText.isEmpty()) {
            statusArea.setText("Enter Quantity!");
            return;
        }

        int qty;
        try {
            qty = Integer.parseInt(qtyText);
        } catch (NumberFormatException e) {
            statusArea.setText("Enter a valid number!");
            return;
        }

        if (qty > fishStock) {
            statusArea.setText("Cannot deduct more than available stock! Current: " + fishStock);
            return;
        }

        fishStock -= qty;
        statusArea.setText("Stock Deducted: " + qty + "\nUpdated Stock: " + fishStock);

        // NEW DATA
        String productId = productIdField.getText().trim();
        if (productId.isEmpty()) productId = "Unknown Product";

        String productName = productNameField.getText().trim();
        if (productName.isEmpty()) productName = "Unknown Name";

        String reason = reasonField.getText().trim();
        if (reason.isEmpty()) reason = "No Reason Provided";

        // Line to save
        String line = "Product ID: " + productId +
                ", Name: " + productName +
                ", Deducted: " + qty +
                ", Updated Stock: " + fishStock +
                ", Reason: " + reason;

        // File Write
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("damaged_goods.txt", true))) {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            statusArea.setText("Error saving data!");
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void verifyStock(ActionEvent actionEvent) {
        statusArea.setText("Stock Verified");
    }
}
