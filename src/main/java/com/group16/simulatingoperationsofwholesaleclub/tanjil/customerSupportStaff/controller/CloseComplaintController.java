package com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.controller;

import com.group16.simulatingoperationsofwholesaleclub.BaseController;
import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
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
    public void handleSearchComplaint(ActionEvent actionEvent) {
//        try (BufferedReader reader = new BufferedReader(new FileReader("complaint.txt"))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                if (line.contains(customerNameField.getText()) && line.contains(complaintTitleField.getText())) {
//                    messageLabel.setText("Complaint found!");
//                    return;
//                }
//            }
//            messageLabel.setText("Complaint not found!");
//        } catch (IOException e) {
//            messageLabel.setText("Something went wrong!");
//        }

        try (BufferedReader reader = new BufferedReader(new FileReader("complaint.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("customerName='" + customerNameField.getText() + "'") &&
                        line.contains("complaintTitle='" + complaintTitleField.getText() + "'")) {
                    messageLabel.setText("Complaint found!");
                    return;
                }
            }
            messageLabel.setText("Complaint not found!");
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
    }

}
