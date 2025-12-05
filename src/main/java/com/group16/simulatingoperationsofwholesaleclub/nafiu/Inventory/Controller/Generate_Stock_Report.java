package com.group16.simulatingoperationsofwholesaleclub.nafiu.Inventory.Controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Generate_Stock_Report {
    @javafx.fxml.FXML
    private TextArea summaryArea;
    @javafx.fxml.FXML
    private TextField currentinventory;

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Inventory/inventory_dashboard.fxml",actionEvent);
    }
    @javafx.fxml.FXML
    public void generateReport(ActionEvent actionEvent) {
        String inventoryData = currentinventory.getText();
        String[] items = inventoryData.split(",");
        StringBuilder report = new StringBuilder("Stock Report:\n");

        for (String item : items) {
            String[] parts = item.split(":");
            if (parts.length == 2) {
                String name = parts[0].trim();
                int qty = Integer.parseInt(parts[1].trim());
                report.append(name).append(": ").append(qty);
                if (qty < 10) {
                    report.append(" (Low Stock)");
                } else if (qty > 100) {
                    report.append(" (Overstock)");
                }
                report.append("\n");
            }
        }
        summaryArea.setText(report.toString());
    }
}
