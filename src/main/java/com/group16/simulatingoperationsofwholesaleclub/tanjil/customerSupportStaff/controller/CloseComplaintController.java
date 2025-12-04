package com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.controller;

import com.group16.simulatingoperationsofwholesaleclub.BaseController;
import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.modelClass.Complaint;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;

public class CloseComplaintController extends BaseController {


    @javafx.fxml.FXML
    private TableColumn<Complaint, String> colCustomerName;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private TableColumn<Complaint, String> colStatus;
    @javafx.fxml.FXML
    private TableView <Complaint> tblReports;


    ObservableList<Complaint> pendingComplaints = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        tblReports.setItems(pendingComplaints);
    }


    @javafx.fxml.FXML
    public void handleLoadComplaints(ActionEvent actionEvent) {
        pendingComplaints.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader("complaints.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    String customerName = parts[0].trim();
                    String status = parts[3].trim();

                    // Only load complaints that are not closed
                    if (!status.equalsIgnoreCase("Closed")) {
                        pendingComplaints.add(new Complaint(customerName, "", "", status));
                    }
                }
            }

            messageLabel.setText(pendingComplaints.isEmpty() ? "No pending complaints." : "Pending complaints loaded.");

        } catch (IOException e) {
            messageLabel.setText("Failed to load complaints.");
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void handleCloseComplaint(ActionEvent actionEvent) {
        Complaint selected = tblReports.getSelectionModel().getSelectedItem();
        if (selected == null) {
            messageLabel.setText("Please select a complaint to close.");
            return;
        }

        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("complaints.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.contains(selected.getCustomerName())) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            messageLabel.setText("Error reading complaints file.");
            e.printStackTrace();
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("complaints.txt"))) {
            for (String l : lines) {
                writer.write(l);
                writer.newLine();
            }
            messageLabel.setText("Complaint closed successfully!");
        } catch (IOException e) {
            messageLabel.setText("Error updating complaints file.");
            e.printStackTrace();
        }

        handleLoadComplaints(null); // refresh table
    }
}