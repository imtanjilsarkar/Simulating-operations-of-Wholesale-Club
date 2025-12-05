package com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.modelClass.DamagedProduct;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResolveIssuesWithSupplierController {

    @FXML
    private TableView<DamagedProduct> damagedTable;
    @FXML
    private TableColumn<DamagedProduct, String> colProductID;
    @FXML
    private TableColumn<DamagedProduct, String> colProductName;
    @FXML
    private TableColumn<DamagedProduct, Integer> deductedQTYcol;
    @FXML
    private TableColumn<DamagedProduct, String> colReason;
    @FXML
    private TextArea remarksArea;
    @FXML
    private Label confirmationLabel;

    private final String FILE_PATH = "damaged_goods.txt";

    @FXML
    public void initialize() {
        // Map TableView columns to model properties
        colProductID.setCellValueFactory(new PropertyValueFactory<>("productId"));
        colProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        deductedQTYcol.setCellValueFactory(new PropertyValueFactory<>("deductedQty"));
        colReason.setCellValueFactory(new PropertyValueFactory<>("reason"));
    }

    @FXML
    public void loadDamagedProducts(ActionEvent event) {
        damagedTable.getItems().clear(); // clear previous items
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            confirmationLabel.setStyle("-fx-text-fill: red;");
            confirmationLabel.setText("Damaged goods file not found.");
            return;
        }

        List<DamagedProduct> damagedList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Expected format:
                // Product ID: P001, Name: Fish, Deducted: 5, Updated Stock: 45, Reason: Rotten
                String[] parts = line.split(",");
                if (parts.length < 5) continue; // skip invalid lines

                String productId = parts[0].split(":")[1].trim();
                String productName = parts[1].split(":")[1].trim();
                int deductedQty = Integer.parseInt(parts[2].split(":")[1].trim());
                String reason = parts[4].split(":")[1].trim(); // ignore Updated Stock at parts[3]

                damagedList.add(new DamagedProduct(productId, productName, deductedQty, reason));
            }

            // Use ObservableList to display in TableView
            ObservableList<DamagedProduct> tableItems = FXCollections.observableArrayList(damagedList);
            damagedTable.setItems(tableItems);

            confirmationLabel.setStyle("-fx-text-fill: green;");
            confirmationLabel.setText("Damaged products loaded successfully.");

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            confirmationLabel.setStyle("-fx-text-fill: red;");
            confirmationLabel.setText("Error loading damaged products.");
        }
    }

    @FXML
    public void sendReplacementRequest(ActionEvent event) {
        String remarks = remarksArea.getText().trim();
        // For simplicity, just show confirmation
        confirmationLabel.setStyle("-fx-text-fill: green;");
        confirmationLabel.setText("Replacement request sent." + (remarks.isEmpty() ? "" : " Remarks: " + remarks));
    }

    @FXML
    public void handleBack(ActionEvent event) {
        try {
            SceneSwitcher.switchTo(
                    "/com/group16/simulatingoperationsofwholesaleclub/rahad/ProcurementOfficer/procurementOff_dashboard.fxml",
                    event
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
