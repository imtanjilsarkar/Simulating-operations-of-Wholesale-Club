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

public class ConfirmCompletedDeliveriesController {

    private static final String ASSIGNED_FILE = "assigned_deliveries.dat";
    private static final String CONFIRMED_FILE = "confirmed_orders.dat";

    @FXML
    private TextField orderIdField;

    @FXML
    private Label deliveredLabel;

    @FXML
    private Label notAssignedLabel;

    @FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo(
                "/com/group16/simulatingoperationsofwholesaleclub/rahad/DeliveryCoordinator/delivery_Dashboard.fxml",
                actionEvent
        );
    }

    @FXML
    public void handleConfirmDelivery(ActionEvent actionEvent) {
        String orderId = orderIdField.getText().trim();

        // Clear previous messages
        deliveredLabel.setText("");
        notAssignedLabel.setText("");

        if (orderId.isEmpty()) {
            notAssignedLabel.setText("⚠ Please enter an Order ID.");
            return;
        }

        // Check if already confirmed
        List<ConfirmOrders> confirmedList = readConfirmedOrders();
        for (ConfirmOrders co : confirmedList) {
            if (co.getOrderId().equals(orderId)) {
                deliveredLabel.setText("⚠ Order ID " + orderId + " is already DELIVERED.");
                return;
            }
        }

        // Load assigned deliveries
        List<AssignedDelivery> assignedList = readAssignedDeliveries();
        AssignedDelivery target = null;

        for (AssignedDelivery ad : assignedList) {
            if (ad.getOrderId().equals(orderId)) {
                target = ad;
                break;
            }
        }

        if (target == null) {
            // Order not assigned
            notAssignedLabel.setText(" Order ID is not assigned to any delivery staff yet.");
            return;
        }

        // Confirm delivery
        saveConfirmedOrder(orderId);

        // Remove from assigned deliveries
        assignedList.remove(target);
        saveAssignedDeliveries(assignedList);

        // Show success in delivered label
        deliveredLabel.setText("✅ Order ID " + orderId + " marked as DELIVERED successfully!");
        orderIdField.clear();
    }

    // ---------- FILE METHODS ----------

    private List<AssignedDelivery> readAssignedDeliveries() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ASSIGNED_FILE))) {
            return (List<AssignedDelivery>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private void saveAssignedDeliveries(List<AssignedDelivery> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ASSIGNED_FILE))) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveConfirmedOrder(String orderId) {
        List<ConfirmOrders> confirmedList = readConfirmedOrders();
        confirmedList.add(new ConfirmOrders(orderId, true));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CONFIRMED_FILE))) {
            oos.writeObject(confirmedList);
        } catch (IOException e) {
            e.printStackTrace();
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
