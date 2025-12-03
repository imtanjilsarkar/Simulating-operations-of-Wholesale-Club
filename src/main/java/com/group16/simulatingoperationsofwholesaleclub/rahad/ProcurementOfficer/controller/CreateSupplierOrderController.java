package com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.modelClass.SupplierOrder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.util.ArrayList;

public class CreateSupplierOrderController {

    @FXML private TextField supplierIdField;
    @FXML private TextField productField;
    @FXML private TextField quantityField;
    @FXML private DatePicker dueDatePicker;
    @FXML private Label messageLabel;

    // Changed extension to .bin for binary file
    private static final String FILE_PATH =
            "C:\\Users\\rubay\\IdeaProjects\\Simulating-operations-of-Wholesale-Club\\supplier_orders.bin";

    @FXML
    public void handleSaveOrderButton(ActionEvent event) {
        try {
            String supplierId = supplierIdField.getText().strip();
            String product = productField.getText().strip();
            String qtyText = quantityField.getText().strip();
            String dueDate = (dueDatePicker.getValue() != null) ? dueDatePicker.getValue().toString() : "";

            // Validation
            if (supplierId.isBlank() || product.isBlank() || qtyText.isBlank() || dueDate.isBlank()) {
                messageLabel.setText("Please fill all fields!");
                messageLabel.setStyle("-fx-text-fill: red;");
                return;
            }

            int quantity = Integer.parseInt(qtyText);

            // 1. Create the new Object
            SupplierOrder newOrder = new SupplierOrder(supplierId, product, quantity, dueDate);

            // 2. Load existing orders (to simulate append)
            ArrayList<SupplierOrder> orderList = new ArrayList<>();
            File file = new File(FILE_PATH);

            if (file.exists()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                    // Suppress warning is safe here as we know what we wrote
                    orderList = (ArrayList<SupplierOrder>) ois.readObject();
                } catch (EOFException | ClassNotFoundException e) {
                    // File might be empty or corrupt, start with new list
                    orderList = new ArrayList<>();
                }
            }

            // 3. Add the new order to the list
            orderList.add(newOrder);

            // 4. Write the entire list back to the binary file
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(orderList);
            }

            // UI Feedback
            messageLabel.setText("Order saved successfully (Binary)!");
            messageLabel.setStyle("-fx-text-fill: green;");

            // Clear fields
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