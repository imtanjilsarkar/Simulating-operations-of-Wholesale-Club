package com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.modelClass.SupplierOrder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class CreateSupplierOrderController {

    @FXML private TextField supplierIdField;
    @FXML private TextField orderIdField;
    @FXML private TextField productField;
    @FXML private TextField quantityField;
    @FXML private DatePicker dueDatePicker;
    @FXML private Label messageLabel;

    private static final String FILE_PATH = "supplier_orders.bin";

    @FXML
    public void handleSaveOrderButton(ActionEvent event) {

        try {
            String supplierId = supplierIdField.getText().trim();
            String orderId = orderIdField.getText().trim(); // use generated or manually entered
            String product = productField.getText().trim();
            String qtyText = quantityField.getText().trim();
            String dueDate = (dueDatePicker.getValue() != null)
                    ? dueDatePicker.getValue().toString()
                    : "";


            if (supplierId.isEmpty() || product.isEmpty() || qtyText.isEmpty() || dueDate.isEmpty()) {
                showMessage("Please fill all fields!", "red");
                return;
            }

            int quantity;
            try {
                quantity = Integer.parseInt(qtyText);
            } catch (NumberFormatException ex) {
                showMessage("Quantity must be a number!", "red");
                return;
            }


            if (orderId.isEmpty()) {
                orderId = generateUniqueOrderId();
                orderIdField.setText(orderId);
            }


            SupplierOrder newOrder = new SupplierOrder(orderId, supplierId, product, quantity, dueDate);


            ArrayList<SupplierOrder> orderList = new ArrayList<>();
            File file = new File(FILE_PATH);

            if (file.exists()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                    orderList = (ArrayList<SupplierOrder>) ois.readObject();
                } catch (EOFException | ClassNotFoundException ignored) {
                    orderList = new ArrayList<>();
                }
            }


            orderList.add(newOrder);


            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(orderList);
            }

            showMessage("Order saved successfully!", "green");


            supplierIdField.clear();
            productField.clear();
            quantityField.clear();
            dueDatePicker.setValue(null);

        } catch (IOException e) {
            showMessage("Error saving order!", "red");
            e.printStackTrace();
        }
    }

    private void showMessage(String msg, String color) {
        messageLabel.setText(msg);
        messageLabel.setStyle("-fx-text-fill:" + color + ";");
    }

    @FXML
    public void handleBack(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo(
                "/com/group16/simulatingoperationsofwholesaleclub/rahad/ProcurementOfficer/procurementOff_dashboard.fxml",
                event
        );
    }

    @FXML
    public void handleGenerateOrderId(ActionEvent actionEvent) {
        String orderId = generateUniqueOrderId();
        orderIdField.setText(orderId);
        orderIdField.setEditable(false);
    }


    private String generateUniqueOrderId() {
        long timestamp = System.currentTimeMillis(); // current time in milliseconds
        int randomNumber = new Random().nextInt(900) + 100; // random 3-digit number (100-999)
        return "ORD" + timestamp + randomNumber;
    }
}
