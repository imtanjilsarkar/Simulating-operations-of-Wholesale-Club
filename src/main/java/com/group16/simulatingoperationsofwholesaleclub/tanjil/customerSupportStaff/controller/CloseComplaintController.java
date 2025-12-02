package com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.controller;

import com.group16.simulatingoperationsofwholesaleclub.BaseController;
import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;

public class CloseComplaintController extends BaseController {
    @javafx.fxml.FXML
    private TextField customerNameField;
    @javafx.fxml.FXML
    private TextField complaintTitleField;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private TextArea complaintListArea;

    @javafx.fxml.FXML
    public void handleSearchComplaint(ActionEvent actionEvent) {
        try (BufferedReader reader = new BufferedReader(new FileReader("complaints.txt"))) {
        String line;
        String foundComplaints = "";
        while ((line = reader.readLine()) != null) {
            if (line.contains(customerNameField.getText())) {
                int start = line.indexOf("complaintTitle='") + 16;
                int end = line.indexOf("'", start);
                String title = line.substring(start, end);
                foundComplaints += title + "\n";
            }
        }
        if (!foundComplaints.isEmpty()) {
            complaintListArea.setText(foundComplaints);
            messageLabel.setText("Complaints found for customer!");
        } else {
            complaintListArea.setText("");
            messageLabel.setText("No complaints found for this customer.");
        }
    } catch (IOException e) {
        messageLabel.setText("Something went wrong!");
    }

    }

    @javafx.fxml.FXML
    public void handleCancel(ActionEvent actionEvent) {
        customerNameField.clear();
        complaintTitleField.clear();
        messageLabel.setText("");
    }

    @javafx.fxml.FXML
    public void handleCloseComplaint(ActionEvent actionEvent) {
        String customerName = customerNameField.getText();
        String complaintTitle = complaintTitleField.getText();

        try {
            File inputFile = new File("complaints.txt");
            File tempFile = new File("temp_complaint.txt");

            boolean removed = false;
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains(customerName) && line.contains(complaintTitle)) {
                        removed = true; // skip this line
                        continue;
                    }
                    writer.write(line);
                    writer.newLine();
                }
            }

            if (removed) {
                if (inputFile.delete()) {
                    tempFile.renameTo(inputFile);
                    messageLabel.setText("Complaint closed successfully!");
                    complaintListArea.clear();
                    complaintTitleField.clear();
                    customerNameField.clear();
                } else {
                    messageLabel.setText("Could not close complaint!");
                }
            } else {
                messageLabel.setText("Complaint not found!");
                tempFile.delete();
            }

        } catch (IOException e) {
            messageLabel.setText("Something went wrong!");
        }
    }

}
