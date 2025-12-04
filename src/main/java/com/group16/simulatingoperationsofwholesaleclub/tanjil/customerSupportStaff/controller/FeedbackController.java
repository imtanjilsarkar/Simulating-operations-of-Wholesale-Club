package com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.controller;

import com.group16.simulatingoperationsofwholesaleclub.BaseController;
import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FeedbackController extends BaseController {
    @javafx.fxml.FXML
    private TextArea txtFeedback;
    @javafx.fxml.FXML
    private TextArea txtCustomerName;
    @javafx.fxml.FXML
    private Label outputMessage;

    @javafx.fxml.FXML
    public void handleSubmit(ActionEvent actionEvent) {

        String customerName = txtCustomerName.getText().trim();
        String feedback = txtFeedback.getText().trim();

        if (customerName.isEmpty() || feedback.isEmpty()) {
            outputMessage.setText("Please enter customer name and feedback.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("feedback.txt", true))) {
            writer.write(customerName + " | " + feedback);
            writer.newLine();

            outputMessage.setText("Feedback submitted successfully!");

            txtCustomerName.clear();
            txtFeedback.clear();

        } catch (IOException e) {
            e.printStackTrace();
            outputMessage.setText("Something went wrong!");
        }
    }
}


