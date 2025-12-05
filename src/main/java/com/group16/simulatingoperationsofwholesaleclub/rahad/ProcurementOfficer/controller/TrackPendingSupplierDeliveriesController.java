package com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.modelClass.SupplierOrder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TrackPendingSupplierDeliveriesController {

    @FXML private TextArea pendingOrdersArea;

    private static final String BIN_FILE_PATH = "supplier_orders.bin";
    private static final String TXT_FILE_PATH = "Receive_Supplier_delivery.txt";
    @FXML
    private Button loadPendingButton;

    @FXML
    public void loadPendingDeliveries(ActionEvent event) {
        pendingOrdersArea.clear();


        Set<String> deliveredOrderIds = new HashSet<>();
        File txtFile = new File(TXT_FILE_PATH);
        if (txtFile.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(txtFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    line = line.trim();
                    if (!line.isEmpty()) {

                        String[] parts = line.split(",");
                        if (parts.length >= 2 && parts[1].equalsIgnoreCase("Delivered")) {
                            deliveredOrderIds.add(parts[0].trim());
                        }
                    }
                }
            } catch (IOException e) {
                pendingOrdersArea.setText("Error reading delivery status file.");
                e.printStackTrace();
                return;
            }
        }


        ArrayList<SupplierOrder> allOrders = new ArrayList<>();
        File binFile = new File(BIN_FILE_PATH);
        if (binFile.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(binFile))) {
                Object obj = ois.readObject();
                if (obj instanceof ArrayList<?>) {
                    for (Object o : (ArrayList<?>) obj) {
                        if (o instanceof SupplierOrder) {
                            allOrders.add((SupplierOrder) o);
                        }
                    }
                }
            } catch (EOFException ignored) {
            } catch (IOException | ClassNotFoundException e) {
                pendingOrdersArea.setText("Error reading supplier orders file.");
                e.printStackTrace();
                return;
            }
        }


        StringBuilder sb = new StringBuilder();
        sb.append("Pending Orders:\n\n");

        boolean hasPending = false;
        for (SupplierOrder order : allOrders) {
            if (!deliveredOrderIds.contains(order.getOrderId())) {
                hasPending = true;
                sb.append("Order ID: ").append(order.getOrderId()).append("\n");
                sb.append("Supplier ID: ").append(order.getSupplierId()).append("\n");
                sb.append("-------------------------\n");
            }
        }

        if (!hasPending) {
            sb.append("No pending orders. All orders are delivered.");
        }

        pendingOrdersArea.setText(sb.toString());
    }

    @FXML
    public void handleBack(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo(
                "/com/group16/simulatingoperationsofwholesaleclub/rahad/ProcurementOfficer/procurementOff_dashboard.fxml",
                event
        );
    }
}
