package com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.modelClass.SupplierRecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ViewSupplierContactController {


    private static final String SUPPLIER_FILE = "supplier_records.dat";

    @FXML
    private TextField supplierIdField;

    @FXML
    private TextArea supplierInfoArea;

    @FXML
    private Label messageLabel;

    @FXML
    public void handleSearchButton(ActionEvent actionEvent) {
        // Clear previous results
        supplierInfoArea.clear();
        messageLabel.setText("");

        String searchId = supplierIdField.getText().trim();

        if (searchId.isEmpty()) {
            messageLabel.setText("Please enter a Supplier ID to search.");
            return;
        }


        List<SupplierRecord> records = loadSupplierRecords();
        SupplierRecord foundRecord = null;


        for (SupplierRecord record : records) {
            if (record.getSupplierId().equals(searchId)) {
                foundRecord = record;
                break;
            }
        }


        if (foundRecord != null) {
            String info = String.format(
                    "Supplier ID: %s\nName: %s\nContact: %s\nAddress: %s",
                    foundRecord.getSupplierId(),
                    foundRecord.getName(),
                    foundRecord.getContact(),
                    foundRecord.getAddress()
            );
            supplierInfoArea.setText(info);
            messageLabel.setText("Supplier found.");
            messageLabel.setStyle("-fx-text-fill: green;");
        } else {
            supplierInfoArea.setText("");
            messageLabel.setText("Error: Supplier with ID " + searchId + " not found.");
            messageLabel.setStyle("-fx-text-fill: red;");
        }
    }


    private List<SupplierRecord> loadSupplierRecords() {
        File file = new File(SUPPLIER_FILE);

        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

            return (List<SupplierRecord>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {

            new Alert(Alert.AlertType.ERROR, "Failed to load supplier records. File may be corrupted or missing model class.").show();
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    @FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/ProcurementOfficer/procurementOff_dashboard.fxml", actionEvent);
    }
}