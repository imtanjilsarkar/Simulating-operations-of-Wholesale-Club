package com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.modelClass.AssignedDelivery;
import com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.modelClass.ConfirmOrders;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrackDeliveryController {

    private static final String ASSIGNED_FILE = "assigned_deliveries.dat";
    private static final String CONFIRMED_FILE = "confirmed_orders.dat";

    @FXML
    private TextField orderIdField;

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
    public void handleTrackDelivery(ActionEvent actionEvent) {
        String orderId = orderIdField.getText().trim();
        statusLabel.setText("");

        if (orderId.isEmpty()) {
            statusLabel.setText(" Please enter an Order ID.");
            return;
        }

        List<ConfirmOrders> confirmedOrders = readConfirmedOrders();
        List<AssignedDelivery> assignedDeliveries = readAssignedDeliveries();


        for (ConfirmOrders co : confirmedOrders) {
            if (co.getOrderId().equals(orderId)) {
                statusLabel.setText("Order ID " + orderId + " has already been delivered.");
                return;
            }
        }


        for (AssignedDelivery ad : assignedDeliveries) {
            if (ad.getOrderId().equals(orderId)) {
                statusLabel.setText("Order ID " + orderId + " is currently in process.");
                return;
            }
        }


        statusLabel.setText("Order ID " + orderId + " was never assigned for delivery.");
    }

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
