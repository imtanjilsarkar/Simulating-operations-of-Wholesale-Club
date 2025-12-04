package com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.modelClass.AssignedDelivery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManageDeliveryScheduleController {

    private static final String FILE_PATH = "C:\\Users\\rubay\\IdeaProjects\\Simulating-operations-of-Wholesale-Club\\assigned_deliveries.dat";

    @FXML
    private Label statusLabel;

    @FXML
    private TextField prevDateField;

    @FXML
    private DatePicker newDatePicker;

    @FXML
    private TextField orderIdField;

    @FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo(
                "/com/group16/simulatingoperationsofwholesaleclub/rahad/DeliveryCoordinator/delivery_Dashboard.fxml",
                actionEvent
        );
    }

    // ---------------- SEARCH ORDER ----------------
    @FXML
    public void searchID(ActionEvent actionEvent) {
        String orderId = orderIdField.getText().trim();
        statusLabel.setText("");
        prevDateField.setText("");

        if (orderId.isEmpty()) {
            statusLabel.setText("⚠ Please enter an Order ID.");
            return;
        }

        AssignedDelivery ad = findAssignedDelivery(orderId);
        if (ad != null) {
            prevDateField.setText(ad.getDeliveryDate());
            statusLabel.setText("Order found. You can update the delivery date.");
        } else {
            statusLabel.setText("❌ No order found with Order ID: " + orderId);
        }
    }

    // ---------------- UPDATE DELIVERY DATE ----------------
    @FXML
    public void handleUpdateDate(ActionEvent actionEvent) {
        String orderId = orderIdField.getText().trim();
        LocalDate newDate = newDatePicker.getValue();

        if (orderId.isEmpty() || newDate == null) {
            statusLabel.setText("⚠ Please enter Order ID and select a new delivery date.");
            return;
        }

        List<AssignedDelivery> assignedList = readAssignedDeliveries();
        boolean found = false;

        for (AssignedDelivery ad : assignedList) {
            if (ad.getOrderId().equals(orderId)) {
                ad.setDeliveryDate(newDate.toString());
                found = true;
                break;
            }
        }

        if (found) {
            saveAssignedDeliveries(assignedList);
            statusLabel.setText("✅ Delivery date updated successfully!");
            prevDateField.setText(newDate.toString());
        } else {
            statusLabel.setText("❌ No order found with Order ID: " + orderId);
        }
    }

    // ---------------- HELPER METHODS ----------------
    private AssignedDelivery findAssignedDelivery(String orderId) {
        List<AssignedDelivery> assignedList = readAssignedDeliveries();
        for (AssignedDelivery ad : assignedList) {
            if (ad.getOrderId().equals(orderId)) {
                return ad;
            }
        }
        return null;
    }

    private List<AssignedDelivery> readAssignedDeliveries() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<AssignedDelivery>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private void saveAssignedDeliveries(List<AssignedDelivery> assignedList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(assignedList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
