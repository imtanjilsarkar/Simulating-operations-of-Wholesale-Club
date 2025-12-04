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

public class PendingComplaintReminderController extends BaseController
{
    @javafx.fxml.FXML
    private TableColumn <SupportReport, String> colCustomerName;
    @javafx.fxml.FXML
    private TableColumn <SupportReport, String>  colComplaintTitle;
    @javafx.fxml.FXML
    private TableView <SupportReport> tblPendingComplaints;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private TableColumn <SupportReport, String> colStatus;

    ObservableList<SupportReport> data = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colComplaintTitle.setCellValueFactory(new PropertyValueFactory<>("complaintTitle"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @javafx.fxml.FXML
    public void handleLoadPending(ActionEvent actionEvent) {
        data.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader("complaints.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Format: Customer | Title | Description | Status
                String[] parts = line.split("\\|");
                if (parts.length != 4) continue;

                String customer = parts[0].trim();
                String title = parts[1].trim();
                String status = parts[3].trim();

                if (!status.equalsIgnoreCase("Closed")) {
                    data.add(new SupportReport(customer, title, status));
                }
            }

            tblPendingComplaints.getItems().clear();
            tblPendingComplaints.getItems().addAll(data);

            messageLabel.setText("Loaded pending complaints.");
        } catch (IOException e) {
            messageLabel.setText("Failed to load complaints.");
            e.printStackTrace();
        }
    }

}