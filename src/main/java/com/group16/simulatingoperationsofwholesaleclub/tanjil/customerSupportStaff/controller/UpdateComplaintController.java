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
import java.util.List;

public class UpdateComplaintController  extends BaseController {

    @javafx.fxml.FXML
    private TableView<Complaint> complaintsTable;
    @javafx.fxml.FXML
    private TextField  customerNameField;
    @javafx.fxml.FXML
    private TableColumn <Complaint, String> colDescription;
    @javafx.fxml.FXML
    private TableColumn <Complaint, String> colTitle;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private TableColumn <Complaint, String> colStatus;

    ObservableList<Complaint> complaintList = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {
        colTitle.setCellValueFactory(new PropertyValueFactory<>("complaintTitle"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @javafx.fxml.FXML
    public void handleSearchComplaint(ActionEvent actionEvent) {
        complaintList.clear();
        String customerName = customerNameField.getText().trim();

        if (customerName.isEmpty()) {
            messageLabel.setText("Please enter a customer name.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("complaints.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                if (parts.length == 4 && parts[0].equalsIgnoreCase(customerName)) {
                    Complaint c = new Complaint(parts[0], parts[1], parts[2], parts[3]);
                    complaintList.add(c);
                }
            }
            complaintsTable.setItems(complaintList);

            if (complaintList.isEmpty()) {
                messageLabel.setText("No complaints found for this customer.");
            } else {
                messageLabel.setText("Complaints loaded successfully.");
            }

        } catch (IOException e) {
            messageLabel.setText("Error reading complaints file.");
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void handleMarkAsSolved(ActionEvent actionEvent) {
        Complaint selected = complaintsTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            messageLabel.setText("Please select a complaint.");
            return;
        }

        List<String> updatedLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("complaints.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(selected.getCustomerName() + " | " + selected.getComplaintTitle())) {
                    line = selected.getCustomerName() + " | " + selected.getComplaintTitle() + " | " + selected.getDescription() + " | Solved";
                }
                updatedLines.add(line);
            }
        } catch (IOException e) {
            messageLabel.setText("Error updating complaints.");
            e.printStackTrace();
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("complaints.txt"))) {
            for (String l : updatedLines) {
                writer.write(l);
                writer.newLine();
            }
        } catch (IOException e) {
            messageLabel.setText("Error saving updates.");
            e.printStackTrace();
            return;
        }

        handleSearchComplaint(new ActionEvent());
        messageLabel.setText("Complaint marked as Solved.");
    }


}


