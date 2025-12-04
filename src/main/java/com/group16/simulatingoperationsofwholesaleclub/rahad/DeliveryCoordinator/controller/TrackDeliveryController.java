package com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.modelClass.AssignedDelivery;
import com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.modelClass.ConfirmOrders;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TrackDeliveryController {

    private static final String ASSIGNED_FILE = "C:\\Users\\rubay\\IdeaProjects\\Simulating-operations-of-Wholesale-Club\\assigned_deliveries.dat";
    private static final String CONFIRMED_FILE = "C:\\Users\\rubay\\IdeaProjects\\Simulating-operations-of-Wholesale-Club\\confirmed_orders.dat";

    @FXML
    private TextField orderIdField;

    @FXML
    private Label statusLabel;

    @FXML
    private Label staffLabel;

    @FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo(
                "/com/group16/simulatingoperationsofwholesaleclub/rahad/DeliveryCoordinator/delivery_Dashboard.fxml",
                actionEvent
        );
    }

    @FXML
    public void handleTrackDelivery(ActionEvent actionEvent) {
        String orderId = orderIdField.getText().trim();
        statusLabel.setText("");
        staffLabel.setText("");

        if (orderId.isEmpty()) {
            statusLabel.setText("⚠ Please enter an Order ID.");
            return;
        }

        // Load confirmed orders
        List<ConfirmOrders> confirmedList = readConfirmedOrders();
        for (ConfirmOrders co : confirmedList) {
            if (co.getOrderId().equals(orderId)) {
                statusLabel.setText("Order ID " + orderId + " has already been delivered.");
                // Check which staff it was assigned to before delivery
                AssignedDelivery ad = findAssignedDelivery(orderId);
                if (ad != null) {
                    staffLabel.setText("Delivered by Staff ID: " + ad.getStaffId());
                }
                return;
            }
        }

        // Check assigned deliveries
        AssignedDelivery ad = findAssignedDelivery(orderId);
        if (ad != null) {
            statusLabel.setText("Order ID " + orderId + " is currently in process .");
            staffLabel.setText("Assigned Staff ID: " + ad.getStaffId());
            return;
        }

        // If not found in both
        statusLabel.setText("Order ID " + orderId + " was never assigned for delivery.");
    }

    // Helper to find assigned delivery by order ID
    private AssignedDelivery findAssignedDelivery(String orderId) {
        List<AssignedDelivery> assignedList = readAssignedDeliveries();
        for (AssignedDelivery ad : assignedList) {
            if (ad.getOrderId().equals(orderId)) {
                return ad;
            }
        }
        return null;
    }

    // ---------------- FILE METHODS ----------------

    private List<AssignedDelivery> readAssignedDeliveries() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ASSIGNED_FILE))) {
            return (List<AssignedDelivery>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private List<ConfirmOrders> readConfirmedOrders() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CONFIRMED_FILE))) {
            return (List<ConfirmOrders>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
