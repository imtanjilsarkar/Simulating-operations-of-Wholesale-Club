package com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.modelClass.AssignedDelivery;
import com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.modelClass.ConfirmOrders;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReDeliveryRequestController {

    @FXML
    private TextField orderIdField;

    @FXML
    private TextArea reasonField;

    @FXML
    private Label statusLabel;

    private static final String RE_DELIVERY_FILE =
            "redelivery_requests.dat";

    private static final String ASSIGNED_DELIVERY_FILE =
            "assigned_deliveries.dat";

    private static final String CONFIRMED_FILE =
            "confirmed_orders.dat";

    // ------------------------------
    // BACK BUTTON
    // ------------------------------
    @FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo(
                "/com/group16/simulatingoperationsofwholesaleclub/rahad/DeliveryCoordinator/delivery_Dashboard.fxml",
                actionEvent
        );
    }

    // ------------------------------
    // SAVE RE-DELIVERY REQUEST
    // ------------------------------
    @FXML
    public void handleSaveRequest(ActionEvent event) {
        String orderId = orderIdField.getText().trim();
        String reason = reasonField.getText().trim();

        if (orderId.isEmpty() || reason.isEmpty()) {
            statusLabel.setText("⚠ Please fill all fields before submitting.");
            return;
        }

        // -----------------------------
        // VALIDATION: Must be assigned & delivered
        // -----------------------------
        boolean isAssigned = false;
        boolean isDelivered = false;

        // Check assigned deliveries
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ASSIGNED_DELIVERY_FILE))) {
            List<AssignedDelivery> assignedList = (List<AssignedDelivery>) ois.readObject();
            for (AssignedDelivery ad : assignedList) {
                if (ad.getOrderId().equals(orderId)) {
                    isAssigned = true;
                    break;
                }
            }
        } catch (Exception ignored) {}

        // Check confirmed orders
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CONFIRMED_FILE))) {
            List<ConfirmOrders> confirmedList = (List<ConfirmOrders>) ois.readObject();
            for (ConfirmOrders co : confirmedList) {
                if (co.getOrderId().equals(orderId)) {
                    isDelivered = true;
                    break;
                }
            }
        } catch (Exception ignored) {}

        if (!isAssigned) {
            statusLabel.setText("❌ Cannot request re-delivery. Order was never assigned.");
            return;
        }

        if (!isDelivered) {
            statusLabel.setText("❌ Cannot request re-delivery. Order is not delivered yet.");
            return;
        }

        // -----------------------------
        // SAVE INTO RE-DELIVERY FILE
        // -----------------------------
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RE_DELIVERY_FILE, true))) {
            writer.write("OrderID: " + orderId + ", Reason: " + reason);
            writer.newLine();
        } catch (IOException e) {
            statusLabel.setText("❌ Error saving re-delivery request.");
            e.printStackTrace();
            return;
        }

        // -----------------------------
        // REMOVE FROM CONFIRMED ORDERS
        // -----------------------------
        removeFromConfirmedOrders(orderId);

        statusLabel.setText("✅ Re-delivery request submitted successfully!");
        orderIdField.clear();
        reasonField.clear();
    }

    // ------------------------------
    // HELPER METHOD: Remove confirmed delivery
    // ------------------------------
    private void removeFromConfirmedOrders(String orderId) {
        List<ConfirmOrders> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CONFIRMED_FILE))) {
            list = (List<ConfirmOrders>) ois.readObject();
        } catch (Exception ignored) {}

        // Remove the delivered order
        list.removeIf(co -> co.getOrderId().equals(orderId));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CONFIRMED_FILE))) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
