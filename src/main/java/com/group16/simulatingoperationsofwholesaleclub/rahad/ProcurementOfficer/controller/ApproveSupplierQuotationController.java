package com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.modelClass.ApproveQuotation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ApproveSupplierQuotationController {

    private static final String QUOTATION_FILE = "quotation_decisions.dat";

    // ========== FXML Fields (Matching FXML Exactly) ==========
    @FXML private TextField supplierfield;
    @FXML private TextField productnamefield;
    @FXML private TextField pricefield;
    @FXML private TextArea qualitynotesTA;

    // Label for messages
    @FXML private Label messageLabel;

    // =========================================================

    @FXML
    public void handleApproveButton(ActionEvent actionEvent) {
        saveQuotationDecision("Approved");
    }

    @FXML
    public void handleRejectButton(ActionEvent actionEvent) {
        saveQuotationDecision("Rejected");
    }

    /**
     * Core saving logic for approved/rejected decisions.
     */
    private void saveQuotationDecision(String status) {

        String supplier = supplierfield.getText().trim();
        String product = productnamefield.getText().trim();
        String priceText = pricefield.getText().trim();
        String qualityNotes = qualitynotesTA.getText().trim();

        // --------- VALIDATION ---------
        if (supplier.isEmpty() || product.isEmpty() || priceText.isEmpty() || qualityNotes.isEmpty()) {
            setMessage("All fields must be filled out.", "red");
            return;
        }

        double price;
        try {
            price = Double.parseDouble(priceText);
            if (price <= 0) {
                setMessage("Price must be a positive number.", "red");
                return;
            }
        } catch (NumberFormatException e) {
            setMessage("Price must be a valid number.", "red");
            return;
        }

        // --------- CREATE RECORD ---------
        ApproveQuotation record = new ApproveQuotation(
                supplier,
                product,
                price,
                qualityNotes,
                status
        );

        // --------- LOAD EXISTING DATA ---------
        List<ApproveQuotation> records = loadQuotationRecords();
        records.add(record);

        // --------- SAVE UPDATED DATA ---------
        if (saveQuotationRecords(records)) {
            setMessage("Quotation successfully " + status + "!", "green");
            clearFields();
        } else {
            setMessage("Error saving data to file.", "red");
        }
    }

    // Show message on the screen
    private void setMessage(String msg, String color) {
        messageLabel.setText(msg);
        messageLabel.setStyle("-fx-text-fill: " + color + "; -fx-font-size: 14px;");
    }

    // Clear input boxes
    private void clearFields() {
        supplierfield.clear();
        productnamefield.clear();
        pricefield.clear();
        qualitynotesTA.clear();
    }

    // Load binary file data
    private List<ApproveQuotation> loadQuotationRecords() {
        File file = new File(QUOTATION_FILE);
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<ApproveQuotation>) ois.readObject();
        } catch (Exception e) {
            setMessage("Could not read saved quotation records.", "red");
            return new ArrayList<>();
        }
    }

    // Save binary file data
    private boolean saveQuotationRecords(List<ApproveQuotation> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(QUOTATION_FILE))) {
            oos.writeObject(list);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo(
                "/com/group16/simulatingoperationsofwholesaleclub/rahad/ProcurementOfficer/procurementOff_dashboard.fxml",
                actionEvent
        );
    }
}
