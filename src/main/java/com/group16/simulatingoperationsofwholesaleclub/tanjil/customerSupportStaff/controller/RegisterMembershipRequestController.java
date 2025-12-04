package com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.controller;

import com.group16.simulatingoperationsofwholesaleclub.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterMembershipRequestController extends BaseController
{
    @javafx.fxml.FXML
    private TextField txtContactInfo;
    @javafx.fxml.FXML
    private TextArea txtNotes;
    @javafx.fxml.FXML
    private TextField txtCustomerName;
    @javafx.fxml.FXML
    private Label messageLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleCancel(ActionEvent actionEvent) {
            txtCustomerName.clear();
            txtContactInfo.clear();
            txtNotes.clear();
            messageLabel.setText("");
        }


    @javafx.fxml.FXML
    public void handleSubmitRequest(ActionEvent actionEvent) {
            String name = txtCustomerName.getText().trim();
            String contact = txtContactInfo.getText().trim();
            String notes = txtNotes.getText().trim();

            if (name.isEmpty() || contact.isEmpty()) {
                messageLabel.setText("Please enter customer name and contact info.");
                return;
            }

            String record = name + " | " + contact + " | " + notes + " | Pending";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("membership_requests.txt", true))) {
                writer.write(record);
                writer.newLine();
                messageLabel.setText("Request submitted successfully!");

                // Clear fields
                txtCustomerName.clear();
                txtContactInfo.clear();
                txtNotes.clear();
            } catch (IOException e) {
                messageLabel.setText("Failed to submit request.");
                e.printStackTrace();
            }
    }
}