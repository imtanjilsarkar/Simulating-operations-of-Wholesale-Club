package com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.modelClass.SupplierRecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManageSupplierRecordsController {

    // IMPORTANT CHANGE: Using a relative binary file path
    private static final String SUPPLIER_FILE = "supplier_records.dat";

    @FXML
    private TextField supplierIdField, nameField, contactField, addressField;

    @FXML
    private Label messageLabel;

    @FXML
    public void handleSaveButton(ActionEvent actionEvent) {
        String supplierId = supplierIdField.getText().trim();
        String name = nameField.getText().trim();
        String contact = contactField.getText().trim();
        String address = addressField.getText().trim();

        // Simple validation (retained from your original code)
        if (supplierId.isEmpty() || name.isEmpty() || contact.isEmpty() || address.isEmpty()) {
            messageLabel.setText("All fields are required!");
            messageLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        if (!name.matches("[a-zA-Z\\s]+")) {
            messageLabel.setText("Name must contain only letters!");
            messageLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        if (!contact.matches("\\d+")) {
            messageLabel.setText("Contact must contain only numbers!");
            messageLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        // --- NEW BINARY FILE LOGIC STARTS HERE ---

        // 1. Load existing records from the binary file
        List<SupplierRecord> records = loadSupplierRecords();
        SupplierRecord newOrUpdatedRecord = new SupplierRecord(supplierId, name, contact, address);

        // 2. Check for existence (Update or Add)
        boolean updated = false;
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getSupplierId().equals(supplierId)) {
                // Update existing record
                records.set(i, newOrUpdatedRecord);
                updated = true;
                break;
            }
        }

        if (!updated) {
            // Add new record
            records.add(newOrUpdatedRecord);
        }

        // 3. Save the entire updated list back to the binary file
        if (saveSupplierRecords(records)) {
            messageLabel.setText(updated ? "Supplier record updated successfully!" : "New supplier record saved successfully!");
            messageLabel.setStyle("-fx-text-fill: green;");

            // Clear fields upon successful save
            supplierIdField.clear();
            nameField.clear();
            contactField.clear();
            addressField.clear();
        } else {
            messageLabel.setText("Error saving record to binary file!");
            messageLabel.setStyle("-fx-text-fill: red;");
        }
        // --- NEW BINARY FILE LOGIC ENDS HERE ---
    }

    /**
     * Helper method to load all SupplierRecord objects from the binary file using ObjectInputStream.
     * Modeled after your demo binary handling code.
     */
    private List<SupplierRecord> loadSupplierRecords() {
        File file = new File(SUPPLIER_FILE);
        // Check 1: If file doesn't exist or is empty, return empty list
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            // Read the single object (the List) from the binary stream
            return (List<SupplierRecord>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Display an alert if file loading fails (e.g., file corrupted)
            new Alert(Alert.AlertType.ERROR, "Failed to load supplier records. File may be corrupted.").show();
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Helper method to save the complete list of SupplierRecord objects to the binary file
     * using ObjectOutputStream.
     */
    private boolean saveSupplierRecords(List<SupplierRecord> records) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SUPPLIER_FILE))) {
            // Write the single object (the List) to the binary stream
            oos.writeObject(records);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/ProcurementOfficer/procurementOff_dashboard.fxml", actionEvent);
    }
}