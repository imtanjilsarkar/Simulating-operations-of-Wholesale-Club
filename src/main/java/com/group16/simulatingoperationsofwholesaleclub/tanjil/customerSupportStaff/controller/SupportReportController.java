package com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.controller;

import com.group16.simulatingoperationsofwholesaleclub.BaseController;
import com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.modelClass.SupportReport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SupportReportController extends BaseController {

    @javafx.fxml.FXML
    private TableColumn<SupportReport, String> colCustomerName;
    @javafx.fxml.FXML
    private TableView<SupportReport> tblReports;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private TableColumn<SupportReport, String> colStatus;

    ObservableList<SupportReport> data = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        tblReports.setItems(data);
    }

    @javafx.fxml.FXML
    public void handleLoadComplaints(ActionEvent actionEvent) {
        data.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader("complaints.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length < 4) continue; // skip invalid lines

                String customerName = parts[0].trim();
                String status = parts[3].trim();

                data.add(new SupportReport(customerName, "", status));
            }

            if (data.isEmpty()) {
                messageLabel.setText("No complaints found.");
            } else {
                messageLabel.setText("Complaints loaded successfully.");
            }

        } catch (IOException e) {
            messageLabel.setText("Failed to load complaints.");
            e.printStackTrace();
        }
    }
}



