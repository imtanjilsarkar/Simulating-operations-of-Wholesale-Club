package com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Model class for Re-Delivery Request
class ReDeliveryRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String orderId;
    private String reason;

    public ReDeliveryRequest(String orderId, String reason) {
        this.orderId = orderId;
        this.reason = reason;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getReason() {
        return reason;
    }
}

public class ReDeliveryRequestController {

    private static final String FILE_PATH = "C:\\Users\\rubay\\IdeaProjects\\Simulating-operations-of-Wholesale-Club\\re_delivery_requests.dat";

    @FXML
    private TextField orderIdField;

    @FXML
    private TextArea reasonField;

    @FXML
    private Label statusLabel;

    @FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo(
                "/com/group16/simulatingoperationsofwholesaleclub/rahad/DeliveryCoordinator/delivery_Dashboard.fxml",
                actionEvent
        );
    }

    @FXML
    public void handleSaveRequest(ActionEvent actionEvent) {
        String orderId = orderIdField.getText().trim();
        String reason = reasonField.getText().trim();

        statusLabel.setText("");

        if (orderId.isEmpty() || reason.isEmpty()) {
            statusLabel.setText("⚠ Please enter both Order ID and reason.");
            return;
        }

        // Read existing requests
        List<ReDeliveryRequest> requests = readRequests();

        // Add new request
        requests.add(new ReDeliveryRequest(orderId, reason));

        // Save back to file
        saveRequests(requests);

        // Show confirmation and clear fields
        statusLabel.setText("✅ Re-delivery request submitted successfully!");
        orderIdField.clear();
        reasonField.clear();
    }

    // ---------------- HELPER METHODS ----------------

    private List<ReDeliveryRequest> readRequests() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<ReDeliveryRequest>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private void saveRequests(List<ReDeliveryRequest> requests) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(requests);
        } catch (IOException e) {
            e.printStackTrace();
            statusLabel.setText("❌ Error saving re-delivery request.");
        }
    }
}
