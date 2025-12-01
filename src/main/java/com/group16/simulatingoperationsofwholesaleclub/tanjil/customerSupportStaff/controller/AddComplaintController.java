package com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.controller;

import com.group16.simulatingoperationsofwholesaleclub.BaseController;
import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.modelClass.Complaint;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AddComplaintController extends BaseController {
    @javafx.fxml.FXML
    private TextArea descriptionArea;
    @javafx.fxml.FXML
    private TextField customerNameField;
    @javafx.fxml.FXML
    private TextField complaintTitleField;
    @javafx.fxml.FXML
    private Label messageLabel;

    @javafx.fxml.FXML
    public void handleCancel(ActionEvent actionEvent) {
        customerNameField.clear();
        complaintTitleField.clear();
        descriptionArea.clear();

        if (messageLabel != null) {
            messageLabel.setText("");
        }
    }

    @javafx.fxml.FXML
    public void handleSubmitComplaint(ActionEvent actionEvent) {
        String customerName = customerNameField.getText();
        String complaintTitle = complaintTitleField.getText();
        String description = descriptionArea.getText();

        if(customerName.isEmpty() || complaintTitle.isEmpty() || description.isEmpty()) {
            messageLabel.setText("Please fill all fields");
            return;
        }


        Complaint complaint = new Complaint(customerName, complaintTitle, description);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("complaints.txt", true))) {
            writer.write(complaint.toString());
            writer.newLine();
            messageLabel.setText("Complaint added successfully!");
        } catch (IOException e) {
            messageLabel.setText("Error saving complaint");
            e.printStackTrace();
        }

        customerNameField.clear();
        complaintTitleField.clear();
        descriptionArea.clear();
    }


}
