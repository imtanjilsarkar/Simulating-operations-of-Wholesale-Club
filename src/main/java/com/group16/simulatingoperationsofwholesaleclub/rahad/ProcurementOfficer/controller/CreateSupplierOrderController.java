package com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.modelClass.SupplierOrder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileWriter;
import java.io.IOException;

public class CreateSupplierOrderController {

    @FXML private TextField supplierIdField;
    @FXML private TextField productField;
    @FXML private TextField quantityField;
    @FXML private DatePicker dueDatePicker;
    @FXML private Label messageLabel;

    private static final String FILE_PATH =
            "C:\\Users\\rubay\\IdeaProjects\\Simulating-operations-of-Wholesale-Club\\supplier_orders.txt";

    @FXML
    public void handleSaveOrderButton(ActionEvent event) {
        try {
            String supplierId = supplierIdField.getText().strip();
            String product = productField.getText().strip();
            String qtyText = quantityField.getText().strip();
            String dueDate = (dueDatePicker.getValue() != null) ? dueDatePicker.getValue().toString() : "";

            if (supplierId.isBlank() || product.isBlank() || qtyText.isBlank() || dueDate.isBlank()) {
                messageLabel.setText("Please fill all fields!");
                messageLabel.setStyle("-fx-text-fill: red;");
                return;
            }

            int quantity = Integer.parseInt(qtyText);

            SupplierOrder order = new SupplierOrder(supplierId, product, quantity, dueDate);

            FileWriter writer = new FileWriter(FILE_PATH, true); // append mode
            writer.write(order.toString() + "\n");
            writer.close();

            messageLabel.setText("Order saved successfully!");
            messageLabel.setStyle("-fx-text-fill: green;");

            supplierIdField.clear();
            productField.clear();
            quantityField.clear();
            dueDatePicker.setValue(null);

        } catch (NumberFormatException e) {
            messageLabel.setText("Quantity must be a number!");
            messageLabel.setStyle("-fx-text-fill: red;");
        } catch (IOException e) {
            messageLabel.setText("Error saving order!");
            messageLabel.setStyle("-fx-text-fill: red;");
            e.printStackTrace();
        }
    }

    @FXML
    public void handleBack(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo(
                "/com/group16/simulatingoperationsofwholesaleclub/rahad/ProcurementOfficer/procurementOff_dashboard.fxml",
                event
        );
    }
}
