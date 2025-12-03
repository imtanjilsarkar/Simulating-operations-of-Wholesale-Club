package com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.modelClass.SupplierOrder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.*;
import java.util.ArrayList;

public class GenerateProcurementReportController {

    @FXML
    private TextArea reportArea;

    @FXML
    private Label successLabel;

    private static final String FILE_PATH =
            "C:\\Users\\rubay\\IdeaProjects\\Simulating-operations-of-Wholesale-Club\\supplier_orders.bin";

    private ArrayList<SupplierOrder> orderList;

    // =============================================================
    // INITIALIZE
    // =============================================================
    @FXML
    public void initialize() {
        loadOrders();
        displayOrders();
    }

    // =============================================================
    // LOAD ORDERS FROM BINARY FILE
    // =============================================================
    private void loadOrders() {
        orderList = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            successLabel.setText("No orders found.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList<?>) {
                ArrayList<?> tempList = (ArrayList<?>) obj;
                for (Object o : tempList) {
                    if (o instanceof SupplierOrder) {
                        orderList.add((SupplierOrder) o);
                    }
                }
            }
            successLabel.setText("Orders loaded successfully!");
        } catch (EOFException ignored) {
            successLabel.setText("Orders loaded successfully!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            successLabel.setText("Error loading orders!");
        }
    }

    // =============================================================
    // DISPLAY ORDERS IN TEXTAREA
    // =============================================================
    private void displayOrders() {
        if (orderList.isEmpty()) {
            reportArea.setText("No orders to display.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-12s %-20s %-12s %-12s\n",
                "Supplier ID", "Product", "Quantity", "Due Date"));
        sb.append("--------------------------------------------------------\n");

        for (SupplierOrder o : orderList) {
            sb.append(String.format("%-12s %-20s %-12d %-12s\n",
                    o.getSupplierId(),
                    o.getProductName(),
                    o.getQuantity(),
                    o.getDueDate()));
        }

        reportArea.setText(sb.toString());
    }

    // =============================================================
    // BACK BUTTON
    // =============================================================
    @Deprecated
    public void BackBTN(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo(
                "/com/group16/simulatingoperationsofwholesaleclub/rahad/ProcurementOfficer/procurementOff_dashboard.fxml",
                event
        );
    }

    @FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/ProcurementOfficer/procurementOff_dashboard.fxml",actionEvent);
    }

    @FXML
    public void generateReport(ActionEvent actionEvent) {
    }

    @FXML
    public void downloadReport(ActionEvent actionEvent) {
    }
}
