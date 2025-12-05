package com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.modelClass.AssignedDelivery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AssignDeliveryTasksController {

    private static final String FILE_PATH =
            "assigned_deliveries.dat";

    @FXML
    private DatePicker deliveryDatePicker;
    @FXML
    private TextField deliveryNoField;
    @FXML
    private TextField staffIdField;
    @FXML
    private Label successLabel;


    @FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/DeliveryCoordinator/delivery_Dashboard.fxml", actionEvent);
    }


    @FXML
    public void AssignDeliveryBTN(ActionEvent actionEvent) {

        String staffId = staffIdField.getText().trim();
        String deliveryNo = deliveryNoField.getText().trim();
        String deliveryDate = (deliveryDatePicker.getValue() != null)
                ? deliveryDatePicker.getValue().toString()
                : "";


        if (staffId.isEmpty() || deliveryNo.isEmpty() || deliveryDate.isEmpty()) {
            successLabel.setText(" Please fill all fields.");
            return;
        }

        try {
            ArrayList<AssignedDelivery> list = loadAssignedDeliveries();


            for (AssignedDelivery ad : list) {
                if (ad.getOrderId().equals(deliveryNo)) {
                    successLabel.setText("This Order ID is already assigned!");
                    return;
                }
            }


            AssignedDelivery assignedDelivery = new AssignedDelivery(staffId, deliveryNo, deliveryDate);
            list.add(assignedDelivery);


            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
                out.writeObject(list);
            }

            successLabel.setText("Delivery Assigned Successfully!");
            clearFields();

        } catch (Exception e) {
            e.printStackTrace();
            successLabel.setText("Error Saving Delivery Task!");
        }
    }


    private ArrayList<AssignedDelivery> loadAssignedDeliveries() {
        ArrayList<AssignedDelivery> list = new ArrayList<>();
        if (Files.exists(Paths.get(FILE_PATH))) {
            try (ObjectInputStream in = new ObjectInputStream(new java.io.FileInputStream(FILE_PATH))) {
                Object obj = in.readObject();
                list = (ArrayList<AssignedDelivery>) obj;
            } catch (Exception ignored) {
            }
        }
        return list;
    }


    private void clearFields() {
        staffIdField.clear();
        deliveryNoField.clear();
        deliveryDatePicker.setValue(null);
    }
}
